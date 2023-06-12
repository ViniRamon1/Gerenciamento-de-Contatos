package sistemacontato.Controle;

import java.util.Scanner;

import sistemacontato.Classes.Fornecedor;

import java.util.ArrayList;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;

public class ControleFornecedor {
    ArrayList<Fornecedor> arrayListFornecedor;

    public ControleFornecedor() {
        arrayListFornecedor = new ArrayList<>();
    }

    public ArrayList<Fornecedor> getListFornecedor() {
        consultarArquivo();
        return arrayListFornecedor;
    }

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        consultarArquivo();
        arrayListFornecedor.add(fornecedor);
        salvarArquivo();
    }

    public Fornecedor selecionarFornecedor(String nome) {
        consultarArquivo();

        if(!arrayListFornecedor.isEmpty()) {
            for(int i = 0; i <= arrayListFornecedor.size(); i++) {
                if(arrayListFornecedor.get(i).getNome().equals(nome)) {
                    return arrayListFornecedor.get(i);
                }
            }
        }
        return null;
    }

    private void consultarArquivo() {
        Scanner input = null;

        try {
            try {
                arrayListFornecedor.clear();
                input = new Scanner(new File("contato/fornecedor/fornecedor.txt"));

                while(input.hasNext()) {
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setNome(input.next());
                    fornecedor.setEmail(input.next());
                    fornecedor.setCNPJ(input.next());
                    fornecedor.setTelefoneFixo(input.next());
                    fornecedor.setFAX(input.next());
                    arrayListFornecedor.add(fornecedor);
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

    public void excluirFornecedor(Fornecedor fornecedor) {
        arrayListFornecedor.remove(fornecedor);
        salvarArquivo();
    }

    public void salvarArquivo() {
        Formatter output = null;

        try {
            try {
                output = new Formatter("contato/fornecedor/fornecedor.txt");
                for (int i = 0; i < arrayListFornecedor.size(); i++) {
                    Fornecedor fornecedor = arrayListFornecedor.get(i);
                    output.format("%s %s %s %s %s \n", fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getCNPJ(), fornecedor.getTelefoneFixo(), fornecedor.getFAX());
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