package com.rudolfs.reactive.workshop.solutions.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample1Solution {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample1Solution.class);

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten");

        // use operators to transform the flowable stream into a stream of Integer that emits all lengths of the String
        // items that are lower than 5
        Flowable<Integer> result = flowable.map(String::length)
                .filter(stringLength -> stringLength < 5);

        result.subscribe(i -> LOG.info("length: {}", i));
    }
}
