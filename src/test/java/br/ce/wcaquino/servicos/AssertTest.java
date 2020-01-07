package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;



public class AssertTest {

	
	
	
	
	
	@Test
	public void assertTestes() {
		Assert.assertTrue(true);
		//Assert.assertTrue(!true);
		Assert.assertFalse(false);
		
		int valorEsperado = 2;
		int valorRecebido = 2;
		Assert.assertEquals(valorEsperado, valorRecebido);
		
		/*
		 * Com valores decimais é necessário colocar um delta de margen de erro para comparação, no exemplo abaixo ele não considera
		 * qualquer casa decimal após o terceiro algaritimo, já no proximo exemplo dará erro pq os algarítimos que devem ser comparados
		 * são diferentes:
		 */
		
		double doubleEsperado = 0.51234;
		double doubleRecebido = 0.51211134;
		double delta = 0.001;
		Assert.assertEquals(doubleEsperado, doubleRecebido, delta);
		
		//doubleRecebido = 0.5111211134;
		//Assert.assertEquals(doubleEsperado, doubleRecebido, delta);
		
		
		/*
		 * Não existe unboxing de tipo primitivo no AssertEquals, para efetuar comparações entre tipo primitivo e objeto é necessário converter um dos dois
		 */
		
		int i = 5;
		Integer i2 = 5;
		//Assert.assertEquals(i, i2); ERRRO
		Assert.assertEquals(Integer.valueOf(i), i2);
		//OU
		Assert.assertEquals(i, i2.intValue());
		
		//STRINGS
		Assert.assertEquals("bola","bola");

		
		//Para validar sem considerar maiusculo ou minusculo deve usar o assertTrue com métodos exclusivos da classe String
		//Funciona do mesmo jeito com objetos, o objeto é o melhor mecanismo para dizer se le é ou não igual ao outro
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("Bo"));
		
		Usuario usuario = new Usuario("Usuario 1");
		Usuario usuario2 = new Usuario("Usuario 1");
		
		//verifica se tem a mesma referencia de memória
		Assert.assertSame(usuario, usuario2);
		
		//verifica se o objeto é null
		Usuario usuario3 = null;
		Assert.assertNull(usuario3);
		
		//todos os asserts possuem sua forma negativa:
		Assert.assertNotNull(usuario2);
		Assert.assertNotEquals("bola","bOla");
		
		//garante que são de instancias diferentes, apesar de serem iguais
		Assert.assertNotSame(usuario, usuario2);
		
		//TODOS os métodos acima podem ter uma string q será apresentada em caso de erro:
		Assert.assertTrue("Não são iguais","bolA".equals("Bola"));
		
	}
	
}


















