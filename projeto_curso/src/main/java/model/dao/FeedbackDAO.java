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
import model.bean.Feedback;
import java.sql.*;

public class FeedbackDAO {

    public void salvar(Feedback feedback) {
        String sql = "INSERT INTO feedback (comentario, curso_id, aluno_id) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, feedback.getComentario());
            ps.setInt(2, feedback.getCursoId());
            ps.setInt(3, feedback.getAlunoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
