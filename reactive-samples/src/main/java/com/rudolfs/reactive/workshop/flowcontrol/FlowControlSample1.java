package com.rudolfs.reactive.workshop.flowcontrol;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class FlowControlSample1 {
    private static final Logger LOG = LoggerFactory.getLogger(FlowControlSample1.class);

    public static void main(String[] args) {
        Flowable<Long> flowable = Flowable.interval(10, TimeUnit.MILLISECONDS);

        // TODO the flowable above emits a sequential number every 10 milliseconds,
        // use a periodic sampling operator (after timestamp operator) to emit the most recent item every 1 second
        long startTime = System.currentTimeMillis();
        Flowable<Timed<Long>> result = flowable.timestamp(); // TODO

        result.map(ts -> ts.time() - startTime + "ms: " + ts.value())
                .take(5)
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
