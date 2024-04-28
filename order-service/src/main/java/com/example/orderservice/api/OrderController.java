package com.example.orderservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    @Value("${HOSTNAME}")
    private String podId;
    private final RestTemplate restTemplate;

    @GetMapping
    public Map<String, String> getUser() {
        Map body = restTemplate.getForEntity("http://user-service/users", Map.class)
                .getBody();
        body.put("order_id", UUID.randomUUID().toString());
        body.put("order_service_pod_id", podId);
        return body;
    }
}
