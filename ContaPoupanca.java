public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(String titular, int numeroConta, double saldo, double taxaJuros) {
        super(titular, numeroConta, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void aplicarJuros() {
        setSaldo(getSaldo() + (getSaldo() * (taxaJuros / 100)));
        System.out.println("Juros aplicados. Novo saldo: R$" + getSaldo());
    }
}
