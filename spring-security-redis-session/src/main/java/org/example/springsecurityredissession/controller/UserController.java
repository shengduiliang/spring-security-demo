package org.example.springsecurityredissession.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/user")
  public UsernamePasswordAuthenticationToken userInfo() {
    return (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
  }
}
