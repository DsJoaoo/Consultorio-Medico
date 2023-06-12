package control;


import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jean_
 */
public class UtilGeral {
    
    public static boolean isInteger(String str) {
        try {
            int numero = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isFloat(String str) {
        return str != null && str.matches("^\\s\\d+(\\.\\d+)?\\s*$");
    }

    public static boolean isData(String str) {
        return str != null && str.matches("\\d{2}/\\d{2}/\\d{4}");
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

    
    public static String formatarDataParaSQL(String data) throws ParseException{
        return new SimpleDateFormat("yyyy/MM/dd").format(strToDate(data));
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
