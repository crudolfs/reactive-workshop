package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OperatorSample6 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample6.class);

    public static void main(String[] args) {
        Flowable<Long> flowable = Flowable.just(5L, 2L);

        // TODO use 1 operator to transform the flowable stream into stream1 that:
        // - first emits the number 5 after 5 seconds from subscription (use the delayedLong method below)
        // - secondly emits the number 2 after 7 seconds from subscription (use the delayedLong method below)
        Flowable<Long> stream1 = Flowable.empty(); // TODO

        // TODO use 1 operator to transform the flowable stream into stream2 that:
        // - first emits the number 2 after 2 seconds from subscription (use the delayedLong method below)
        // - secondly emits the number 5 after 5 seconds from subscription (use the delayedLong method below)
        Flowable<Long> stream2 = Flowable.empty(); // TODO

        LOG.info("start");
        stream1.subscribe(aLong -> LOG.info("stream1: {}", aLong));
        stream2.subscribe(aLong -> LOG.info("stream2: {}", aLong));

        sleep(10_000);
    }

    private static Flowable<Long> delayedLong(Long aLong) {
        return Flowable.timer(aLong, SECONDS).map(x -> aLong);
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
