package com.eastsoft.avro.ssltest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.eastsoft.router.protocol.filter.tls.SSLContextGenerator;
import com.eastsoft.router.protocol.filter.tls.SslFilter;
import com.eastsoft.router.protocol.filter.tls.impl.SSLContextGeneratorImpl;

public class MinaClientTest {

	private static final int PORT = 22222;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		for(int i=0;i<1;i++){
			client(i);
		}
	}
	
	public static void client(int i){
		// 客户端的实现
		NioSocketConnector connector = new NioSocketConnector();
		addSSLSupport(connector.getFilterChain());
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory()));
		connector.getFilterChain().addLast("logging", new LoggingFilter());

		connector.setHandler(new IoHandler() {

			@Override
			public void sessionOpened(IoSession session) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("client send begin");
				String s ="request";
				//System.out.println("客户端 :"+s);			
				session.write("客户端 "+session.getLocalAddress()+"--"+s);// 
				System.out.println("client written...");
				 session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
				session.write("123");
				
			}

			@Override
			public void sessionIdle(IoSession session, IdleStatus arg1)
					throws Exception {
				if(IdleStatus.BOTH_IDLE==arg1){
					SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
					Date d=new Date();
					
					String msg=session.getRemoteAddress()+"--"+sf.format(d)+"->idle....";
					System.out.println(msg);
					session.write(msg);
				}
				

			}

			@Override
			public void sessionCreated(IoSession arg0) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void sessionClosed(IoSession arg0) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void messageSent(IoSession session, Object arg1)
					throws Exception {
				// TODO Auto-generated method stub				

			}

			@Override
			public void messageReceived(IoSession session, Object message)
					throws Exception {
				String s = message.toString();
				System.out.println("server :"+s);
				

			}

			@Override
			public void exceptionCaught(IoSession arg0, Throwable arg1)
					throws Exception {
				// TODO Auto-generated method stub

			}
		});
		// 本句需要加上，否则无法调用下面的readFuture来从session中读取到服务端返回的信息。
		connector.getSessionConfig().setUseReadOperation(true);
		ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1",
					PORT));

//		connector.dispose();
			 
	}
	private static  void addSSLSupport(DefaultIoFilterChainBuilder chain) {
		// String keystoreName = ConstantUtil.CONFDIR + "/server.jks";
		// String passwd = "eastsoft";
		try {
			InputStream is=new FileInputStream(new File("conf/mobile_1.bks"));
			byte [] b=new byte[is.available()];
			is.read(b);
			is.close();
			
			SSLContext sslContext = new SSLContextGeneratorImpl().getMobileSslContext(b, "eastsof");			
//			SSLContext sslContext=getSSLContext();
			SSLContextGenerator sSLContextGenerator=new SSLContextGeneratorImpl();
//			SSLContext sslContext=sSLContextGenerator.getSslContext("conf/client.jks","eastsoft");
			SslFilter sslFilter = new SslFilter(sslContext);
			sslFilter.setUseClientMode(true);
			chain.addLast("sslFilter1", sslFilter);
			System.out.println("SSL support is added..");
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
public static SSLContext getSSLContext(){
		
		try {
			String passwd="eastsof";
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			// From https://www.washington.edu/itconnect/security/ca/load-der.crt
			InputStream caInput = new FileInputStream(new File("conf/ca.crt"));
			Certificate ca;
			try {
			    ca = cf.generateCertificate(caInput);
			    System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
			} finally {
			    caInput.close();
			}
			
			InputStream serInput = new FileInputStream(new File("conf/server.crt"));
			Certificate ser;
			try {
				ser = cf.generateCertificate(serInput);
			    System.out.println("ser=" + ((X509Certificate) ser).getSubjectDN());
			} finally {
			    serInput.close();
			}			
			// Create a KeyStore containing our trusted CAs
//			String keyStoreType = KeyStore.getDefaultType();
			KeyStore keyStore = KeyStore.getInstance("BKS");
			keyStore.load(null, null);
			
			KeyStore ks=KeyStore.getInstance("BKS");
			
			InputStream in3 = new FileInputStream(new File("conf/mobile.bks"));
			ks.load(in3,"eastsof".toCharArray()); 
			in3.close();
		     //获取别名对应的条目的证书链 
		    Certificate[ ] mychain=ks.getCertificateChain("mobile"); 			
	        PrivateKey prk=(PrivateKey)ks.getKey("mobile",passwd.toCharArray()); 
	        //导入证书
	        keyStore.setKeyEntry("mobile",prk,passwd.toCharArray(),mychain); 			
			
			
			keyStore.setCertificateEntry("ca", ca);
			keyStore.setCertificateEntry("ser", ser);
			// Create a TrustManager that trusts the CAs in our KeyStore
			String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
			
			//================
			KeyManagerFactory kmf=KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(keyStore, passwd.toCharArray());
			//================
			
			TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
			tmf.init(keyStore);

			// Create an SSLContext that uses our TrustManager
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			return context;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
	}
}
