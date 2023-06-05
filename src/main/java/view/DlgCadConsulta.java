/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.ControllerView;
import control.UtilGeral;
import domain.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;


/**
 *
 * @author joaop
 */
public class DlgCadConsulta extends javax.swing.JDialog {
    private final ControllerView gerIG;
    private Paciente pacienteSelecionado;
    private Medico medicoSelecionado;
    private TipoConsulta tipoConsultaSelecionado;
    private Funcionario funcionarioSelecionado;
    private Consulta consultaSelecionada;
    /**
     * Creates new form DlgCliente
     * @param parent
     * @param modal
     * @param controller
     */
    public DlgCadConsulta(java.awt.Frame parent, boolean modal, ControllerView controller) {
        super(parent, modal);
        initComponents();
        pacienteSelecionado = null;
        medicoSelecionado = null;
        tipoConsultaSelecionado = null;
        funcionarioSelecionado = null;
        consultaSelecionada = null;
        gerIG = controller;
        
        //atualizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpTelas = new javax.swing.JTabbedPane();
        CadastroConsulta = new javax.swing.JPanel();
        jpDados = new javax.swing.JPanel();
        jpTipos = new javax.swing.JPanel();
        jpDao = new javax.swing.JPanel();
        lbMedico = new javax.swing.JLabel();
        lbPaciente = new javax.swing.JLabel();
        jpCombo = new javax.swing.JPanel();
        btPesqMedico = new javax.swing.JButton();
        btPesqPaciente = new javax.swing.JButton();
        jpCombo1 = new javax.swing.JPanel();
        txtMedico = new javax.swing.JTextField();
        txtPaciente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jpID = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        txtIdPaciente = new javax.swing.JFormattedTextField();
        jpData = new javax.swing.JPanel();
        lbData = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jpHora = new javax.swing.JPanel();
        lbHora = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();
        jpTipo = new javax.swing.JPanel();
        lbTipoConsulta = new javax.swing.JLabel();
        cmbTipoConsulta = new javax.swing.JComboBox<>();
        jpBotoes = new javax.swing.JPanel();
        btConfirmar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        ListaConsulta = new javax.swing.JPanel();
        lbPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btLupa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbConsultas = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jpBotoes1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btListarTodos = new javax.swing.JButton();
        cmbOpcao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar / Listar consultas");
        setMinimumSize(new java.awt.Dimension(612, 509));
        setModal(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtpTelas.setAlignmentX(0.1F);
        jtpTelas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jpDados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jpDados.setPreferredSize(new java.awt.Dimension(570, 130));
        jpDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpTipos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpDao.setLayout(new java.awt.GridLayout(2, 1, 0, 3));

        lbMedico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbMedico.setText("Médico");
        jpDao.add(lbMedico);

        lbPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbPaciente.setText("Paciente");
        jpDao.add(lbPaciente);

        jpTipos.add(jpDao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 130));

        jpCombo.setLayout(new java.awt.GridLayout(2, 2, 0, 30));

        btPesqMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/lupa24-icon.png"))); // NOI18N
        btPesqMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesqMedicoActionPerformed(evt);
            }
        });
        jpCombo.add(btPesqMedico);

        btPesqPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/lupa24-icon.png"))); // NOI18N
        btPesqPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesqPacienteActionPerformed(evt);
            }
        });
        jpCombo.add(btPesqPaciente);

        jpTipos.add(jpCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 50, 110));

        jpCombo1.setLayout(new java.awt.GridLayout(2, 2, 0, 30));
        jpCombo1.add(txtMedico);
        jpCombo1.add(txtPaciente);

        jpTipos.add(jpCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 150, 110));

        jpDados.add(jpTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 330, 220));

        jpID.setLayout(new java.awt.GridLayout(1, 2, -50, 15));
        jpID.setVisible(false);

        lbID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbID.setText("ID");
        jpID.add(lbID);

        txtIdPaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtIdPaciente.setEnabled(false);
        jpID.add(txtIdPaciente);

        jpData.setLayout(new java.awt.GridLayout(1, 2, -50, 15));

        lbData.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbData.setText("data");
        jpData.add(lbData);

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jpData.add(txtData);

        jpHora.setLayout(new java.awt.GridLayout(1, 2, -50, 15));

        lbHora.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbHora.setText("hora");
        jpHora.add(lbHora);

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jpHora.add(txtHora);

        jpTipo.setLayout(new java.awt.GridLayout(1, 2, -50, 15));

        lbTipoConsulta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbTipoConsulta.setText("Tipo");
        jpTipo.add(lbTipoConsulta);

        jpTipo.add(cmbTipoConsulta);
        cmbTipoConsulta.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(jpTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jpID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jpDados.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 210));

        jpBotoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/confirmar 24x24.png"))); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });
        jpBotoes.add(btConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, 40));

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/atualizar 24x24.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });
        jpBotoes.add(btAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, 40));
        btAtualizar.setVisible(false);

        btLimpar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/icons8-vassoura-24.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        jpBotoes.add(btLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 150, 40));

        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout CadastroConsultaLayout = new javax.swing.GroupLayout(CadastroConsulta);
        CadastroConsulta.setLayout(CadastroConsultaLayout);
        CadastroConsultaLayout.setHorizontalGroup(
            CadastroConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroConsultaLayout.createSequentialGroup()
                .addGroup(CadastroConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(CadastroConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpDados, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CadastroConsultaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        CadastroConsultaLayout.setVerticalGroup(
            CadastroConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDados, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtpTelas.addTab("Cadastrar Consulta", CadastroConsulta);

        ListaConsulta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPesquisar.setText("Pesquisar");
        ListaConsulta.add(lbPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 40));
        ListaConsulta.add(txtPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 280, 40));

        btLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/lupa24-icon.png"))); // NOI18N
        btLupa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLupaActionPerformed(evt);
            }
        });
        ListaConsulta.add(btLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 40, 40));

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListaConsulta.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 610, 10));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        tbConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATA ATENDIMENTO", "HORÁRIO", "PACIENTE", "FUNCIONARIO", "MÉDICO", "TIPO", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbConsultas);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        ListaConsulta.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 610, 190));

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListaConsulta.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 610, 10));

        jpBotoes1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/adicionar 24x24.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setPreferredSize(new java.awt.Dimension(75, 23));
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jpBotoes1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/editar 24x24.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setPreferredSize(new java.awt.Dimension(75, 23));
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jpBotoes1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 150, 40));

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/lixera 24x24.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jpBotoes1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 150, 40));

        ListaConsulta.add(jpBotoes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 594, 60));

        btListarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/icons8-multidão-24.png"))); // NOI18N
        btListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarTodosActionPerformed(evt);
            }
        });
        ListaConsulta.add(btListarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 40, 40));

        cmbOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tipo", "Medico", "Paciente", "Funcionario", "Data" }));
        ListaConsulta.add(cmbOpcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 40));

        jtpTelas.addTab("Listar Consultas", ListaConsulta);

        getContentPane().add(jtpTelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 610, 390));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/TelaMedico.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
     private void habilitarBotoes() {
       if(consultaSelecionada == null){
            limparCampos();
            btAtualizar.setVisible(false);
            btConfirmar.setVisible(true);
            jpID.setVisible(false);
        }else{
            limparCampos();
            jtpTelas.setSelectedIndex(0);
            btAtualizar.setVisible(true);
            btConfirmar.setVisible(false);
            jpID.setVisible(false);
        }
    }
    
    private void setCor(){
       Color defaultLabelColor = UIManager.getColor("Label.foreground");

    // Define a cor padrão para o componente de rótulo
       lbData.setForeground(defaultLabelColor);
       lbHora.setForeground(defaultLabelColor);
       lbMedico.setForeground(defaultLabelColor);
       lbPaciente.setForeground(defaultLabelColor);
       lbTipoConsulta.setForeground(defaultLabelColor);
       lbPesquisar.setForeground(defaultLabelColor);
    }
    
    
    private boolean validarCampoPesquisa(){
       setCor();
        String msgErro = "";
        if(txtPesquisar.getText().isEmpty()){
            lbPesquisar.setForeground(Color.red);
            msgErro += "Insira um nome!\n";
        }
        
        if(msgErro.isEmpty()){
            return true;
        }else{
            JOptionPane.showMessageDialog(this, msgErro, "Verifique os campos e tente novamente", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
    }
    
    
    private boolean validarCampos(){
       setCor();
       String msgErro = "";
       
        
        txtIdPaciente.getText();
        txtData.getText();      
        txtHora.getText();
      
       if(UtilGeral.validarHora(txtHora.getText()) == false){
          lbHora.setForeground(Color.red);
          msgErro += "horário incorreto\n";
       }
       if(UtilGeral.verificarFormatoData(txtData.getText()) == false){
           lbData.setForeground(Color.red);
           msgErro += "data incorreta\n";
       }
       if(medicoSelecionado == null ){
           lbMedico.setForeground(Color.red);
           msgErro += "selecione um medico\n";
       }else if(gerIG.getGerDominio().verificarDisponibilidade(medicoSelecionado, txtHora.getText(), txtData.getText())){
           msgErro += "Médico selecionado não está disponível para atender neste horário\n";
       }
       
       
       if(pacienteSelecionado == null){
            lbPaciente.setForeground(Color.red);
            msgErro += "selecione um paciente\n";
       }else if (gerIG.getGerDominio().verificarDisponibilidade(pacienteSelecionado, txtHora.getText(), txtData.getText())){
           msgErro += "Paciente selecionado está disponível para atender neste horário\n";
       }
       
       if(tipoConsultaSelecionado == null){
           lbTipoConsulta.setForeground(Color.red);
           msgErro += "selecione o tipo de consulta\n";
       }
       
       if(gerIG.getGerDominio().getFuncionarioLogado() == null){
           msgErro += "Funcionario não está habilitada para cadastro\n";
       }else{
           funcionarioSelecionado = gerIG.getGerDominio().getFuncionarioLogado();
       }
       
       
       if(msgErro.isEmpty()){
            return true;
        }else{
            JOptionPane.showMessageDialog(this, msgErro, "Verifique os campos e tente novamente", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void limparCampos(){
        setCor();
        txtIdPaciente.setText("");
        txtData.setText("");      
        txtHora.setText("");
        txtMedico.setText("");
        txtPaciente.setText("");
        cmbTipoConsulta.setSelectedIndex(-1);
    }
  
    
    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        String data = txtData.getText();
        String hora = txtHora.getText();
        tipoConsultaSelecionado = (TipoConsulta) cmbTipoConsulta.getSelectedItem();
        if(validarCampos()){
            try {
                Date dt = UtilGeral.strToDate(data);
                Time hr = UtilGeral.convertStringToTime(hora);
                
                
                
                gerIG.getGerDominio().inserirConsulta(dt, hr,funcionarioSelecionado, pacienteSelecionado, medicoSelecionado, tipoConsultaSelecionado);
                JOptionPane.showMessageDialog(this, "Consulta inserida com sucesso.", "Inserir Consulta", JOptionPane.INFORMATION_MESSAGE  );

            } catch (HeadlessException | ParseException e) {
               JOptionPane.showMessageDialog(this, e, "ERRO Cliente", JOptionPane.ERROR_MESSAGE  );
            }
            habilitarBotoes();
            formComponentShown(null);
            limparCampos();
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparCampos();
        jtpTelas.setSelectedIndex(0);
    }//GEN-LAST:event_btNovoActionPerformed

    
    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed

        int opcao = tbConsultas.getSelectedRow();
        if(opcao >= 0){         
            setCor();
            txtIdPaciente.setText(tbConsultas.getValueAt(opcao, 0).toString());
            txtData.setText(tbConsultas.getValueAt(opcao, 1).toString());
            txtHora.setText(tbConsultas.getValueAt(opcao, 2).toString());

            btAtualizar.setVisible(true);
            jpID.setVisible(true);
            btConfirmar.setVisible(false);
            
            jtpTelas.setSelectedIndex(0);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        }
        
    }//GEN-LAST:event_btEditarActionPerformed

    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int linha = tbConsultas.getSelectedRow();
        if ( linha >= 0 ) {
            try {
                Consulta fun = (Consulta) tbConsultas.getValueAt(linha, 0);
                if ( JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse consulta?", "Título", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ) {
                    gerIG.getGerDominio().excluir(fun);
                    ( (DefaultTableModel) tbConsultas.getModel() ).removeRow(linha);
                    JOptionPane.showMessageDialog(this, "Consulta " + fun.getIdConsulta()+ " excluído com sucesso.", "PESQUISAR consulta", JOptionPane.INFORMATION_MESSAGE  );
                }
                
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO ao PESQUISAR consulta", JOptionPane.ERROR_MESSAGE  );
            }             
        }        
        else {
            JOptionPane.showMessageDialog(this,"Selecione uma linha.", "Pesquisar consulta", JOptionPane.ERROR_MESSAGE  );
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    
    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed

        if(validarCampos()){
            //Atualiza o cliente
            formComponentShown(null);
            jtpTelas.setSelectedIndex(1);
            jpID.setVisible(false);
            btConfirmar.setVisible(true);
            btAtualizar.setVisible(false);
            limparCampos();
            jtpTelas.setSelectedIndex(1);
        }
    }//GEN-LAST:event_btAtualizarActionPerformed
    
    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparCampos();
        btAtualizar.setVisible(false);
        btConfirmar.setVisible(true);
        jpID.setVisible(false);
    }//GEN-LAST:event_btLimparActionPerformed

    private void btLupaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLupaActionPerformed
        if(validarCampoPesquisa()){
            try {
                List<Consulta> lista = gerIG.getGerDominio().pesquisarConsulta(txtPesquisar.getText(), cmbOpcao.getSelectedIndex());

                // APAGA as linhas da tabela
                ( (DefaultTableModel) tbConsultas.getModel() ).setNumRows(0);

                for (Consulta cli : lista ) {
                    // ADICIONAR LINHA NA TABELA        
                    ( (DefaultTableModel) tbConsultas.getModel() ).addRow( cli.toArray() );                
                }
            } catch (HibernateException  ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO ao PESQUISAR Consulta", JOptionPane.ERROR_MESSAGE  );
            } 
        }
        limparCampos();
    }//GEN-LAST:event_btLupaActionPerformed

    private void btListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarTodosActionPerformed

        limparCampos();
        //lista todos que estão no banco
    }//GEN-LAST:event_btListarTodosActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            
            gerIG.carregarTabela(tbConsultas, Consulta.class);
            gerIG.carregarCombo(cmbTipoConsulta, TipoConsulta.class);
            cmbTipoConsulta.setSelectedIndex(-1);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar funcionários " + ex.getMessage() );
    }
    }//GEN-LAST:event_formComponentShown

    private void btPesqMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesqMedicoActionPerformed
        medicoSelecionado = gerIG.janelaPesqMedico();
        if ( medicoSelecionado != null ) {
            txtMedico.setText(medicoSelecionado.getNomePessoa());
        }
    }//GEN-LAST:event_btPesqMedicoActionPerformed

    private void btPesqPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesqPacienteActionPerformed
        pacienteSelecionado = gerIG.janelaPesqPaciente();
        if ( pacienteSelecionado != null ) {
            txtPaciente.setText(pacienteSelecionado.getNomePessoa());
        }
    }//GEN-LAST:event_btPesqPacienteActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CadastroConsulta;
    private javax.swing.JPanel ListaConsulta;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btListarTodos;
    private javax.swing.JButton btLupa;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesqMedico;
    private javax.swing.JButton btPesqPaciente;
    private javax.swing.JComboBox<String> cmbOpcao;
    private javax.swing.JComboBox<String> cmbTipoConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpBotoes1;
    private javax.swing.JPanel jpCombo;
    private javax.swing.JPanel jpCombo1;
    private javax.swing.JPanel jpDados;
    private javax.swing.JPanel jpDao;
    private javax.swing.JPanel jpData;
    private javax.swing.JPanel jpHora;
    private javax.swing.JPanel jpID;
    private javax.swing.JPanel jpTipo;
    private javax.swing.JPanel jpTipos;
    private javax.swing.JTabbedPane jtpTelas;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbMedico;
    private javax.swing.JLabel lbPaciente;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbTipoConsulta;
    private javax.swing.JTable tbConsultas;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JFormattedTextField txtIdPaciente;
    private javax.swing.JTextField txtMedico;
    private javax.swing.JTextField txtPaciente;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
