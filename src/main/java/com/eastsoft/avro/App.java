package com.eastsoft.avro;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.security.cert.X509Certificate;

import com.eastsoft.router.protocol.filter.tls.SSLContextGenerator;
import com.eastsoft.router.protocol.filter.tls.impl.SSLContextGeneratorImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, Exception
    {
//        System.out.println( "Hello World!" );
//        ServerSocket ss=new ServerSocket(12121);
//        Socket s=new Socket("127.0.0.1", 2222);
//        sslcontext.init(getKeyManagers(), new DummyTrustManager(), null); 
        com.eastsoft.router.ipc.sslfilter.SSLContextGenerator sSLContextGenerator=new SSLContextGeneratorImpl("conf/client.jks", "eastsoft");
        SSLContext sslcontext = sSLContextGenerator.getSslContext();
        SocketFactory socketFactory = sslcontext.getSocketFactory(); 

        SSLSocket socket = (SSLSocket) socketFactory.createSocket("127.0.0.1", 5000);
        X509Certificate[] cert=socket.getSession().getPeerCertificateChain();
        System.out.println(cert.toString());
//        cert[0].get
    }
}
