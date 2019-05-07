package com.rudolfs.reactive.samples;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample01 {
    private static final Logger LOG = LoggerFactory.getLogger( RxJavaSample01.class );

    public static void main(String[] args) {
        // create Publisher
        Flowable<String> words = Flowable.just("Java", "Kotlin", "C#", "JavaScript");

        // apply operators
        words.filter(word -> word.contains("Java"))
                .map(String::toLowerCase)
                .subscribe(LOG::info);

    }
}
