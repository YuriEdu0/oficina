package com.mycompany.oficina;

import java.util.Scanner;

public class Oficina {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu = 0;

        System.out.println("1- Cadastra peça\n"
                + "2- Cadastrar serviços\n"
                + "3- Imprimir serviços (tela e TXT)\n"
                + "4- Sair");
        menu = sc.nextInt();

        do {

            switch (menu) {

                case 1 ->
                    System.out.println("oi1");

                case 2 ->
                    System.out.println("oi2");

                case 3 ->
                    System.out.println("oi3");

            }

            System.out.println("1- Cadastra peça\n"
                    + "2- Cadastrar serviços\n"
                    + "3- Imprimir serviços (tela e TXT)\n"
                    + "4- Sair");
            menu = sc.nextInt();

        } while (menu != 4);

    }
}
