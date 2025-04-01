import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = null;

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Aplicar Juros (Conta Poupança)");
            System.out.println("7. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta:");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do titular:");
                    String titular = scanner.nextLine();
                    System.out.println("Digite o saldo inicial:");
                    double saldo = scanner.nextDouble();
                    System.out.println("Digite o limite de crédito:");
                    double limite = scanner.nextDouble();
                    conta = new ContaCorrente(titular, numero, saldo, limite);
                    System.out.println("Conta Corrente criada com sucesso.");
                    break;

                case 2:
                    System.out.println("Digite o número da conta:");
                    numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do titular:");
                    titular = scanner.nextLine();
                    System.out.println("Digite o saldo inicial:");
                    saldo = scanner.nextDouble();
                    System.out.println("Digite a taxa de juros:");
                    double taxaJuros = scanner.nextDouble();
                    conta = new ContaPoupanca(titular, numero, saldo, taxaJuros);
                    System.out.println("Conta Poupança criada com sucesso.");
                    break;

                case 3:
                    if (conta != null) {
                        System.out.println("Digite o valor para depósito:");
                        conta.depositar(scanner.nextDouble());
                    } else {
                        System.out.println("Nenhuma conta criada.");
                    }
                    break;

                case 4:
                    if (conta != null) {
                        System.out.println("Digite o valor para saque:");
                        conta.sacar(scanner.nextDouble());
                    } else {
                        System.out.println("Nenhuma conta criada.");
                    }
                    break;

                case 5:
                    if (conta != null) {
                        System.out.println("Saldo atual: R$" + conta.getSaldo());
                    } else {
                        System.out.println("Nenhuma conta criada.");
                    }
                    break;

                case 6:
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).aplicarJuros();
                    } else {
                        System.out.println("Apenas contas poupança aplicam juros.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
