package io.a1brz.app;

import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/")
public class Controller {
    @Inject
    Service service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("ping")
    public CompletionStage<String> ping() {
        return CompletableFuture.supplyAsync(() -> "pong");
    }

    @GET
    @Path("stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> stream() {
        return service.stream();
    }
}