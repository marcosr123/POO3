/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;


import ModeloBeans.BeansLivro;
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
public class DAOLivro {
     /* ----CONEXÃO COM O BD-> */
      private final Connection conexao;
    
    // Estabelece uma conexão
    public DAOLivro() throws SQLException {       
        this.conexao = ConexaoBD.getConexao();
    }
    /* <-CONEXÃO COM O BD---- */
    
    
    
    
    /* ----LIVRO-> */
    
    // CREATE - Adiciona um registro
    public void adicionaLivro(BeansLivro l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO cadas_livro(exemplar, autor, edicao, ano, disponibilidade)"
                + "VALUES(?, ?, ?, ?, ?)";       
        PreparedStatement stmt = null;
        // stmt recebe o comando SQL
        try{
        stmt = conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"
        stmt.setString(1, l.getExemplar());
        stmt.setString(2, l.getAutor());
        stmt.setString(3, String.valueOf(l.getEdicao()));
        stmt.setString(4, String.valueOf(l.getAno()));
        stmt.setString(5, l.getDisponibilidade());
        JOptionPane.showMessageDialog(null, "Dados Inseridos Com Sucesso!");
            stmt.execute();
        }catch(SQLException ex){
        // O stmt executa o comando SQL no BD, e fecha a conexão
        JOptionPane.showMessageDialog(null, "ERRO Ao Inserir Dados!\nErro: " + ex);
        }
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<BeansLivro> getLista(String exemplar) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM cadas_livro WHERE exemplar like ?";
        List<BeansLivro> lista;
          try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
              stmt.setString(1, exemplar);
            try ( // Recebe o resultado da consulta SQL
                    ResultSet rs = stmt.executeQuery()) {
                lista = new ArrayList<>();
                // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
                while(rs.next()) {
                    //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
                    BeansLivro l = new BeansLivro();
                    
                    // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome"
                    l.setId(Integer.valueOf(rs.getString("id_livro")));
                    l.setExemplar(rs.getString("exemplar"));
                    l.setAutor(rs.getString("autor"));
                    l.setEdicao(Byte.valueOf(rs.getString("edicao")));
                    l.setAno(Short.valueOf(rs.getString("ano")));
                    l.setDisponibilidade(rs.getString("disponibilidade"));
                    
                    // Adiciona o registro na lista
                    lista.add(l);
                }     // Fecha a conexão com o BD
            }
          }
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // UPDATE - Atualiza registros
    public void altera(BeansLivro l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE cadas_livro set exemplar=?, autor=?, edicao=?, ano=?, disponibilidade=?"
                + "WHERE id_livro=?";
          // Seta os valores p/ o stmt, substituindo os "?"
          try ( // stmt recebe o comando SQL
                  PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
              // Seta os valores p/ o stmt, substituindo os "?"
              stmt.setString(1, l.getExemplar());
              stmt.setString(2, l.getAutor());
              stmt.setString(3, String.valueOf(l.getEdicao()));
              stmt.setString(4, String.valueOf(l.getAno()));
              stmt.setString(5, l.getDisponibilidade());
              // Usa o ID como parâmetro de comparação no SQL
              stmt.setInt(6, l.getId());
              
              // O stmt executa o comando SQL no BD, e fecha a conexão
              stmt.execute();
          }
    }
    
    // UPDATE - Altera a disponibilidade do livro
    public void alteraDisponibilidadeLivro(BeansLivro l) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE cadas_livro set disponibilidade=?"
                + "WHERE id_livro=?";
          // Seta os valores p/ o stmt, substituindo os "?"
          try ( // stmt recebe o comando SQL
                  PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
              // Seta os valores p/ o stmt, substituindo os "?"
              stmt.setString(1, l.getDisponibilidade());
              // Usa o ID como parâmetro de comparação no SQL
              stmt.setInt(2, l.getId());
              
              // O stmt executa o comando SQL no BD, e fecha a conexão
              stmt.execute();
          }
    }
    
    // DELETE - Apaga registros
    public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM cadas_livro WHERE id_livro=?";
          // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
          try ( // stmt recebe o comando SQL
                  PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
              // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
              stmt.setInt(1, id);
              
              // Executa o codigo SQL, e fecha
              stmt.execute();
          }
        
    }
  
}
