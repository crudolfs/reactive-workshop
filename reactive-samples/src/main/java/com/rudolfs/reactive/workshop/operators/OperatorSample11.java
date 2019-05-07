package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample11 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample11.class);

    public static void main(String[] args) {
        Flowable<Integer> temperatures = Flowable.just(17, 17, 20, 21, 22, 22, 22, 19, 19, 20);

        // TODO use 1 operator to create a stream that emits a temperature only when it changes, so the output should be:
        // 17, 20, 21, 22, 19, 20
        Flowable<Integer> result = Flowable.empty(); // TODO

        result.subscribe(s -> LOG.info("{}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));
    }
}
