package com.rudolfs.reactive.workshop.solutions.create;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSample3Solution {
    private static final Logger LOG = LoggerFactory.getLogger( CreateSample3Solution.class );

    public static void main(String[] args) {
        // create a publisher that emits 10 integers, starting from 5
        Flowable<Integer> flowable = Flowable.range(5, 10);

        flowable.subscribe(i -> LOG.info("number {}: ", i));
    }
}
