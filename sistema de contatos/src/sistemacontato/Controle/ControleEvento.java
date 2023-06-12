package sistemacontato.Controle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import sistemacontato.Classes.Evento;

public class ControleEvento {
    private List<Evento> eventos;

    public ControleEvento() {
        eventos = new ArrayList<>();
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void removerEvento(Evento evento){
        eventos.remove(evento);
    }

    public void iniciarVerificacaoLembretes() {
        Timer timer = new Timer();
        timer.schedule(new VerificadorLembretes(), 0, 1000); // Verifica os lembretes a cada segundo
    }

    public Evento acessarEvento(String nomeEvento) {
    for (Evento evento : eventos) {
        if (evento.getNome().equals(nomeEvento)) {
            return evento;
        }
    }
    return null; // Se o evento não for encontrado, retorna null
}

    private class VerificadorLembretes extends TimerTask {
        @Override
        public void run() {
            LocalDateTime agora = LocalDateTime.now();

            for (Evento evento : eventos) {
                LocalDateTime dataHoraEvento = evento.getDataHora();
                Duration duracao = Duration.between(agora, dataHoraEvento);

                if (duracao.getSeconds() >= 0 && duracao.getSeconds() <= 60) {
                    System.out.println("Lembrete: O evento \"" + evento.getNome() + "\" está próximo!");
                }
            }
        }
    }
}