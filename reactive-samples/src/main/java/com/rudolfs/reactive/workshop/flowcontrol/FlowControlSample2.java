package com.rudolfs.reactive.workshop.flowcontrol;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FlowControlSample2 {
    private static final Logger LOG = LoggerFactory.getLogger(FlowControlSample2.class);

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.range(1, 100);

        // TODO use an operator such that the result stream emits Lists of Integers of size 5
        // [1, 2, 3, 4, 5]
        // [6, 7, 8, 9, 10]
        // [11, 12, 13, 14, 15]
        // etc.
        Flowable<List<Integer>> result = Flowable.empty(); // TODO

        result.subscribe(s -> LOG.info("{}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));
    }
}
