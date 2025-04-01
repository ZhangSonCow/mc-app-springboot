package com.coldsink.controller;

import com.coldsink.entity.User;
import com.coldsink.entity.JwtUtils;
import com.coldsink.entity.Result;
import com.coldsink.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "*")
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService empService;

    /**
     * 登录
     * @return
     * */
    @PostMapping("/login")
    public Result<String> login(@RequestBody User emp) {
        log.info("登录: {}", emp);
        User e = empService.login(emp);

        if(e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("nickname", e.getNickname());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            System.out.println(jwt);
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误");
    }
}
