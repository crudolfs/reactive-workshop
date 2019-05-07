package com.rudolfs.reactive.samples;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample03b {
    private static final Logger LOG = LoggerFactory.getLogger(RxJavaSample03b.class);

    public static void main(String[] args) {
        // operator composition
        Observable.just(8, 9, 10)
                .filter(i -> i % 3 > 0)
                .map(i -> "#" + i * 10)
                .filter(s -> s.length() < 4)
                .subscribe(s -> LOG.info("D: {}", s));
    }
}