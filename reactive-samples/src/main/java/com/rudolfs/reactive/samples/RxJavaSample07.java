package com.rudolfs.reactive.samples;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample07 {
    private static final Logger LOG = LoggerFactory.getLogger(RxJavaSample07.class);

    public static void main(String[] args) {
        // DON'T START A THREAD LIKE THIS INSIDE AN OBSERVABLE
        Observable<String> a = Observable.create(s -> {
            new Thread(() -> {
                s.onNext("one");
                s.onNext("two");
                s.onComplete();
            }).start();
        });

        Observable<String> b = Observable.create(s -> {
            new Thread(() -> {
                s.onNext("three");
                s.onNext("four");
                s.onComplete();
            }).start();
        });

        // this subscribes to a and b concurrently,
        // and merges into a third sequential stream
        Observable<String> c = Observable.merge(a, b);

        c.subscribe(event -> LOG.info("{}", event));

        // output:
        // - 'one' will appear before 'two'
        // - 'three' will appear before 'four'
        // - the order between 'one'/'two' and 'thre'/'four' is unspecified

        LOG.info("end");

    }
}