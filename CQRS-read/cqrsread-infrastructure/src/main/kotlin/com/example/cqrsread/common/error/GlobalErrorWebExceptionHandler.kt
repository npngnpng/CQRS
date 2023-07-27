package com.example.cqrsread.common.error

import com.example.cqrsread.common.exception.InternalServerErrorException
import org.springframework.boot.autoconfigure.web.WebProperties
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler
import org.springframework.boot.web.reactive.error.ErrorAttributes
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Order(-2)
@Component
class GlobalErrorWebExceptionHandler(
    private val serverCodecConfigurer: ServerCodecConfigurer,
    private val errorAttributes: ErrorAttributes,
    private val webProperties: WebProperties,
    private val applicationContext: ApplicationContext
): AbstractErrorWebExceptionHandler(
    errorAttributes,
    webProperties.resources
    , applicationContext
) {

    init {
        super.setMessageReaders(serverCodecConfigurer.readers)
        super.setMessageWriters(serverCodecConfigurer.writers)
    }

    override fun getRoutingFunction(errorAttributes: ErrorAttributes?): RouterFunction<ServerResponse> =
        RouterFunctions.route(RequestPredicates.all(), this::handleError)

    private fun handleError(request: ServerRequest): Mono<ServerResponse> {
        return when(val error = getError(request)) {
            is BaseException -> buildErrorResponse(error)
            else -> buildErrorResponse(InternalServerErrorException)
        }
    }

    private fun buildErrorResponse(e: BaseException) =
        ServerResponse
            .status(e.errorProperty.status)
            .bodyValue(
                ErrorResponse(
                    message = e.errorProperty.message,
                    status = e.errorProperty.status
                )
            )

}