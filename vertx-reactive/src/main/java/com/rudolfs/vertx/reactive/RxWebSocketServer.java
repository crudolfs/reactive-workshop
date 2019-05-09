package com.rudolfs.vertx.reactive;

import io.reactivex.Flowable;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.http.HttpServer;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RxWebSocketServer {

  public static void main(String[] args) {
    HttpServer rxHttpServer = Vertx.vertx().createHttpServer();
    rxHttpServer.websocketStream().toFlowable()
      .subscribe(serverWebSocket -> {
        serverWebSocket.toFlowable()
          .map(buffer -> buffer.toString("UTF-8"))
          .filter(searchTerm -> searchTerm.length() >= 3)
          // TODO change the following operator such that when a new searchTerm arrives, the result from
          // the previous search operation is unsubscribed from
          .flatMap(searchTerm -> doSlowSearch(searchTerm))
          .subscribe(serverWebSocket::writeTextMessage);
      });
    rxHttpServer.listen(8080);
  }

  private static Flowable<String> doSlowSearch(String searchTerm) {
    return Flowable.timer(8, SECONDS)
      .map(aLong -> "Found result for searchTerm: '" + searchTerm + "'");
  }
}
