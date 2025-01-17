package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100}; //

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {  
                achou = true;                
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException(null);
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public Iterator<Integer> getTroco() {
        return null;
    }

    public String imprimir() throws SaldoInsuficienteException {
        String result = "";
        try {
            if (saldo < valor) { //[erro] inici
                throw new SaldoInsuficienteException(null);
            }
            result = "*****************\n";
            result += "*** R$ " + saldo + ",00 ****\n"; //[erro] inici
            result += "*****************\n";
            return result;
        } catch (SaldoInsuficienteException e) {
            return result;
        }
    }
}
