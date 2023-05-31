/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import control.Functions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author joaop
 */
@Entity
@PrimaryKeyJoinColumn (name = "idPaciente")
public class Paciente extends Pessoa implements Serializable{    
    
    
    @Temporal ( TemporalType.DATE )
    private Date dataNascimento;
    
    
    @Column ( length = 10, nullable = false)
    private String sexo;

    @OneToMany (mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Consulta> consulta = new ArrayList();

    public Paciente() {
    }

    public Paciente(String nomePessoa, String telefone, String email, String cpf, Date dataNascimento, String sexo) {
        super(nomePessoa, telefone, email, cpf);
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }

    @Override
    public Object[] toArray(){
       return new Object[] {
            getIdPessoa(), this, getCpf(), getEmail(), Functions.formatarDataParaInterface(this.getDataNascimento().toString()), getSexo(), getTelefone()
        };    
    };

}
