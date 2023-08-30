import java.util.ArrayList;

public class ContaCorrente {
    public String nomeTitular;
    private double saldo;
    private ArrayList<String> operacoes;

    public ContaCorrente() {
        operacoes = new ArrayList<>();
        operacoes.add("Saldo inicial: " + saldo);
    }

    private void registrarOperacao(String operacao, double valor) {
        operacoes.add(operacao + ": " + valor);
    }

    public void depositar(double valor) {
        saldo += valor;
        registrarOperacao("Depósito", valor);
    }

    public void depositar(double valor, boolean transferencia) {
        saldo += valor;
        if(!transferencia) {
            registrarOperacao("Depósito", valor);
        }
    }

    public boolean sacar(double valor) {
        if(saldo >= valor) {
            saldo -= valor;
            registrarOperacao("Saque", valor);
            return true;
        }
        return false;
    }

    public boolean sacar(double valor, boolean transferencia) {
        if(saldo >= valor) {
            saldo -= valor;
            if(!transferencia) {
                registrarOperacao("Saque", valor);
            }
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, ContaCorrente contaDestino ) {
        if(sacar(valor, true)) {
            contaDestino.depositar(valor, true);
            registrarOperacao("Transferência enviada", valor);
            contaDestino.registrarOperacao("Transferência recebida", valor);
            return true;
        }
        return false;
    }

    public String extrato() {
        String extrato = "";
        for(String linha: operacoes) {
            extrato += linha + "\n";
        }
        extrato += "Saldo final: " + saldo;
        return extrato;

    }
}
