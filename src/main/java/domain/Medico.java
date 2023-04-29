/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author joaop
 */
public class Medico extends Pessoa{
    private String crm;
    private String especializacao;
    

    public Medico(int idPessoa, String nomePessoa, String cpf, String email, String telefone, String crm, String especializacao) {
        super(idPessoa, nomePessoa, telefone, email, cpf);
        this.crm = crm;
        this.especializacao = especializacao;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
