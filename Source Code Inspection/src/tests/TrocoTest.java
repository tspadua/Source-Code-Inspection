package br.calebe.ticketmachine.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.calebe.ticketmachine.utils.TrocoProxy;
import br.calebe.ticketmachine.core.PapelMoeda;

public class TrocoTest {

    @Test(timeout = 1000)
    public void testPapeisMoeda() {
       var amount = 1;
       var troco = new TrocoProxy(5);
       assertEquals(amount, troco.getPapelMoeda()[1]);
    }

    @Test(timeout = 1000)
    public void testTrocoIterator() {
        var troco = new TrocoProxy(10);
        var cashOne = new PapelMoeda(1,5);
        var cashTwo = new PapelMoeda(2,5);

        PapelMoeda[] cashArr =  {cashOne, cashTwo};
        troco.setPapelMoeda(cashArr);
        assertEquals(true, troco.getIterator().hasNext());
    }
}
