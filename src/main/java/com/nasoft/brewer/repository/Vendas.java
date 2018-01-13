package com.nasoft.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasoft.brewer.model.Venda;
import com.nasoft.brewer.repository.helper.venda.VendasQueries;

public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries {

}

