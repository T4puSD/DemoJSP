package com.example.demojsp.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User {
    private com.example.demojsp.domain.User user;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public com.example.demojsp.domain.User getUser() {
        return user;
    }

    public CustomUserDetails setUser(com.example.demojsp.domain.User user) {
        this.user = user;
        return this;
    }
}
