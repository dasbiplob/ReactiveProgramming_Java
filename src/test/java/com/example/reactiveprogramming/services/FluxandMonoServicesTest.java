package com.example.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxandMonoServicesTest {

    FluxandMonoServices fluxandMonoServices =
            new FluxandMonoServices();

    @Test
    void fruitsFlux() {

        var fruitsFlux = fluxandMonoServices.fruitsFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("Orange","Mango","Banana")
                .verifyComplete();
    }

    @Test
    void fruiteMono() {
        var fruitMono = fluxandMonoServices.fruiteMono();
        StepVerifier.create(fruitMono)
                .expectNext("Orange")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMap() {

        var fruitFluxMap = fluxandMonoServices.fruitsFluxMap();
        StepVerifier.create(fruitFluxMap)
                .expectNext("ORANGE","MANGO", "BANANA")
                .verifyComplete();
    }

    @Test
    void fruiteMonoMap() {
        var fruitMonoMap = fluxandMonoServices.fruiteMonoMap();

        StepVerifier.create(fruitMonoMap)
                .expectNext("ORANGE")
                .verifyComplete();
    }

    @Test
    void fruitrsFluxFilter() {

        var fruitFluxFilter = fluxandMonoServices.fruitrsFluxFilter(5);

        StepVerifier.create(fruitFluxFilter)
                .expectNext("Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitrsFluxFilterMap() {
        var fruitrsFluxFilterMap = fluxandMonoServices.fruitrsFluxFilterMap(5);

        StepVerifier.create(fruitrsFluxFilterMap)
                .expectNext("ORANGE","BANANA")
                .verifyComplete();
    }

    @Test
    void fruitrsFluxFilterFlatMap() {
        var fruitrsFluxFlatMap = fluxandMonoServices.fruitrsFluxFlatMap();

        StepVerifier.create(fruitrsFluxFlatMap)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitrsFluxFlatMapAsync() {
        var fruitrsFluxFlatMap = fluxandMonoServices.fruitrsFluxFlatMapAsync();
        StepVerifier.create(fruitrsFluxFlatMap)
                .expectNextCount(17)
                .verifyComplete();

    }

    @Test
    void fruiteMonoFlatMap() {
        var fruitrsFluxFlatMap = fluxandMonoServices.fruiteMonoFlatMap();
        StepVerifier.create(fruitrsFluxFlatMap)
                .expectNextCount(1)
                .verifyComplete();
    }
}