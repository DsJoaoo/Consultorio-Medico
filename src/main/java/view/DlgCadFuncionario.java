/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.ControllerView;
import control.Functions;
import domain.Funcionario;
import domain.Medico;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;

/**
 *
 * @author joaop
 */
public class DlgCadFuncionario extends javax.swing.JDialog {
    private ControllerView gerIG;
    private Funcionario funcionarioSelecionado;
    /**
     * Creates new form DlgCliente
     */
    public DlgCadFuncionario(java.awt.Frame parent, boolean modal, ControllerView controller) {
        super(parent, modal);
        initComponents();
        gerIG = controller;
        funcionarioSelecionado = null;
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
        CadastroFuncionario = new javax.swing.JPanel();
        jpDados = new javax.swing.JPanel();
        jpInfo = new javax.swing.JPanel();
        jpID = new javax.swing.JPanel();
        lbID = new javax.swing.JLabel();
        txtIdFuncionario = new javax.swing.JFormattedTextField();
        jpNome = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jpEmail = new javax.swing.JPanel();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbDataAdmissao = new javax.swing.JLabel();
        txtDataAdmissao = new javax.swing.JFormattedTextField();
        jpCapacidade = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtCPF = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtPSW = new javax.swing.JPasswordField();
        txtConfirmarPSW = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        lbCPF = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        lbConfirmarSenha = new javax.swing.JLabel();
        jpBotoes = new javax.swing.JPanel();
        btConfirmar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        ListarFuncionario = new javax.swing.JPanel();
        lbPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btListarTodos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jpTabelaFuncionarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jpBotoesLista = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btLupa1 = new javax.swing.JButton();
        cmbOpcao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar / Listar funcionários");
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

        jpID.setLayout(new java.awt.GridLayout(1, 2, -120, 15));
        jpID.setVisible(false);

        lbID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbID.setText("ID");
        jpID.add(lbID);

        txtIdFuncionario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtIdFuncionario.setEnabled(false);
        jpID.add(txtIdFuncionario);

        jpNome.setLayout(new java.awt.GridLayout(1, 2, -120, 15));

        lbNome.setBackground(new java.awt.Color(255, 255, 255));
        lbNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbNome.setText("Nome");
        jpNome.add(lbNome);
        jpNome.add(txtNome);

        jpEmail.setLayout(new java.awt.GridLayout(1, 2, -120, 15));

        lbEmail.setBackground(new java.awt.Color(255, 255, 255));
        lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbEmail.setText("E-mail");
        jpEmail.add(lbEmail);
        jpEmail.add(txtEmail);

        lbDataAdmissao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbDataAdmissao.setText("Data de Admissao");

        try {
            txtDataAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpInfoLayout.createSequentialGroup()
                        .addComponent(lbDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jpID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpDados.add(jpInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, 210));

        jpCapacidade.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new java.awt.GridLayout(4, 1, 0, 20));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(txtCPF);

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(txtTelefone);
        jPanel4.add(txtPSW);
        jPanel4.add(txtConfirmarPSW);

        jpCapacidade.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 150, 200));

        jPanel3.setLayout(new java.awt.GridLayout(4, 1, 0, 8));

        lbCPF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbCPF.setText("CPF");
        jPanel3.add(lbCPF);

        lbTelefone.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbTelefone.setText("Telefone");
        jPanel3.add(lbTelefone);

        lbSenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbSenha.setText("Senha");
        jPanel3.add(lbSenha);

        lbConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbConfirmarSenha.setText("Confir. Senha");
        jPanel3.add(lbConfirmarSenha);

        jpCapacidade.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 200));

        jpDados.add(jpCapacidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 320, 220));

        jpBotoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/icons8-vassoura-24.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        jpBotoes.add(btLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 150, 40));

        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout CadastroFuncionarioLayout = new javax.swing.GroupLayout(CadastroFuncionario);
        CadastroFuncionario.setLayout(CadastroFuncionarioLayout);
        CadastroFuncionarioLayout.setHorizontalGroup(
            CadastroFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroFuncionarioLayout.createSequentialGroup()
                .addGroup(CadastroFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(CadastroFuncionarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpDados, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CadastroFuncionarioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        CadastroFuncionarioLayout.setVerticalGroup(
            CadastroFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDados, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpTelas.addTab("Cadastrar Funcionário", CadastroFuncionario);

        ListarFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPesquisar.setText("Pesquisar ");
        ListarFuncionario.add(lbPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 40));
        ListarFuncionario.add(txtPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 290, 40));

        btListarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/icons8-multidão-24.png"))); // NOI18N
        btListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarTodosActionPerformed(evt);
            }
        });
        ListarFuncionario.add(btListarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 40, 40));

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListarFuncionario.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 610, 10));

        jpTabelaFuncionarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Funcionários", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jpTabelaFuncionarios.setLayout(new java.awt.BorderLayout());

        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "DATA ADMISSÃO", "E-MAIL", "SENHA", "TELEFONE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbFuncionarios);

        jpTabelaFuncionarios.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        ListarFuncionario.add(jpTabelaFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 590, 190));

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListarFuncionario.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 610, 10));

        jpBotoesLista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/adicionar 24x24.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.setPreferredSize(new java.awt.Dimension(75, 23));
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jpBotoesLista.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 40));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/editar 24x24.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setPreferredSize(new java.awt.Dimension(75, 23));
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jpBotoesLista.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 150, 40));

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/lixera 24x24.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jpBotoesLista.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 150, 40));

        ListarFuncionario.add(jpBotoesLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 594, 60));

        btLupa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/icons/lupa24-icon.png"))); // NOI18N
        btLupa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLupa1ActionPerformed(evt);
            }
        });
        ListarFuncionario.add(btLupa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 40, 40));

        cmbOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Data", "E-mail", "ID" }));
        ListarFuncionario.add(cmbOpcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 40));

        jtpTelas.addTab("Listar Funcionários", ListarFuncionario);

        getContentPane().add(jtpTelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 37, 610, 390));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaces/imgs/TelaMedico.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void habilitarBotoes() {
        if(funcionarioSelecionado == null){
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
        lbNome.setForeground(Color.black);
        lbCPF.setForeground(Color.black);
        lbEmail.setForeground(Color.black);
        lbDataAdmissao.setForeground(Color.black);
        lbTelefone.setForeground(Color.black);
        lbPesquisar.setForeground(Color.black);
        lbPesquisar.setForeground(Color.black);
        lbSenha.setForeground(Color.black);
        lbConfirmarSenha.setForeground(Color.black);
    }
    
    
    private boolean validarPesquisa(){
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
        String msgErro = "";
        setCor();
        
        String senha = String.valueOf(txtPSW.getPassword());
        String confirmarSenha = String.valueOf(txtConfirmarPSW.getPassword());
        
        if(txtNome.getText().isEmpty()){
            msgErro += "Nome invalido\n";
            lbNome.setForeground(Color.red);
        }
        
        if(Functions.validarSenha(senha) == false){
            msgErro += "Senha invalida\nVerifique se sua senha possui pelo menos:\n    (8) caracteres;\n    (1) caractere especial;\n    (1) número;\n    (1) letra maiúscula;\n    (1) letra minúscula.\n";
            lbSenha.setForeground(Color.red);
            lbConfirmarSenha.setForeground(Color.red);
        }
       
        
        if((!senha.equals(confirmarSenha))){
            msgErro += "As senhas não conferem\n";
            lbConfirmarSenha.setForeground(Color.red);
        }
        
        if(txtCPF.getText().isEmpty()){
            msgErro += "CPF invalido\n";
            lbCPF.setForeground(Color.red);
        }
        
        if(Functions.validarEmail(txtEmail.getText()) == false){
            msgErro += "Email invalido\n";
            lbEmail.setForeground(Color.red);
        }
        
        if(Functions.verificarFormatoData(txtDataAdmissao.getText()) == false){
            msgErro += "Data de admissao invalida\n";
            lbDataAdmissao.setForeground(Color.red);
        }
        
        if(Functions.validarTelefone(txtTelefone.getText()) == false){
            msgErro += "Telefone ou dd invalido\n";
            lbTelefone.setForeground(Color.red);
        }
        
        if(Functions.validarCPF(txtCPF.getText()) == false){
            lbCPF.setForeground(Color.red);
            msgErro += "CPF Invalido\n";
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
        txtIdFuncionario.setText("");
        txtNome.setText("");
        txtCPF.setText("");
        txtEmail.setText("");      
        txtDataAdmissao.setText("");
        txtTelefone.setText("");
        txtPSW.setText("");
        txtConfirmarPSW.setText("");
    }
    
    
    
    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        String nome = txtNome.getText();
        String cpf = txtCPF.getText();
        String dataAdmissao = txtDataAdmissao.getText();
        String email = txtEmail.getText(); 
        String senha  = txtPSW.getText();
        String telefone = txtTelefone.getText(); 
        if(validarCampos()){
            try {
                Date dt = Functions.strToDate(dataAdmissao);
                if(funcionarioSelecionado == null){
                    gerIG.getGerDominio().inserirFucionario(nome, cpf,dt, email, senha, telefone);
                    JOptionPane.showMessageDialog(this, "Funcionario inserido com sucesso.", "Inserir Funcionario", JOptionPane.INFORMATION_MESSAGE  );
                }
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
        int opcao = tbFuncionarios.getSelectedRow();
        if(opcao >= 0){          
            txtIdFuncionario.setText(tbFuncionarios.getValueAt(opcao, 0).toString());
            txtNome.setText(tbFuncionarios.getValueAt(opcao, 1).toString());
            txtCPF.setText(tbFuncionarios.getValueAt(opcao, 2).toString());
            txtEmail.setText(tbFuncionarios.getValueAt(opcao, 3).toString());

            txtDataAdmissao.setText(Functions.formatarDataParaInterface(tbFuncionarios.getValueAt(opcao, 4).toString()));
            txtTelefone.setText(Functions.removerCaracteresTelefone(tbFuncionarios.getValueAt(opcao, 6).toString()));
           
            btAtualizar.setVisible(true);
            jpID.setVisible(true);
            btConfirmar.setVisible(false);
            
            jtpTelas.setSelectedIndex(0);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int opcao = tbFuncionarios.getSelectedRow();
        if(opcao >= 0){
            //Exclui do banco
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        int idPaciente = Integer.parseInt(txtIdFuncionario.getText());
        String nome = txtNome.getText();
        String cpf = txtCPF.getText();
        String email = txtEmail.getText(); 
        String dataNascimento = Functions.formatarDataParaSQL(txtDataAdmissao.getText());
        String telefone = txtTelefone.getText();
        
        if(validarCampos()){
            //Insere no banco
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

    private void btListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarTodosActionPerformed

        limparCampos();
        //lista todos que estão no banco
    }//GEN-LAST:event_btListarTodosActionPerformed

    private void btLupa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLupa1ActionPerformed
        if(validarPesquisa()){
            try {
                List<Funcionario> lista = gerIG.getGerDominio().pesquisarFuncionario(txtPesquisar.getText(), cmbOpcao.getSelectedIndex());

                // APAGA as linhas da tabela
                ( (DefaultTableModel) tbFuncionarios.getModel() ).setNumRows(0);

                for (Funcionario cli : lista ) {
                    // ADICIONAR LINHA NA TABELA        
                    ( (DefaultTableModel) tbFuncionarios.getModel() ).addRow( cli.toArray() );                
                }
            } catch (HibernateException  ex) {
                JOptionPane.showMessageDialog(this, ex, "ERRO ao PESQUISAR Tipo Consulta", JOptionPane.ERROR_MESSAGE  );
            } 
        }
        limparCampos();
    }//GEN-LAST:event_btLupa1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       try {
            gerIG.carregarTabela(tbFuncionarios, Funcionario.class);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar funcionários " + ex.getMessage() );
        }
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CadastroFuncionario;
    private javax.swing.JPanel ListarFuncionario;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btListarTodos;
    private javax.swing.JButton btLupa1;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox<String> cmbOpcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpBotoesLista;
    private javax.swing.JPanel jpCapacidade;
    private javax.swing.JPanel jpDados;
    private javax.swing.JPanel jpEmail;
    private javax.swing.JPanel jpID;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpNome;
    private javax.swing.JPanel jpTabelaFuncionarios;
    private javax.swing.JTabbedPane jtpTelas;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbConfirmarSenha;
    private javax.swing.JLabel lbDataAdmissao;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPesquisar;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JTable tbFuncionarios;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JPasswordField txtConfirmarPSW;
    private javax.swing.JFormattedTextField txtDataAdmissao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtIdFuncionario;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPSW;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
