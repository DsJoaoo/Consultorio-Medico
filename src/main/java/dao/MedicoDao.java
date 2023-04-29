/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author joaop
 */
public class MedicoDao {
    public void cadastrar(Medico med){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "INSERT INTO MEDICO (nomeMedico, cpf, email, telefone, CRM, Especializacao) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, med.getNomePessoa());
            smt.setString(2, med.getCpf());
            smt.setString(3, med.getEmail());
            smt.setString(4, med.getTelefone());
            smt.setString(5, med.getCrm());
            smt.setString(6, med.getEspecializacao());
            
            smt.executeUpdate();
            smt.close();
            conex.close();
            System.out.println("Cliente Cadastrado com sucesso! "); 
        } catch (Exception e) {
            System.out.println( "Erro ao cadastrar Cliente no banco de dados! "+ e );   
        }
    }
    
    public void atualizar(Medico med){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "UPDATE MEDICO SET nomeMedico = ?, cpf = ?, email = ?, telefone = ?, CRM = ?, Especializacao = ? WHERE idMedico = ?";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, med.getNomePessoa());
            smt.setString(2, med.getCpf());
            smt.setString(3, med.getEmail());
            smt.setString(4, med.getTelefone());
            smt.setString(5, med.getCrm());
            smt.setString(6, med.getEspecializacao());
            smt.setInt(7, med.getIdPessoa());
            
            smt.executeUpdate();
            smt.close();
            conex.close();
            System.out.println( "Cliente Cadastrado com sucesso! "); 
        } catch (Exception e) {
            System.out.println( "Erro ao cadastrar Médico no banco de dados! "+ e );   
        }
    }
   
    public void remover(Medico med){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "Delete From medico WHERE idPaciente = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse médico? " + med.getNomePessoa() + "?", "Excluir", JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION){
            try (PreparedStatement smt = conex.prepareStatement(sql)){
                smt.setInt(1, med.getIdPessoa());
                smt.executeUpdate();
                smt.close();
                conex.close();
                System.out.println("Excluído com sucesso! "); 
            }catch (Exception e) {
                System.out.println("Erro ao remover medico" + e);   
            }
        }
    }
    
    public List<Medico> listar(){
        Connection conex = ConexaoSingleton.getInstance();
        List<Medico> lista = new ArrayList();
        String sql = "SELECT * FROM medico ORDER BY nomemedico";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
               Medico pessoa = new Medico(resultado.getInt("idMedico"),
               resultado.getString("NomeMedico"),
               resultado.getString("cpf"),
               resultado.getString("email"),
               resultado.getString("telefone"),
               resultado.getString("CRM"),
               resultado.getString("Especializacao"));
               lista.add(pessoa);
            }
        }catch (Exception e) {
            System.out.println( "Erro ao buscar médicos no banco de dados! "+ e );   
        }
        return lista;
    } 
    
    
    public Medico buscarMedicoPorId(int idMedico) {
        Connection con = ConexaoSingleton.getInstance();
        String sql = "SELECT * FROM Medico WHERE idMedico = ?";
        Medico med = null;
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setInt(1, idMedico);
            ResultSet resultado = smt.executeQuery();
            if (resultado.next()) {
                med = new Medico(resultado.getInt("idMedico"),
               resultado.getString("NomeMedico"),
               resultado.getString("cpf"),
               resultado.getString("email"),
               resultado.getString("telefone"),
               resultado.getString("CRM"),
               resultado.getString("Especializacao")
                );      
            }
            smt.close();
        } catch (Exception ex) {
        System.out.println("Erro ao buscar o paciente: " + ex.getMessage());
        }
        return med;
    }   
}
