package com.rudolfs.reactive.samples;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxJavaSample04 {
    private static final Logger LOG = LoggerFactory.getLogger(RxJavaSample04.class);

    public static void main(String[] args) {
        // Observable defaults to being synchronous
        Observable.create(emitter -> {
            emitter.onNext("EVENT 1");
            emitter.onComplete();
        }).subscribe(event -> LOG.info("{}", event),
                throwable -> LOG.error("onError: ", throwable),
                () -> LOG.info("onComplete"));

    }

}
