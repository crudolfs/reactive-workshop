package com.rudolfs.reactive.workshop.solutions.flowcontrol;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The example in this class is inspired by https://www.lightbend.com/blog/7-ways-washing-dishes-and-message-driven-reactive-systems
 */
public class FlowControlSample6Solution {
    private static final Logger LOG = LoggerFactory.getLogger(FlowControlSample6Solution.class);

    public static void main(String[] args) {
        Observable<Dish> dishes = Observable.range(1, 1_000_000_000)
                .map(Dish::new);

        dishes.observeOn(Schedulers.io())
                .subscribe(x -> {
                    LOG.info("Washing: " + x);
                    sleep(50);
                }, throwable -> LOG.error("onError: ", throwable));
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
        private final int id;

        Dish(int id) {
            this.id = id;
            LOG.info("Created: " + id);
        }

        public String toString() {
            return String.valueOf(id);
        }
    }

}
