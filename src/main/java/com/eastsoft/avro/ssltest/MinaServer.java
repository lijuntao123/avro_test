package com.eastsoft.avro.ssltest;

import java.net.InetSocketAddress;

import javax.net.ssl.SSLContext;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.eastsoft.router.protocol.filter.tls.SSLContextGenerator;
import com.eastsoft.router.protocol.filter.tls.SslFilter;
import com.eastsoft.router.protocol.filter.tls.impl.SSLContextGeneratorImpl;

public class MinaServer {
	private static final int PORT = 22222;

	public static void main(String[] args) throws Exception {
//		final Protocol protocol = Protocol.parse(new File("dataProtocol.avro"));
		// 服务端的实例
		NioSocketAcceptor accept = new NioSocketAcceptor();	
		DefaultIoFilterChainBuilder filterChain=accept.getFilterChain();
		addSSLSupport(filterChain);
		// 添加filter，日志信息
		filterChain.addLast("logging", new LoggingFilter());		
		// 添加filter，codec为序列化方式。这里为对象序列化方式，即表示传递的是对象。
		filterChain.addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory()));
		
		// 设置服务端的handler
		accept.setHandler(new MyHandler());
		// 绑定ip
		accept.bind(new InetSocketAddress(PORT));

		System.out.println("upload  server started.");
	}
	
	private static void addSSLSupport(DefaultIoFilterChainBuilder chain) {
		// String keystoreName = ConstantUtil.CONFDIR + "/server.jks";
		// String passwd = "eastsoft";
		try {
			SSLContextGenerator sSLContextGenerator=new SSLContextGeneratorImpl();
			SSLContext sslContext=sSLContextGenerator.getSslContext("conf/server.jks","eastsoft");
			SslFilter sslFilter = new SslFilter(sslContext);
			sslFilter.setNeedClientAuth(true);
			chain.addLast("sslFilter1", sslFilter);
			System.out.println("SSL support is added..");
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
