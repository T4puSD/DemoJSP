package com.example.demojsp.context;

import com.example.demojsp.domain.User;
import com.example.demojsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component
public class UserContextSupport {

    private static final String USER_ACCOUNT_SESSION_KEY = "userAccount";

    private final UserRepository userRepository;

    @Autowired
    public UserContextSupport(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void processUserContext(HttpServletRequest req, HttpServletResponse res) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(USER_ACCOUNT_SESSION_KEY);
        if (Objects.isNull(user)) {
            user = userRepository.findByEmail(username)
                    .orElseThrow(() -> {
                        throw new IllegalArgumentException("No user found with username: " + username);
                    });
            session.setAttribute(USER_ACCOUNT_SESSION_KEY, user);
        }

        if (Objects.nonNull(user)) {
            setUserContext(user);
        }
    }

    private void setUserContext(User user) {
        UserContext userContext = new UserContext();
        userContext.setUser(user);
    }

    public void resetContext() {
        UserContext.resetContext();
    }
}
