package com.rudolfs.reactive.workshop.solutions.flowcontrol;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * The example in this class is inspired by https://www.lightbend.com/blog/7-ways-washing-dishes-and-message-driven-reactive-systems
 */
public class FlowControlSample7Solution {
    private static final Logger LOG = LoggerFactory.getLogger(FlowControlSample7Solution.class);

    public static void main(String[] args) {
        //Flowable<Dish> dishes = Flowable.range(1, 1_000_000_000)
        Flowable<Dish> dishes = Flowable.intervalRange(1, 100_000, 0, 100, MILLISECONDS)
                //.onBackpressureBuffer(300)
                //.onBackpressureDrop(integer -> LOG.info("dropped: {}", integer))
                .onBackpressureBuffer(300, () -> {}, BackpressureOverflowStrategy.ERROR)
                .map(aLong -> aLong.intValue())
                .map(Dish::new);

        LOG.info("start");

        dishes.observeOn(Schedulers.io())
                .subscribe(x -> {
                    LOG.info("Washing: " + x);
                    sleep(200);
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
