package com.example.cqrsread.common.security

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

class AuthenticationFilter: WebFilter {

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val userId: String = exchange.request.headers["User-Id"]?.get(0) ?: return chain.filter(exchange)

        val authorities: List<SimpleGrantedAuthority> = ArrayList()
        val userDetails: UserDetails = User(userId, "", authorities)
        val authentication: Authentication = UsernamePasswordAuthenticationToken(userDetails, "", authorities)
        SecurityContextHolder.getContext().authentication = authentication

        return chain.filter(exchange)
    }
}