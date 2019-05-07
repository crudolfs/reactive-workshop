package com.rudolfs.reactive.workshop.solutions.flowcontrol;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlowControlSample3Solution {
    private static final Logger LOG = LoggerFactory.getLogger(FlowControlSample3Solution.class);

    public static void main(String[] args) {
        Flowable<Long> flowable = Flowable.interval(100, TimeUnit.MILLISECONDS);

        // the flowable above emits a sequential number every 100 milliseconds,
        // use an operator that aggregates all numbers within 1 second time periods (note that the items per aggregation may differ)
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        // [10, 11, 12, 13, 14, 15, 16, 17, 18]
        // [19, 20, 21, 22, 23, 24, 25, 26, 27, 28]
        // etc.
        Flowable<List<Long>> result = flowable.buffer(1, TimeUnit.SECONDS);

        result.take(5)
                .subscribe(s -> LOG.info("{}", s),
                        throwable -> LOG.error("onError: ", throwable),
                        () -> LOG.info("onCompleted"));

        sleep(6_000);
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
