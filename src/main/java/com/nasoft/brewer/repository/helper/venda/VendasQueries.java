package com.nasoft.brewer.repository.helper.venda;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nasoft.brewer.dto.VendaMes;
import com.nasoft.brewer.dto.VendaOrigem;
import com.nasoft.brewer.model.Venda;
import com.nasoft.brewer.repository.filter.VendaFilter;

public interface VendasQueries {

	public Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);
	
	public Venda buscarComItens(Long codigo);
	
	public BigDecimal valorTotalNoAno();
	public BigDecimal valorTotalNoMes();
	public BigDecimal valorTicketMedioNoAno();
	
	public BigDecimal valorEstoque();
	public Long qtdeItensEstoque();
	public Long qtdeTotalClientes();
	
	public List<VendaMes> totalPorMes();
	public List<VendaOrigem> totalPorOrigem();
}
