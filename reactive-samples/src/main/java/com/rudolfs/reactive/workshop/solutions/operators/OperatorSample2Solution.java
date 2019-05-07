package com.rudolfs.reactive.workshop.solutions.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class OperatorSample2Solution {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample2Solution.class);

    public static void main(String[] args) {
        Flowable<String> words = Flowable.just("Lorem", "ipsum", "dolor", "sit", "amet",
                        "consectetur", "adipiscing", "elit");

        // use the delay and timer operators to ensure that the emission of each String is delayed by the length of the
        // String in seconds. So 'sit' will be emitted after 3 seconds, 'amet' and 'elit' after 4 seconds, etc.
        Flowable<String> result = words.delay(word -> Flowable.timer(word.length(), TimeUnit.SECONDS));

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
