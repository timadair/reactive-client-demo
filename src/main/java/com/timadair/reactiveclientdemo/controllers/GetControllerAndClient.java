package com.timadair.reactiveclientdemo.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * Demonstrates a reactive call to another service
 *
 * @author timadair
 * Created 10/10/17.
 */
@RestController
public class GetControllerAndClient {

  @GetMapping(value = "/flux-client/", produces = "text/event-stream")
  public Flux<String> getTerminatingFlux() {
    Flux<String> personFlux = WebClient.create("http://127.0.0.1:8080")
      .get()
      .uri("/flux/endless")
      .accept(MediaType.TEXT_EVENT_STREAM)
      .retrieve().bodyToFlux(String.class);

    return personFlux.take(100).map(this::mapAndPrint);
  }

  @GetMapping(value = "/flux-client/endless", produces = "text/event-stream")
  public Flux<String> getEndlessFlux() {
    Flux<String> personFlux = WebClient.create("http://127.0.0.1:8080")
      .get()
      .uri("/flux/endless")
      .accept(MediaType.TEXT_EVENT_STREAM)
      .retrieve().bodyToFlux(String.class);

    return personFlux.map(this::mapAndPrint);
  }

  private String mapAndPrint(String i) {
    System.out.println(i);
    return i + " Plus processing";
  }
}
