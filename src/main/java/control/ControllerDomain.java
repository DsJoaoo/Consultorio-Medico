/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import domain.*;
import dao.*;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author joaop
 */
public class ControllerDomain {
    private final GenericDao genDao;
    private final PacienteDao pacDao;
    private final MedicoDao medDao;
    private final FuncionarioDao funDao;
    private final ConsultaDao conDao;
    private final TipoConsultaDao tipoDao;
    private final LoginDao logDao;
    private Funcionario funcionarioLogado;
    
    
    public ControllerDomain() throws ClassNotFoundException, SQLException {
        // TESTE
        ConexaoHibernate.getSessionFactory();
        genDao = new GenericDao();
        pacDao = new PacienteDao();
        medDao = new MedicoDao();
        funDao = new FuncionarioDao();
        conDao = new ConsultaDao();
        tipoDao = new TipoConsultaDao();
        logDao = new LoginDao();
        funcionarioLogado = null;
    }
    
    //<editor-fold defaultstate="collapsed" desc="CODE: Inserções e exclusão ">
    

    public int inserirPaciente(String nome, String cpf, String email, Date data, String telefone, String sexo){
        Pessoa p = new Paciente(nome, telefone, email, cpf, data, sexo);
        genDao.cadastrar(p);
        return p.getIdPessoa();
    }
    
    public int inserirFucionario(String nome, String cpf, Date dt, String email, String senha, String telefone) {
        Pessoa p = new Funcionario(nome, telefone,email, cpf, dt, UtilCriptografia.encryptPassword(senha));
        genDao.cadastrar(p);
        return p.getIdPessoa();
    }

    public int inserirMedico(String nome, String telefone, String email, String cpf, String crm, String especializacao) {
        Pessoa p = new Medico(nome, telefone,email, cpf, crm, especializacao);
        genDao.cadastrar(p);
        return p.getIdPessoa();
    }

    public void inserirConsulta(Date dt, Time hr, Funcionario fun, Paciente pac, Medico med, TipoConsulta tipo) throws RuntimeException {
        Consulta p = new Consulta(dt, hr, pac,fun, med, tipo);
        if(conDao.verificarMedicoDisponivel(med, dt, hr) && conDao.verificarFuncionarioDisponivel(fun, dt, hr)){
            genDao.cadastrar(p);
        }else{
            throw new RuntimeException("\nErro, paciente ou médico já possui atendimento nesse dia e horário");
        }
    }

    public int inserirTipo(String nome, Double preco, boolean selecionado) {
        TipoConsulta p = new TipoConsulta(nome, preco, selecionado);
        genDao.cadastrar(p);
        return p.getIdTipoConsulta();
    }
    
    
    public List listar(Class classe) throws HibernateException {        
        return genDao.listar(classe);        
    }    
     
    public void excluir (Object obj) throws HibernateException {
        genDao.remover(obj);
    }
    
        //</editor-fold>

    public List<TipoConsulta> pesquisarTipoConsulta(String pesq, int tipo) {
        List<TipoConsulta> lista = null;
        switch (tipo) {
            case 0: lista = tipoDao.pesquisarID(pesq); break;

            case 1: lista = tipoDao.pesquisarNome(pesq); break;

            case 2: lista = tipoDao.pesquisarPlano(pesq); break;
        }
        return lista;
    }

    public List<Paciente> pesquisarPaciente(String pesq, int tipo) {
        List<Paciente> lista = null;
        switch (tipo) {
            case 0: lista = pacDao.pesquisarNome(pesq); break;

            case 1: lista = pacDao.pesquisarData(UtilGeral.formatarDataParaSQL(pesq)); break;

            case 2: lista = pacDao.pesquisarID(pesq); break;
            
            case 3: lista = pacDao.pesquisarCPF(pesq); break;
        }
        return lista;
    }

    public List<Medico> pesquisarMedico(String pesq, int tipo) {
        List<Medico> lista = null;
        switch (tipo) {
            case 0: lista = medDao.pesquisarNome(pesq); break;

            case 1: lista = medDao.pesquisarCPF(pesq); break;

            case 2: lista = medDao.pesquisarEMAIL(pesq); break;
            
            case 3: lista = medDao.pesquisarTEL(pesq); break;
            
            case 5: lista = medDao.pesquisarCRM(pesq); break;
            
            case 6: lista = medDao.pesquisarID(pesq); break;
        }
        return lista;
    }

    public List<Funcionario> pesquisarFuncionario(String pesq, int tipo) {
        List<Funcionario> lista = null;
        switch (tipo) {
            case 0: lista = funDao.pesquisarNome(pesq); break;

            case 1: lista = funDao.pesquisarCPF(pesq); break;

            case 2: lista = funDao.pesquisarData(UtilGeral.formatarDataParaSQL(pesq)); break;
            
            case 3: lista = funDao.pesquisarEmail(pesq); break;
            
            case 4: lista = funDao.pesquisarID(pesq); break;
        }
        return lista;
    }

    public List<Consulta> pesquisarConsulta(String pesq, int tipo) {
        List<Consulta> lista = null;
        switch (tipo) {
            case 0: lista = conDao.pesquisarID(pesq); break;

            case 1: lista = conDao.pesquisarTIPO(pesq); break;

            case 2: lista = conDao.pesquisarMedico(pesq); break;
            
            case 3: lista = conDao.pesquisarPaciente(pesq); break;
            
            case 4: lista = conDao.pesquisarFuncionario(pesq); break;
            
            case 5: lista = conDao.pesquisarData(UtilGeral.formatarDataParaSQL(pesq)); break;
        }
        return lista;
    }
    
    public boolean verificarDisponibilidade(Medico medico, String hora, String data){
        
        return false;
    }
    
    public boolean verificarDisponibilidade( Paciente paciente, String hora, String data){
        
        return false;
        
    }
    
    public boolean validarCPF(String cpf, Class classe, Adapter objeto){
         if (objeto == null)
             return (genDao.validar(cpf, 0, classe) && UtilCPF.validarCPF(cpf));
        else
             return (UtilCPF.validarCPF(cpf));
    }
    
    public boolean validarEmail(String email, Class classe, Adapter objeto){
        if (objeto == null)
            return (genDao.validar(email, 1, classe) && UtilGeral.validarEmail(email));
        else
             return (UtilGeral.validarEmail(email));
    }
    
    public boolean validarFuncionario(String cpf, String senha){
        Funcionario usuarioRequisicao = logDao.validarUsuario(cpf);
        //verificando se o cpf cadastrado no banco possuí a mesma senha criptografada que foi que foi inserida na interface
        if(usuarioRequisicao!= null && UtilCriptografia.verifyPassword(senha, usuarioRequisicao.getSenha()))
            funcionarioLogado = usuarioRequisicao;
        return funcionarioLogado != null;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void alterarPaciente(Paciente pacienteSelecionado, String nome, String cpf, String email, Date dt, String telefone, String sexo) {
        pacienteSelecionado.setNomePessoa(nome);
        pacienteSelecionado.setCpf(cpf);
        pacienteSelecionado.setEmail(email);
        pacienteSelecionado.setDataNascimento(dt);
        pacienteSelecionado.setTelefone(telefone);
        pacienteSelecionado.setSexo(sexo);
        genDao.atualizar(pacienteSelecionado);
    }

    public void aterarMedico(Medico medicoSelecionado, String nome, String telefone, String email, String cpf, String crm, String especializacao) {
        medicoSelecionado.setNomePessoa(nome);
        medicoSelecionado.setTelefone(telefone);
        medicoSelecionado.setEmail(email);
        medicoSelecionado.setCpf(cpf);
        medicoSelecionado.setCrm(crm);
        medicoSelecionado.setEspecializacao(especializacao);
        genDao.atualizar(medicoSelecionado);
    }

    public void alterarConsulta(Consulta consultaSelecionada, Date dt, Time hr, Funcionario funcionarioSelecionado, Paciente pacienteSelecionado, Medico medicoSelecionado, TipoConsulta tipoConsultaSelecionado) {
        consultaSelecionada.setDataConsulta(dt);
        consultaSelecionada.setHora(hr);
        consultaSelecionada.setFuncionario(funcionarioSelecionado);
        consultaSelecionada.setPaciente(pacienteSelecionado);
        consultaSelecionada.setMedico(medicoSelecionado);
        consultaSelecionada.setTipoConsulta(tipoConsultaSelecionado);
        
        genDao.atualizar(consultaSelecionada);
    }

    public void alterarFucionario(Funcionario funcionarioSelecionado, String nome, String cpf, Date dt, String email, String senha, String telefone) {
        funcionarioSelecionado.setNomePessoa(nome);
        funcionarioSelecionado.setCpf(cpf);
        funcionarioSelecionado.setDataAdmissao(dt);
        funcionarioSelecionado.setEmail(email);
        funcionarioSelecionado.setSenha(UtilCriptografia.encryptPassword(senha));
        funcionarioSelecionado.setTelefone(telefone);
        genDao.atualizar(funcionarioSelecionado);
    }

    public void alterarTipo(TipoConsulta tipoSelecionado, String nome, Double preco, boolean selecionado) {
        tipoSelecionado.setDescricao(nome);
        tipoSelecionado.setValor(preco);
        tipoSelecionado.setIsPlano(selecionado);
        genDao.atualizar(tipoSelecionado);
    }
    
    
}
