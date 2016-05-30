package com.eastsoft.avro.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.avro.AvroRemoteException;

import com.eastsoft.router.ipc.api.RouterClient;
import com.eastsoft.router.ipc.proto.GatewayInfo;
import com.eastsoft.router.ipc.proto.MobileInfo;
import com.eastsoft.router.ipc.proto.RouterResult;
import com.eastsoft.router.ipc.proto.ServiceException;

public class RPCClientTest {

	private static final String  ip="129.1.1.124";
	private static final int port=22222;
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		testRequestMobileLogin();
//		testRequestGatewayLogin();
		test();

	}
	
	public static void test(){
		MyThread mt;
		for(int i=0;i<1;i++){
			mt=new RPCClientTest().new MyThread();
			mt.start();
		}
	}
	public static void testRequestMobileLogin() throws Exception {
		MobileInfo minfo=new com.eastsoft.router.ipc.proto.MobileInfo();
		minfo.setGid(12345467890l);		
		minfo.setOptionalMobileType("HTC_wildfire_s");
		minfo.setOptionalIMEI("62719491273494");
		List<SocketAddress> addrs=new ArrayList<SocketAddress>();
		addrs.add(new InetSocketAddress(ip,port));
		String path1="conf/mobile_client.pfx";
		String path2="conf/mobile_ca_root.pfx";
		InputStream in1=new FileInputStream(new File(path1));
		InputStream in2=new FileInputStream(new File(path2));
		RouterClient client=new RouterClient(addrs,null,in1,in2,"eastsof",true);
		RouterResult iap;
		try {
			iap = client.requestMobileLogin(minfo);
			System.out.println("iap=="+iap.toString());
		} catch (ServiceException e) {
			
			System.out.println("errorCode="+e.getErrorCode()+" msg== "+e.getDescription());
			e.printStackTrace();
		} catch (AvroRemoteException e) {
			
			e.printStackTrace();
		}finally{
			if(client.getMinaTransceiver().isConnected()){
				client.getMinaTransceiver().close();
			}
		}		
	}
	
	public static void testRequestGatewayLogin() throws Exception {
		GatewayInfo ginfo=new GatewayInfo();
		ginfo.setGid(1234567890l);
		ginfo.setBadBridgeIp("129.1.1.1");
		List<SocketAddress> addrs=new ArrayList<SocketAddress>();
		addrs.add(new InetSocketAddress(ip,port));
		File file=new File("conf/client.jks");
		InputStream is=new FileInputStream(file);
		byte[] b=new byte[is.available()];
		is.read(b);
		RpcClient client=new RpcClient(addrs,null,b,"eastsoft");
		RouterResult iap;
		try {
			iap = client.requestGatewayLogin(ginfo);
			System.out.println("iap=="+iap.toString());
		} catch (ServiceException e) {			
			System.out.println("errorCode="+e.getErrorCode()+" msg== "+e.getDescription());
			e.printStackTrace();
		} catch (AvroRemoteException e) {			
			e.printStackTrace();
		}finally{
			if(client.getMinaTransceiver().isConnected()){
				client.close();
			}
		}
				
	}
	
	class MyThread extends Thread{

		@Override
		public void run() {
			try {
				testRequestMobileLogin();
//				testRequestGatewayLogin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
