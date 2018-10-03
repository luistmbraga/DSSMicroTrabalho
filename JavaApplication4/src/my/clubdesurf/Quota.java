/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clubdesurf;

import java.time.LocalDateTime;
import java.io.Serializable; 

/**
 * Write a description of class Quotas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quota implements Serializable
{
    private LocalDateTime data;
    private double valor;
    
    public Quota(){
        this.data = LocalDateTime.now();
        this.valor = 0;
    }
    
    public Quota(Quota q){
        this.data = q.getData();
        this.valor = q.getValor();
    }
    
    public Quota(LocalDateTime data, double valor){
        this.data = data;
        this.valor = valor;
    }
    
    public LocalDateTime getData(){
        return this.data;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Data: " + this.data.toString());
        sb.append("    Valor: " + this.valor);
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if (o == this) return true;
        
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Quota q = (Quota) o;
        
        return(this.data.equals(q.getData()) && this.valor == q.getValor());
    }
    
    public Quota clone(){
        return new Quota(this);
    }
}

