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

public class PacienteDao{
    
    public void cadastrar(Paciente paciente){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "INSERT INTO PACIENTE (nomePaciente, cpf, email, dataNascimento, sexo, telefone) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, paciente.getNomePessoa());
            smt.setString(2, paciente.getCpf());
            smt.setString(3, paciente.getEmail());
            smt.setString(4, paciente.getDataNascimento());
            smt.setString(5, paciente.getSexo());
            smt.setString(6, paciente.getTelefone());
            smt.executeUpdate();
            smt.close();
            conex.close();
            System.out.println("Cliente Cadastrado com sucesso! "); 
        } catch (Exception e) {
            System.out.println( "Erro ao cadastrar Cliente no banco de dados! "+ e );   
        }
    }
    
    public void atualizar(Paciente paciente){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "UPDATE PACIENTE SET nomePaciente = ?, cpf = ?, email = ?, dataNascimento = ?, sexo = ?, telefone = WHERE idPaciente = ?";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, paciente.getNomePessoa());
            smt.setString(2, paciente.getCpf());
            smt.setString(3, paciente.getEmail());
            smt.setString(4, paciente.getDataNascimento());
            smt.setString(5, paciente.getSexo());
            smt.setString(6, paciente.getTelefone());
            smt.setInt(7, paciente.getIdPessoa());
            smt.executeUpdate();
            smt.close();
            conex.close();
            System.out.println("Atualizado com sucesso! "); 
        } catch (Exception e) {
            System.out.println( "Erro ao atualizar paciente no banco de dados! "+ e );   
        }
    }
    public void remover(Paciente paciente){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "Delete From paciente WHERE idPaciente = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse paciente?" + paciente.getNomePessoa() + "?", "Excluir", JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION){
            try (PreparedStatement smt = conex.prepareStatement(sql)){
                smt.setInt(1, paciente.getIdPessoa());
                smt.executeUpdate();
                smt.close();
                conex.close();
                System.out.println("Excluído com sucesso! "); 
            }catch (Exception e) {
                System.out.println("Erro ao remover " + e);   
            }
        }
    }
    
    public List<Paciente> listar(){
        Connection conex = ConexaoSingleton.getInstance();
        List<Paciente> lista = new ArrayList();
        String sql = "SELECT * FROM paciente";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            ResultSet resultado = smt.executeQuery();
            while (resultado.next()) {
               Paciente pessoa = new Paciente(resultado.getInt("idPaciente"),
                                             resultado.getString("NomePaciente"),
                                                  resultado.getString("cpf"),
                                                 resultado.getString("email"),
                                          resultado.getString("dataNascimento"),
                                                  resultado.getString("sexo"),
                                               resultado.getString("telefone")
                                              );
               lista.add(pessoa);
            }
        }catch (Exception e) {
            System.out.println("Erro ao buscar pacientes no banco de dados! "+ e );   
        }
        return lista;
    }
    
    public Paciente buscarPacientePorId(int idPaciente) {
        Connection con = ConexaoSingleton.getInstance();
        String sql = "SELECT * FROM Paciente WHERE idPaciente = ?";
        Paciente paciente = null;
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setInt(1, idPaciente);
            ResultSet resultado = smt.executeQuery();
            if (resultado.next()) {
                paciente = new Paciente(
                resultado.getInt("idPaciente"),
                resultado.getString("nomePaciente"),
                resultado.getString("cpf"),
                resultado.getString("email"),
                resultado.getString("dataNascimento"),
                resultado.getString("sexo"),
                resultado.getString("telefone")
                );
            }
            smt.close();
        } catch (Exception ex) {
        System.out.println("Erro ao buscar o paciente: " + ex.getMessage());
        }
        return paciente;
    }   
}
