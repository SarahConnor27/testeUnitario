package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

public class LocacaoService {
	
	/*
	 * Aqui vale elucidar a diferença entre ERRO e FALHA:
	 * 
	 * - FALHA: quando o teste espera por um resultado e recebe outro, são tratadas pelas assertivas;
	 * - ERRO: ocorre quando algo inesperado ocorre no teste, e nesse caso, é melhor deixar o tratamento para o jUnit.
	 * 
	 * Resumindo, se o teste não espera receber exceção alguma, deixa por conta do jUnit para resolve-lo, caso contrário, trate nas assertivas.
	 * 
	 */
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws Exception, FilmeSemEstoqueException, LocadoraException {
		
		if (filmes == null || filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}
		
		
		for (Filme filme : filmes) {
			if (filme.getEstoque() == 0) {
				throw new FilmeSemEstoqueException(filme.getNome() +  " sem estoque.");
			}
		}
		
		if (usuario == null) {
			throw new LocadoraException("Usuario vazio");
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());

		Double valor = 0d;
		
		for (Filme filme : filmes) {
			valor = filme.getPrecoLocacao();
		}
		locacao.setValor(valor);

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}
	
	
}






















