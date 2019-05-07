package com.rudolfs.reactive.samples;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample02 {
    private static final Logger LOG = LoggerFactory.getLogger( RxJavaSample02.class );

    public static void main(String[] args) {
        // create Publisher
        Flowable<String> words = Flowable.just("Java", "Kotlin", "C#", "JavaScript");

        // apply operators
        words.filter(word -> word.contains("Java"))
                .map(word -> word.toLowerCase())
                .subscribe(word -> LOG.info("onNext: {}", word),
                        throwable -> LOG.error("onError: {}", throwable),
                        () -> LOG.info("onCompleted"));

    }
}
