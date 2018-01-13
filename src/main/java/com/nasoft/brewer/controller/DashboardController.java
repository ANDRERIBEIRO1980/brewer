package com.nasoft.brewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nasoft.brewer.repository.Vendas;

@Controller
public class DashboardController {

	@Autowired
	private Vendas vendas;
	
	@GetMapping("/")
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView("Dashboard");
		
		mv.addObject("vendasNoAno", vendas.valorTotalNoAno());
		mv.addObject("vendasNoMes", vendas.valorTotalNoMes());
		mv.addObject("ticketMedio", vendas.valorTicketMedioNoAno());
		mv.addObject("valorEstoque", vendas.valorEstoque());
		mv.addObject("qtdeItensEstoque", vendas.qtdeItensEstoque());
		mv.addObject("qtdeTotalClientes", vendas.qtdeTotalClientes());
		
		return mv;
	}
	
}
