package com.rudolfs.reactive.workshop.solutions.flowcontrol;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The example in this class is inspired by https://www.lightbend.com/blog/7-ways-washing-dishes-and-message-driven-reactive-systems
 */
public class FlowControlSample6Solution {
    private static final Logger LOG = LoggerFactory.getLogger(FlowControlSample6Solution.class);

    public static void main(String[] args) {
        final long washDishIntervalInMs = 200;
        // first run this sample and see what happens...
        // as an exercise, try to make the producer backpressure aware
        // solution: just use a Flowable, which is backpressure aware
        Flowable<Dish> dishes = Flowable.range(1, 100_000)
                .map(Dish::new);

        dishes.observeOn(Schedulers.io())
                .subscribe(x -> {
                    LOG.info("Washing: " + x);
                    sleep(washDishIntervalInMs);
                }, throwable -> LOG.error("onError: ", throwable));

        sleep(120_000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOG.warn("Interrupted: ", e);
            Thread.currentThread().interrupt();
        }
    }

    private static class Dish {
        private final byte[] oneKb = new byte[1_024];
        private final long id;

        Dish(long id) {
            this.id = id;
            LOG.info("Created: " + id);
        }

        public String toString() {
            return String.valueOf(id);
        }
    }

}
