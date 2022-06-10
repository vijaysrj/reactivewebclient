package com.example.reactive;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class WebClientTestController {

	@GetMapping("/reactiveclient")
	public void test() {

		Flux<Map> response = WebClient
							.builder()
							.baseUrl("http://localhost:8088/superhero")
							.build()
							.get()
							.retrieve()
							.bodyToFlux(Map.class);

		response.subscribe(

				data -> {

					System.out.println(data);
				});

	}

}
