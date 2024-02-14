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
        if (ex instanceof PropertyManagementException) {
            return GraphqlErrorBuilder.newError()
                    .errorType(resolveErrorType(ex))
                    .message(ex.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        } else {
            return null;
        }
    }

    private ErrorTypes resolveErrorType(Throwable ex) {
        return Enum.valueOf(ErrorTypes.class,ex.getCause().getMessage());
    }
}