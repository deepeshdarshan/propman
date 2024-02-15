package com.eh.propman.app.shared.config;

import com.eh.propman.app.shared.exception.ErrorTypes;
import com.eh.propman.commons.exceptions.PropertyManagementException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        var errorType = ex instanceof PropertyManagementException ? resolveErrorType(ex) : ErrorTypes.INTERNAL_ERROR;
        var message = ex instanceof PropertyManagementException ? ex.getMessage() : ex.getCause().getMessage();
        return GraphqlErrorBuilder.newError()
                .errorType(errorType)
                .message(message)
                .path(env.getExecutionStepInfo().getPath())
                .location(env.getField().getSourceLocation())
                .build();
    }

    private ErrorTypes resolveErrorType(Throwable ex) {
        return Enum.valueOf(ErrorTypes.class, ex.getCause().getMessage());
    }
}