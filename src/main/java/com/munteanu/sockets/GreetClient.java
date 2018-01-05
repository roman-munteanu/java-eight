package com.munteanu.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GreetClient {

  private Socket client;
  private PrintWriter out;
  private BufferedReader in;

  public void startConnection(String host, int port) {
    try {
      client = new Socket(host, port);
      out = new PrintWriter(client.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void stopConnection() {
    try {
      in.close();
      out.close();
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String sendMessage(String msg) throws IOException {
    out.println(msg);
    return in.readLine();
  }
}
