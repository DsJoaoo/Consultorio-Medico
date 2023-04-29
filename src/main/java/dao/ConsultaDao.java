/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import control.ControllerDomain;
import domain.Consulta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author joaop
 */
public class ConsultaDao {
    public void cadastrar(Consulta agendamento){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "INSERT INTO Consulta (dataAtendimento, horario, fk_TipoConsulta_idTipoConsulta, fk_Paciente_idPaciente, fk_Funcionario_idFuncionario, fk_Medico_idMedico) VALUES(?,?,?,?,?,?);";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setDate(1, (Date) agendamento.getData());
            smt.setTime(2, agendamento.getHora());
            smt.setInt(3, agendamento.getObjetoConsulta().getIdTipoServico());
            smt.setInt(4, agendamento.getObjetoPaciente().getIdPessoa());
            smt.setInt(5, agendamento.getObjetoFuncionario().getIdPessoa());
            smt.setInt(6, agendamento.getObjetoMedico().getIdPessoa());
            smt.executeUpdate();
            smt.close();
            conex.close();
            System.out.println( "Inserido com sucesso! "); 
        } catch (Exception e) {
            System.out.println( "Erro ao conectar com o banco de dados! "+ e );   
        }
    }
    
    public void atualizar(Consulta agendamento){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "UPDATE Consulta SET dataAtendimento = ?, horario = ?, fk_TipoConsulta_idTipoConsulta = ?, fk_Paciente_idPaciente = ?, fk_Funcionario_idFuncionario = ?, fk_Medico_idMedico = ?  WHERE idConsulta = ?;";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setDate(1, (Date) agendamento.getData());
            smt.setTime(2, agendamento.getHora());
            smt.setInt(3, agendamento.getObjetoConsulta().getIdTipoServico());
            smt.setInt(4, agendamento.getObjetoPaciente().getIdPessoa());
            smt.setInt(5, agendamento.getObjetoFuncionario().getIdPessoa());
            smt.setInt(6, agendamento.getObjetoMedico().getIdPessoa());
            smt.setInt(7, agendamento.getIdConsulta());
            smt.executeUpdate();
            smt.close();
            conex.close();
            System.out.println( "Consulta Atualizada com sucesso! "); 
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados! "+ e );   
        }
    }
    public void remover(Consulta agendamento){
        Connection conex = ConexaoSingleton.getInstance();
        String sql = "delete  Consulta SET dataAtendimento = ?, horario = ?, fk_TipoConsulta_idTipoConsulta = ?, fk_Paciente_idPaciente = ?, fk_Funcionario_idFuncionario = ?, fk_Medico_idMedico = ?  WHERE idConsulta = ?;";
        try (PreparedStatement smt = conex.prepareStatement(sql)){
            smt.setString(1, agendamento.getData().toString());
            smt.setString(2, agendamento.getHora().toString());
            smt.setInt(3, agendamento.getObjetoConsulta().getIdTipoServico());
            smt.setInt(4, agendamento.getObjetoPaciente().getIdPessoa());
            smt.setInt(5, agendamento.getObjetoFuncionario().getIdPessoa());
            smt.setInt(6, agendamento.getObjetoMedico().getIdPessoa());
            smt.setInt(7, agendamento.getIdConsulta());
            smt.executeUpdate();
            smt.close();
            conex.close();
            System.out.println( "Consulta removida com sucesso! "); 
        } catch (Exception e) {
            System.out.println("Erro ao remover agendamento" + e);   
        }
    }  

    public List<Consulta> listar( ControllerDomain controller) {
        Connection con = ConexaoSingleton.getInstance();
        List<Consulta> listaConsultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta ";
        try(PreparedStatement smt = con.prepareStatement(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                Consulta consulta = new Consulta(
                resultado.getInt("idConsulta"),
                resultado.getDate("dataAtendimento"),
                resultado.getTime("horario"),
                controller.buscarPacientePorId(resultado.getInt("fk_Paciente_idPaciente")),
                controller.buscarFuncionarioPorId(resultado.getInt("fk_Funcionario_idFuncionario")),
                controller.buscarMedicoPorId(resultado.getInt("fk_Medico_idMedico")),      
               controller.buscarConsultaPorId(resultado.getInt("fk_TipoConsulta_idTipoConsulta"))        
                );
                listaConsultas.add(consulta);
            }
            smt.close();
        }catch(Exception ex){
            System.out.println("Erro ao buscar os funcionários");
        }
        return listaConsultas;  
    }

    
    
    
}
