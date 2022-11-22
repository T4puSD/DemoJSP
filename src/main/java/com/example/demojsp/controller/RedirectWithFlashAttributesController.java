package com.example.demojsp.controller;

import com.example.demojsp.config.SecurityUtils;
import com.example.demojsp.context.UserContext;
import com.example.demojsp.domain.User;
import com.example.demojsp.model.Name;
import com.example.demojsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class RedirectWithFlashAttributesController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/home")
    public ModelAndView home(@RequestParam(required = false) String name) {

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("name2", "Static Name");
        objectMap.put("name3", "Static Name2");
        objectMap.put("fname", new Name("Tapu", "Sutradhar"));
        return new ModelAndView("jsp/home").addObject("name", name).addAllObjects(objectMap);
    }

    @GetMapping("/home2")
    public ModelAndView home2UserContextTestPatchTypeWorking(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("userAccount");
        User user1 = userRepository.findById(user.getId())
                .orElse(null);
        System.out.println(user1.getRoles());
        return new ModelAndView("home").addObject("name",user1.getEmail());
    }

    @GetMapping("/home3")
    public ModelAndView home3UserContextTestNotWorking(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("userAccount");
        User user1 = userRepository.findById(user.getId())
                .orElse(null);
        System.out.println(user1.getRoles());
        return new ModelAndView("home").addObject("name",user1.getEmail());
    }

    @GetMapping("/home4")
    public ModelAndView home4UserContextTestPatchTypeWorking(HttpSession httpSession) {
        Optional<User> userOp = SecurityUtils.getUser();
        User user = userOp.get();
        return new ModelAndView("home").addObject("name",user.getEmail());
    }

    @GetMapping("/next")
    public ModelAndView next(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("redirectName", "NICE");
        return new ModelAndView("redirect:/home");
    }
}
