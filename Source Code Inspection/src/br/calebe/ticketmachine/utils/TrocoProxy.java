package br.calebe.ticketmachine.utils;

import br.calebe.ticketmachine.core.*;

public class TrocoProxy extends Troco {

    public TrocoProxy(int valor) {
        super(valor);
    }

    public PapelMoeda[] getPapelMoeda() {
        return(papeisMoeda);
    }

    public void setPapelMoeda(PapelMoeda[] obj) {
        papeisMoeda = obj;
    }
    
}
