package com.tlstest.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.ssl.SslFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.eastsoft.router.ipc.sslfilter.SSLContextGenerator;



/**
 * @author giftsam
 */
public class SSLClient {
	private static final int REMORT_PORT = 5000;

	public static void main(String[] args) throws IOException,
			InterruptedException, GeneralSecurityException {
		IoConnector connector = new NioSocketConnector();
		connector.getSessionConfig().setReadBufferSize(2048);

		InputStream is=new FileInputStream(new File("conf/mobile_1.bks"));
		byte [] b=new byte[is.available()];
		is.read(b);
		is.close();
//		SSLContext sslContext = new SSLContextGeneratorImpl().getMobileSslContext(b, "eastsof");
		SSLContext sslContext = SSLContextGenerator.getSslContext("conf/client.jks","eastsoft");
//		SSLContext sslContext=getSSLContext();
		System.out.println("SSLContext protocol is: "
				+ sslContext.getProtocol());

		SslFilter sslFilter = new SslFilter(sslContext);
		sslFilter.setUseClientMode(true);
//		connector.getFilterChain().addFirst("sslFilter", sslFilter);

		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec",	new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

		connector.setHandler(new SSLClientHandler("Hello Server.."));
		connector.getSessionConfig().setUseReadOperation(true);
		ConnectFuture future = connector.connect(new InetSocketAddress(
				"129.1.77.14", REMORT_PORT));
//		future.awaitUninterruptibly();
//
//		if (!future.isConnected()) {
//			return;
////		}
//		IoSession session = future.getSession();
//		session.getConfig().setUseReadOperation(true);
//		session.getCloseFuture().awaitUninterruptibly();
		System.out.println("After Writing");
//		connector.dispose();
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
