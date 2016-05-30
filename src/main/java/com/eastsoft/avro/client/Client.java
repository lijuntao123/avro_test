package com.eastsoft.avro.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

import org.apache.avro.Protocol;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.ipc.HttpTransceiver;
import org.apache.avro.ipc.Transceiver;
import org.apache.avro.ipc.generic.GenericRequestor;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.channel.ServerChannel;
import org.jboss.netty.channel.ServerChannelFactory;
import org.jboss.netty.handler.ssl.SslHandler;

import com.eastsoft.avro.Utils;
import com.eastsoft.router.ipc.proto.IpsAndToken;
import com.eastsoft.router.ipc.proto.MobileInfo;
import com.eastsoft.router.ipc.proto.RouterProtocol;
import com.eastsoft.router.ipc.sslfilter.SSLContextGenerator;



/**
 * 客户端
 * 
 * @author ljt
 * 
 */
public class Client {
	private Protocol protocol = null;
	private String host = null;
	private int port = 0;
	private int size = 0;
	private int count = 0;

	public Client(Protocol protocol, String host, int port, int size, int count) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.size = size;
		this.count = count;
	}

	public long sendMessage() throws Exception {
		GenericRecord requestData = new GenericData.Record(protocol.getType("message"));

		// initiate the request data
		requestData.put("name", "lisi");
		requestData.put("type", 1);
		requestData.put("price", 12.1);
		requestData.put("valid", true);
		requestData.put("content", ByteBuffer.wrap("con".getBytes()));
		
		Schema testSchema=protocol.getType("test");
		GenericRecord param=new GenericData.Record(testSchema);
		param.put("param1", "age");
		param.put("param2", "name");
		
		List<GenericRecord> list=new ArrayList<GenericRecord>();
		list.add(param);
		
		param=new GenericData.Record(testSchema);
		param.put("param1", "age1");
		param.put("param2", "name1");
		
		list.add(param);		
		requestData.put("list", list);		

		Schema schema = protocol.getMessages().get("sendMessage").getRequest();//得到sendMessage方法的参数模式
		
		GenericRecord request = new GenericData.Record(schema);
		request.put("message", requestData);// 给方法传一个参数

		// 通信的载体
		Transceiver t = new HttpTransceiver(new URL("http://" + host + ":"
				+ port));
		GenericRequestor requestor = new GenericRequestor(protocol, t);

		long start = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			GenericRecord req = (GenericRecord) requestor.request("sendMessage", request);//发送请求并得到响应结果
			 
			System.out.println("msg=" + req);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return end - start;
	}
	
	
	public long sendMessage1() throws Exception {
		
		Schema schema = protocol.getMessages().get("phoneMsg").getRequest();//得到sendMessage方法的参数模式		
		GenericRecord request = new GenericData.Record(schema);
		
		GenericRecord requestData = new GenericData.Record(protocol.getType("phoneRequest"));
		requestData.put("gid", "0x123456789");
		request.put("phoneRequest", requestData);// 给方法传一个参数
//		request.put("gid", "0x123456789");

		// 通信的载体
		Transceiver t = new HttpTransceiver(new URL("http://" + host + ":"	+ port));
		GenericRequestor requestor = new GenericRequestor(protocol, t);

		long start = System.currentTimeMillis();
		for (int i = 0; i <=count; i++) {
			GenericRecord req = (GenericRecord) requestor.request("phoneMsg", request);//发送请求并得到响应结果			 
			System.out.println("msg=" + req);
//			System.out.println("error="+requestor.readError(protocol.getMessages().get("phoneMsg").getErrors(), in));
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return end - start;
	}
	
	
	public long sendMessage2() throws Exception {
		
		MobileInfo minfo=new MobileInfo();
		minfo.setGid(12345467890l);		
//		minfo.setOptionalMobileType("HTC_wildfire_s");
		minfo.setOptionalIMEI("62719491273494");
//		NettyTransceiver client = new NettyTransceiver(new InetSocketAddress("127.0.0.1",port),new MyChannelPipelineFactory());
		NettyTransceiver client = new NettyTransceiver(new InetSocketAddress("127.0.0.1",port));		
		RouterProtocol proxy = (RouterProtocol) SpecificRequestor.getClient(RouterProtocol.class,client);		
		IpsAndToken iap=(IpsAndToken)proxy.requestMobileLogin(minfo);
//		proxy.requestMobileLogin(minfo);
//		RpcClient client=new RpcClient(new InetSocketAddress("127.0.0.1",port));
//		IpsAndToken iap=client.requestMobileLogin(minfo);
		return 0;
	}
	
	/**
	 * new 
	 * @return
	 * @throws Exception
	 */
	public long sendMessage3() throws Exception {
		
		Schema schema = protocol.getMessages().get("requestMobileLogin").getRequest();//得到sendMessage方法的参数模式		
		GenericRecord request = new GenericData.Record(schema);
		
		GenericRecord requestData = new GenericData.Record(protocol.getType("MobileInfo"));
		requestData.put("gid", 1212L);
		request.put("mobileInfo", requestData);// 给方法传一个参数
//		request.put("gid", "0x123456789");
		Socket socket=new Socket("129.1.77.14", 22223);
//		socket.		
		OutputStream os=socket.getOutputStream();
		
		ByteBuffer bb=ByteBuffer.allocate(18);
		bb.putShort((short)1);
		bb.putInt(0);
		bb.putInt(1);
		bb.putInt(4);
		bb.putInt(1);
		os.write(bb.array());
		InputStream is=socket.getInputStream();
		
		ByteBuffer bb1=ByteBuffer.allocate(1024);
		byte[] b=new byte[128];
		int len=0;
		while((len=is.read(b))!=-1){
			bb1.put(b);
		}
		

		return 0;
	}

	public long run() {
		long res = 0;
		try {
			res = sendMessage3();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static void main(String[] args)  {		

		String host = "129.1.77.14";
		int port = 22223;
		int size = 10;
		int count = 1;
		new Client(Utils.getProtocol(), host, port, size, count).run();
		
		
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
				SSLContextGenerator sslcg=new SSLContextGenerator();
	        	SSLContext sslc=sslcg.getSslContext("conf/server.jks", "eastsoft");
	        	SSLEngine engine=sslc.createSSLEngine();
	        	engine.setUseClientMode(true);
	        	SslHandler sslHandler=new SslHandler(engine);
//	        	sslHandler.setEnableRenegotiation(true);
	        	sslHandler.setIssueHandshake(true);
				cp.addLast("sslHandler", sslHandler);
				return cp;
			}

		}
}
