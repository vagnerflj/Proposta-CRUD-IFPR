/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Compra;

/**
 *
 * @author Aluno
 */
public class CompraDAO {
    public void create(Compra c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "INSERT INTO compra(data, id_fornecedor, id_usuario) VALUES (?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setDate(1, c.getData());
            stmt.setInt(2, c.getFornecedor().getId());
            stmt.setInt(3, c.getUsuario().getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Compra. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public ArrayList<Compra> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Compra> compras = new ArrayList();
        
        try {
            String query = "SELECT * FROM compra";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Compra c = new Compra();
                c.setId(rs.getInt("id_compra"));
                c.setData(rs.getDate("data"));
                c.setFornecedor(new FornecedorDAO().read(rs.getInt("id_fornecedor")));
                c.setUsuario(new UsuarioDAO().read(rs.getInt("id_usuario")));
               
                compras.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Compras. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
        
        return compras;
    }
    
    public Compra read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM compra WHERE id_compra = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            Compra c = new Compra();
            if(rs.next()) {
                c.setId(rs.getInt("id_compra"));
                c.setData(rs.getDate("data"));  
                c.setFornecedor(new FornecedorDAO().read(rs.getInt("id_fornecedor")));
                c.setUsuario(new UsuarioDAO().read(rs.getInt("id_usuario")));
            }
            
            return c;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Compra. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
        
        return null;
    }
    
    public void update(Compra c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "UPDATE compra "
                    + "SET data = ?, id_fornecedor = ?, id_usuario = ? "
                    + "WHERE id_compra = ?";
            stmt = con.prepareStatement(query);
            stmt.setDate(1, c.getData());
            stmt.setInt(2, c.getFornecedor().getId());
            stmt.setInt(3, c.getUsuario().getId());
            stmt.setInt(4, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Compra atualizada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Compra. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void destroy(Compra c) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "DELETE FROM compra WHERE id_compra = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Compra. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
