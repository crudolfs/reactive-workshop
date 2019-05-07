package com.rudolfs.reactive.workshop.create;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSample1 {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSample1.class);

    public static void main(String[] args) {
        // TODO create a publisher that emits five string values: 'value1', 'value2' until 'value5'
        Flowable<String> flowable = Flowable.empty(); // TODO

        flowable.subscribe(LOG::info);
    }
}
