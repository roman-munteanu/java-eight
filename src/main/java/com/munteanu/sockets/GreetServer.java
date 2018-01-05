package com.munteanu.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetServer {

//    private static final Logger LOG = LoggerFactory.getLogger(GreetServer.class);

  private ServerSocket server;
  private Socket client;
  private PrintWriter out;
  private BufferedReader in;

  public void start(int port) {
    try {
      server = new ServerSocket(port);
      client = server.accept();

      out = new PrintWriter(client.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));

      String msg = in.readLine();
      if ("hello server".equals(msg)) {
        out.println("hello client");
      } else {
        out.println("unknown message");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void stop() {
    try {
      in.close();
      out.close();
      client.close();
      server.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    GreetServer greetServer = new GreetServer();
    greetServer.start(6666);
  }
}
