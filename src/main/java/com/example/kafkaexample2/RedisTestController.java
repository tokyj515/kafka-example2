package com.example.kafkaexample2;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@Tag(name = "redis-test-controller", description = "Redis 테스트 API")
public class RedisTestController {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisTestController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/write")
    public String write(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Written!";
    }

    @GetMapping("/read")
    public String read(@RequestParam String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
