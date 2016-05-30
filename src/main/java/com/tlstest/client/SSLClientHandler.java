package com.tlstest.client;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eastsoft.router.ipc.util.PacketUtil;

/**
 * @author giftsam
 */
public class SSLClientHandler extends IoHandlerAdapter {
	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	private final String values;
	private boolean finished;

	public SSLClientHandler(String values) {
		this.values = values;
	}

	public boolean isFinished() {
		return finished;
	}

	@Override
	public void sessionOpened(IoSession session) {
		session.setAttribute("name","session1");
		session.write(values);
		session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
		logger.info("Message received in the client..");
		logger.info("Message is: " + message.toString());
		System.out.println("gid====="+session.getAttribute(PacketUtil.GID));
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		session.close();
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		session.write(session.getAttribute("name")+"client idle"+new Date());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("closed===================");
	}
	
}
