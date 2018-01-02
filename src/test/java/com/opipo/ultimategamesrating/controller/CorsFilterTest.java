package com.opipo.ultimategamesrating.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilterTest {

    private CorsFilter corsFilter = new CorsFilter();

    @Test
    public void doFilterInternal() throws ServletException, IOException {
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        FilterChain filterChain = Mockito.mock(FilterChain.class);
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

        corsFilter.doFilterInternal(request, response, filterChain);

        Mockito.verify(response).addHeader("Access-Control-Allow-Origin", "*");
        Mockito.verify(response).addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD");
        Mockito.verify(response).addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        Mockito.verify(response).addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
        Mockito.verify(response).addHeader("Access-Control-Allow-Credentials", "true");
        Mockito.verify(response).addIntHeader("Access-Control-Max-Age", 10);
        Mockito.verify(filterChain).doFilter(request, response);
    }
}