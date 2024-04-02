package org.iftm.atividadea2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AtividadeA2ApplicationTests {
	private static Calculadora calculadora;

@BeforeAll
    static void inicializarTeste(){
        System.out.println("Começou caso de teste");
    }

	@BeforeEach
    void setUp() {
        calculadora = new Calculadora(3);
    }

	//  Teste para o construtor sem parâmetro de entrada
    @Test
    void testConstrutorSemParametro() throws Exception{
		calculadora = new Calculadora();
        assertEquals(0, calculadora.getMemoria());
    }

	//  Testes para o construtor com parâmetro: recebendo o valor 3.
    @Test
    void testConstrutorComParametro() throws Exception{
        assertEquals(3, calculadora.getMemoria());
    }

	// Implemente os testes do método somar:somar um número negativo.
    @Test
    void testSomarNumeroNegativo() throws Exception{
        calculadora.somar(-2);
        assertEquals(1, calculadora.getMemoria());
    }

	// Implemente os testes do método subtrair: subtrair um número positivo.
    @Test
    void testSubtrairNumeroPositivo() throws Exception{
        calculadora.subtrair(2);
        assertEquals(1, calculadora.getMemoria());
    }

	//  Implemente os testes do método multiplicar: multiplicar um número positivo.
    @Test
    void testMultiplicarNumeroPositivo() throws Exception{
        calculadora.multiplicar(3);
        assertEquals(9, calculadora.getMemoria());
    }

	//  Implemente os testes do método dividir: dividir por valor 0. A divisão por zero deverá retornar uma exception.
	@Test
    void testDividirZero() {
        assertThrows(Exception.class, () -> calculadora.dividir(0));
    }

	//  Implemente os testes do método dividir: dividir por um valor positivo
	@Test
    void testDividirNumeroPositivo() throws Exception {
        calculadora.dividir(3);
        assertEquals(1, calculadora.getMemoria());
    }

	//  Implemente os testes do método exponenciação: exponenciar a memória por 1
    @Test
    void testExponenciarPorUm() throws Exception {
        calculadora.exponenciar(1);
        assertEquals(3, calculadora.getMemoria());
    }

	// Implemente os testes do método exponenciação: exponenciar a memória por 10
	@Test
    void testExponenciarPorDez() throws Exception {
        calculadora.exponenciar(10);
        assertEquals(59049, calculadora.getMemoria());
    }

	//  Implemente os testes do método exponenciação: Se a entrada for um valor maior que 10 deverá retornar uma exception
    @Test
    void testExponencialMaiorQueDez() {
        assertThrows(Exception.class, () -> calculadora.exponenciar(11));
    }

	//  Implemente os testes para o método zerarMemória. (Utilize o método getMemoria para verificar se o valor da memória é 0).
    @Test
    void testZerarMemoria() throws Exception{
        calculadora.zerarMemoria();
        assertEquals(0, calculadora.getMemoria());
    }

	@AfterEach
    void TerminaTeste(){
        System.out.println("Caso de teste finalizado.");        
    }

}
