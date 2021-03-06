package com.aol.cyclops.sum.types;

import org.junit.Test;

import com.aol.cyclops.control.Maybe;

public class MaybeTest {

    @Test
    public void flatMap() {
        Maybe.of(10)
             .flatMap(i -> { System.out.println("Not lazy!"); return  Maybe.of(15);})
             .map(i -> { System.out.println("Not lazy!"); return  Maybe.of(15);})
             .map(i -> Maybe.of(20));
            
    }
     @Test
    public void odd() {
        System.out.println(even(Maybe.just(200000)).get());
    }

    public Maybe<String> odd(Maybe<Integer> n) {

        return n.flatMap(x -> even(Maybe.just(x - 1)));
    }

    public Maybe<String> even(Maybe<Integer> n) {
        return n.flatMap(x -> {
            return x <= 0 ? Maybe.just("done") : odd(Maybe.just(x - 1));
        });
    }
 
}
