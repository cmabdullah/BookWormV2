package com.ml.coreweb;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiErrorTest {

    @Test
    void optionalCheck() {
        System.out.println("hello");
        Optional<String> stringOptional = Optional.of("Hello");
        Optional<String> stringOptionalNull = Optional.ofNullable(null);
        assertEquals("Hello", stringOptional.get());
        assertEquals("hello null check", stringOptionalNull.orElse("hello null check"));
        assertEquals("cm", stringOptionalNull.orElseGet(() -> "cm"));
    }

}
