package com.munteanu.sockets;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class GreetServerTest {

  private static final int SERVER_PORT = 6666;
  private static final int CLIENT_PORT = 4444;
  private static final String CLIENT_HOST = "127.0.0.1";

  private GreetClient client;

  @BeforeClass
  public static void start() throws InterruptedException {
    Executors.newSingleThreadExecutor()
        .submit(() -> new GreetServer().start(SERVER_PORT));
    Thread.sleep(1000);
  }

  @Before
  public void init() {
    client = new GreetClient();
    client.startConnection(CLIENT_HOST, CLIENT_PORT);
  }

  @After
  public void tearDown() {
    client.stopConnection();
  }

  @Test
  public void givenGreetServerAndClient_whenServerResponds_thenCorrectMessageReceived() throws IOException {
    String actualResponse = client.sendMessage("hello server");
    assertEquals("hello client", actualResponse);
  }
}
