package com.example.demojsp.context;

import com.example.demojsp.domain.User;

import java.util.Objects;

public class UserContext {

    private static final ThreadLocal<UserContext> userContextHolder = new InheritableThreadLocal<>();
    private String sessionId;
    private String username;
    private User user;

    public static UserContext getUserContext() {
        return userContextHolder.get();
    }

    public static void setUserContext(UserContext userContext) {
        userContextHolder.set(userContext);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static User getUserFromUserContext() {
        if (Objects.isNull(userContextHolder.get())) {
            return null;
        }
        return userContextHolder.get().getUser();
    }

    public static void resetContext() {
        userContextHolder.remove();
    }
}
