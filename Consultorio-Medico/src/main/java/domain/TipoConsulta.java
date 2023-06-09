/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author joaop
 */
@Entity
public class TipoConsulta implements Serializable, Adapter{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idTipoConsulta;
    
    
    @Column (length = 30, nullable = false)
    private String descricao;
    
    
    @Column (nullable = false)
    private double valor;
    
    
    @Column (nullable = false)
    private boolean isPlano;
    
    
    @OneToMany (mappedBy = "tipoConsulta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Consulta> consulta = new ArrayList();

    public TipoConsulta() {
    }

    public TipoConsulta(String descricao, double valor, boolean isPlano) {
        this.descricao = descricao;
        this.valor = valor;
        this.isPlano = isPlano;
    }

    
    
    public int getIdTipoConsulta() {
        return idTipoConsulta;
    }

    public void setIdTipoConsulta(int idTipoConsulta) {
        this.idTipoConsulta = idTipoConsulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean getIsPlano() {
        return isPlano;
    }

    public void setIsPlano(boolean isPlano) {
        this.isPlano = isPlano;
    }

    public List<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(List<Consulta> consulta) {
        this.consulta = consulta;
    }

   
     @Override
    public String toString(){
        return descricao;
    }
    
    @Override
    public Object[] toArray(){
       return new Object[] {idTipoConsulta, this, valor, isPlano};  
    };
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoConsulta other = (TipoConsulta) obj;
        return this.idTipoConsulta == other.idTipoConsulta;
    }
}