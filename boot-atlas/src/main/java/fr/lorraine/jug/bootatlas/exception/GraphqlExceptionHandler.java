package fr.lorraine.jug.bootatlas.exception;

import graphql.GraphqlErrorException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler({
            NotFoundException.class,
            GraphqlErrorException.class,
            ConstraintViolationException.class})
    public ThrowableGraphQLError handle(final Exception nfe) {
        return new ThrowableGraphQLError(nfe);
    }

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError handle(final RuntimeException re) {
        return new ThrowableGraphQLError(re, "Internal Server Error");
    }

}
