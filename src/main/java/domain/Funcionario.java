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
public class Funcionario{
    private int idPessoa;
    private String nomePessoa;
    private String telefone;
    private String email;
    private String cpf;
    private Date dataAdmissao;
    private String Senha;

    public Funcionario(int idPessoa, String nomePessoa, String telefone, String email, String cpf, Date dataAdmissao, String Senha) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.Senha = Senha;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
