package com.rudolfs.reactive.workshop.flowcontrol;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class FlowControlSample4 {
    private static final Logger LOG = LoggerFactory.getLogger(FlowControlSample4.class);

    public static void main(String[] args) {
        Flowable<Long> events = Flowable.interval(100, TimeUnit.MILLISECONDS);

        // TODO use the window operator to count the number of events per second
        Flowable<Long> eventsPerSecond = Flowable.empty(); // TODO

        eventsPerSecond.subscribe(s -> LOG.info("{}", s),
                        throwable -> LOG.error("onError: ", throwable),
                        () -> LOG.info("onCompleted"));

        sleep(10_000);
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
