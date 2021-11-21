package com.example.demo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ApiHandler {

    public Mono<ServerResponse> index(ServerRequest request) {
        final RepresentationModel<?> model = new RepresentationModel<>();
        model.add(Link.of("http://localhost:8080/accounts","accounts"));
        model.add(Link.of("http://localhost:8080/roles","roles"));
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                    Mono.just(model),
                    RepresentationModel.class
            );
    }
}
