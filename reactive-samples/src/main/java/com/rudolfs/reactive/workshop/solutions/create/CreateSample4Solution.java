package com.rudolfs.reactive.workshop.solutions.create;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class CreateSample4Solution {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSample4Solution.class);

    public static void main(String[] args) {
        // create a publisher that has the following requirements:
        // - starts emitting after 2 seconds
        // - emits 10 Long values, starting from 5
        // - emits a Long value every 500 milliseconds
        Flowable<Long> flowable = Flowable.intervalRange(5, 10, 5000, 500, MILLISECONDS);

        flowable.subscribe(i -> LOG.info("number {}: ", i),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onComplete"));

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
