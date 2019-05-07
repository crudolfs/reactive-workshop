package com.rudolfs.reactive.workshop.operators;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample10 {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample10.class);

    public static void main(String[] args) {
        Flowable<Integer> numbers = Flowable.just(10, 20, 30, 40, 50);

        // TODO use 1 operator to create a stream that emits 1 element that equals the sum of all elements in the numbers stream (150)
        Maybe<Integer> sumOfNumbersMaybe = Maybe.empty(); // TODO

        // TODO try to achieve the same as in previous todo, but now with the scan operator and 1 additional operator
        Flowable<Integer> sumOfNumbersFlowable = Flowable.empty(); // TODO

        sumOfNumbersMaybe.subscribe(s -> LOG.info("sumOfNumbersMaybe: {}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));

        sumOfNumbersFlowable.subscribe(s -> LOG.info("sumOfNumbersFlowable: {}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));
    }
}
