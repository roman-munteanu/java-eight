package com.munteanu.sockets;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executors;

public class MultiClientServerTest {

  private static final int PORT = 5555;
  private static final String HOST = "127.0.0.1";

  @BeforeClass
  public static void start() throws InterruptedException {
    Executors.newSingleThreadExecutor().submit(
        () -> new MultiClientServer().start(PORT)
    );
    Thread.sleep(500);
  }

  @Test
  public void test() throws IOException {
    Socket client1 = new Socket(HOST, PORT);
    Runnable handler1 = new RequestHandler(client1);
    // TODO
  }

}
