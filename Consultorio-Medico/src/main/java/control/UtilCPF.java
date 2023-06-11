/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author joaop
 */
public class UtilCPF {
        
    public static String removerCaracteresCPF(String cpf){
        // Remove todos os caracteres que não são dígitos
        cpf = cpf.replaceAll("\\D", "");
        return cpf;
    }
    
    
    public static boolean validarCPF(String cpf) {
        // Remove todos os caracteres que não são dígitos
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        boolean todosIguais = true;
        char primeiroDigito = cpf.charAt(0);
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != primeiroDigito) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }

        // Verifica se os dois dígitos verificadores são válidos
        int soma = 0;
        int resto;
        for (int i = 0; i < 9; i++) {
            int digito = Integer.parseInt(cpf.substring(i, i + 1));
            soma += digito * (10 - i);
        }
        resto = soma % 11;
        int primeiroDV = (resto < 2) ? 0 : 11 - resto;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = Integer.parseInt(cpf.substring(i, i + 1));
            soma += digito * (11 - i);
        }
        resto = soma % 11;
        int segundoDV = (resto < 2) ? 0 : 11 - resto;

        return cpf.substring(9, 11).equals(primeiroDV + "" + segundoDV);
}
}
