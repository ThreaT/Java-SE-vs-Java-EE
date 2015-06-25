package com.java.se.vs.java.ee.webserver.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import java.io.FileInputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

public class WebServer {

    public static void main(String[] args) throws Exception {
        startHttpServer();
        startHttpsServer();
        System.out.println("Java SE WebServer started.");
    }

    public static void startHttpServer() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(80), 0);
        httpServer.createContext("/example", new ExampleHandler());
        httpServer.setExecutor(null);
        httpServer.start();
    }

    public static void startHttpsServer() throws CertificateException, IOException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        HttpsServer httpsServer = HttpsServer.create(new InetSocketAddress(443), 0);
        char[] keystorePassword = "password".toCharArray();
        SSLContext sslContext = SSLContext.getInstance("TLS");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("keystore.jks"), keystorePassword);
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, keystorePassword);
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
        HttpsConfigurator configurator = new HttpsConfigurator(sslContext);
        httpsServer.createContext("/example", new ExampleHandler());
        httpsServer.setHttpsConfigurator(configurator);
        httpsServer.setExecutor(null);
        httpsServer.start();
    }

    public static class ExampleHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "Java-SE-WebServer-Example";
            httpExchange.sendResponseHeaders(200, response.length());
            try (OutputStream outputStream = httpExchange.getResponseBody()) {
                outputStream.write(response.getBytes());
            }
        }
    }

}
