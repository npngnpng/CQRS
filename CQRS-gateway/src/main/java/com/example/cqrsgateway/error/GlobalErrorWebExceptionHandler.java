package com.example.cqrsgateway.error;

import com.example.cqrsgateway.error.exception.BaseException;
import com.example.cqrsgateway.exception.InternalServerErrorException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Order(-2)
@Component
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    private final ServerCodecConfigurer serverCodecConfigurer;

    @PostConstruct
    public void init() {
        super.setMessageWriters(serverCodecConfigurer.getWriters());
        super.setMessageReaders(serverCodecConfigurer.getReaders());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::handleError);
    }

    private Mono<ServerResponse> handleError(ServerRequest request) {
        Throwable e = getError(request);
        if (e instanceof BaseException) {
            return buildErrorResponse((BaseException) e);
        } else {
            return buildErrorResponse(InternalServerErrorException.EXCEPTION);
        }
    }

    private Mono<ServerResponse> buildErrorResponse(BaseException e) {
        return ServerResponse
                .status(e.getErrorCode().getStatus())
                .bodyValue(
                        new ErrorResponse(
                                e.getErrorCode().getMessage(),
                                e.getErrorCode().getStatus()
                        )
                );
    }

    public GlobalErrorWebExceptionHandler(ServerCodecConfigurer serverCodecConfigurer, ErrorAttributes errorAttributes,
                                          WebProperties.Resources resources, ApplicationContext applicationContext) {
        super(errorAttributes, resources, applicationContext);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }
}
