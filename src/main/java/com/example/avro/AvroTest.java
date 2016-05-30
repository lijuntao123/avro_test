package com.example.avro;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;

public class AvroTest {

	public static void main(String[] args) {

		try {
//			Arrays.s
			
			System.out.println("------- with code generation---------");
			long start1 = System.nanoTime();
			long start = System.nanoTime();
			User user = create();
//			String str1="";
//			str1.com
			long end = System.nanoTime();
			double delta = ((double) end - (double) start) / 1000d;
			System.out.println("object create time  : " + delta + "us");

			start = System.nanoTime();
			byte[] b = serializeTest1(user);
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			// FileInputStream fis=new FileInputStream();
			System.out.println("Serialize time is   : " + delta + "us");
			System.out.println("Serialize size is   : " + b.length + "b");

			start = System.nanoTime();
			List<GenericRecord> dus;
			dus = deserlializeTest1(b);
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			System.out.println("deserialize time is : " + delta + "us");

			long end1 = System.nanoTime();
			double delta1 = ((double) end1 - (double) start1) / 1000d;
			System.out.println("Total time is       : " + delta1 + "us");

			System.out.println("------- without code generation---------");
			start1 = System.nanoTime();
			start = System.nanoTime();
			GenericRecord user1 = create2();
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			System.out.println("object create time   : " + delta + "us");

			start = System.nanoTime();
			b = serializeTest2(user);
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			// FileInputStream fis=new FileInputStream();
			System.out.println("Serialize time is    : " + delta + "us");
			System.out.println("Serialize size is    : " + b.length + "b");

			start = System.nanoTime();
			dus = deserlializeTest2(b);
			end = System.nanoTime();
			delta = ((double) end - (double) start) / 1000d;
			System.out.println("deserialize time is  : " + delta + "us");

			end1 = System.nanoTime();
			delta1 = ((double) end1 - (double) start1) / 1000d;
			System.out.println("Total time is        :" + delta1 + "us");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static User create() {
		User user = User.newBuilder().setName("zhangsan").setAge("22")
				.setNumber("112233").setAddress("eastsoft").setClass1("class1")
				.setFavoriteColor("red").setFavoriteNumber("8")
				.setPhone("13800000000").setFirstName("zhang")
				.setLastName("san").build();

		return user;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static byte[] serializeTest1(User user)
			throws IOException {
		// File file = new File("users.avro");
		/*
		 * ByteArrayOutputStream out = new ByteArrayOutputStream();
		 * DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(
		 * User.class); DataFileWriter<User> dataFileWriter = new
		 * DataFileWriter<User>( userDatumWriter);
		 * dataFileWriter.create(record.getSchema(), out);
		 * dataFileWriter.append(record); // dataFileWriter.
		 * dataFileWriter.close();
		 */

		// Schema schema = Schema.parse(new File("user.avro"));
		Schema schema = user.getSchema();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GenericDatumWriter writer = new GenericDatumWriter(schema);
		Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
		writer.write(user, encoder);
		encoder.flush();

		return out.toByteArray();

	}

	public static List<GenericRecord> deserlializeTest1(byte[] b)
			throws IOException {

//		File file = new File("users.avro");
		DatumReader<User> datumReader = new SpecificDatumReader<User>(
				User.class);
		/*
		 * DataFileReader<User> dataFileReader = new DataFileReader<User>(file,
		 * userDatumReader); List<User> users = new ArrayList<User>(); User user
		 * = null; while (dataFileReader.hasNext()) {
		 * 
		 * user = dataFileReader.next(user); users.add(user); //
		 * System.out.println(user); }
		 */
		Schema schema = Schema.parse(new File("user.avro"));
		datumReader.setSchema(schema);
		Decoder decoder = DecoderFactory.get().binaryDecoder(b, null);
		List<GenericRecord> records = new ArrayList<GenericRecord>();
		while (true) {
			try {
				GenericRecord result = datumReader.read(null, decoder);
				records.add(result);
//				System.out.println(result);
			} catch (EOFException eof) {
				break;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return records;
	}

	public static GenericRecord create2() {
		Schema schema = null;
		try {
			schema = Schema.parse(new File("user.avro"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GenericRecord user1 = new GenericData.Record(schema);
		user1.put("name", "zhangsan");
		user1.put("favorite_number", "8");
		user1.put("favorite_color", "red");
		user1.put("age", "22");
		user1.put("class1", "12");
		user1.put("number", "112233");
		user1.put("phone", "13800000000");
		user1.put("address", "eastsoft");
		user1.put("first_name", "zhang");
		user1.put("last_name", "san");
		return user1;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static byte[] serializeTest2(GenericRecord record)
			throws IOException {

		// File file = new File("users2.avro");
		Schema schema = record.getSchema();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GenericDatumWriter writer = new GenericDatumWriter(schema);
		Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
		writer.write(record, encoder);
		encoder.flush();

		return out.toByteArray();

	}

	public static List<GenericRecord> deserlializeTest2(byte[] b)
			throws IOException {

		Schema schema = Schema.parse(new File("user.avro"));
		DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(
				schema);

		Decoder decoder = DecoderFactory.get().binaryDecoder(b, null);
		List<GenericRecord> records = new ArrayList<GenericRecord>();
		while (true) {
			try {
				GenericRecord result = datumReader.read(null, decoder);
//				System.out.println(result);
			} catch (EOFException eof) {
				break;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return records;

	}

}
