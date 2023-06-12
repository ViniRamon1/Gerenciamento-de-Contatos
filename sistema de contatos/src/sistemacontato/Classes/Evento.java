package sistemacontato.Classes;

import java.time.LocalDateTime;

public class Evento {
    private String nome;
    private LocalDateTime dataHora;

    public Evento(String nome, LocalDateTime dataHora) {
        this.nome = nome;
        this.dataHora = dataHora;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
