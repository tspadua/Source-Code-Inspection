package br.calebe.ticketmachine.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

class TicketMachineTest {

	public TicketMachine ticket = new TicketMachine(10);

	@Test
	public void inserirQuantiaZerada() {
		int quantia = 0;
		assertThrows(PapelMoedaInvalidaException.class, () -> ticket.inserir(quantia));

	}

	@Test
	public void inserirQuantiaNaoExistente() throws PapelMoedaInvalidaException {
		int quantia = 3;
		assertThrows(PapelMoedaInvalidaException.class, () -> ticket.inserir(quantia));
	}
	
	@Test
	public void inserirQuantiaValida() throws PapelMoedaInvalidaException {
		int quantia = 10;		
		ticket.inserir(quantia);
		assertEquals(quantia, ticket.getSaldo());
	}
	
	@Test
	public void imprimirSaldoInvalido() {
		TicketMachine teste =  new TicketMachine(10);
		assertThrows(SaldoInsuficienteException.class, () -> teste.imprimir());
		
	}
	
	@Test
	public void imprimirSaldoValido() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
		TicketMachine teste =  new TicketMachine(10);
		teste.inserir(20);
		String tst = teste.imprimir();
		String result = "*****************\n";
        result += "*** R$ " + teste.getSaldo() + ",00 ****\n"; 
        result += "*****************\n";
		
		
		assertEquals(result, tst);
		
	}

}