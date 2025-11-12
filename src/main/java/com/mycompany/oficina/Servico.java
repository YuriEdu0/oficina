package com.mycompany.oficina;

public class Servico {

    String descricao;
    int codpeca,codservico;
    double valor;

    //construtor com o parametros
    public Servico (int codservico, String descricao, double valor, int codpeca){
        this.codservico = codservico;
        this.descricao = descricao;
        this.valor = valor;
        this.codpeca = codpeca;
    }
    
    
    public void visualizaServico (){
        System.out.println("Código: " + codservico + "\n"
        + "Descrição: " + descricao +"\n"
        + "Valor: " + valor +"\n"
        + "Código da Peça: " + codpeca +"\n");

    } 
}
