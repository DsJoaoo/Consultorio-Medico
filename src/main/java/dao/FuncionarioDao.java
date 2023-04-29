package dao;

import domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDao {

    public void cadastrar(Funcionario r) {
        Connection con = ConexaoSingleton.getInstance();
        String sql = "INSERT INTO funcionario (nome,cpf,email,telefone,dataadmissao,senha) VALUES(?,?,?,?,?,MD5(?))";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, r.getNomePessoa());
            smt.setString(2, r.getCpf());
            smt.setString(3, r.getEmail());
            smt.setString(4, r.getTelefone());
            smt.setString(5, r.getDataAdmissao().toString());
            smt.setString(6, r.getSenha());
            smt.executeUpdate();
            smt.close();
            con.close();
            System.out.println("Cadastrado com sucesso!");
        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar o funcionário");
        }
    }

    public void atualizar(Funcionario r) {
        Connection con = ConexaoSingleton.getInstance();
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, email = ?, telefone = ?,dataadmissao = ? WHERE id_funcionario = ?";
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setString(1, r.getNomePessoa());
            smt.setString(2, r.getCpf());
            smt.setString(3, r.getEmail());
            smt.setString(4, r.getTelefone());
            smt.setString(5, r.getDataAdmissao().toString());
            smt.setInt(6, r.getIdPessoa());
            smt.executeUpdate();
            smt.close();
            con.close();
            System.out.println("Atualizado com sucesso!");
        } catch (Exception ex) {
            System.out.println( "Erro ao atualizar o funcionário");
        }

    }

    public void excluir(Funcionario r) {
        Connection con = ConexaoSingleton.getInstance();
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o funcionário " + r.getNomePessoa(), "Exclusão", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try (PreparedStatement smt = con.prepareStatement(sql)) {
                smt.setInt(1, r.getIdPessoa());
                smt.executeUpdate();
                smt.close();
                con.close();
                System.out.println( "Excluído com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao remover funcionario" + e);   
            }
        }
    }
    public List<Funcionario> listar(){
        Connection con = ConexaoSingleton.getInstance();
        List<Funcionario> listaFuncionario = new ArrayList<>();
        String sql = "SELECT * FROM funcionario ORDER BY nome";
        try(PreparedStatement smt = con.prepareStatement(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                Funcionario f = new Funcionario(
                resultado.getInt("idFuncionario"),
                resultado.getString("nomeFuncionario"),
                resultado.getString("cpf"),
                resultado.getDate("dataAdmissao"),
                resultado.getString("email"),
                resultado.getString("Senha"),
                resultado.getString("telefone")        
                );
                
                listaFuncionario.add(f);
            }
            smt.close();
            con.close();
        }catch(Exception ex){
            System.out.println("Erro ao buscar os funcionários");
        }
        return listaFuncionario;
    }
    
    public Funcionario buscarFuncionarioPorId(int idFuncionario) {
        Connection con = ConexaoSingleton.getInstance();
        String sql = "SELECT * FROM Funcionario WHERE idFuncionario = ?";
        Funcionario f = null;
        try (PreparedStatement smt = con.prepareStatement(sql)) {
            smt.setInt(1, idFuncionario);
            ResultSet resultado = smt.executeQuery();
            if (resultado.next()) {
                 f = new Funcionario(
                resultado.getInt("idFuncionario"),
                resultado.getString("nomeFuncionario"),
                resultado.getString("cpf"),
                resultado.getDate("dataAdmissao"),
                resultado.getString("email"),
                resultado.getString("Senha"),
                resultado.getString("telefone")        
                );
            }
            smt.close();
        } catch (Exception ex) {
        System.out.println("Erro ao buscar o paciente: " + ex.getMessage());
        }
        return f;
    }   
}
