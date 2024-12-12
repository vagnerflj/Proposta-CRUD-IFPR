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
import model.bean.Curso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void salvar(Curso curso) {
    String sql = "INSERT INTO curso (nome, descricao, professor_id1) VALUES (?, ?, ?)";

    try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, curso.getNome());
        ps.setString(2, curso.getDescricao());
        ps.setInt(3, curso.getProfessorId()); 
        ps.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao salvar o curso", e);
    }
}

public List<Curso> listar() {
    List<Curso> cursos = new ArrayList<>();
    String sql = "SELECT id, nome, descricao, professor_id1 FROM curso";

    try (Connection conn = Conexao.getConexao(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Curso curso = new Curso();
            curso.setId(rs.getInt("id"));
            curso.setNome(rs.getString("nome"));
            curso.setDescricao(rs.getString("descricao"));
            curso.setProfessorId(rs.getInt("professor_id1"));
            cursos.add(curso);
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao listar os cursos", e);
    }

    return cursos;
}

    public void excluir(int cursoId) {
        String sql = "DELETE FROM curso WHERE id = ?";

        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cursoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao excluir o curso", e);
        }
    }
}






