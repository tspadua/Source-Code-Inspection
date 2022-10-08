package br.calebe.ticketmachine.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.calebe.ticketmachine.utils.TrocoProxy;

public class TrocoTest {

    @Test(timeout = 1000)
    public void testPapeisMoeda() {
       var amount = 1;
       var troco = new TrocoProxy(5);
       assertEquals(amount, troco.getPapelMoeda()[1]);
    }
}
