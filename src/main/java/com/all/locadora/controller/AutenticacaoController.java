package com.all.locadora.controller;

import com.all.locadora.controller.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class AutenticacaoController {

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDTO){
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/logout")
    @PostMapping
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
