/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import conexao.Conexao;
import model.bean.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlunoDAO {

    public void salvar(Aluno aluno) {
    String sql = "INSERT INTO aluno (nome, email, inscricao_curso_id, inscricao_aluno_id) VALUES (?, ?, ?, ?)";

    try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, aluno.getNome());  
        ps.setString(2, aluno.getEmail());  
        ps.setInt(3, aluno.getInscricaoCursoId());  
        ps.setInt(4, aluno.getInscricaoAlunoId()); 
        ps.executeUpdate();
       
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao salvar aluno: " + e.getMessage());
    }
}

    public List<Aluno> listar() {
    List<Aluno> alunos = new ArrayList<>();
    String sql = "SELECT * FROM aluno";

    try (Connection conn = Conexao.getConexao(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setId(rs.getInt("id"));          
            aluno.setNome(rs.getString("nome"));   
            aluno.setEmail(rs.getString("email")); 
            aluno.setInscricaoCursoId(rs.getInt("inscricao_curso_id"));
            alunos.add(aluno);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao listar alunos: " + e.getMessage());
    }
    return alunos;
}
    public void excluir(int alunoId) {
        String sql = "DELETE FROM aluno WHERE id = ?";

        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, alunoId);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir aluno: " + e.getMessage());
        }
    }
}
