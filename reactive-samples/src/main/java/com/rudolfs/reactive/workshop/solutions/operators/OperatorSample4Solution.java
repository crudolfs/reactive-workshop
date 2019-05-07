package com.rudolfs.reactive.workshop.solutions.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OperatorSample4Solution {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample4Solution.class);

    public static void main(String[] args) {
        Flowable<Long> flowable = Flowable.just(10L, 1L);

        // use operators to transform the above stream such that 10L is emitted after 1L.
        Flowable<Long> result =
                flowable.flatMap(aLong -> Flowable.timer(aLong, SECONDS).map(x -> aLong));

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
