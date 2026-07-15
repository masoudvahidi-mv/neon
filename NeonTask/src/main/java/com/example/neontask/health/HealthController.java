package com.example.neontask.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health/api/v1")
public class HealthController {
    @GetMapping()
    public String HealthController() {
        return "Application is running";
    }
}
