package control;


import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jean_
 */
public class Functions {
    
    public static void centralizarColunas(JTable tabela){
        int qtdeColunas = tabela.getColumnCount();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for(int i=0; i < qtdeColunas; i++){
        tabela.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    
    
    public static Time convertStringToTime(String timeString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = dateFormat.parse(timeString);
        long timeInMillis = date.getTime();
        return new Time(timeInMillis);
    }
    
    
    public static Date strToDate( String strDt) throws ParseException {
        DateFormat dtForm = new SimpleDateFormat("dd/MM/yyyy");
        dtForm.setLenient(false);
        return dtForm.parse(strDt);
    }
    
    
    public static  String checarBotao(ButtonGroup group){
        String nomeBotao = "";
        Enumeration<AbstractButton> botoes = group.getElements();
        while (botoes.hasMoreElements()) {
            AbstractButton botao = botoes.nextElement();
            if (botao.isSelected()) {
                nomeBotao = botao.getText();
                break;
            }  
        }
         return nomeBotao;
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

    
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
    
    
    public static boolean validarHora(String hora) {
        // Verifica se a String de hora tem o tamanho correto
        if (hora.length() != 5) {
            return false;
        }

        // Divide a String em horas e minutos
        String[] partes = hora.split(":");
        if (partes.length != 2) {
            return false;
        }

        // Converte as partes em inteiros
        int horas, minutos;
        try {
            horas = Integer.parseInt(partes[0]);
            minutos = Integer.parseInt(partes[1]);
        } catch (NumberFormatException e) {
            return false;
        }
        // Verifica se as horas e minutos são válidos
        // Se chegou aqui, é porque a hora é válida

        return !(horas < 0 || horas > 23 || minutos < 0 || minutos > 59);
    }
    
    
    public static boolean validarTelefone(String telefone) {
        // Remove os caracteres especiais
        telefone = telefone.replaceAll("[^0-9]", "");

        // Verifica se a String resultante tem o tamanho correto
        if (telefone.length() != 11) {
            return false;
        }

        // Verifica se o DDD é válido
        String ddd = telefone.substring(0, 2);
        // Se chegou aqui, é porque o telefone é válido
        return !(!ddd.equals("11") && !ddd.equals("12") && !ddd.equals("13") && !ddd.equals("14") &&
                !ddd.equals("15") && !ddd.equals("16") && !ddd.equals("17") && !ddd.equals("18") &&
                !ddd.equals("19") && !ddd.equals("21") && !ddd.equals("22") && !ddd.equals("24") &&
                !ddd.equals("27") && !ddd.equals("28") && !ddd.equals("31") && !ddd.equals("32") &&
                !ddd.equals("33") && !ddd.equals("34") && !ddd.equals("35") && !ddd.equals("37") &&
                !ddd.equals("38") && !ddd.equals("41") && !ddd.equals("42") && !ddd.equals("43") &&
                !ddd.equals("44") && !ddd.equals("45") && !ddd.equals("46") && !ddd.equals("47") &&
                !ddd.equals("48") && !ddd.equals("49") && !ddd.equals("51") && !ddd.equals("53") &&
                !ddd.equals("54") && !ddd.equals("55"));
    }

    
    public static boolean verificarFormatoData(String data) {
        // Verifica se a string possui 10 caracteres
        if (data.length() != 10) {
            return false;
        }

        // Verifica se os caracteres nas posições 2 e 5 são "/"
        if (data.charAt(2) != '/' || data.charAt(5) != '/') {
            return false;
        }

        // Tenta converter as substrings para inteiros e verifica se são válidos
        try {
            int dia = Integer.parseInt(data.substring(0, 2));
            int mes = Integer.parseInt(data.substring(3, 5));
            int ano = Integer.parseInt(data.substring(6, 10));

            if (dia < 1 || dia > 31) {
                return false;
            }

            if (mes < 1 || mes > 12) {
                return false;
            }

            if (ano < 1900 || ano > 2100) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    
    public static boolean validarCRM(String campo) {
        // Verifica se o campo não é nulo e não está vazio
        if (campo == null || campo.isEmpty()) {
            return false;
        }

        // Tenta converter o campo para inteiro
        try {
            int valor = Integer.parseInt(campo);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    
    public static String formatarDataParaSQL(String data){
        String dia = data.substring(0, 2);
        String mes = data.substring(3,5);
        String ano = data.substring(6, 10);
        String dataFormatada = ano + "-" + mes + "-" + dia;
        return dataFormatada;
    }
    
    
    public static String formatarDataParaInterface(String data) {
        String dataLimpa = data.replaceAll("-", ""); // remove o traço
        String dia = dataLimpa.substring(6); // obtém o dia
        String mes = dataLimpa.substring(4, 6); // obtém o mês
        String ano = dataLimpa.substring(0, 4); // obtém o ano
        String resultado = dia + "/" + mes + "/" + ano;
        return resultado;
    }
    
    
    public static String removerCaracteresTelefone(String telefone){
        String resultado = telefone.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "");
        return resultado;
    }
}
