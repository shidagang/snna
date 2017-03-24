package cn.com.na.netty5.echo.client;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 
 * @author David
 *
 */
public class EchoClient {
	private final static String  host = "112.74.59.45";//"127.0.0.1";
	private final static int port = 5050;
	
	public void start()throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try{
			Bootstrap b = new Bootstrap();
			b.group(group)
			 .channel(NioSocketChannel.class)
			 .remoteAddress(new InetSocketAddress(host,port))
			 .handler(new ChannelInitializer<SocketChannel>(){

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast("decoder", new StringDecoder());
					ch.pipeline().addLast("encoder", new StringEncoder());
					ch.pipeline().addLast(new EchoClientHandler());
				}
			 });
			
			ChannelFuture f = b.connect().sync();
			f.channel().closeFuture().sync();
			
		}finally{
			 group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String args[])throws Exception{
		new EchoClient().start();
	}

}
