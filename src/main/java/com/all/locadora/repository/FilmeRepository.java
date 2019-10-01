package com.all.locadora.repository;

import com.all.locadora.model.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<FilmeModel, Integer> {

}
