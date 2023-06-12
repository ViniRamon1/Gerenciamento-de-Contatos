package sistemacontato.Controle;

import java.util.InputMismatchException;

public class ValidarCNPJ {
    public static boolean isCNPJ(String validaCNPJ) {
        //Sequência de números iguais
        if (validaCNPJ.equals("00000000000000") ||
            validaCNPJ.equals("11111111111111") ||
            validaCNPJ.equals("22222222222222") ||
            validaCNPJ.equals("33333333333333") ||
            validaCNPJ.equals("44444444444444") ||
            validaCNPJ.equals("55555555555555") ||
            validaCNPJ.equals("66666666666666") ||
            validaCNPJ.equals("77777777777777") ||
            validaCNPJ.equals("88888888888888") ||
            validaCNPJ.equals("99999999999999") ||
            // verifica o tamanho
            (validaCNPJ.length() != 14)) {
                return(false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        // Protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Cálculo do primeiro digito verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
            // Converte o i-esimo caractere do validarCNPJ em um numero - 48 = '0' na tabela ASCII 
                num = (int)(validaCNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;

                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;

            if ((r == 0) || (r == 1)){
                dig13 = '0';
            } else {
                dig13 = (char)((11-r) + 48);
            }

            // Cálculo do segundo digito verificador 
            sm = 0;
            peso = 2;

            for (i = 12; i >= 0; i--) {
                num = (int)(validaCNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;

                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;

            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char)((11-r) + 48);
            }

            // Realiza a verificação dos digitos calculados com os digitos informados pelo usuário 
            if ((dig13 == validaCNPJ.charAt(12)) && (dig14 == validaCNPJ.charAt(13))) {
                return(true);
            } else {
                return(false);
            }
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String imprimeCNPJ(String validaCNPJ) {
        // Máscara de validação: 99.999.999.9999-99
        return(validaCNPJ.substring(0, 2) + "." + validaCNPJ.substring(2, 5) + "." + validaCNPJ.substring(5, 8) + "." + validaCNPJ.substring(8, 12) + "-" + validaCNPJ.substring(12, 14));
    }

}