package com.rudolfs.reactive.workshop.solutions.create;

import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class CreateSample6Solution {
    private static final Logger LOG = LoggerFactory.getLogger(CreateSample6Solution.class);

    public static void main(String[] args) {
        final String validUrl = "https://www.google.nl";
        final String invalidUrl = "this_is_not_a_valid_url";
        // create an URL (by using the getURL method below) based on the validUrl String above and emit this as a single event
        Single<URL> validUrlSingle = Single.fromCallable(() -> getURL(validUrl));

        // create an URL (by using the getURL method below) based on the invalidUrl String above and emit the error that is thrown
        Single<URL> invalidUrlSingle = Single.fromCallable(() -> getURL(invalidUrl));

        validUrlSingle.subscribe(url -> LOG.info("URL: {}", url),
                throwable -> LOG.error("onError: ", throwable));

        invalidUrlSingle.subscribe(url -> LOG.info("URL: {}", url),
                throwable -> LOG.error("onError: ", throwable));
    }

    private static URL getURL(String url) throws MalformedURLException {
        return URI.create(url).toURL();
    }
}
