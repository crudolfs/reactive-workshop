package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OperatorSample8 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample8.class);

    public static void main(String[] args) {
        // Create infinite stream
        Flowable<Long> ticks = Flowable.interval(1, SECONDS);

        // TODO use operators to transform the ticks stream into a stream that emits values from 10 to 20 and
        // unsubscribes from the ticks stream.
        Flowable<Long> result = Flowable.empty(); //TODO

        result.subscribe(aLong -> LOG.info("{}", aLong),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));

        sleep(30_000);
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
