package cn.com.na.utils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;


public class TestSend {
	public static void main(String[] args) throws MessagingException, IOException
    {
        Map<String,String> map= new HashMap<String,String>();
        String account = "plug@easycount.cn";
        /**
         * 该pwd为授权码
         * vuszzcljrlbfcadg
         * bsyanwqoujdqbiie
         */
        String pwd = "plug168";
        SendMailTool mail = new SendMailTool(account,pwd);
        
        map.put("mail.smtp.host", "smtp.163.com");
        //暂时未成功，需要调试
        /*SendMail mail = new SendMail("14789****@sina.cn","***miya");
        map.put("mail.smtp.host", "smtp.sina.com");*/
        map.put("mail.smtp.auth", "true");
        map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        map.put("mail.smtp.port", "465");
        map.put("mail.smtp.socketFactory.port", "465");
       // map.put("mail.smtp.starttls.enable", "true");
        
        mail.setPros(map);
        mail.initMessage();
        /*
         * 添加收件人有三种方法：
         * 1,单人添加(单人发送)调用setRecipient(str);发送String类型
         * 2,多人添加(群发)调用setRecipients(list);发送list集合类型
         * 3,多人添加(群发)调用setRecipients(sb);发送StringBuffer类型
         */
        List<String> list = new ArrayList<String>();
        list.add("87nba87@163.com");
        //list.add("***92@sina.cn");
        //list.add("****@163.com");
        mail.setRecipients(list);
        /*String defaultStr = "283942930@qq.com,429353942@qq.com,2355663819@qq.com,381766286@qq.com;
        StringBuffer sb = new StringBuffer();
        sb.append(defaultStr);
        sb.append(",316121113@qq.com");
        mail.setRecipients(sb);*/
        mail.setSubject("测试邮箱");
        //mail.setText("谢谢合作");
        mail.setDate(new Date());
        mail.setFrom("MY");
//      mail.setMultipart("D:你你你.txt");
        mail.setContent("谢谢合作", "text/html; charset=UTF-8");
        /*List<String> fileList = new ArrayList<String>();
        fileList.add("D:1.jpg");
        fileList.add("D:activation.zip");
        fileList.add("D:dstz.sql");
        fileList.add("D:软件配置要求.doc");
        mail.setMultiparts(fileList);*/
        System.out.println(mail.sendMessage());
    }
}
