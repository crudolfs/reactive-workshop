package com.rudolfs.reactive.samples;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample05 {
    private static final Logger LOG = LoggerFactory.getLogger(RxJavaSample05.class);

    public static void main(String[] args) {
        // Observable defaults to being synchronous
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        });

        // map defaults to being synchronous
        observable.map(i -> "Number " + i)
                .subscribe(event -> LOG.info("{}", event));

        LOG.info("end");
    }
}
