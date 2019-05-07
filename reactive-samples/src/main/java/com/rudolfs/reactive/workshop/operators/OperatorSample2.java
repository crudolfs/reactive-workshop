package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample2 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample2.class);

    public static void main(String[] args) {
        Flowable<String> words = Flowable.just("Lorem", "ipsum", "dolor", "sit", "amet",
                "consectetur", "adipiscing", "elit");

        // TODO use the delay and timer operators to ensure that the emission of each String is delayed by the length of the
        // String in seconds. So 'sit' will be emitted after 3 seconds, 'amet' and 'elit' after 4 seconds, etc.
        Flowable<String> result = Flowable.empty(); // TODO

        result.subscribe(LOG::info);

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
