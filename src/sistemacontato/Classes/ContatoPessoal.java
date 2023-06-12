package sistemacontato.Classes;

public class ContatoPessoal extends Contato {
    /* Atributos */
    private String telefoneFixo;
    private String telefoneCelular;

    /* Métodos Especiais */
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

}