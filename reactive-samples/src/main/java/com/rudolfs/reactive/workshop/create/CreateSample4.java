package com.rudolfs.reactive.workshop.create;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSample4 {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSample4.class);

    public static void main(String[] args) {
        // TODO create a publisher that has the following requirements:
        // - starts emitting after 2 seconds
        // - emits 10 Long values, starting from 5
        // - emits a Long value every 500 milliseconds
        Flowable<Long> flowable = Flowable.empty(); //TODO

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
