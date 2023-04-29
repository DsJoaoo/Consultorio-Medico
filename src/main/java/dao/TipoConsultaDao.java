/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.TipoConsulta;
import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author joaop
 */
public class TipoConsultaDao {
    public void cadastrar(Paciente p){
    
    }
    
    public void atualizar(Paciente p){
    
    }
    public void remover(Paciente p){
    
    }

    public List<TipoConsulta> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public TipoConsulta buscarTipoConsultaPorId(int id) {
        Connection con = ConexaoSingleton.getInstance();
        TipoConsulta tipoConsulta = null;
        String sql = "SELECT * FROM TipoConsulta WHERE idTipoConsulta = ?";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setInt(1, id);
            ResultSet resultado = smt.executeQuery();
            if (resultado.next()) {
                tipoConsulta = new TipoConsulta(
                resultado.getInt("idTipoConsulta"),
                resultado.getString("nomeTipoConsulta"),
                resultado.getDouble("valorConsulta")
                );
                
            }
                smt.close();
        } catch (Exception e) {
            System.out.println("Erro ao buscar tipo de consulta por id: " + e.getMessage());
        }
        return tipoConsulta;
    }   
}
