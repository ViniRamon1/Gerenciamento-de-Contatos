package sistemacontato.Controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

import sistemacontato.Classes.ContatoPessoal;
import sistemacontato.Classes.Usuario;


public class ControleContatoPessoal {
        ArrayList<ContatoPessoal> arrayListContatoPessoal;

    public ControleContatoPessoal() {
        arrayListContatoPessoal = new ArrayList<>();
    }

    public ArrayList<ContatoPessoal> getListContatoPessoal() {
        consultarArquivo();
        return arrayListContatoPessoal;
    }

    public void cadastrarContatoPessoal(ContatoPessoal contatoPessoal) {
        consultarArquivo();
        arrayListContatoPessoal.add(contatoPessoal);
        salvarArquivo();
    }

    public ContatoPessoal selecionarContatoPessoal(String nome) {
        consultarArquivo();

        if(!arrayListContatoPessoal.isEmpty()) {
            for(int i = 0; i <= arrayListContatoPessoal.size(); i++) {
                if(arrayListContatoPessoal.get(i).getNome().equals(nome)) {
                    return arrayListContatoPessoal.get(i);
                }
            }
        }
        return null;
    }

    private void consultarArquivo() {
        Scanner input = null;

        try {
            try {
                arrayListContatoPessoal.clear();
                input = new Scanner(new File("contato/contatoPessoal/contatoPessoal.txt"));

                while(input.hasNext()) {
                    ContatoPessoal contatoPessoal = new ContatoPessoal();
                    contatoPessoal.setNome(input.next());
                    contatoPessoal.setEmail(input.next());
                    contatoPessoal.setTelefoneFixo(input.next());
                    contatoPessoal.setTelefoneCelular(input.next());
                    contatoPessoal.setCategoria(input.next());
                    arrayListContatoPessoal.add(contatoPessoal);
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

    public void excluirContatoPessoal(ContatoPessoal contatoPessoal) {
        arrayListContatoPessoal.remove(contatoPessoal);
        salvarArquivo();
    }

    public void salvarArquivo() {
        Formatter output = null;

        try {
            try {
                output = new Formatter("contato/contatoPessoal/contatoPessoal.txt");
                for (int i = 0; i < arrayListContatoPessoal.size(); i++) {
                    ContatoPessoal contatoPessoal = arrayListContatoPessoal.get(i);
                    output.format("%s %s %s %s %s\n", contatoPessoal.getNome(), contatoPessoal.getEmail(), contatoPessoal.getTelefoneFixo(), contatoPessoal.getTelefoneCelular(), contatoPessoal.getCategoria());
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

    public ArrayList<ContatoPessoal> buscarContatos(String chave, Usuario usuario) {
        if(arrayListContatoPessoal.isEmpty()){
            System.out.println("Lista de contatos vazia");
            return arrayListContatoPessoal;
        }
        ArrayList<ContatoPessoal> contatosEncontrados = new ArrayList<>();
        for (ContatoPessoal contato : arrayListContatoPessoal) {
                if (contato.getNome().contains(chave) || contato.getEmail().contains(chave)) {
                    contatosEncontrados.add(contato);
                }
            }
        return contatosEncontrados;
    }

    public ArrayList<ContatoPessoal> buscarContatosPorCategoria(String categoria, Usuario usuario) {
        if(arrayListContatoPessoal.isEmpty()){
            System.out.println("Lista de contatos vazia");
            return arrayListContatoPessoal;
        }
        ArrayList<ContatoPessoal> contatosEncontrados = new ArrayList<>();
            for (ContatoPessoal contato : arrayListContatoPessoal) {
                if (contato.getCategoria().equals(categoria)) {
                    contatosEncontrados.add(contato);
                }
            }
            return contatosEncontrados;
    }
}