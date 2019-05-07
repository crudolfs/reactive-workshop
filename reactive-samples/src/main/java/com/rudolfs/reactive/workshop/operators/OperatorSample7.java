package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OperatorSample7 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample7.class);

    public static void main(String[] args) {
        Flowable<String> stream1 = stream(2, 1, "STREAM_1");
        Flowable<String> stream2 = stream(3, 2, "STREAM_2");
        Flowable<String> stream3 = stream(1, 5, "STREAM_3");

        // TODO use 1 operator that subscribes to all 3 streams, but unsubscribes from the other 2 streams when one of the streams emits the first event.
        Flowable<String> result = Flowable.empty(); // TODO

        LOG.info("start");
        result.subscribe(aLong -> LOG.info("{}", aLong));

        sleep(20_000);
    }

    private static Flowable<String> stream(int initialDelay, int interval, String name) {
        return Flowable.interval(initialDelay, interval, SECONDS)
                .map(x -> name + ": " + x)
                .doOnSubscribe(x -> LOG.info("Subscribe to " + name))
                .doOnCancel(() -> LOG.info("Unsubscribe from " + name));
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
