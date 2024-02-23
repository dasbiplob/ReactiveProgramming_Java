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
}