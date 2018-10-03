/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clubdesurf;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors; 
import static java.util.stream.Collectors.toMap;
import java.time.LocalDate;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
/**
 * Write a description of class Clube here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Clube implements Serializable
{
    private Map<Integer,Aluno> alunos;
    
    public Clube(){
        this.alunos = new HashMap<Integer, Aluno>();
    }
    
    public Aluno getAluno(Integer num){
        return this.alunos.get(num);
    }
    
    public Map<Integer,Aluno> getAlunos(){
        return this.alunos.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    
    public void pagarQuota(Integer num, Double valor, LocalDate data){
        Quota q = new Quota(data,valor);
        
        this.alunos.get(num).addQuota(q);
    }
    
    public void gravaObj(String fich) throws IOException, FileNotFoundException{
        FileOutputStream fos = new FileOutputStream(fich);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    
    public static Clube leObj(String fich) throws IOException, FileNotFoundException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fich);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Clube fe = (Clube) ois.readObject();
        ois.close();
        return fe;
    }
    
    public void addAluno(Aluno a){
        this.alunos.put(a.getNumero(),a);
    }
    
    public void removerAluno(int num){
        this.alunos.remove(num);
    }
    
    public boolean existe(int num){
        return this.alunos.containsKey(num);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Aluno a : this.alunos.values()){
            sb.append(a.getNumero() + "       " + a.getNome() + "\n");
        }
        
        return sb.toString();
    }
    
}