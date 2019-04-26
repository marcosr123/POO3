/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloBeans.BeansCliente;
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
public class DAOCliente {



    /* ----CONEXÃO COM O BD-> */
    private Connection conexao = null;

    // Estabelece uma conexão
    public DAOCliente() {
        try {
            conexao = ConexaoBD.getConexao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Estabelecer Conexão!\nErro: " + ex);
        }
    }

    /* <-CONEXÃO COM O BD---- */
 /* ----CLIENTE-> */

    // CREATE - Adiciona um registro
    public void Salvar(BeansCliente tmCliente) throws SQLException, ClassNotFoundException {

        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO cadas_cliente(nome, cpf, nascimento, sexo, funcao, email, telefone, celular)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)"; 
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, tmCliente.getNome());
            stmt.setString(2, tmCliente.getCpf());
            stmt.setString(3, tmCliente.getData());
            stmt.setString(4, tmCliente.getSexo());
            stmt.setString(5, tmCliente.getFuncao());
            stmt.setString(6, tmCliente.getEmail());
            stmt.setString(7, tmCliente.getTelefone());
            stmt.setString(8, tmCliente.getCelular());
          
            JOptionPane.showMessageDialog(null, "Dados Inseridos Com Sucesso!");
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Inserir Dados!\nErro: " + ex);
        }
        

    }

    public List<BeansCliente> getLista(String nome) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM cadas_cliente WHERE nome like ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        List<BeansCliente> listaC = null;
        try {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
           
            listaC = new ArrayList<>();
            // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista

            while (rs.next()) {
                //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
                BeansCliente Cliente = new BeansCliente();
                // "Cliente" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
                Cliente.setCodigo(Integer.valueOf(rs.getString("id")));
                Cliente.setNome(rs.getString("nome"));
                Cliente.setCpf(rs.getString("cpf"));
                Cliente.setData(rs.getString("nascimento"));
                Cliente.setSexo(rs.getString("sexo"));
                Cliente.setEmail(rs.getString("email"));
                Cliente.setFuncao(rs.getString("funcao"));
                Cliente.setTelefone(rs.getString("telefone"));
                Cliente.setCelular(rs.getString("celular"));



                // Adiciona o registro na lista
                listaC.add(Cliente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Inserir Dados!\nErro: " + ex);
        }
        return listaC;
    }
    public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM cadas_cliente WHERE id=?";
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        try ( // stmt recebe o comando SQL
            PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
            stmt.setInt(1, id);
            
            // Executa o codigo SQL, e fecha
            stmt.execute();
        }
        
    }
    
    public void altera(BeansCliente tmCliente) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE  cadas_cliente SET nome=?, cpf=?, nascimento=?, sexo=?,funcao=?, email=?, telefone=?, celular=?, "
                + "WHERE id=?";

        // Seta os valores p/ o stmt, substituindo os "?"
        try ( // stmt recebe o comando SQL
                PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            // Seta os valores p/ o stmt, substituindo os "?"
           
            stmt.setInt(11, tmCliente.getCodigo());
            stmt.setString(1, tmCliente.getNome());
            stmt.setString(2, tmCliente.getCpf());
            stmt.setString(3, tmCliente.getData());
            stmt.setString(4, tmCliente.getSexo());
            stmt.setString(5, tmCliente.getFuncao());
            stmt.setString(6, tmCliente.getEmail());
            stmt.setString(7, tmCliente.getTelefone());
            stmt.setString(8, tmCliente.getCelular());          

            // O stmt executa o comando SQL no BD, e fecha a conexão
            stmt.execute();
        }
    }
    
}



