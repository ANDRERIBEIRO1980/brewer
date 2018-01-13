/*
 cria o namespace Brewer
 se Brewer nao existir criar*/
var Brewer = Brewer || {};

Brewer.EstiloCadastroRapido = (function() {
	
	/*funcao construtora*/
	function EstiloCadastroRapido() {
		
		/*busca modal*/
		this.modal = $('#modalCadastroRapidoEstilo');
		
		/*busca botao salvar*/
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-estilo-salvar-btn');
		
		/*busca formulario*/
		this.form = this.modal.find('form');
		
		/*busca url*/
		this.url = this.form.attr('action');
		
		/*busca o input*/
		this.inputNomeEstilo = $('#nomeEstilo');
		
		/*exibir mensagem de erro*/
		this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');
	}
	
	/*execucao de inicializacao*/
	EstiloCadastroRapido.prototype.iniciar = function() {
		
		/*BIND COLOCA OS MÉTODOS ABAIXO NO MESMO CONTEXTO*/
		
		/*evita submeter o formulario com um enter*/
		this.form.on('submit', function(event) { event.preventDefault() });
		
		/*apos o modal ser carregado, posiciona o foco no campo de input*/
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		
		/*limpa o input, se fechar o modal*/
		this.modal.on('hide.bs.modal', onModalClose.bind(this))		
		
		/*salvar estilo*/
		this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
	}
	
	/*
	 funcao para colocar o foco no input*/
	function onModalShow() {
		this.inputNomeEstilo.focus();
	}
	
	/*funcao para limpar o input, se fechar o modal*/
	function onModalClose() {
		this.inputNomeEstilo.val('');
		
		/*limpa mensagens de erro antigas*/
		this.containerMensagemErro.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
	}
	
	/*funcao para salvar estilo*/
	function onBotaoSalvarClick() {
		var nomeEstilo = this.inputNomeEstilo.val().trim();
		$.ajax({
			url: this.url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ nome: nomeEstilo }),
			error: onErroSalvandoEstilo.bind(this),
			success: onEstiloSalvo.bind(this)
		});
	}
	
	/*funcao para tratar erro ao salvar estilo*/
	function onErroSalvandoEstilo(obj) {
		var mensagemErro = obj.responseText;
		
		/*remove a classe hidden para que seja exibido*/
		this.containerMensagemErro.removeClass('hidden');
		
		/*adiciona um spam para adicionar a mensagem de erro*/
		this.containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		
		/*deixa input em vermelho*/
		this.form.find('.form-group').addClass('has-error');
	}
	
	/*funcao para tratar sucesso ao salvar estilo*/	
	function onEstiloSalvo(estilo) {
		
		/*procura combo do estilo*/
		var comboEstilo = $('#estilo');
		
		/*adiciona o estilo no combo*/
		comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome + '</option>');
		
		/*ja deixa o novo estilo cadastrado selecionado*/
		comboEstilo.val(estilo.codigo);
		
		/*esconde o modal*/
		this.modal.modal('hide');
	}
	
	return EstiloCadastroRapido;
	
}());

$(function() {
	
	/*executa funcao construtora*/
	var estiloCadastroRapido = new Brewer.EstiloCadastroRapido();
	
	/*executa funcao inicializacao*/
	estiloCadastroRapido.iniciar();
});