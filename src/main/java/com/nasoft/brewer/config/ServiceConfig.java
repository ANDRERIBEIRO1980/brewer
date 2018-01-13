package com.nasoft.brewer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nasoft.brewer.service.CadastroCervejaService;
import com.nasoft.brewer.storage.FotoStorage;
import com.nasoft.brewer.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class) //mapeia todas as classes de servico que estiverem no pacote da classe CadastroCervejaService.class 
public class ServiceConfig {

	
	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}
	
}