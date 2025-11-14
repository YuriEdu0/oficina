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

    public static Peca getPeca(int cod, Peca[] pecas, int totalpecas) {
        for (int i = 0; i < totalpecas; i++) {
            if (pecas[i] != null && pecas[i].codpeca == cod) {
                return pecas[i];
            }
        }
        return null; // não achou
    }

}
