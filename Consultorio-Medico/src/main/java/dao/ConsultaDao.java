package dao;

import control.UtilGeral;
import domain.Consulta;
import domain.Funcionario;
import domain.Medico;
import domain.Paciente;
import domain.TipoConsulta;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ConsultaDao extends GenericDao {

    public ConsultaDao() {
        
    }
    
    public boolean verificarPacienteDisponivel(Paciente paciente, Date dataConsulta, Time horaConsulta) throws HibernateException{
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

                Root<Consulta> consultaRoot = criteriaQuery.from(Consulta.class);
                Predicate funcionarioPredicate = criteriaBuilder.equal(consultaRoot.get("paciente"), paciente);
                Predicate dataPredicate = criteriaBuilder.equal(consultaRoot.get("dataConsulta"), dataConsulta);
                Predicate horaPredicate = criteriaBuilder.equal(consultaRoot.get("hora"), horaConsulta);

                criteriaQuery.select(criteriaBuilder.count(consultaRoot));
                criteriaQuery.where(criteriaBuilder.and(funcionarioPredicate, dataPredicate, horaPredicate));

                Long count = session.createQuery(criteriaQuery).getSingleResult();
                return count == 0;
        }
    }
    
    
    public boolean verificarMedicoDisponivel(Medico medico, Date dataConsulta, Time horaConsulta) throws HibernateException{
        try (Session session = ConexaoHibernate.getSessionFactory().openSession()) {
                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

                Root<Consulta> consultaRoot = criteriaQuery.from(Consulta.class);
                Predicate medicoPredicate = criteriaBuilder.equal(consultaRoot.get("medico"), medico);
                Predicate dataPredicate = criteriaBuilder.equal(consultaRoot.get("dataConsulta"), dataConsulta);
                Predicate horaPredicate = criteriaBuilder.equal(consultaRoot.get("hora"), horaConsulta);

                criteriaQuery.select(criteriaBuilder.count(consultaRoot));
                criteriaQuery.where(criteriaBuilder.and(medicoPredicate, dataPredicate, horaPredicate));

                Long count = session.createQuery(criteriaQuery).getSingleResult();
                return count == 0;
        }
    }

    private List<Consulta> pesquisar(String pesq, int tipo) throws HibernateException, ParseException {
        List<Consulta> lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Consulta> consulta = builder.createQuery(Consulta.class);
            Root<Consulta> tabela = consulta.from(Consulta.class);
            Predicate restricoes;

            switch (tipo) {
                case 0:
                    restricoes = builder.equal(tabela.get("idConsulta"), Integer.valueOf(pesq));
                    break;
                case 1:
                    Join<Consulta, TipoConsulta> tipoConsultaJoin = tabela.join("tipoConsulta");
                    restricoes = builder.like(tipoConsultaJoin.get("descricao" ), pesq + "%");
                    break;
                case 2:
                    Join<Consulta, Medico> medicoJoin = tabela.join("medico");
                    restricoes = builder.like(medicoJoin.get("nomePessoa"), pesq + "%");
                    break;
                case 3:
                    Join<Consulta, Paciente> pacienteJoin = tabela.join("paciente");
                    restricoes = builder.like(pacienteJoin.get("nomePessoa"), pesq + "%");
                    break;
                case 4:
                    Join<Consulta, Funcionario> funcionarioJoin = tabela.join("funcionario");
                    restricoes = builder.like(funcionarioJoin.get("nomePessoa"), pesq + "%");
                    break;
                case 5:
                    restricoes = builder.equal(tabela.get("dataConsulta"),pesq);
                    break;
                default:
                    restricoes = null;
        }

        consulta.where(restricoes);
        lista = sessao.createQuery(consulta).getResultList();

        sessao.getTransaction().commit();
        sessao.close();
    } catch (HibernateException ex) {
        if (sessao != null) {
            sessao.getTransaction().rollback();
            sessao.close();
        }
        throw new HibernateException(ex);
    }
    return lista;
    }


    public List<Consulta> pesquisarID(String pesq) throws HibernateException, ParseException{
        return pesquisar(pesq, 0);
    }

    public List<Consulta> pesquisarTIPO(String pesq) throws HibernateException, ParseException {
        return pesquisar(pesq, 1);
    }

    public List<Consulta> pesquisarMedico(String pesq)throws HibernateException, ParseException {
        return pesquisar(pesq, 2);
    }

    public List<Consulta> pesquisarPaciente(String pesq)throws HibernateException, ParseException {
        return pesquisar(pesq, 3);
    }

    public List<Consulta> pesquisarFuncionario(String pesq)throws HibernateException, ParseException {
        return pesquisar(pesq, 4);
    }

    public List<Consulta> pesquisarData(String pesq) throws HibernateException, ParseException{
        return pesquisar(pesq, 5);
    }
}
