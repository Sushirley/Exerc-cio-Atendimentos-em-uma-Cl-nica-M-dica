import java.util.Stack;

public class PilhaHistoricoAtendimentos {
    private Stack<Paciente> historico = new Stack<>();

    public void adicionarAoHistorico(Paciente p) {
        historico.push(p);
        System.out.println("Paciente " + p.getNome() + " adicionado ao histórico.");
    }

    public Paciente verUltimoAtendido() {
        if (!historico.isEmpty()) {
            return historico.peek();
        }
        return null;
    }

    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("O histórico de atendimentos está vazio.");
        } else {
            System.out.println("--- Histórico de Atendimentos (Mais Recente para Mais Antigo) ---");
            for (int i = historico.size() - 1; i >= 0; i--) {
                System.out.println(historico.get(i).exibirInfo());
            }
            System.out.println("---------------------------------------------------------------");
        }
    }
}
