package com.example.demojsp.config;

import com.example.demojsp.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.Optional;

public class SecurityUtils {
    public static Optional<User> getUser() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (Objects.nonNull(customUserDetails)) {
            return Optional.ofNullable(customUserDetails.getUser());
        }
        return Optional.empty();
    }

    private SecurityUtils() {
    }
}
