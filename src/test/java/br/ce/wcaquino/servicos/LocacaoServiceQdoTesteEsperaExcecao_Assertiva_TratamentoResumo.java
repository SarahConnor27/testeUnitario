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
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;


public class LocacaoServiceQdoTesteEsperaExcecao_Assertiva_TratamentoResumo {

	/*
	 * Quando o teste ESPERA por uma exceção, existem três formas para resolve-la:
	 * 
	 * -ELEGANTE: tem a desvantagem de não checar a mensagem, se suas exceções são genéricas essa forma não é aconselhavel.
	 */
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	
	/*
	 * Se vc conseguir garantir que a exceção vem por um único motivo, a forma elegante resolve o problema
	 */
	@Test(expected = FilmeSemEstoqueException.class)
	public void testeLocacaoExceptionElegante_filemSemEstoque() throws Exception {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 5.0));
		
		service.alugarFilme(usuario, filmes);
	}
	
	
	
	/*
	 * Para passar, tem que lançar a exceção mas o controle fica pra mim
	 * vantagem: posso verificar a mensagem retornada e em caso de exceção, o fluxo do método continua seguindo.
	 * bom se vc precisar fechar algum recurso, imprimir uma msn etc
	 */
	@Test
	public void testeLocacaoExceptionRobusta_usuarioVazio() throws FilmeSemEstoqueException, Exception  {
		// cenario
		LocacaoService service = new LocacaoService();
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
		
		try {
			service.alugarFilme(null, filmes);
			Assert.fail("Deveria ter lançado uma exceção aqui.");
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuario vazio"));
		}
		
		System.out.println("Forma Robusta");
	}
	
	
	@Test
	public void testeLocacaoExceptionForma_Nova_filmeVazio() throws FilmeSemEstoqueException, LocadoraException, Exception   {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");

		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		
		service.alugarFilme(usuario, null);
		
		System.out.println("Forma Nova");
	}
	

	
	
}





































