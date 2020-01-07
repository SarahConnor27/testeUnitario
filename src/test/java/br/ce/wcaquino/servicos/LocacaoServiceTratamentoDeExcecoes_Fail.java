package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Assert;

public class LocacaoServiceTratamentoDeExcecoes_Fail {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	
	@Test
	public void testeLocacaoComFail() {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 5.0));

		// acao
		Locacao locacao;
		try {
			locacao = service.alugarFilme(usuario, filmes);
			// verificacao
			error.checkThat(locacao.getValor(), is(equalTo(6.0)));
			error.checkThat(locacao.getValor(), is(not(6.0)));
			error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
			error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Não deveria lançar exceção");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
