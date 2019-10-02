package com.all.locadora.controller;

import com.all.locadora.controller.dto.NovoUsuarioDTO;
import com.all.locadora.controller.dto.UsuarioDTO;
import com.all.locadora.model.UsuarioModel;
import com.all.locadora.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDTO> lista() {
        List<UsuarioModel> listaUsuario = usuarioRepository.findAll();
        return listaUsuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody NovoUsuarioDTO novoUsuarioDTO) {
        UsuarioModel usuarioModel = new UsuarioModel(novoUsuarioDTO.getId(), novoUsuarioDTO.getEmail(), novoUsuarioDTO.getNome(), novoUsuarioDTO.getSenha());
        usuarioModel = usuarioRepository.save(usuarioModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioModel.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuarioModel));
    }

}
