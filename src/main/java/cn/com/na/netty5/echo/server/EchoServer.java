package cn.com.na.netty5.echo.server;

import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.na.mapper.UserMapper;
import cn.com.na.service.UserService;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 
 * @author David
 *
 */
public class EchoServer {
	private final static int port = 5050;
	/**
	 * 
	 */
	public void initMethod() {
		Thread t = new Service();
		t.setDaemon(true);
		t.setName("NettyServer");
		t.start();

	}

	/**
	 * 
	 * @author David
	 * 
	 */
	class Service extends Thread {
		public void run() {
			try {
				new EchoServer().start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	public void start() throws Exception{
		final EchoServerHandler serverHandler = new EchoServerHandler();
		EventLoopGroup group = new NioEventLoopGroup();
		try{
			 ServerBootstrap b = new ServerBootstrap();
			 b.group(group)
			  .channel(NioServerSocketChannel.class)
			  .localAddress(new InetSocketAddress(port))
			  .childHandler(new ChannelInitializer<SocketChannel>(){

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast("decoder", new StringDecoder());
					ch.pipeline().addLast("encoder", new StringEncoder());
					ch.pipeline().addLast(serverHandler);
				}
				  
			  });
			 //绑定端口并启动去接收进来的连接
			 ChannelFuture f = b.bind().sync();
			 //一直等待，直到socket被关闭
			 f.channel().closeFuture().sync();
		}finally{
			//最终走向关闭
			group.shutdownGracefully().sync();
		}
		
	}

}
