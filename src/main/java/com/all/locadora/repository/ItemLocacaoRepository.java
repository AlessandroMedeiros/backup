package com.all.locadora.repository;

import com.all.locadora.model.ItemLocacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemLocacaoRepository extends JpaRepository<ItemLocacao, Integer> {
}
