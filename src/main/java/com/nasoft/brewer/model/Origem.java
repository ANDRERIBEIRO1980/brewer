package com.nasoft.brewer.model;

public enum Origem {

	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");
	
	private String descricao;
	
	Origem(String descricao) {
		this.descricao = descricao;
	}
	
	public final String getDescricao() { 
		return descricao;
	}
	
}