package com.eastsoft.avro.ssltest;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MyHandler extends IoHandlerAdapter {
	
	

	// 当一个客户端连接进入时
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("incoming client:" + session.getRemoteAddress());
	}

	// 当客户端发送消息到达时
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String s = message.toString();
		System.out.println("msg=="+session.getAttribute("gid"));
	}

	// 当一个客户端连接关闭时
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("one client closed");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("sent :"+message);
//		session.close(false);
		
	}

}
