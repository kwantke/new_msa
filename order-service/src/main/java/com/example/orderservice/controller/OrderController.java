package com.example.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final Environment env;
  @GetMapping("/health_check")
  public String status() {
    return String.format("It's working in Order Service on PORT %s", env.getProperty("local.server.port"));
  }
}
