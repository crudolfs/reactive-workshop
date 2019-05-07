package com.rudolfs.reactive.samples;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample03 {
    private static final Logger LOG = LoggerFactory.getLogger(RxJavaSample03.class);

    public static void main(String[] args) {
        // create stream of even integers
        Flowable<Integer> evens = Flowable.range(1, 100)
                .filter(i -> i % 2 == 0);

        // create stream of odd integers
        Flowable<Integer> odds = Flowable.range(1, 100)
                .filter(i -> i % 2 != 0);

        // merge both streams
        evens.mergeWith(odds)
                .subscribe(i -> LOG.info("onNext: {}", i),
                        throwable -> LOG.error("onError: {}", throwable),
                        () -> LOG.info("onComplete"));
    }
}