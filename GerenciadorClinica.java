import java.util.Scanner;

public class GerenciadorClinica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaDeAtendimento fila = new FilaDeAtendimento();
        PilhaHistoricoAtendimentos historico = new PilhaHistoricoAtendimentos();

        boolean rodando = true;
        while (rodando) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade do paciente: ");
                    int idade = lerIdade(scanner);
                    System.out.print("Sintoma do paciente: ");
                    String sintoma = scanner.nextLine();
                    Paciente novoPaciente = new Paciente(nome, idade, sintoma);
                    fila.adicionarPaciente(novoPaciente);
                } else if (opcao == 2) {
                    Paciente pacienteAtendido = fila.atenderPaciente();
                    if (pacienteAtendido != null) {
                        System.out.println("Atendendo paciente: " + pacienteAtendido.exibirInfo());
                        historico.adicionarAoHistorico(pacienteAtendido);
                    } else {
                        System.out.println("Não há pacientes na fila para atender.");
                    }
                } else if (opcao == 3) {
                    fila.mostrarFila();
                } else if (opcao == 4) {
                    historico.mostrarHistorico();
                } else if (opcao == 5) {
                    rodando = false;
                    System.out.println("Encerrando o sistema...");
                } else {
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 5.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===================================================");
        System.out.println("1. Adicionar novo paciente à fila");
        System.out.println("2. Atender próximo paciente");
        System.out.println("3. Exibir fila de atendimento");
        System.out.println("4. Exibir histórico de atendimentos");
        System.out.println("5. Sair");
        System.out.println("===================================================");
    }

    private static int lerIdade(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int idade = scanner.nextInt();
                scanner.nextLine();
                return idade;
            } else {
                System.out.println("Entrada inválida. Por favor, digite uma idade válida (número inteiro):");
                scanner.nextLine();
            }
        }
    }
}