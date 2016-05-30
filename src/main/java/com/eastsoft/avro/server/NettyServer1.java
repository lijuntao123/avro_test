package com.eastsoft.avro.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.specific.SpecificResponder;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.channel.ServerChannel;
import org.jboss.netty.channel.ServerChannelFactory;
import org.jboss.netty.handler.ssl.SslHandler;

import com.eastsoft.router.protocol.filter.tls.impl.SSLContextGeneratorImpl;
import com.eastsoft.router.protocol.proto.v1.GatewayInfo;
import com.eastsoft.router.protocol.proto.v1.IpsAndToken;
import com.eastsoft.router.protocol.proto.v1.MobileInfo;
import com.eastsoft.router.protocol.proto.v1.RouterProtocol;
import com.eastsoft.router.protocol.proto.v1.ServiceException;

public class NettyServer1 extends SpecificResponder{
	

	private static int port=22223;
	private static Server server;
	private Class iface;
	private Object impl;
	 
	public NettyServer1(Class iface, Object impl) {
		super(iface, impl);
		this.iface=iface;
		this.impl=impl;
	}
	

	public static class RouterProtocolImpl implements RouterProtocol{

		@Override
		public IpsAndToken requestMobileLogin(MobileInfo mobileInfo)
				throws AvroRemoteException, ServiceException {
			System.out.println("rec = "+mobileInfo.toString());
	    	IpsAndToken iap=new IpsAndToken();
	    	iap.setBridgeIp("129.1.1.122:8080");
	    	ArrayList<String> routerList=new ArrayList<String>();
	    	routerList.add("127.0.0.1:1223");
	    	iap.setRouterList(routerList);
	    	iap.setToken("123456789");
	        return iap;
		}

		@Override
		public IpsAndToken requestGatewayLogin(GatewayInfo gatewayInfo)
				throws AvroRemoteException, ServiceException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
    
	public static void main(String[] args) throws IOException {
        new NettyServer1(RouterProtocol.class, new RouterProtocolImpl()).run();
        System.out.println("Server started");       
    }
	
	 public void run() {
	        try {
	        	
	        	ChannelPipelineFactory pipelineFactory = new MyChannelPipelineFactory();
//	        	Server server = new NettyServer(this, new InetSocketAddress(port),
//	        			new NioServerSocketChannelFactory(Executors .newCachedThreadPool(), Executors.newCachedThreadPool()), 
//	        			pipelineFactory,null);	
	        	Server server = new NettyServer(this, new InetSocketAddress(port));	
	            server.start();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 class MyChannelFactory implements ServerChannelFactory{

		@Override
		public void releaseExternalResources() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public ServerChannel newChannel(ChannelPipeline pipeline) {
			// TODO Auto-generated method stub
			return null;
		}

		
		 
	 }
	 
	 public class MyChannelPipelineFactory implements ChannelPipelineFactory {

			@Override
			public ChannelPipeline getPipeline() throws Exception {
				// TODO Auto-generated method stub
				ChannelPipeline cp=new DefaultChannelPipeline();
				SSLContextGeneratorImpl sslcg=new SSLContextGeneratorImpl();
	        	SSLContext sslc=sslcg.getSslContext("conf/server.jks", "eastsoft");
	        	SSLEngine engine=sslc.createSSLEngine();
	        	engine.setNeedClientAuth(true);
	        	SslHandler sslHandler=new SslHandler(engine);
	        	sslHandler.setEnableRenegotiation(true);
	        	sslHandler.setIssueHandshake(true);
				cp.addLast("sslHandler", sslHandler);
				return cp;
			}

		}
}
