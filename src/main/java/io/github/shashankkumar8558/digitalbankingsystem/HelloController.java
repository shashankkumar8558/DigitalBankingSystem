package io.github.shashankkumar8558.digitalbankingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  @GetMapping("/")
  public String Hello() {
    return "Hello from shashank";
  }
}
