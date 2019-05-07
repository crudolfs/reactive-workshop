package com.rudolfs.reactive.workshop.create;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateSample2 {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSample2.class);

    public static void main(String[] args) {
        List<Integer> evens = IntStream.rangeClosed(1, 100)
                .filter(value -> value % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        // TODO create a publisher that emits all items from the evens List of Integer
        Flowable<String> flowable = Flowable.empty(); // TODO

        flowable.subscribe(i -> LOG.info("number {}: ", i));
    }
}
