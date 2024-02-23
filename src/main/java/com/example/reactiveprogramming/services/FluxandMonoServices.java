package com.example.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FluxandMonoServices {

    public Flux<String> fruitsFlux(){
       return Flux.fromIterable(List.of("Orange","Mango","Banana")).log();
    }

    public Flux<String> fruitsFluxMap(){
        return Flux.fromIterable(List.of("Orange","Mango","Banana"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitrsFluxFilter(int number){
        return Flux.fromIterable(List.of("Orange","Mango","Banana"))
                .filter(s->s.length()>number);
    }

    public Flux<String> fruitrsFluxFilterMap(int number){
        return Flux.fromIterable(List.of("Orange","Mango","Banana"))
                .filter(s->s.length()>number)
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitrsFluxFlatMap(){
        return Flux.fromIterable(List.of("Orange","Mango","Banana"))
                .flatMap(s -> Flux.just(s.split("")))
                .log();
    }

    public Flux<String> fruitrsFluxFlatMapAsync(){
        return Flux.fromIterable(List.of("Orange","Mango","Banana"))
                .flatMap(s -> Flux.just(s.split(""))
                        .delayElements(Duration.ofMillis(
                                new Random().nextInt(1000)
                        )))
                .log();
    }

    public Mono<List<String>> fruiteMonoFlatMap(){
        return Mono.just("Orange").flatMap(s->Mono.just(List.of(s.split(""))))
                .log();
    }
    public Mono<String> fruiteMono(){
        return Mono.just("Orange").log();
    }

    public Mono<String> fruiteMonoMap(){
        return Mono.just("Orange")
                .map(String::toUpperCase)
                .log();
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