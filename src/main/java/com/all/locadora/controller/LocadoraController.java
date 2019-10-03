package com.all.locadora.controller;

import com.all.locadora.controller.dto.LocacaoDTO;
import com.all.locadora.model.LocacaoModel;
import com.all.locadora.service.LocadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/locacao")
public class LocadoraController {

    @Autowired
    LocadoraService locadoraService;

    @PostMapping("/locar")
    public ResponseEntity<LocacaoModel> locacaoFilme(@RequestBody LocacaoDTO locacaoDTO) {
        LocacaoModel locacaoModel = locadoraService.locarFilme(locacaoDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(locacaoModel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/{id}/devolver")
    public void devolucaoFilme(@PathVariable LocacaoDTO locacaoDTO) {
        LocacaoModel locacaoModel = locadoraService.devolverFilme(locacaoDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(locacaoModel.getId()).toUri();
    }
}
