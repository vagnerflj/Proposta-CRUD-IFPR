/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bean;

/**
 *
 * @author hemil
 */
public class Aluno {
    private int id;
    private String nome;
    private String email;
    private int inscricaoCursoId;
    private int inscricaoAlunoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getInscricaoCursoId() {
        return inscricaoCursoId;
    }

    public void setInscricaoCursoId(int inscricaoCursoId) {
        this.inscricaoCursoId = inscricaoCursoId;
    }

    public int getInscricaoAlunoId() {
        return inscricaoAlunoId;
    }

    public void setInscricaoAlunoId(int inscricaoAlunoId) {
        this.inscricaoAlunoId = inscricaoAlunoId;
    }
    
    
    
}
