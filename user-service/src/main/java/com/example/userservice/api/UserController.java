package com.example.userservice.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Value("${HOSTNAME}")
    private String podId;

    @GetMapping
    public Map<String, String> getUser() {
        return Map.of("user", "mafei", "user_service_pod_id-service-pod", this.podId);
    }
}
