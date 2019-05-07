package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample5 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample5.class);

    public static void main(String[] args) {
        // TODO create a stream of even numbers and a stream of odd numbers and ensure that the streams are merged
        // into one stream that emits a number every second, while preserving the natural order of the numbers (1, 2, 3, 4, ...)
        Flowable<Long> evens = Flowable.empty();// TODO

        Flowable<Long> odds = Flowable.empty();// TODO

        evens.mergeWith(odds)
                .subscribe(aLong -> LOG.info("number: {}", aLong));

        sleep(20_000);
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
