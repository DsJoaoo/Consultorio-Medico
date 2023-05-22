/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

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
public class Paciente implements Serializable, Convertivel{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idPaciente;
    
    
    @Column (name="nomePaciente", length = 50, nullable = false)
    private String nomePessoa;
    
    
    @Column (length = 11, nullable = false)
    private String telefone;
    
    
    @Column ( unique = true, length = 50, nullable = false)
    private String email;
    
    
    @Column ( unique = true, updatable = false, length = 14)
    private String cpf;
     
     
    @Temporal ( TemporalType.DATE )
    private Date dataNascimento;
    
    
    @Column ( length = 10, nullable = false)
    private String sexo;

    @OneToMany (mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Consulta> consulta = new ArrayList();

    public Paciente() {
    }
    
    
    public Paciente(String nomePessoa, String telefone, String email, String cpf, Date dataNascimento, String sexo) {
        this.nomePessoa = nomePessoa;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public int getIdPessoa() {
        return idPaciente;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPaciente = idPessoa;
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



    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
        
    @Override
    public String toString(){
        return nomePessoa;
    }
    
    @Override
    public Object[] toArray(){
       return new Object[] {
            getIdPessoa(), this, getCpf(), getEmail(), getDataNascimento(), getSexo(), getTelefone()
        };    
    };

}
