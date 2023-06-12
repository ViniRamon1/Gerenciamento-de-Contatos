package sistemacontato.Controle;

import java.util.Scanner;

import sistemacontato.Classes.PessoaJuridica;

import java.util.ArrayList;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;


public class ControlePessoaJuridica {
    ArrayList<PessoaJuridica> arrayListPessoaJuridica;

    public ControlePessoaJuridica() {
        arrayListPessoaJuridica = new ArrayList<>();
    }

    public ArrayList<PessoaJuridica> getListPessoaJuridica() {
        consultarArquivo();
        return arrayListPessoaJuridica;
    }

    public void cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        consultarArquivo();
        arrayListPessoaJuridica.add(pessoaJuridica);
        salvarArquivo();
    }

    public PessoaJuridica selecionarPessoaJuridica(String nome) {
        consultarArquivo();

        if(!arrayListPessoaJuridica.isEmpty()) {
            for(int i = 0; i <= arrayListPessoaJuridica.size(); i++) {
                if(arrayListPessoaJuridica.get(i).getNome().equals(nome)) {
                    return arrayListPessoaJuridica.get(i);
                }
            }
        }
        return null;
    }

    private void consultarArquivo() {
        Scanner input = null;

        try {
            try {
                arrayListPessoaJuridica.clear();
                input = new Scanner(new File("contato/cliente/pessoaJuridica/pessoaJuridica.txt"));

                while(input.hasNext()) {
                    PessoaJuridica pessoaJuridica = new PessoaJuridica();
                    pessoaJuridica.setNome(input.next());
                    pessoaJuridica.setEmail(input.next());
                    pessoaJuridica.setTelefoneResidencial(input.next());
                    pessoaJuridica.setTelefoneTrabalho(input.next());
                    pessoaJuridica.setTelefoneCelular(input.next());
                    pessoaJuridica.setFAX(input.next());
                    pessoaJuridica.setCNPJ(input.next());
                    arrayListPessoaJuridica.add(pessoaJuridica);
                }
            } finally {
                if(input != null) {
                    input.close();
                }
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void excluirPessoaJuridica(PessoaJuridica pessoaJuridica) {
        arrayListPessoaJuridica.remove(pessoaJuridica);
        salvarArquivo();
    }

    public void salvarArquivo() {
        Formatter output = null;

        try {
            try {
                output = new Formatter("contato/cliente/pessoaJuridica/pessoaJuridica.txt");
                for (int i = 0; i < arrayListPessoaJuridica.size(); i++) {
                    PessoaJuridica pessoaJuridica = arrayListPessoaJuridica.get(i);
                    output.format("%s %s %s %s %s %s %s \n", pessoaJuridica.getNome(), pessoaJuridica.getEmail(), pessoaJuridica.getTelefoneResidencial(), pessoaJuridica.getTelefoneTrabalho(), pessoaJuridica.getTelefoneCelular(), pessoaJuridica.getFAX(), pessoaJuridica.getCNPJ());
                }
            } finally {
                if (output != null) {
                    output.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

}