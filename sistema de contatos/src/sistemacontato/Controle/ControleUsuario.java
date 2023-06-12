package sistemacontato.Controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

import sistemacontato.Classes.Usuario;

public class ControleUsuario {
    private ArrayList<Usuario> arrayListUsuarios;

    public ControleUsuario() {
        arrayListUsuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        consultarArquivo();
        arrayListUsuarios.add(usuario);
        salvarArquivo();
    }

    public ArrayList<Usuario> getarrayListUsuarios() {
        consultarArquivo();
        return arrayListUsuarios;
    }

    public Usuario fazerLogin(String email, String senha) {
        consultarArquivo();
        for (Usuario usuario : arrayListUsuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null; // Usuário não encontrado
    }

    private void consultarArquivo() {
        Scanner input = null;

        try {
            try {
                arrayListUsuarios.clear();
                input = new Scanner(new File("usuario/usuario.txt"));

                while(input.hasNext()) {
                    Usuario usuario = new Usuario(null, null, null, null, null, null);
                    usuario.setNome(input.next());
                    usuario.setEmail(input.next());
                    usuario.setSenha(input.next());
                    usuario.setAniversario(input.next());
                    usuario.setStatus(input.next());
                    usuario.setTelefone(input.next());
                    arrayListUsuarios.add(usuario);
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

    public void salvarArquivo() {
        Formatter output = null;

        try {
            try {
                output = new Formatter("usuario/usuario.txt");
                for (int i = 0; i < arrayListUsuarios.size(); i++) {
                    Usuario usuario = arrayListUsuarios.get(i);
                    output.format("%s %s %s %s %s %s \n", usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getAniversario(), usuario.getStatus(), usuario.getTelefone());
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
