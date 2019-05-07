package com.rudolfs.reactive.workshop.solutions.create;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateSample5Solution {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSample5Solution.class);

    public static void main(String[] args) {
        // create can be used as a bridge from imperative to reactive code, a BackpressureStrategy is required though.
        Flowable<String> flowable = Flowable.create(emitter -> {
            List<String> todos = getTodos(10);
            // create a stream of todo Strings and make sure to complete the stream correctly
            todos.forEach(todo -> emitter.onNext(todo));
            emitter.onComplete();
        }, BackpressureStrategy.DROP);

        flowable.subscribe(LOG::info,
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onComplete"));
    }

    private static List<String> getTodos(final int numberOfTodos) {
        return IntStream.rangeClosed(1, numberOfTodos)
                .mapToObj(i -> "todo-" + i)
                .collect(Collectors.toList());
    }
}
