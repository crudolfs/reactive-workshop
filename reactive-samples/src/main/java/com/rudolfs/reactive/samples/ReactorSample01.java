package com.rudolfs.reactive.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class ReactorSample01 {
    private static final Logger LOG = LoggerFactory.getLogger(ReactorSample01.class);

    public static void main(String[] args) {
        // create Publisher
        Flux<String> words = Flux.just("Java", "Kotlin", "C#", "JavaScript");

        // apply operators
        words.filter(word -> word.contains("Java"))
                .map(String::toLowerCase)
                .subscribe(LOG::info);

    }
}
