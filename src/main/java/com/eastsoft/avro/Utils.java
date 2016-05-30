package com.eastsoft.avro;

import java.io.File;
import java.io.IOException;
import java.net.URL;
 
import org.apache.avro.Protocol;
 /**
  * 获取client与server之间通信的协议
  * @author ljt
  *
  */
public class Utils {
    public static Protocol getProtocol() {
        Protocol protocol = null;
        try {
//            URL url = Utils.class.getClassLoader().getResource("message.avsc");
//            protocol = Protocol.parse(new File(url.getPath()));
//        	protocol = Protocol.parse(new File("conf/protocol.avro"));
        	protocol = Protocol.parse(new File("conf/routerProtocol.avsc"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return protocol;
    }
}
