package com.rudolfs.reactive.samples;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample06 {
    private static final Logger LOG = LoggerFactory.getLogger(RxJavaSample06.class);

    public static void main(String[] args) {
        // DO NOT DO THIS: onNext is invoked concurrently
        Observable<String> observable =
                Observable.create(s -> {
                    // Thread A
                    new Thread(() -> {
                        s.onNext("one");
                        s.onNext("two");
                    }).start();
                    // Thread B
                    new Thread(() -> {
                        s.onNext("three");
                        s.onNext("four");
                    }).start();

                    // ignoring need to emit s.onCompleted() due to race of threads
                });

        // map defaults to being synchronous
        observable.map(i -> "Number " + i)
                .subscribe(event -> LOG.info("{}", event));

        LOG.info("end");
    }
}