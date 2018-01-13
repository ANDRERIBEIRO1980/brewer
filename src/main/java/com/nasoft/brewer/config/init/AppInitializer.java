package com.nasoft.brewer.config.init;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nasoft.brewer.config.JPAConfig;
import com.nasoft.brewer.config.MailConfig;
import com.nasoft.brewer.config.SecurityConfig;
import com.nasoft.brewer.config.ServiceConfig;
import com.nasoft.brewer.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { JPAConfig.class, ServiceConfig.class, SecurityConfig.class };
	}

	//configuracao para localizar os controllers
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class, MailConfig.class };
	}
	
	
	//caminho de inicializacao da aplicacao
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	//forca utf8
	@Override
	protected Filter[] getServletFilters() {	
		/*filtro para permissao de javascript para atualizacao ativar\desativar varios usuarios*/
		HttpPutFormContentFilter httpPutFormContentFilter = new HttpPutFormContentFilter();
        return new Filter[] { httpPutFormContentFilter };
	}
	
	//habilita multipart para upload de arquivos
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}

}