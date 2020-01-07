package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Usuario;


public class LocacaoServiceQdoTesteEsperaExcecao_Assertiva_Tratamento {

	/*
	 * Quando o teste ESPERA por uma exceção, existem três formas para resolve-la:
	 * 
	 * -ELEGANTE
	 */
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	
	/*
	 * Para passar, tem que lançar a exceção mas o controle fica por conta do junit
	 */
	@Test(expected = Exception.class)
	public void testeLocacaoExceptionElegante_filemSemEstoque() throws Exception {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");

		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 5.0));

		//acao
		service.alugarFilme(usuario, filmes);
	}
	
	
	
	/*
	 * Para passar, tem que lançar a exceção mas o controle fica pra mim
	 * vantagem: posso verificar a mensagem retornada
	 */
	@Test
	public void testeLocacaoExceptionRobusta_filemSemEstoque()  {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
		
		try {
			service.alugarFilme(usuario, filmes);
			Assert.fail("Deveria ter lançado uma exceção aqui.");
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Filme sem estoque"));
		}
	}
	
	
	@Test
	public void testeLocacaoExceptionForma_Nova_filemSemEstoque() throws Exception  {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");

		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 5.0));

		exception.expect(Exception.class);
		exception.expectMessage("Filme sem estoque");
		
		service.alugarFilme(usuario, filmes);
	}
	

	
	
}





































