package com.cg.hospitalmanagementsystem.filter;

import com.cg.hospitalmanagementsystem.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        // Public route: login API
        if (isPublicRoute(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Only protect API routes
        if (isProtectedRoute(requestURI)) {

            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

            // Missing or invalid Authorization header
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Missing or invalid Authorization header");
                return;
            }

            String token = authHeader.substring(7);

            try {
                // Validate token
                jwtUtil.extractClaims(token);

                // Optional: extract info for later use
                String email = jwtUtil.extractUserEmail(token);
                String role = jwtUtil.extractRole(token);

                request.setAttribute("loggedInUserEmail", email);
                request.setAttribute("loggedInUserRole", role);

            } catch (JwtException | IllegalArgumentException e) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Invalid or expired JWT token");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean isPublicRoute(String requestURI) {
        return requestURI.startsWith("/auth/");
    }

    private boolean isProtectedRoute(String requestURI) {
        return requestURI.startsWith("/staff/")
                || requestURI.startsWith("/api/");
    }
}