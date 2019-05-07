package com.rudolfs.reactive.workshop.solutions.operators;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorSample10Solution {
    private static final Logger LOG = LoggerFactory.getLogger(OperatorSample10Solution.class);

    public static void main(String[] args) {
        Flowable<Integer> numbers = Flowable.just(10, 20, 30, 40, 50);
        // use 1 operator to create a stream that emits 1 element that equals the sum of all elements in the numbers stream (150)
        Maybe<Integer> sumOfNumbersMaybe = numbers.reduce((totalSoFar, i) -> totalSoFar + i);

        // try to achieve the same as in previous todo, but now with the scan operator and 1 additional operator
        Flowable<Integer> sumOfNumbersFlowable = numbers.scan((integer, integer2) -> integer + integer2).takeLast(1);

        sumOfNumbersMaybe.subscribe(s -> LOG.info("sumOfNumbersMaybe: {}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));

        sumOfNumbersFlowable.subscribe(s -> LOG.info("sumOfNumbersFlowable: {}", s),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onCompleted"));
    }
}
