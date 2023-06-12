package sistemacontato.Controle;

import java.util.Scanner;

import sistemacontato.Classes.PessoaFisica;

import java.util.ArrayList;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;

public class ControlePessoaFisica {
    ArrayList<PessoaFisica> arrayListPessoaFisica;

    public ControlePessoaFisica() {
        arrayListPessoaFisica = new ArrayList<>();
    }

    public ArrayList<PessoaFisica> getListPessoaFisica() {
        consultarArquivo();
        return arrayListPessoaFisica;
    }

    public void cadastrarPessoaFisica(PessoaFisica pessoaFisica) {
        consultarArquivo();
        arrayListPessoaFisica.add(pessoaFisica);
        salvarArquivo();
    }

    public PessoaFisica selecionarPessoaFisica(String nome) {
        consultarArquivo();

        if(!arrayListPessoaFisica.isEmpty()) {
            for(int i = 0; i <= arrayListPessoaFisica.size(); i++) {
                if(arrayListPessoaFisica.get(i).getNome().equals(nome)) {
                    return arrayListPessoaFisica.get(i);
                }
            }
        }
        return null;
    }

    private void consultarArquivo() {
        Scanner input = null;

        try {
            try {
                arrayListPessoaFisica.clear();
                input = new Scanner(new File("contato/cliente/pessoaFisica/pessoaFisica.txt"));

                while(input.hasNext()) {
                    PessoaFisica pessoaFisica = new PessoaFisica();
                    pessoaFisica.setNome(input.next());
                    pessoaFisica.setEmail(input.next());
                    pessoaFisica.setTelefoneResidencial(input.next());
                    pessoaFisica.setTelefoneTrabalho(input.next());
                    pessoaFisica.setTelefoneCelular(input.next());
                    pessoaFisica.setFAX(input.next());
                    pessoaFisica.setCPF(input.next());
                    arrayListPessoaFisica.add(pessoaFisica);
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

    public void excluirPessoaFisica(PessoaFisica pessoaFisica) {
        arrayListPessoaFisica.remove(pessoaFisica);
        salvarArquivo();
    }

    public void salvarArquivo() {
        Formatter output = null;

        try {
            try {
                output = new Formatter("contato/cliente/pessoaFisica/pessoaFisica.txt");
                for (int i = 0; i < arrayListPessoaFisica.size(); i++) {
                    PessoaFisica pessoaFisica = arrayListPessoaFisica.get(i);
                    output.format("%s %s %s %s %s %s %s \n", pessoaFisica.getNome(), pessoaFisica.getEmail(), pessoaFisica.getTelefoneResidencial(), pessoaFisica.getTelefoneTrabalho(), pessoaFisica.getTelefoneCelular(), pessoaFisica.getFAX(), pessoaFisica.getCPF());
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