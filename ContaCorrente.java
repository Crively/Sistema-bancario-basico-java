public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular, int numeroConta, double saldo, double limite) {
        super(titular, numeroConta, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= (getSaldo() + limite)) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }
}
