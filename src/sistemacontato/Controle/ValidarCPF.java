package sistemacontato.Controle;

import java.util.InputMismatchException;

public class ValidarCPF {
    public static boolean isCPF(String validaCPF) {
        // Sequência de números iguais
        if (validaCPF.equals("00000000000") ||
            validaCPF.equals("11111111111") ||
            validaCPF.equals("22222222222") ||
            validaCPF.equals("33333333333") ||
            validaCPF.equals("44444444444") ||
            validaCPF.equals("55555555555") ||
            validaCPF.equals("66666666666") ||
            validaCPF.equals("77777777777") ||
            validaCPF.equals("88888888888") ||
            validaCPF.equals("99999999999") ||
            // verifica o tamanho
            (validaCPF.length() != 11)) {
                return(false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // Protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Cálculo do primeiro digito verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // Converte o i-esimo caractere do validarCPF em um numero - 48 = '0' na tabela ASCII
                num = (int)(validaCPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char)(r + 48);
            }

            // Cálculo do segundo digito verificador
            sm = 0;
            peso = 11;

            for(i = 0; i < 10; i++) {
                num = (int)(validaCPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char)(r + 48);
            }

            // Realiza a verificação dos digitos calculados com os digitos informados pelo usuário
            if ((dig10 == validaCPF.charAt(9)) && (dig11 == validaCPF.charAt(10))) {
                return(true);
            } else {
                return(false);
            }
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String imprimeCPF(String validaCPF) {
        // Máscara de validação: 999.999.999-99
        return(validaCPF.substring(0, 3) + "." + validaCPF.substring(3, 6) + "." + validaCPF.substring(6, 9) + "-" + validaCPF.substring(9, 11));
    }

}