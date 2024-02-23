package com.example.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxandMonoServices {

    public Flux<String> fruitsFlux(){
       return Flux.fromIterable(List.of("Orange","Mango","Banana")).log();
    }

    public Mono<String> fruiteMono(){
        return Mono.just("Orange").log();
    }

    public static void main(String[] args){
        FluxandMonoServices fluxandMonoServices = new FluxandMonoServices();
        fluxandMonoServices.fruitsFlux()
                .subscribe(s->{
                    System.out.println("Flux s = "+s);
                });

        fluxandMonoServices.fruiteMono()
                .subscribe(s -> {
                    System.out.println("Mono -> s = " +s);
                });
    }
}