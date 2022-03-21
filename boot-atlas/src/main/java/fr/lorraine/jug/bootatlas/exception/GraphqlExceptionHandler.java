package fr.lorraine.jug.bootatlas.exception;

import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ThrowableGraphQLError handle(final NotFoundException nfe) {
        return new ThrowableGraphQLError(nfe);
    }

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError handle(final RuntimeException re) {
        return new ThrowableGraphQLError(re, "Internal Server Error");
    }

}
