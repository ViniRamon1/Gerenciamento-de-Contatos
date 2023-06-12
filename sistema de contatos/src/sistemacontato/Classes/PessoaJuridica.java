package sistemacontato.Classes;

public class PessoaJuridica extends Cliente {
    /* Atributos */
    private String CNPJ;

    /* Métodos Especiais */
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

}