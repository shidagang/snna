package cn.com.na.netty5.echo.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Client received: "+msg.toString());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		//client端上报他的<unique+`fVersion+hVersion,isOn> 格式mac,fVersion,hVersion,isOn;
		String msg = "28f36678d008,MF352ZP/A,C37ltznxfrc4,1";
		ctx.writeAndFlush(Unpooled.copiedBuffer(msg,CharsetUtil.UTF_8));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

	@Override
	protected void messageReceived(ChannelHandlerContext arg0, ByteBuf arg1) throws Exception {
	}

}
