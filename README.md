# Workshop Reactive Programming
In this workshop you'll learn the basics and some more advanced topics regarding Reactive Programming in Java.
All samples will use RxJava2, but feel free to use Project Reactor instead.  

## 1. Creating Publishers
This section is about creating Publishers.

Fix the TODOs in the *reactive-samples* module (by replacing the empty Publishers) in all CreateSample* classes in the package com.rudolfs.reactive.workshop.create.

## 2. Using operators
In this section you'll work with various Reactive Programming operators, like *map*, *flatMap*, 
*filter*, *merge*, *delay*, *concatMap*, *takeUntil*, *zip*, etc.  

Fix the TODOs in the *reactive-samples* module in all OperatorSample* classes in the package com.rudolfs.reactive.workshop.operators.

## 3. Flow Control
This section is about flow control, which becomes important when consumers can't keep up with events emitted from within the producer.

The samples will show multiple ways to deal with flow control. 

Fix the TODOs in the *reactive-samples* module in all FlowControlSample* classes in the package com.rudolfs.reactive.workshop.flowcontrol. 

## 4. Integration with front-end

### 4.1 Server-Sent Events (SSE)
We're going to use Micronaut to implement the server side of SSE.

Open the TickController class in the *micronaut-reactive* module and have a look at the reactive return types of both methods.

Start the Application main class inside the *micronaut-reactive* module.

Use curl as the client: 

```curl -X GET -H "Accept:text/event-stream" http://localhost:8080/tick/10```

The data events should be printed to your console now.

As an exercise, try to add some additional endpoints and/or logic within the existing endpoint. 

### 4.2 WebSockets
We'll use [Vert.x with RxJava2](https://vertx.io/docs/vertx-rx/java2/) to implement a WebSocket Server.

Open the RxWebSocketServer class in the *vertx-reactive* module and run the program, this will start a WebSocket Server 
listening on port 8080. Use e.g. [Advanced Rest Client](https://install.advancedrestclient.com/install) to send some messages  
to the WebSocket Server by connecting to ws://localhost:8080. The WebSocket Server simulates the processing of a user's search 
action (from e.g. a web page) and streams the search results back to the WebSocket Client connection. The search operation is 
delayed on purpose to simulate a long running search. 

Try to solve the TODO in the RxWebSocketServer. 

Additional exercise: rewrite the WebSocketClient into a RxWebSocketClient (by using the io.vertx.reactivex.core.http.HttpClient).

