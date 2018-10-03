/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clubdesurf;

import java.util.List;  
import java.util.ArrayList;
import java.io.Serializable; 
/**
 * Write a description of class Membro here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Aluno implements Serializable
{
    private int numero; // número do aluno 
    private String nome; // nome do aluno
    private String curso; // curso que o aluno frequenta
    private int ano; // ano em que se inscreveu no clube
    private String morada; // morada do aluno
    private String email; // email do aluno
    private List<Quota> quotas;
    
    public Aluno()
    {
        this.numero = -1;
        this.nome = "";
        this.curso = "";
        this.ano = -1;
        this.morada = "";
        this.email = "";
        this.quotas = new ArrayList<>();
    }
    
    public Aluno(Aluno a)
    {
        this.numero = a.getNumero();
        this.nome = a.getNome();
        this.curso = a.getCurso();
        this.ano = a.getAno();
        this.morada = a.getMorada();
        this.email = a.getEmail();
        this.quotas = a.getQuotas();
    }
    
    public Aluno(int num, String nome, String curso, int ano, String morada, String email)
    {
        this.numero = num;
        this.nome = nome;
        this.curso = curso;
        this.ano = ano;
        this.morada = morada;
        this.email = email;
        this.quotas = new ArrayList<>();
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCurso(){
        return this.curso;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public List<Quota> getQuotas(){
        List<Quota> l = new ArrayList<>();
        for(Quota q : this.quotas){
            l.add(q.clone());
        }
        
        return l;
    }
    
    public void setNumero(int num){
        this.numero = num;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCurso(String curso){
        this.curso = curso;
    }
    
    public void setAno(int ano){
        this.ano = ano;
    }
    
    public void setMorada(String morada){
        this.morada = morada;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void addQuota(Quota q){
        this.quotas.add(q);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Número: " + this.numero);
        sb.append("; Nome: " + this.nome);
        sb.append("; Curso: " + this.curso);
        sb.append("; Ano: " + this.ano);
        sb.append("; Morada: " + this.morada);
        sb.append("; Email: " + this.email);
        
        return sb.toString();
    }
    
    public Aluno clone(){
        return new Aluno(this);
    }
    
    public boolean equals(Object o){
        if (this == o) return true;
        
        if (o == null || o.getClass() != this.getClass()) return false;
        
        Aluno a = (Aluno) o;
        
        return (this.numero == a.getNumero() && this.nome.equals(a.getNome()) && this.curso.equals(a.getCurso())
                                             && this.ano == a.getAno() && this.morada.equals(a.getMorada())
                                             && this.email.equals(a.getEmail()));
    }
}

