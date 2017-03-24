package cn.com.na.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.com.na.bean.EmailMessage;

public class SendEmail {

    public static final String HOST = "smtp.ym.163.com";
    public static final String PROTOCOL = "smtp";  
    public static final int PORT = 25;
    public static final String FROM = "plug@easycount.cn";//发件人的email
    public static final String PWD = "plug168";//发件人密码
 
    /**
     * 获取Session
     * @return
     */
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);//设置服务器地址
        props.put("mail.store.protocol" , PROTOCOL);//设置协议
        props.put("mail.smtp.port", PORT);//设置端口
        props.put("mail.smtp.auth" , "true");
 
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PWD);
            }
 
        };
        Session session = Session.getInstance(props, authenticator);
        //session.setDebug(true);
        return session;
    }
 
    public static void send(EmailMessage message) {
        Session session = getSession();
        try {
            System.out.println("--send--"+message.getContent());
            // Instantiate a message
            Message msg = new MimeMessage(session);
 
            //Set message attributes
            msg.setFrom(new InternetAddress(FROM));
            InternetAddress[] address = {new InternetAddress(message.getReceiver())};
            msg.setRecipients(Message.RecipientType.TO, address);
            if("0".equals(message.getLanguage())){
            	msg.setSubject(message.getSubject());
            }else{
            	msg.setSubject("Account activation email");
            }
            msg.setSentDate(new Date());
            msg.setContent(message.getContent() , "text/html;charset=utf-8");
 
            //Send the message
            Transport transport=session.getTransport("smtp");
            transport.connect(HOST,FROM,PWD);
                  //Send the message
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    
}
