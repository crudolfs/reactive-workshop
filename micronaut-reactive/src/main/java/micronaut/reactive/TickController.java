package micronaut.reactive;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.sse.Event;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.reactivestreams.Publisher;

import static java.util.concurrent.TimeUnit.SECONDS;

@Controller("/tick")
public class TickController {

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Get(value = "/reactive", produces = MediaType.TEXT_PLAIN)
    public HttpResponse<Single<String>> helloReactive() {
        return HttpResponse.ok(
                Single.just("Welcome to reactive Micronaut. Running on " + Thread.currentThread().getName()));
    }

    @Get("/{limit}")
    public Publisher<Event<String>> ticks(Long limit) {
        return Flowable.interval(1, SECONDS)
                .takeUntil(tick -> tick.longValue() == limit)
                .map(tick -> Event.of("This is SSE tick: " + tick));
    }
}