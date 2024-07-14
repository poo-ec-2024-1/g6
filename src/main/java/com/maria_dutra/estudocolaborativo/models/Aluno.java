package com.maria_dutra.estudocolaborativo.models;

public class Aluno extends Usuario {
    private String curso;
    private double matricula;
    private String país;

    public Aluno () {}

    public Aluno(Long id,String nome,String email,String senha,String curso,double matricula, String país) {
        super(id,nome, email, senha);
        this.curso = curso;
        this.matricula = matricula;
        this.país = país;
    }

    //getter e setters
    public String getCurso(){
        return curso;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }

    public String getPaís() {
        return país;
    }

    public void setPaís(String país) {
        this.país = país;
    }

    @Override
    public String toString() {
        return super.toString() + ", Curso : " + curso + ", Matricula: " + matricula + ", País : " + país;
    }
}
