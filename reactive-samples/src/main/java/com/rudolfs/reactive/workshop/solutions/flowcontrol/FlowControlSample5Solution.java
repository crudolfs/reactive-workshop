package com.rudolfs.reactive.workshop.solutions.flowcontrol;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class FlowControlSample5Solution {
    private static final Logger LOG = LoggerFactory.getLogger(FlowControlSample5Solution.class);

    public static void main(String[] args) {
        Flowable<Long> keyEvents = Flowable.interval(60, MILLISECONDS)
                .flatMap(aLong -> randomDelay(aLong));

        // TODO use an operator that discards all of the events that are followed by another event within 100 milliseconds,
        // in other words if a given event is not followed by another event within 100 milliseconds it should be emitted
        Flowable<Long> result = keyEvents.debounce(100, MILLISECONDS);

        result.subscribe(s -> LOG.info("{}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));

        sleep(20_000);
    }

    private static Flowable<Long> randomDelay(long x) {
        return Flowable.just(x)
                .delay((long) (Math.random() * 100), MILLISECONDS);
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