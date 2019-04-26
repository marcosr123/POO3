/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloBeans.BeansUsuarioFuncionario;
import ModeloConection.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class DAOUsuarioFuncionario {
     private Connection conexao = null;
     
public DAOUsuarioFuncionario(){
        try {
            conexao = ConexaoBD.getConexao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Estabelecer Conexão!\nErro: " + ex);
        }
}

 public void Salvar(BeansUsuarioFuncionario tmUserFunc) throws SQLException, ClassNotFoundException {

        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO usuariosfunc(loginF, senhaF, funcaoF)"
                + "VALUES(?, ?, ?)"; 
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, tmUserFunc.getLoguin());
            stmt.setString(2, tmUserFunc.getSenha());
            stmt.setString(3, tmUserFunc.getFuncao());
          
            JOptionPane.showMessageDialog(null, "Dados Inseridos Com Sucesso!");
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Inserir Dados!\nErro: " + ex);
        } finally {
            ConexaoBD.closeConexao(conexao, stmt);
        }

    }
    
 
 
    public List<BeansUsuarioFuncionario> getLista(String loginF) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM usuariosfunc WHERE loginF like ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        List<BeansUsuarioFuncionario> UserLista = null;
        try {
            stmt.setString(1, loginF);
            ResultSet rs = stmt.executeQuery();
           
            UserLista = new ArrayList<>();
            // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na UserLista

            while (rs.next()) {
                //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a UserLista
                BeansUsuarioFuncionario UserFunc = new BeansUsuarioFuncionario();
                // "Func" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
                UserFunc.setId(Integer.valueOf(rs.getString("id_user")));
                UserFunc.setLoguin(rs.getString("loginF"));
                UserFunc.setSenha(rs.getString("senhaF"));
                UserFunc.setFuncao(rs.getString("funcaoF"));


                // Adiciona o registro na UserLista
                UserLista.add(UserFunc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Inserir Dados!\nErro: " + ex);
        }
        return UserLista;
    }
    public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM usuariosfunc WHERE id=?";
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        try ( // stmt recebe o comando SQL
            PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
            stmt.setInt(1, id);
            
            // Executa o codigo SQL, e fecha
            stmt.execute();
        }
        
    }
    
    public void altera(BeansUsuarioFuncionario tmUserFunc) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE  usuariosfunc SET loginF=?, senhaF=?, funcaoF=? WHERE id=?";

        // Seta os valores p/ o stmt, substituindo os "?"
        try ( // stmt recebe o comando SQL
                PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            // Seta os valores p/ o stmt, substituindo os "?"
            
            stmt.setInt(4, tmUserFunc.getId());
            stmt.setString(1, tmUserFunc.getLoguin());
            stmt.setString(2, tmUserFunc.getSenha());
            stmt.setString(3, tmUserFunc.getFuncao());

            
            // O stmt executa o comando SQL no BD, e fecha a conexão
            stmt.execute();
            
        }
    }



}
