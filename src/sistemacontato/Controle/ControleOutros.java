package sistemacontato.Controle;

import java.util.Scanner;

import sistemacontato.Classes.Outros;

import java.util.ArrayList;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;

public class ControleOutros {
    ArrayList<Outros> arrayListOutros;

    public ControleOutros() {
        arrayListOutros = new ArrayList<>();
    }

    public ArrayList<Outros> getListOutros() {
        consultarArquivo();
        return arrayListOutros;
    }

    public void cadastrarOutros(Outros outro) {
        consultarArquivo();
        arrayListOutros.add(outro);
        salvarArquivo();
    }

    public Outros selecionarOutros(String nome) {
        consultarArquivo();

        if(!arrayListOutros.isEmpty()) {
            for(int i = 0; i <= arrayListOutros.size(); i++) {
                if(arrayListOutros.get(i).getNome().equals(nome)) {
                    return arrayListOutros.get(i);
                }
            }
        }
        return null;
    }

    private void consultarArquivo() {
        Scanner input = null;

        try {
            try {
                arrayListOutros.clear();
                input = new Scanner(new File("contato/outros/outros.txt"));

                while(input.hasNext()) {
                    Outros outro = new Outros();
                    outro.setNome(input.next());
                    outro.setEmail(input.next());
                    outro.setTelefone(input.next());
                    arrayListOutros.add(outro);
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

    public void excluirOutros(Outros outro) {
        arrayListOutros.remove(outro);
        salvarArquivo();
    }

    public void salvarArquivo() {
        Formatter output = null;

        try {
            try {
                output = new Formatter("contato/outros/outros.txt");
                for (int i = 0; i < arrayListOutros.size(); i++) {
                    Outros outro = arrayListOutros.get(i);
                    output.format("%s %s %s \n", outro.getNome(), outro.getEmail(), outro.getTelefone());
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