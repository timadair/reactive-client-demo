package com.timadair.reactiveclientdemo.controllers;

import com.timadair.reactiveclientdemo.schema.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * Demonstrate a calls between two services.
 *
 * @author timadair
 * Created 10/10/17.
 */
@RestController
public class PersonControllerAndClient {

  @GetMapping(value = "/people/", produces = "text/event-stream")
  public Flux<Person> getPeople() {
    Flux<Person> personFlux = WebClient.create("http://127.0.0.1:8080")
      .get()
      .uri("/persons/")
      .accept(MediaType.APPLICATION_STREAM_JSON)
      .retrieve().bodyToFlux(Person.class);

    return personFlux.map(this::replaceSurname).map(p -> println(p, "Getting"));
  }

  private Person replaceSurname(Person person) {
    return new Person(person.getId(), person.getGivenName(), "notTheOriginal", person.getFullName());
  }

  private Person println(Person d, String mode) {
    System.out.println(mode + ": " + d.getFullName());
    return d;
  }

}
