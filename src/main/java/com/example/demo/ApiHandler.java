package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApiHandler {

    public Mono<ServerResponse> index(ServerRequest request) {
        final Map<String,Object> model = new HashMap<>();
        final List<Object> links = new ArrayList<>();
        links.add(new HashMap<>(){{
            put("href", URI.create("http://localhost:8080/accounts"));
            put("rel","accounts");
        }});
        links.add(new HashMap<>(){{
            put("href", URI.create("http://localhost:8080/roles"));
            put("rel","roles");
        }});
        model.put("links",links);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                Mono.just(model),
                Map.class
        );
    }
}
