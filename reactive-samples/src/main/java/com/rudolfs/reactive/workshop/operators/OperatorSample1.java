package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample1 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample1.class);

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten");

        // TODO use operators to transform the flowable stream into a stream of Integer that emits all lengths of the String
        // items that are lower than 5
        Flowable<Integer> result = Flowable.empty(); //TODO

        result.subscribe(i -> LOG.info("length: {}", i));
    }
}
