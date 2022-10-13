package com.example.demojsp.controller;

import com.example.demojsp.domain.Role;
import com.example.demojsp.domain.User;
import com.example.demojsp.facility.UserFacility;
import com.example.demojsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lazy")
public class LazyLoadingExceptionTestController {

    @Autowired
    private UserFacility userFacility;

    @GetMapping("/get-user")
    public void getUser() {
        User user = userFacility.getOneWithEntityManager(1L);

        for (Role role : user.getRoles()) {
            System.out.println("role: "+ role.getName());
        }
    }
}
