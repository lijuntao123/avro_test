package com.example.thrift;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;

public class ThriftTest {

	public static void main(String[] args) {

		try {
			long start1 = System.nanoTime();
			long start = System.nanoTime();
			User p = create();
			long end = System.nanoTime();
			double delta = ((double) end - (double) start) / 1000d;
			System.out.println("object create time  : " + delta + "us");

			start = System.nanoTime();
			byte[] b = serializeTest1(p);
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			// FileInputStream fis=new FileInputStream();
			System.out.println("Serialize time is   : " + delta + "us");
			System.out.println("Serialize size is   : " + b.length + "b");

			start = System.nanoTime();
			User dp = deserlializeTest1(b);
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			System.out.println("deserialize time is : " + delta + "us");

			long end1 = System.nanoTime();
			double delta1 = ((double) end1 - (double) start1) / 1000d;
			System.out.println("Total time is       : " + delta1 + "us");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static User create() {
		User user =new User(); 
			user.setName("zhangsan").setAge("22")
				.setNumber("112233").setAddress("eastsoft").setClass1("class1")
				.setFavorite_color("red").setFavorite_number("8")
				.setPhone("13800000000").setFirst_name("zhang")
				.setLast_name("san");
		return user;

	}

	public static byte[] serializeTest1(User user) {
		 ByteArrayOutputStream baos = new ByteArrayOutputStream(0);
		    TIOStreamTransport trans = new TIOStreamTransport(baos);
		    TBinaryProtocol oprot = new TBinaryProtocol(trans);
		    try {
				user.write(oprot);
			} catch (TException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    byte[] array = baos.toByteArray();
//		    expectedSize = array.length;
		    return array;

	}

	public static User deserlializeTest1(byte[] b) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
	    TIOStreamTransport trans = new TIOStreamTransport(bais);
	    TBinaryProtocol oprot = new TBinaryProtocol(trans);
	    User content = new User();
	    try {
			content.read(oprot);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return content;
	}

}
