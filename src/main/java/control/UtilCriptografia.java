/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author joaop
 */
public class UtilCriptografia {
    
    
    public static String encryptPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
    
    public static boolean validarSenha(String senha) {
        // Verifica se a senha tem pelo menos 8 caracteres
        if (senha.length() < 8) {
            return false;
        }

        // Verifica se a senha contém pelo menos um caractere especial, um caractere em maiúsculo,
        // um caractere em minúsculo e um número
        boolean temCaractereEspecial = false;
        boolean temCaractereMaiusculo = false;
        boolean temCaractereMinusculo = false;
        boolean temNumero = false;

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (!temCaractereEspecial && !Character.isLetterOrDigit(caractere)) {
                temCaractereEspecial = true;
            }

            if (!temCaractereMaiusculo && Character.isUpperCase(caractere)) {
                temCaractereMaiusculo = true;
            }

            if (!temCaractereMinusculo && Character.isLowerCase(caractere)) {
                temCaractereMinusculo = true;
            }

            if (!temNumero && Character.isDigit(caractere)) {
                temNumero = true;
            }
        }

        return !(!temCaractereEspecial || !temCaractereMaiusculo || !temCaractereMinusculo || !temNumero);
    }
}
