/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloBeans.BeansMulta;
import ModeloConection.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinic
 */
public class DAOMulta {
    private final Connection conexao;
    
    // Estabelece uma conexão
    public DAOMulta() throws SQLException {       
        conexao = ConexaoBD.getConexao();
    }
    /* <-CONEXÃO COM O BD---- */
    
    
    
    
    /* ----MULTA-> */
    
    // CREATE - Adiciona um registro
    public void adicionaMulta(BeansMulta m) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO multa(id_cliente, descricao, valor) VALUES(?, ?, ?)";       
        PreparedStatement stmt=null;
        // stmt recebe o comando SQL
        stmt = conexao.prepareStatement(sql);
        
        // Seta os valores p/ o stmt, substituindo os "?"        
        stmt.setString(1, String.valueOf(m.getId_cliente()));
        stmt.setString(2, m.getDescricao());
        stmt.setString(3, String.valueOf(m.getValor()));
        
        // O stmt executa o comando SQL no BD, e fecha a conexão
        stmt.execute();
        stmt.close();
        
    }
    
    // SELECT - Retorna uma lista com o resultado da consulta
    public List<BeansMulta> getLista(String id) throws SQLException{
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM multa WHERE id_multa like ?";
        List<BeansMulta> lista;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, id);
            try ( // Recebe o resultado da consulta SQL
                    ResultSet rs = stmt.executeQuery()) {
                lista = new ArrayList<>();
                // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
                while(rs.next()) {
                    //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
                    BeansMulta m = new BeansMulta();
                    
                    // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome"
                    m.setId_multa(Integer.valueOf(rs.getString("id_multa")));
                    m.setId_cliente(Integer.valueOf(rs.getString("id_cliente")));
                    m.setDescricao(rs.getString("descricao"));
                    m.setValor(Float.valueOf(rs.getString("valor")));
                    
                    // Adiciona o registro na lista
                    lista.add(m);
                }   // Fecha a conexão com o BD
            }            
        }
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna uma lista com as multas de um determinado cliente
    public List<BeansMulta> getListaMultaPorCliente(String id_cliente) throws SQLException{  
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT multa.id_multa, multa.id_cliente, multa.descricao, multa.valor " +
                    "FROM multa " +
                    "INNER JOIN cadas_cliente " +
                    "ON multa.id_cliente = cadas_cliente.id " +
                    "WHERE multa.id_cliente = ?;";
        List<BeansMulta> lista;
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, id_cliente);
            try ( // Recebe o resultado da consulta SQL
                    ResultSet rs = stmt.executeQuery()) {
                lista = new ArrayList<>();
                // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista
                while(rs.next()) {
                    //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
                    BeansMulta m = new BeansMulta();
                    
                    // "c" -> Registro novo - .setNome recebe o campo do banco de String "nome"
                    m.setId_multa(Integer.valueOf(rs.getString("multa.id_multa")));
                    m.setId_cliente(Integer.valueOf(rs.getString("multa.id_cliente")));
                    m.setDescricao(rs.getString("multa.descricao"));
                    m.setValor(Float.valueOf(rs.getString("multa.valor")));
                    
                    // Adiciona o registro na lista
                    lista.add(m);
                }   // Fecha a conexão com o BD
            }            
        }
        
        // Retorna a lista de registros, gerados pela consulta
        return lista;          
    }
    
    // SELECT - Retorna o valor total das multas de um cliente
    public String totalMultaCliente(String id_cliente) throws SQLException {
        System.out.println("asdj89asduasd8asd8");
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT SUM(multa.valor) AS totalMulta FROM multa "
                + "INNER JOIN cadas_cliente ON multa.id_cliente = cadas_cliente.id "
                + "WHERE cadas_cliente.id = ? "
                + "GROUP BY cadas_cliente.id;";
        String totalMulta;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, id_cliente);
            try ( // Recebe o resultado da consulta SQL
                    ResultSet rs = stmt.executeQuery()) {
                rs.next();
                totalMulta = String.valueOf(rs.getFloat("totalMulta"));
                System.out.println(totalMulta);
                // Fecha a conexão com o BD
            }
        }

        // Retorna a lista de registros, gerados pela consulta
        System.out.println("asdj89asduasd8asd8");
        return totalMulta;

    }
    
    // DELETE - Apaga registros
    public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM multa WHERE id_multa=?";
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        try ( // stmt recebe o comando SQL
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
            stmt.setInt(1, id);
                    
            // Executa o codigo SQL, e fecha
            stmt.execute();
        }
    }
    
    // DELETE - Apaga todas as multas
    public void removeMultas(String id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM multa WHERE id_cliente=?";
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        try ( // stmt recebe o comando SQL
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
            stmt.setString(1, id);
                    
            // Executa o codigo SQL, e fecha
            stmt.execute();
        }
    }
    
}
