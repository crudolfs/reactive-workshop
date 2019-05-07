package com.rudolfs.reactive.workshop.create;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSample3 {
    private static final Logger LOG = LoggerFactory.getLogger( CreateSample3.class );

    public static void main(String[] args) {
        // TODO create a publisher that emits integers in the range of 5 to 15
        Flowable<String> flowable = Flowable.empty(); // TODO

        flowable.subscribe(i -> LOG.info("number {}: ", i));
    }
}
