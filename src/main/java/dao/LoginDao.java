/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Funcionario;
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
public class LoginDao {
    private Funcionario pesquisar(String cpf, String senha) throws HibernateException {
        List<Funcionario> lista = null;
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
            
            Predicate restricao1 = builder.equal(tabela.get("cpf"), cpf); 
            Predicate restricao2 = builder.equal(tabela.get("senha"), senha);             
                        
            consulta.where(restricao1,restricao2);
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
        
        if (lista != null && !lista.isEmpty()) {
            return lista.get(0);
        }else {
            return null; // ou retorne algum valor padrão adequado
        }
    }   
    
    public Funcionario validarEntrada(String cpf, String senha) {
        return pesquisar(cpf, senha);
    }

}
