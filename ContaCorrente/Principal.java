public class Principal {

    public static void main(String[] args) {
        ContaCorrente cc1 = new ContaCorrente();
        cc1.depositar(300);
        if(cc1.sacar(200)) {
            System.out.println("Saque realizado");
        }
        else {
            System.out.println("Saldo insuficiente");
        }

        ContaCorrente cc2 = new ContaCorrente();
        cc1.transferir(50, cc2);

        System.out.println(cc1.extrato());
        System.out.println(cc2.extrato());

        cc1.depositar(400);
        System.out.println(cc1.extrato());

    }
}
