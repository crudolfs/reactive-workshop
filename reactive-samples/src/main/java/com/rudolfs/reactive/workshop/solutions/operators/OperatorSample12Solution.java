package com.rudolfs.reactive.workshop.solutions.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample12Solution {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample12Solution.class);

    public static void main(String[] args) {
        Flowable<Integer> temperatures = Flowable.just(17, 17, 20, 21, 22, 22, 22, 19, 19, 20);

        // TODO use 1 operator to create a stream that emits all distinct temperatures:
        // 17, 20, 21, 22, 19
        Flowable<Integer> result = temperatures.distinct();

        result.subscribe(s -> LOG.info("{}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));
    }
}
