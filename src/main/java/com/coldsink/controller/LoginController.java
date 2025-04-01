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
            claims.put("admin", e.getAdmin());
            claims.put("image", e.getImage());

            String jwt = JwtUtils.generateJwt(claims);
            System.out.println(jwt);

            return Result.success(jwt);
        }

        return Result.error("登录失败");
    }

    /**
     * 登出
     * @return 登出结果
     */
    @PostMapping("/logout")
    public Result<String> logout(@RequestHeader(value = "Authorization", required = false) String token) {
        log.info("用户登出");

        // 在实际应用中，这里可以添加将令牌加入黑名单的逻辑
        // 或者记录登出日志等操作

        // 如果前端传了token，可以在这里处理token失效逻辑
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            // 可以将token加入黑名单或设置过期
            log.info("令牌失效处理: {}", token);
        }

        return Result.success("登出成功");
    }
}