package com.rudolfs.reactive.workshop.solutions.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class OperatorSample3Solution {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample3Solution.class);

    public static void main(String[] args) {
        Flowable<String> words = Flowable.just("Lorem", "ipsum", "dolor", "sit", "amet",
                "consectetur", "adipiscing", "elit");

        // similar as previous exercise, but now use the flatMap and timer operators (instead of the delay operator)
        // to ensure that the emission of each String is delayed by the length of the String in seconds.
        // So 'sit' will be emitted after 3 seconds, 'amet' and 'elit' after 4 seconds, etc.
        Flowable<String> result = words.flatMap(word ->
                Flowable.timer(word.length(), TimeUnit.SECONDS).map(x -> word));

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
