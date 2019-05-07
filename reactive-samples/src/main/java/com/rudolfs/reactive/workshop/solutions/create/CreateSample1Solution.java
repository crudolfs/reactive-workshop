package com.rudolfs.reactive.workshop.solutions.create;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSample1Solution {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSample1Solution.class);

    public static void main(String[] args) {
        // create a publisher that emits five string values: 'value1', 'value2' until 'value5'
        Flowable<String> flowable = Flowable.just("value1", "value2", "value3", "value4", "value5");

        flowable.subscribe(LOG::info);
    }
}
