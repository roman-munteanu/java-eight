
package com.munteanu.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler implements Runnable {

  private final Socket client;
  private PrintWriter out;
  private BufferedReader in;

  public RequestHandler(Socket client) {
    this.client = client;
  }

  @Override
  public void run() {
    try {
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      out = new PrintWriter(client.getOutputStream(), true);

      System.out.println("Thread started with name: " + Thread.currentThread().getName());

      String inputLine;
      while ( (inputLine = in.readLine()) != null ) {
        System.out.println("Read line from client: " + client);
        if ("quit".equals(inputLine)) {
          out.println("Bye");
          break;
        }
        out.println("Hi " + inputLine);
        out.flush();
      }
      stop();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void stop() {
    try {
      in.close();
      out.close();
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
