package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class OperatorSample9 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample9.class);

    public static void main(String[] args) {
        Flowable<Long> evens = Flowable.intervalRange(1, 100, 2000, 1000, MILLISECONDS)
                .filter(aLong -> aLong % 2 == 0);

        Flowable<Long> odds = Flowable.intervalRange(1, 100, 1000, 1000, MILLISECONDS)
                .filter(aLong -> aLong % 2 != 0);

        // TODO use 1 operator to create a stream that outputs the following events every 2 seconds:
        // 1 : 2
        // 3 : 4
        // 5 : 6
        // 7 : 8
        // etc.
        Flowable<String> result = Flowable.empty(); // TODO

        result.subscribe(s -> LOG.info("{}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));

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
