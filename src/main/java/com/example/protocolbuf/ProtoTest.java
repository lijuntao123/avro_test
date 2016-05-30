package com.example.protocolbuf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.example.protocolbuf.User.Person;

public class ProtoTest {

	public static void main(String[] args) {

		try {
			long start1 = System.nanoTime();
			long start = System.nanoTime();
			Person p = create();
			long end = System.nanoTime();
			double delta = ((double) end - (double) start) / 1000d;
			System.out.println("object create time   : " + delta + "us");

			start = System.nanoTime();
			byte[] b = serializeTest1(p);
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			// FileInputStream fis=new FileInputStream();
			System.out.println("Serialize time is    : " + delta + "us");
			System.out.println("Serialize size is    : " + b.length + "b");

			start = System.nanoTime();
			Person dp = deserlializeTest1(b);
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			System.out.println("deserialize time is  : " + delta + "us");

			long end1 = System.nanoTime();
			double delta1 = ((double) end1 - (double) start1) / 1000d;
			System.out.println("Total time is        : " + delta1 + "us");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Person create() {
		Person person1 = Person.newBuilder().setName("zhangsan").setAge("22")
				.setNumber("112233").setAddress("eastsoft").setClass1("class1")
				.setFavoriteColor("red").setFavoriteNumber("8")
				.setPhone("13800000000").setFirstName("zhang")
				.setLastName("san").build();
		return person1;

	}

	public static byte[] serializeTest1(Person p) throws IOException {
		return p.toByteArray();

	}

	public static Person deserlializeTest1(byte[] b) throws IOException {
		return Person.parseFrom(b);
	}

}
