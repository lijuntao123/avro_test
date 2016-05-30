package com.eastsoft.avro.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.avro.Protocol;
import org.apache.avro.Protocol.Message;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.Encoder;
import org.apache.avro.ipc.HttpServer;
import org.apache.avro.ipc.generic.GenericResponder;

import com.eastsoft.avro.Utils;
import com.eastsoft.router.protocol.proto.v1.IpsAndToken;
import com.eastsoft.router.protocol.proto.v1.MobileInfo;

 
public class Server1 extends GenericResponder {
    private Protocol protocol = null;
    private int port;
 
    public static void main(String[] args) {
        /* if (args.length != 1) {
             System.out.println("Usage: Server port");
             System.exit(0);
         }*/
     	
         int port = 22223;// Integer.parseInt(args[0]);
//         System.out.println("=====start=======");
//         Protocol protocol=null;
//         try {
//			protocol = Protocol.parse(new File("conf/protocol.avro"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		new Server1(protocol, port).run();
		
      new Server1(Utils.getProtocol(), port).run();
     }
    
    public Server1(Protocol protocol, int port) {
        super(protocol);
        this.protocol = protocol;
        this.port = port;
    }
 
    
     //* 客户端请求到来时，默认调用该方法  
	@Override
	public Object respond(Message message, Object request) throws Exception {
		// TODO Auto-generated method stub
		return mRespond3(message, request);
	}
    
    @Override
	public List<ByteBuffer> respond(List<ByteBuffer> buffers)
			throws IOException {
		// TODO Auto-generated method stub
		return super.respond(buffers);
	}
    
    public Object mRespond3(Message message, Object request){
    	MobileInfo mobileInfo=(MobileInfo)request;
    	IpsAndToken iap=new IpsAndToken();
    	iap.setBridgeIp("129.1.1.122:8080");
    	ArrayList<String> routerList=new ArrayList<String>();
    	routerList.add("127.0.0.1:1223");
    	iap.setRouterList(routerList);
    	iap.setToken("123456789");
        return iap;
   }
 
    public Object mRespond2(Message message, Object request){
    	GenericRecord req = (GenericRecord) request;
       // process the request
//        GenericRecord responseData = new GenericData.Record(protocol.getType("phoneResponse"));
        Schema schema = protocol.getMessages().get("phoneMsg").getResponse();
        GenericRecord responseData=new GenericData.Record(schema);
		// initiate the request data
        responseData.put("portalIp", "127.0.0.1:8080");
		responseData.put("token", "0x1234567890");
		responseData.put("routerList", new ArrayList<String>());
		responseData.put("success", false);
		responseData.put("errorCode", 6);
		
//		Schema errorschema = protocol.getMessages().get("phoneMsg").getErrors();
//		GenericRecord error=new GenericData.Record(errorschema);
//		Record errorData = new GenericData.Record(message.getErrors());		
//		int temp=0x0001;		
//		errorData.put("errorCode", temp);
////		Schema sc=message.ge
        return responseData;
   }
    
    public Object mRespond1(Message message, Object request){
    	 GenericRecord req = (GenericRecord) request;
         GenericRecord msg = (GenericRecord)(req.get("message"));
         System.out.println("msg="+msg);
        // process the request
         GenericRecord responseData = new GenericData.Record(protocol.getType("message"));

 		// initiate the request data
 		responseData.put("name", "zhangsan");
 		responseData.put("type", 2);
 		responseData.put("price", 13.2);
 		responseData.put("valid", false);
 		responseData.put("content",ByteBuffer.wrap("dpm".getBytes()));
         return responseData;
    }
    
    public void run() {
        try {
            HttpServer server = new HttpServer(this, port);
 
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
   

	@Override
	public void writeResponse(Schema schema, Object response, Encoder out)
			throws IOException {
		// TODO Auto-generated method stub
		/*GenericRecord requestData = new GenericData.Record(
				protocol.getType("message"));

		// initiate the request data
		requestData.put("name", "lisi");
		requestData.put("type", 1);
		requestData.put("price", 12.1);
		requestData.put("valid", true);
		requestData.put("content",ByteBuffer.wrap("con".getBytes()));
		
		GenericRecord respon=(GenericRecord)response;
		respon.put("message", requestData);*/
		System.out.println("-----------1------------");
		super.writeResponse(schema, response, out);
	}


	
}
