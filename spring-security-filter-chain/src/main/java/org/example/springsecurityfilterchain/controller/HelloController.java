package org.example.springsecurityfilterchain.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "hello spring security";
  }

  @GetMapping("/api/hello")
  public String apiHello() {
    return "hello api spring security";
  }

  @GetMapping("/basic")
  public String basic() {
    return "hello basic spring security";
  }
}
