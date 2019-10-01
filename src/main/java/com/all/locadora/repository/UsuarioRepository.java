package com.all.locadora.repository;

import com.all.locadora.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}
