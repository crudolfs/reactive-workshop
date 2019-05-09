package com.rudolfs.vertx.reactive;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;

public class WebSocketClient {
  public static void main(String[] args) throws Exception {
    HttpClient client = Vertx.vertx().createHttpClient();

    client.websocket(8080, "localhost", "/", websocket ->
    {
      websocket.handler(data ->
      {
        System.out.println("Server message: ");
        System.out.println("Received data " + data.toString("ISO-8859-1"));
      });
      websocket.writeBinaryMessage(Buffer.buffer("Hello server"));
    });
  }
}
