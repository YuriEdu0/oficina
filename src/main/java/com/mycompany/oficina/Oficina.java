package com.mycompany.oficina;

import java.util.Scanner;

public class Oficina {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String peca;
        int menu = 0, i = 0,resp;

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

                        peca1.nomePeca();

                        System.out.println("\n\nDeseja cadastrar mais peças ? \n1-Sim ou 2-Não");
                        resp = sc.nextInt();
                        sc.nextLine();

                    } while (resp != 2);

                    break;

                case 2:
                    System.out.println("oi2");
                    break;

                case 3:
                    System.out.println("oi3");
                    break;
            }

        } while (menu != 4);

    }
}
