package org.example.day14;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Handler;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<PrintWriter> allPrintWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Starting Chat Server");
        ServerSocket serverSocket = new ServerSocket(PORT);
        try{
            while(true){
                System.out.println("Waiting for connection");
                //new Handler(serverSocket.accept()).start();
            }
        } finally {
            serverSocket.close();
        }
    }
}
