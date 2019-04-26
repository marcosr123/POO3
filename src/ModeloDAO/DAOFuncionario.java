/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloConection.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloBeans.BeansFuncionario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOFuncionario {

    /* ----CONEXÃO COM O BD-> */
    private Connection conexao = null;

    // Estabelece uma conexão
    public DAOFuncionario() {
        try {
            conexao = ConexaoBD.getConexao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Estabelecer Conexão!\nErro: " + ex);
        }
    }

    // CREATE - Adiciona um registro
    public void Salvar(BeansFuncionario tmFunc) throws SQLException, ClassNotFoundException {

        // Prepara conexão p/ receber o comando SQL
        String sql = "INSERT INTO cadas_func(nome, cpf, nascimento, sexo, email, telefone, celular, "
                + "funcao, banco, agencia, conta)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, tmFunc.getNome());
            stmt.setString(2, tmFunc.getCpf());
            stmt.setString(3, tmFunc.getData());
            stmt.setString(4, tmFunc.getSexo());
            stmt.setString(5, tmFunc.getEmail());
            stmt.setString(6, tmFunc.getTelefone());
            stmt.setString(7, tmFunc.getCelular());
            stmt.setString(8, tmFunc.getFuncao());
            stmt.setString(9, tmFunc.getBanco());
            stmt.setInt(10, tmFunc.getAgencia());
            stmt.setInt(11, tmFunc.getConta());

          
            JOptionPane.showMessageDialog(null, "Dados Inseridos Com Sucesso!");
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Inserir Dados!\nErro: " + ex);
        }
     

    }

    public List<BeansFuncionario> getLista(String nome) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "SELECT * FROM cadas_func WHERE nome like ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        List<BeansFuncionario> lista = null;
        try {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
           
            lista = new ArrayList<>();
            // Enquanto existir registros, pega os valores do ReultSet e vai adicionando na lista

            while (rs.next()) {
                //  A cada loop, é instanciado um novo objeto, p/ servir de ponte no envio de registros p/ a lista
                BeansFuncionario Func = new BeansFuncionario();
                // "Func" -> Cliente novo - .setNome recebe o campo do banco de String "nome" 
                Func.setCodigo(Integer.valueOf(rs.getString("id")));
                Func.setNome(rs.getString("nome"));
                Func.setCpf(rs.getString("cpf"));
                Func.setData(rs.getString("nascimento"));
                Func.setSexo(rs.getString("sexo"));
                Func.setEmail(rs.getString("email"));
                Func.setTelefone(rs.getString("telefone"));
                Func.setCelular(rs.getString("celular"));
                Func.setFuncao(rs.getString("funcao"));
                Func.setBanco(rs.getString("banco"));
                Func.setAgencia(rs.getInt("agencia"));
                Func.setConta(rs.getInt("conta"));

                // Adiciona o registro na lista
                lista.add(Func);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Ao Inserir Dados!\nErro: " + ex);
        }
        return lista;
    }
    public void remove(int id) throws SQLException {       
        // Prepara conexão p/ receber o comando SQL
        String sql = "DELETE FROM cadas_func WHERE id=?";
        // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
        try ( // stmt recebe o comando SQL
            PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            // Seta o valor do ID p/ a condição de verificação SQL, dentro do stmt
            stmt.setInt(1, id);
            
            // Executa o codigo SQL, e fecha
            stmt.execute();
        }
        
    }
    
    public void altera(BeansFuncionario tmFunc) throws SQLException {
        // Prepara conexão p/ receber o comando SQL
        String sql = "UPDATE  cadas_func SET nome=?, cpf=?, nascimento=?, sexo=?, email=?, telefone=?, celular=?, "
                + "funcao=?, banco=?, agencia=?, conta=? WHERE id=?";

        // Seta os valores p/ o stmt, substituindo os "?"
        try ( // stmt recebe o comando SQL
                PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            // Seta os valores p/ o stmt, substituindo os "?"
            
            stmt.setInt(12, tmFunc.getCodigo());
            stmt.setString(1, tmFunc.getNome());
            stmt.setString(2, tmFunc.getCpf());
            stmt.setString(3, tmFunc.getData());
            stmt.setString(4, tmFunc.getSexo());
            stmt.setString(5, tmFunc.getEmail());
            stmt.setString(6, tmFunc.getTelefone());
            stmt.setString(7, tmFunc.getCelular());
            stmt.setString(8, tmFunc.getFuncao());
            stmt.setString(9, tmFunc.getBanco());
            stmt.setInt(10, tmFunc.getAgencia());
            stmt.setInt(11, tmFunc.getConta());
            
            // O stmt executa o comando SQL no BD, e fecha a conexão
            stmt.execute();
            
        }
    }
    
}
