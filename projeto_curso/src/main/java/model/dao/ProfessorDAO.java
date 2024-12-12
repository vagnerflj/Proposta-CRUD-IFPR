/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author hemil
 */
import conexao.Conexao;
import model.bean.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public void salvar(Professor professor) {
        String sql = "INSERT INTO professor (nome, email) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Professor> listar() {
    List<Professor> professores = new ArrayList<>();
    String sql = "SELECT * FROM professor";

    try (Connection conn = Conexao.getConexao(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Professor professor = new Professor();
            professor.setId(rs.getInt("id"));
            professor.setNome(rs.getString("nome"));
            professor.setEmail(rs.getString("email"));
            professores.add(professor);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return professores;
}
    public void excluir(int professorId) {
    String sql = "DELETE FROM professor WHERE id = ?";
    
    try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, professorId);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
