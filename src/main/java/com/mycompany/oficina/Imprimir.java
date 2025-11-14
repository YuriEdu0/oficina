/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficina;

/**
 *
 * @author oem
 */
public class Imprimir {
    
     /**
     * Método responsável por imprimir os serviços e gerar o arquivo .txt
     * @param servicos array de serviços cadastrados
     * @param totalservicos quantidade de serviços cadastrados
     */
    public static void imprimirServicos(Servico[] servicos, int totalservicos) {

        if (totalservicos == 0) {
            System.out.println("Nenhum serviço cadastrado ainda! Cadastre um serviço e tente novamente...");
            return;
        }


        // Monta o conteúdo que será impresso e salvo no arquivo
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("--------LISTAGEM DE SERVIÇOS--------\n");

        for (int j = 0; j < totalservicos; j++) {
            if (servicos[j] != null) {
                String linha = "Código: " + servicos[j].codservico
                        + " | Descrição: " + servicos[j].descricao
                        + " | Valor: R$" + servicos[j].valor
                        + " | Cód. Peça: " + servicos[j].codpeca;
                conteudo.append(linha).append(System.lineSeparator());
            }
        }

        // Cria o arquivo de texto na pasta raiz do projeto
        GerenciadorDeArquivo gerenciador = new GerenciadorDeArquivo("servicos.txt");
        gerenciador.escreverConteudo(conteudo.toString());

        System.out.println("\n--> Arquivo 'servicos.txt' gerado com sucesso na pasta raiz do projeto!\n");
    }

    
}   
