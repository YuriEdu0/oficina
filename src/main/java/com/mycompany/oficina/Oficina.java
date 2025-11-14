package com.mycompany.oficina;

import java.util.Scanner;

public class Oficina {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Peca[] pecas = new Peca[50]; //PASSO 1: cria um array com espaço para as peças. PASSO 2 ao cadastrar uma peça
        Servico[] servicos = new Servico[50]; //PASSO 1: cria um array com espaço para as servicos. PASSO 2 ao cadastrar uma servicos
        String peca, descServico;
        int menu = 0, i = 0, codservico = 0,resp = 0, codpeca, totalpecas = 0, totalservicos = 0;
        double valor;

        do {

            System.out.println("----MENU----\n"
                    + "1- Cadastra peça\n"
                    + "2- Cadastrar serviços\n"
                    + "3- Imprimir serviços (tela e TXT)\n"
                    + "4- Sair\n"
                    + "--------------");
            menu = sc.nextInt();
            sc.nextLine(); //Limpar o \n

            switch (menu) {

                case 1:
                    do {

                        System.out.print("--------Cadastro de Peças-------\n");

                        System.out.print("Nome da peça: ");
                        peca = sc.nextLine();

                        i++;

                        System.out.println("-------------------\n"
                                + "Peça cadastrada com sucesso! ");
                        Peca peca1 = new Peca(peca, i);
                        pecas[totalpecas] = new Peca(peca, i); //PASSO 2: Registra a peça cadastrada no array. PASSO 3 na listagem de peças dos serviços
                        totalpecas++;
                        peca1.nomePeca();

                        System.out.println("\n\nDeseja cadastrar mais peças ? \n1-Sim ou 2-Não");
                        resp = sc.nextInt();
                        sc.nextLine();

                    } while (resp != 2);

                    break;

                case 2:
                    do {
                        System.out.print("--------Cadastro de Serviços-------\n");
                        if (totalpecas == 0) {
                            System.out.println("Nenhuma peça cadastrada ainda... Cadastre uma peça antes de cadastrar um serviço!");
                            break;
                        }
                        System.out.print("Descrição do serviço: ");
                        descServico = sc.nextLine();
                        System.out.print("Valor do serviço: R$");
                        valor = sc.nextDouble();
                        System.out.print("Peças disponíveis: ");
                        // Listar as peças atuais
                        System.out.println("Peças disponíveis:");

                        //PASSO 3: Percorre o array
                        for (int j = 0; j < totalpecas; j++) {
                            if (pecas[j] != null) { // evita acessar posições nullas
                                System.out.println("Código: " + pecas[j].codpeca + " | Nome: " + pecas[j].nomepeca);
                            }
                        }

                        // Verificar se o código existe
                        boolean codigoValido = false;
                        do {
                            System.out.print("\nDigite o código da peça: ");
                            codpeca = sc.nextInt();
                            sc.nextLine();
                            
                            for (int j = 0; j < totalpecas; j++) {
                                if (pecas[j].codpeca == codpeca) {
                                    codigoValido = true;
                                    break;
                                }
                            }
                            
                            if (!codigoValido) {
                                System.out.println("Código de peça inválido! Tente novamente.");
                            }
                        } while (!codigoValido);
                        Servico servico = new Servico(codservico, descServico, valor, codpeca);//PASSO 2: Registra a serviço cadastrada no array. PASSO 3 na listagem  dos serviços
                        servicos[totalservicos] = servico; 

                        totalservicos++;
                        codservico++;

                        System.out.println("-------------------\n"
                                + "Serviço cadastrado com sucesso! ");

                        servico.visualizaServico();
                        System.out.println("\n\nDeseja cadastrar mais serviços? \n1-Sim ou 2-Não");
                        resp = sc.nextInt();
                        sc.nextLine();

                    } while (resp != 2);

                    break;

                case 3:
                    do {
                        System.out.print("--------Listagem de Serviços-------\n");
                        if (totalservicos == 0) {
                            System.out.println("Nenhum serviço cadastrado ainda! Cadastre um serviço e tente novamente...");
                            break;
                        }

                        //PASSO 3: Percorre o array
                        for (int j = 0; j < totalservicos; j++) {
                            if (servicos[j] != null) {

                                Peca p = Peca.getPeca(servicos[j].codpeca, pecas, totalpecas);

                                if (p != null) {
                                    System.out.println(
                                        "Código: " + servicos[j].codservico +
                                        " | Descrição: " + servicos[j].descricao +
                                        " | Valor: " + servicos[j].valor +
                                        " | Peça: [" + p.codpeca + " - " + p.nomepeca + "]"
                                    );
                                } else {
                                    System.out.println(
                                        "Código: " + servicos[j].codservico +
                                        " | Descrição: " + servicos[j].descricao +
                                        " | Valor: " + servicos[j].valor +
                                        " | Peça: (não encontrada)"
                                    );
                                }
                            }
                        }

                    } while (resp != 2);

                    break;
            }

        } while (menu != 4);
        sc.close();
    }
}
