/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Funcionario;
import domain.Medico;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author joaop
 */
public class FuncionarioDao {
    
        private List<Funcionario> pesquisar(String pesq, int tipo) throws HibernateException {
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Funcionario.class );
            
            // FROM
            Root tabela = consulta.from(Funcionario.class);
            
            // RESTRIÇÕES
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: restricoes = builder.like(tabela.get("nomePessoa"), pesq + "%"); 
                        break;
                case 1: restricoes = builder.equal(tabela.get("cpf"), pesq);
                        break; 
                case 2: restricoes = builder.equal(tabela.get("dataAdmissao"), pesq);
                        break;
                case 3: restricoes = builder.like(tabela.get("email"), pesq + "%"); 
                        break;
                case 4: restricoes = builder.equal(tabela.get("idPessoa"), pesq ); 
                        break;  
            }
                        
            consulta.where(restricoes);
            lista = sessao.createQuery(consulta).getResultList();            

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null ) {
                sessao.getTransaction().rollback();          
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }   
    
    public List<Funcionario> pesquisarNome(String pesq) {
        return pesquisar(pesq,0);
    }

    public List<Funcionario> pesquisarCPF(String pesq) {
        return pesquisar(pesq,1);
    }

    public List<Funcionario> pesquisarData(String pesq) {
        return pesquisar(pesq,2);
    }

    public List<Funcionario> pesquisarEmail(String pesq) {
        return pesquisar(pesq,3);
    }

    public List<Funcionario> pesquisarID(String pesq) {
        return pesquisar(pesq,4);
    }
    
}
