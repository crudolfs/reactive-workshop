package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample4 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample4.class);

    public static void main(String[] args) {
        Flowable<Long> flowable = Flowable.just(10L, 1L);

        // TODO use operators to transform the above stream such that 10L is emitted after 1L.
        Flowable<Long> result = Flowable.empty(); // TODO

        result.subscribe(aLong -> LOG.info("{}", aLong));

        sleep(12_000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOG.warn("Interrupted: ", e);
            Thread.currentThread().interrupt();
        }
    }
}
