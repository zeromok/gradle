package com.example.hello.controller;

import com.example.hello.dto.Req;
import com.example.hello.dto.User;
import com.example.hello.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {

//    @Autowired -> 어노테이션을 이용한 주입 (엣버전?)
    // 생성자를 이용한 명시적 주입
    private final RestTemplateService restTemplateService;
    public ClientController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello")
//    public String getHello() {    // 1.
//    public ResponseEntity<String> getHello() {  // 2.
//    public User getHello() {  // 3, exchange
    public Req<User> post() {    // post

//        return restTemplateService.hello();
//        return restTemplateService.post();
//        return restTemplateService.exchange();
        return restTemplateService.genericExchange();
    }

} // end class
