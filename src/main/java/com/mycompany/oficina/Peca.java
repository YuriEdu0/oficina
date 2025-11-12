package com.mycompany.oficina;

public class Peca {

    String nomepeca;
    int codpeca;
    
    //construtor com o parametro nomepeca
    public Peca (String nomepeca, int codpeca){
        this.nomepeca = nomepeca;
        this.codpeca = codpeca;
    }
    
    
    public void nomePeca (){
        System.out.println("Peça: " + nomepeca + "\n"
        + "Codigo: " + codpeca);
    } 
}
