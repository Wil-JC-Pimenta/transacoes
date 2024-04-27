import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String cliente = "John Doe";
        String tipoConta = "Corrente";
        double saldo = 2500.00;
        int opcao = 0;

        System.out.println("DADOS INICIAIS DO CLIENTE:");
        mostrarDadosDoCliente(cliente, tipoConta, saldo);

        Scanner scanner = new Scanner(System.in);

        while (opcao != 4) {
            consultarSaldo();

            try {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("\nSaldo atual: R$" + formatarSaldo(saldo));
                        break;
                    case 2:
                        System.out.println("Informe o valor a ser recebido:");
                        double valor = scanner.nextDouble();
                        saldo = receberTransferencia(valor, saldo);
                        System.out.println("\nSaldo atualizado: R$" + formatarSaldo(saldo));
                        break;
                    case 3:
                        System.out.println("Informe o valor a ser transferido:");
                        double valorTransferencia = scanner.nextDouble();
                        saldo = transferirValor(valorTransferencia, saldo);
                        System.out.println("\nSaldo atualizado: R$" + formatarSaldo(saldo));
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("\nOpção inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nOpção inválida. Digite uma opção válida!\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void consultarSaldo() {
        System.out.println("\n\nOPERAÇÕES\n\n1- Consultar Saldo\n2- Receber Valor\n3- Transferir Valor\n4- Sair\n\nDigite a opção desejada:");
    }

    public static String formatarSaldo(double saldo) {
        return String.format("%.2f", saldo);
    }

    public static double receberTransferencia(double valor, double saldo) {
        saldo += valor;
        return saldo;
    }

    public static double transferirValor(double valor, double saldo) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return saldo;
        }
        saldo -= valor;
        return saldo;
    }

    public static void mostrarDadosDoCliente(String cliente, String tipoConta, double saldo) {
        System.out.printf("Cliente: %s\nConta: %s\nSaldo: R$ %s\n\n", cliente, tipoConta, formatarSaldo(saldo));
    }
}