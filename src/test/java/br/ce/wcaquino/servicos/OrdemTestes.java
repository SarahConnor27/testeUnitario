package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/*
 * Por padrão o junit não garante a ordem dos testes.
 * Porém é possível fixar uma ordem para executar os testes, caso um teste tenha dependencia de outro (o que não é aconselhavel) vc pode
 * ordenar os testes por ordem alfabética, nada bom.... através da annotation FixMethodOrder
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTestes {

	public static int cont = 0;
	
	@Test
	public void inicia() {
		cont++;
	}
	
	@Test
	public void veri() {
		Assert.assertThat(cont, is(1));
	}
	
}
