package com.rudolfs.reactive.workshop.solutions.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class OperatorSample5Solution {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample5Solution.class);

    public static void main(String[] args) {
        // create a stream of even numbers and a stream of odd numbers and ensure that the streams are merged
        // into one stream that emits a number every second, while preserving the natural order of the numbers (1, 2, 3, 4, ...)
        Flowable<Long> evens = Flowable.intervalRange(1, 100, 0, 1000, MILLISECONDS)
                .filter(aLong -> aLong % 2 == 0);

        Flowable<Long> odds = Flowable.intervalRange(1, 100, 100, 1000, MILLISECONDS)
                .filter(aLong -> aLong % 2 != 0);

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
