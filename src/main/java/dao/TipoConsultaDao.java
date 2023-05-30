/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.TipoConsulta;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author joaop
 */
public class TipoConsultaDao extends GenericDao{
    
   private List<TipoConsulta> pesquisar(String pesq, int tipo) throws HibernateException {
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( TipoConsulta.class );
            
            // FROM
            Root tabela = consulta.from(TipoConsulta.class);
            
            // RESTRIÇÕES
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: restricoes = builder.equal(tabela.get("idTipoConsulta"), pesq ); 
                        break;
                case 1: restricoes = builder.like(tabela.get("descricao"), pesq + "%" ); 
                        break;
                case 2: 
                        restricoes = builder.equal(tabela.get("isPlano"), pesq);
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
            
    public List<TipoConsulta> pesquisarID(String pesq) throws HibernateException {
        return pesquisar(pesq,0);
    }
    
    
    public List<TipoConsulta> pesquisarNome(String pesq) throws HibernateException {
        return pesquisar(pesq,1);
    }
    
    public List<TipoConsulta> pesquisarPlano(String pesq) throws HibernateException {
        return pesquisar(pesq,2);
    }
}
