package com.tlstest.server;

import javax.security.cert.X509Certificate;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.ssl.SslFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eastsoft.router.ipc.util.PacketUtil;

/**
 * @author giftsam
 */
public class SSLServerHandler extends IoHandlerAdapter {
	private final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	private int idleTimeout = 10;
	private IoAcceptor ioAcceptor;

	public SSLServerHandler(IoAcceptor ioAcceptor){
		this.ioAcceptor=ioAcceptor;
		
		
	}
	@Override
	public void sessionOpened(IoSession session) {
		// set idle time to 10 seconds
//		getCertId();
		session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, idleTimeout);
		System.out.println("sasxasxas");
		session.setAttribute("Values: ");
	}
	
	public String getCertId(){
		SslFilter sslFilter=(SslFilter) ioAcceptor.getFilterChain().get("sslFilter");
//		add
//		X509Certificate[] certArray=CertUtil.certArray ;
//		if(certArray!=null)
//		 for(X509Certificate xc:certArray){
//         	System.out.println("issuerDN="+xc.getIssuerDN());
//         	System.out.println("subjectDN="+xc.getSubjectDN());
//         }
//        handler.getSslEngine();
//        SSLSession sslSession=sslEngine.getSession();
//        X509Certificate[] certArray=sslSession.getPeerCertificateChain();
		return null;
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
		System.out.println("Message received in the server..");
		System.out.println("Message is: " + message.toString());
//		getCertId();
		System.out.println("Gid==="+session.getAttribute(PacketUtil.GID));
//		String gid=SessionFilter.getLocalSession().getAttribute(PacketUtil.GID).toString();
//		System.out.println("gid===="+gid);
		System.out.println("sessionid=="+session.getId());
//		System.out.println("sessionid1=="+SessionFilter.getLocalSession().getId());
		//		if(((String)message).contains("server idle")){
//			session.write("recv idle"+new Date());
//		}
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) {
		logger.info("Transaction is idle for " + idleTimeout
				+ "secs, So disconnecting..");
		// disconnect an idle client
//		session.close();
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		// close the connection on exceptional situation
		session.close();
	}
}
