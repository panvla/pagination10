package com.vladimirpandurov.pagination10B.controller;

import com.vladimirpandurov.pagination10B.domain.HttpResponse;
import com.vladimirpandurov.pagination10B.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> name,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size){
        return ResponseEntity.ok().body(HttpResponse.builder()
        .timeStamp(LocalTime.now().toString())
        .data(Map.of("page", userService.getUsers(name.orElse(""),page.orElse(0), size.orElse(10) )))
        .message("Users Retrieved")
        .status(HttpStatus.OK)
        .statusCode(HttpStatus.OK.value())
        .build());
    }
}
