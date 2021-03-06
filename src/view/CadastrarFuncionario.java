/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ModeloBeans.BeansFuncionario;
import ModeloConection.ConexaoBD;
import ModeloDAO.DAOFuncionario;
import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.M;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ModeloDAO.ValidaCPF;

/**
 *
 * @author samsung
 */
public class CadastrarFuncionario extends javax.swing.JFrame {

    BeansFuncionario funci = new BeansFuncionario();
    DAOFuncionario control = new DAOFuncionario();
    ConexaoBD conex = new ConexaoBD();
    int flag = 0;
    public CadastrarFuncionario() {
        initComponents();
        desabilitaCampos();
        Salvar.setEnabled(false);
        Cancelar.setEnabled(false);
        Editar.setEnabled(false);
        Excluir.setEnabled(false);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        pesquisar = new javax.swing.JTextField();
        Pesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePesquisa = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        nomeFunc = new javax.swing.JTextField();
        cpf = new javax.swing.JLabel();
        Cpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nascimento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        sexo = new javax.swing.JComboBox<>();
        Funcao = new javax.swing.JLabel();
        funcao = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        telefone = new javax.swing.JFormattedTextField();
        celular = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Novo = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        numeroConta = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        BANCO = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        agencia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Salvar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);
        jPanel1.add(pesquisar);
        pesquisar.setBounds(90, 40, 300, 30);

        Pesquisar.setText("PESQUISAR FUNCIONÁRIO");
        Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(Pesquisar);
        Pesquisar.setBounds(440, 40, 200, 30);

        jTablePesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablePesquisa.setModel(tmFunc);
        jTablePesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePesquisaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePesquisa);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(40, 80, 630, 160);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS PESSOAIS"));

        cpf.setText("NOME DO FUNCIONARIO:");

        try {
            Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("CPF:");

        jLabel5.setText("EMAIL:");

        jLabel6.setText("DATA DE NASCIMENTO:");

        try {
            nascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("SEXO:");

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "MASCULINO", "FEMENINO", "INDEFINIDO" }));

        Funcao.setText("FUNÇÃO:");

        funcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "GERENTE", "ATENDENTE" }));

        jLabel3.setText("CÓDIGO:");

        codigo.setEnabled(false);
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cpf)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(Cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                        .addComponent(nomeFunc)
                        .addComponent(Email))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(sexo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nascimento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Funcao)
                    .addComponent(funcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(143, 143, 143))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(nomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Funcao)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funcao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(21, 250, 640, 250);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("CONTATO"));

        try {
            telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("TELEFONE:");

        jLabel9.setText("CELULAR:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(celular, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(telefone))
                .addGap(68, 68, 68))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(20, 510, 313, 207);

        Novo.setText("Novo");
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });
        jPanel1.add(Novo);
        Novo.setBounds(680, 280, 90, 23);

        jLabel14.setText("BIBLIOTECA DIGITAL");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(310, 740, 102, 14);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS DE PAGAMENTO"));

        try {
            numeroConta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        numeroConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroContaActionPerformed(evt);
            }
        });

        jLabel15.setText("NÚMERO DA CONTA:");

        BANCO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE SEU BANCO", "BANCO DO BRASIL", "BRADESCO", "HSBC", "ITAU" }));

        jLabel16.setText("BANCO:");

        jLabel2.setText("AGÊNCIA:");

        agencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel15)
                        .addComponent(numeroConta)
                        .addComponent(jLabel16)
                        .addComponent(BANCO, 0, 243, Short.MAX_VALUE))
                    .addComponent(agencia, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(4, 4, 4)
                .addComponent(BANCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(350, 520, 309, 207);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CADASTRO DE FUNCIONARIOS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(290, 10, 192, 17);

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });
        jPanel1.add(Salvar);
        Salvar.setBounds(680, 330, 90, 23);

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel1.add(Editar);
        Editar.setBounds(680, 430, 90, 23);

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(Excluir);
        Excluir.setBounds(680, 480, 90, 23);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        jPanel1.add(Sair);
        Sair.setBounds(680, 520, 90, 23);

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelar);
        Cancelar.setBounds(680, 380, 90, 23);

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        flag = 1;
        habilitaCampos();
        Salvar.setEnabled(true);
        Cancelar.setEnabled(true);
        // Limpa os dados dos campos
        limpaCampos();
    }//GEN-LAST:event_NovoActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
    if (flag == 1){        
        if (verificaDados() && verificaCPF()) {
            try {
                funci.setNome(nomeFunc.getText());
                funci.setCpf(Cpf.getText());
                funci.setEmail(Email.getText());
                funci.setFuncao((String) funcao.getSelectedItem());
                funci.setTelefone(telefone.getText());
                funci.setCelular(celular.getText());
                funci.setData(nascimento.getText());
                funci.setAgencia(Integer.parseInt(agencia.getText()));
                funci.setConta(Integer.parseInt(numeroConta.getText()));
                funci.setSexo((String) sexo.getSelectedItem());
                funci.setBanco((String) BANCO.getSelectedItem());
                limpaCampos();
                desabilitaCampos();
                Salvar.setEnabled(false);
                Cancelar.setEnabled(false);
                control.Salvar(funci);
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"ERRO Ao Inserir Dados!\nErro: "+ex);
            }
        }
    }else{
        try {
            alteraRegistro();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao alterar registro.\n"+ex);
        }
    
    }
    }//GEN-LAST:event_SalvarActionPerformed

    private void numeroContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroContaActionPerformed

    private void agenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agenciaActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        try {
            excluirRegistro();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao excluir registro."+ex);
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        flag = 2;
        habilitaCampos();
        Salvar.setEnabled(true);
        Cancelar.setEnabled(true);
        Editar.setEnabled(false);
        Excluir.setEnabled(false);
        Novo.setEnabled(false);
        
    }//GEN-LAST:event_EditarActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed
        try {
            listaContatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Problemas ao listar Funcionarios.\n"+ex);
        }
    }//GEN-LAST:event_PesquisarActionPerformed

    private void jTablePesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePesquisaMouseClicked
        int linhaSelecionada = jTablePesquisa.getSelectedRow();
        
        codigo.setText(jTablePesquisa.getValueAt(linhaSelecionada, 0).toString());
        nomeFunc.setText(jTablePesquisa.getValueAt(linhaSelecionada, 1).toString());
        Cpf.setText(jTablePesquisa.getValueAt(linhaSelecionada, 2).toString());
        Email.setText(jTablePesquisa.getValueAt(linhaSelecionada, 5).toString());
        funcao.setSelectedItem(jTablePesquisa.getValueAt(linhaSelecionada, 8).toString());
        telefone.setText(jTablePesquisa.getValueAt(linhaSelecionada, 6).toString());
        celular.setText(jTablePesquisa.getValueAt(linhaSelecionada, 7).toString());
        nascimento.setText(jTablePesquisa.getValueAt(linhaSelecionada, 3).toString());
        agencia.setText(jTablePesquisa.getValueAt(linhaSelecionada, 10).toString());
        numeroConta.setText(jTablePesquisa.getValueAt(linhaSelecionada, 11).toString());
        sexo.setSelectedItem(jTablePesquisa.getValueAt(linhaSelecionada, 4).toString());
        BANCO.setSelectedItem(jTablePesquisa.getValueAt(linhaSelecionada, 9).toString());
        Editar.setEnabled(true);
        Excluir.setEnabled(true);
        
        
    }//GEN-LAST:event_jTablePesquisaMouseClicked

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        limpaCampos();
        limparTabela();
        Novo.setEnabled(true);
        Salvar.setEnabled(false);
        Cancelar.setEnabled(false);
        Editar.setEnabled(false);
        Excluir.setEnabled(false);
    }//GEN-LAST:event_CancelarActionPerformed

     
    DefaultTableModel tmFunc = new DefaultTableModel(null, new String[]{"Id", "Nome", "Cpf","Nascimento", "Sexo","Email", "Telefone","Celular", "Função", "Banco", "Agência", "Conta"});
    List<BeansFuncionario> funcionarios;
    
    void listaContatos() throws SQLException {
        limpaCampos();
        DAOFuncionario d = new DAOFuncionario();
        funcionarios = d.getLista("%" + pesquisar.getText() + "%"); 
        
        // Após pesquisar os contatos, executa o método p/ exibir o resultado na tabela pesquisa
        mostraPesquisa(funcionarios);
        funcionarios.clear();
    }

    // Mostra a lista de resultado de acordo com o nome passado no campo pesquisa
    private void mostraPesquisa(List<BeansFuncionario> funcionario) {
        // Limpa a tabela sempre que for solicitado uma nova pesquisa
        limparTabela();
        
        if (funcionario.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum registro encontrado.");
        } else {            
            // Linha em branco usada no for, para cada registro é criada uma nova linha 
            String[] linha = new String[] {null, null, null, null, null, null, null, null, null, null, null, null};
            // P/ cada registro é criada uma nova linha, cada recebe linha os campos do registro
            for (int i = 0; i < funcionario.size(); i++) {
                tmFunc.addRow(linha);
                tmFunc.setValueAt(funcionario.get(i).getCodigo(), i, 0);
                tmFunc.setValueAt(funcionario.get(i).getNome(), i, 1);
                tmFunc.setValueAt(funcionario.get(i).getCpf(), i, 2);
                tmFunc.setValueAt(funcionario.get(i).getData(), i, 3);
                tmFunc.setValueAt(funcionario.get(i).getSexo(), i, 4);
                tmFunc.setValueAt(funcionario.get(i).getEmail(), i, 5);
                tmFunc.setValueAt(funcionario.get(i).getTelefone(), i, 6); 
                tmFunc.setValueAt(funcionario.get(i).getCelular(), i, 7);
                tmFunc.setValueAt(funcionario.get(i).getFuncao(), i, 8);
                tmFunc.setValueAt(funcionario.get(i).getBanco(), i, 9);
                tmFunc.setValueAt(funcionario.get(i).getAgencia(), i, 10);
                tmFunc.setValueAt(funcionario.get(i).getConta(), i, 11);

            }            
        }
    }
    
    void limparTabela() {       
        while (tmFunc.getRowCount() > 0) {            
            tmFunc.removeRow(0);
        }
    } 
    
    private void excluirRegistro() throws SQLException {
        // Se algum registro estiver selecionado
        if (jTablePesquisa.getSelectedRow() != -1) {
            // Exibe uma janela de confirmação antes de exluir o registro
            int resp = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este registro?",
                    "Confirmação!", JOptionPane.YES_NO_OPTION);

            // Se a confirmação for SIM
            if (resp == JOptionPane.YES_NO_OPTION) {
                // Recebe a linha selecionada
                int linhaSelecionada = jTablePesquisa.getSelectedRow();
                // Recebe o ID da linha selecionada
                int id = (int) jTablePesquisa.getValueAt(linhaSelecionada, 0);
                // Remove o registro, usando como parâmetro, o id da linha selecionada                
                DAOFuncionario d = new DAOFuncionario();
                d.remove(id);

                JOptionPane.showMessageDialog(rootPane, "Registro excluido com sucesso.");
                limpaCampos();
                desabilitaCampos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Registro não selecionado.");
        }
    }
    
    
    private void alteraRegistro() throws SQLException {
        if (jTablePesquisa.getSelectedRow() != -1) {
            int resp = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente alterar este registro?",
                    "Confirmação!", JOptionPane.YES_NO_OPTION);

            // Se a confirmação for SIM
            if (resp == JOptionPane.YES_NO_OPTION) {                
                DAOFuncionario controle = new DAOFuncionario(); 
                BeansFuncionario func = new BeansFuncionario();
                
                func.setCodigo(Integer.parseInt(codigo.getText()));
                func.setNome(nomeFunc.getText());
                func.setCpf(Cpf.getText());
                func.setEmail(Email.getText());
                func.setFuncao((String) funcao.getSelectedItem());
                func.setTelefone(telefone.getText());
                func.setCelular(celular.getText());
                func.setData(nascimento.getText());
                func.setAgencia(Integer.parseInt(agencia.getText()));
                func.setConta(Integer.parseInt(numeroConta.getText()));
                func.setSexo((String) sexo.getSelectedItem());
                func.setBanco((String) BANCO.getSelectedItem());            
                controle.altera(func);
                
                JOptionPane.showMessageDialog(rootPane, "Registro alterado com sucesso.");
                limpaCampos();
                desabilitaCampos();
                listaContatos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Registro não selecionado.");
        }
    }
    
    private boolean verificaDados() {
        if ((!nomeFunc.getText().equals("")) && (!Cpf.getText().equals("")) 
                && (!Email.getText().equals("")) && (!nascimento.getText().equals(""))
                && (!telefone.getText().equals(""))&& (!celular.getText().equals(""))
                && (!agencia.getText().equals(""))&& (!numeroConta.getText().equals(""))){            
            return true;
        }
        JOptionPane.showMessageDialog(rootPane, "Dados imcompletos.");
        return false;
    }
    private boolean verificaCPF(){
        ValidaCPF d = new ValidaCPF();
        boolean valida = ValidaCPF.isCPF(Cpf.getText());
        if (valida == true){
            return true;
        }else{
            JOptionPane.showMessageDialog(rootPane, "CPF Invalido.");
            return false;
        }
    }
    
    
    private void limpaCampos() {
        nomeFunc.setText("");
        Cpf.setText("");
        Email.setText("");
        nascimento.setText("");
        telefone.setText("");
        celular.setText("");
        agencia.setText("");
        numeroConta.setText("");
    }
    
    // Desabilita os campos do formulário
    private void desabilitaCampos() {
        nomeFunc.setEditable(false);
        Cpf.setEditable(false);
        Email.setEditable(false);
        nascimento.setEditable(false);
        telefone.setEditable(false);
        celular.setEditable(false);
        agencia.setEditable(false);
        numeroConta.setEditable(false);
        sexo.setEnabled(false);
        funcao.setEnabled(false);
        BANCO.setEnabled(false);
    }
    
    // Habilita os campos do formulário
    private void habilitaCampos() {
        nomeFunc.setEditable(true);
        Cpf.setEditable(true);
        Email.setEditable(true);
        nascimento.setEditable(true);
        telefone.setEditable(true);
        celular.setEditable(true);
        agencia.setEditable(true);
        numeroConta.setEditable(true);
        sexo.setEnabled(true);
        funcao.setEnabled(true);
        BANCO.setEnabled(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarFuncionario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BANCO;
    private javax.swing.JButton Cancelar;
    private javax.swing.JFormattedTextField Cpf;
    private javax.swing.JButton Editar;
    private javax.swing.JTextField Email;
    private javax.swing.JButton Excluir;
    private javax.swing.JLabel Funcao;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Pesquisar;
    private javax.swing.JButton Sair;
    private javax.swing.JButton Salvar;
    private javax.swing.JTextField agencia;
    private javax.swing.JFormattedTextField celular;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel cpf;
    private javax.swing.JComboBox<String> funcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePesquisa;
    private javax.swing.JFormattedTextField nascimento;
    private javax.swing.JTextField nomeFunc;
    private javax.swing.JFormattedTextField numeroConta;
    private javax.swing.JTextField pesquisar;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JFormattedTextField telefone;
    // End of variables declaration//GEN-END:variables
}
