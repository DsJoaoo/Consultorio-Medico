/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;

/**
 *
 * @author joaop
 */
public class Funcionario extends Pessoa{
    private Date dataAdmissao;
    private String Senha;

    public Funcionario( int idPessoa,  String nomePessoa, String cpf, Date dataAdmissao, String email, String Senha, String telefone) {
        super(idPessoa, nomePessoa, telefone, email, cpf);
        this.dataAdmissao = dataAdmissao;
        this.Senha = Senha;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    } 

}
