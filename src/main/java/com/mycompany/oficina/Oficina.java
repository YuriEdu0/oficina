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
        int menu = 0, i = 0, codservico = 0, resp = 0, codpeca, totalpecas = 0, totalservicos = 0;
        double valor;

        do {

            System.out.println(
                    "======================\n"
                    + "        MENU\n"
                    + "======================\n"
                    + "1 - Cadastrar peça\n"
                    + "2 - Cadastrar serviços\n"
                    + "3 - Imprimir serviços (tela e TXT)\n"
                    + "4 - Sair\n"
                    + "======================"
            );
            menu = sc.nextInt();
            sc.nextLine(); //Limpar o \n

            switch (menu) {

                case 1:
                    do {

                        System.out.print(
                                "======================================\n"
                                + "--------Cadastro de Peças-------\n"
                                + "\"======================================\n");

                        System.out.print("Nome da peça: ");
                        peca = sc.nextLine();

                        i++;

                        System.out.println("====================\n"
                                + "Peça cadastrada com sucesso! ");
                        Peca peca1 = new Peca(peca, i);
                        pecas[totalpecas] = peca1;
                        totalpecas++;
                        peca1.nomePeca();

                        System.out.println("\n\nDeseja cadastrar mais peças ? \n1-Sim ou 2-Não");
                        resp = sc.nextInt();
                        sc.nextLine();

                    } while (resp != 2);

                    break;

                case 2:
                    do {
                        System.out.print(
                                "======================================\n"
                                + "--------Cadastro de Serviços-------\n"
                                + "======================================\n");
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

                        System.out.println("====================\n"
                                + "Serviço cadastrado com sucesso! ");

                        servico.visualizaServico();
                        System.out.println("\n\nDeseja cadastrar mais serviços? \n1-Sim ou 2-Não");
                        resp = sc.nextInt();
                        sc.nextLine();

                    } while (resp != 2);

                    break;

                case 3:
                    System.out.print(
                            "======================================\n"
                            + "--------Listagem de Serviços-------\n"
                            + "======================================\n");
                    if (totalservicos == 0) {
                        System.out.println("Nenhum serviço cadastrado ainda! Cadastre um serviço e tente novamente...");
                    } else {

                        for (int j = 0; j < totalservicos; j++) {
                            if (servicos[j] != null) {
                                Peca p = Peca.getPeca(servicos[j].codpeca, pecas, totalpecas);

                                if (p != null) {
                                    System.out.println(
                                            "Código: " + servicos[j].codservico
                                            + " | Descrição: " + servicos[j].descricao
                                            + " | Valor: " + servicos[j].valor
                                            + " | Peça: [" + p.codpeca + " - " + p.nomepeca + "]"
                                    );
                                } else {
                                    System.out.println(
                                            "Código: " + servicos[j].codservico
                                            + " | Descrição: " + servicos[j].descricao
                                            + " | Valor: " + servicos[j].valor
                                            + " | Peça: (não encontrada)"
                                    );
                                }
                            }
                        }
                        // Gera o arquivo TXT (mantendo a impressão na tela como está)

                        if (totalservicos == 0) {
                            System.out.println("Nenhum serviço cadastrado ainda! Cadastre um serviço e tente novamente...");
                            return;
                        }

                        // Monta o conteúdo que será impresso e salvo no arquivo
                        StringBuilder conteudo = new StringBuilder();
                        conteudo.append("--------LISTAGEM DE SERVIÇOS--------\n");

                        for (int j = 0; j < totalservicos; j++) {
                            if (servicos[j] != null) {
                                
                                Peca p = Peca.getPeca(servicos[j].codpeca, pecas, totalpecas);
                                
                                String linha = "Código: " + servicos[j].codservico
                                        + " | Descrição: " + servicos[j].descricao
                                        + " | Valor: R$" + servicos[j].valor
                                        + " | Peça: [" + p.codpeca + " - " + p.nomepeca + "]";
                                conteudo.append(linha).append(System.lineSeparator());
                            }
                        }

                        // Cria o arquivo de texto na pasta raiz do projeto
                        GerenciadorDeArquivo gerenciador = new GerenciadorDeArquivo("servicos.txt");
                        gerenciador.escreverConteudo(conteudo.toString());

                        System.out.println("\n--> Arquivo 'servicos.txt' gerado com sucesso na pasta raiz do projeto!\n");

                    }

                    // Pequena pausa para o usuário ver a saída (opcional)
                    System.out.println(
                            "Pressione ENTER para voltar ao menu...");
                    sc.nextLine();

                    break;

            }

        } while (menu != 4);
        sc.close();
    }
}
