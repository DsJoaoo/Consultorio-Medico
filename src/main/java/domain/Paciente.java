/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author joaop
 */
public class Paciente extends Pessoa{
    private String dataNascimento;
    private String sexo;

    public Paciente(int idPessoa, String nomePessoa, String cpf, String email, String dataNascimento,  String sexo,   String telefone) {
        super(idPessoa, nomePessoa, telefone, email, cpf);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
        
    @Override
    public String toString(){
        return nomePessoa;
    }

}
