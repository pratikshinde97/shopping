package com.example.shopping.util;


import com.example.shopping.exception.ResourceNotFoundException;

public class RestPreconditions {

    public static <T> T checkFound(T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new ResourceNotFoundException();
        }
        return reference;
    }
}
