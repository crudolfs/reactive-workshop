package com.rudolfs.reactive.samples;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample08 {
    private static final Logger LOG = LoggerFactory.getLogger(RxJavaSample08.class);

    public static void main(String[] args) {
        // create stream of even integers
        Flowable<Integer> evens = Flowable.range(1, 10)
                .filter(i -> i % 2 == 0);

        // subscription 1
        evens.subscribe(i -> LOG.info("1 onNext: {}", i));

        // subscription 2
        evens.subscribe(i -> LOG.info("2 onNext: {}", i));
    }
}