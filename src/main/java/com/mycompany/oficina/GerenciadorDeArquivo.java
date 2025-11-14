package com.mycompany.oficina;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Esta classe faz o gerenciamento dos arquivos
 * @since 31/10/2025
 * @author Yuri Eduardo
 * @version 1.0
 */
public class GerenciadorDeArquivo {

    private final String nomeArquivo;

    public GerenciadorDeArquivo(String nomeArquivo) {

        this.nomeArquivo = nomeArquivo;
    }

    private File getArquivo() {
        return new File(nomeArquivo);
    }

    //--------------CRIAR/SOBRESCREVER O ARQUIVO----------------
    /**
     * Este metodo cria ou sobrescreve o conteudo em um arquivo
     * @param conteudo String 
     */
    public void escreverConteudo(String conteudo) {

        File arquivo = getArquivo();

        try {

            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso: " + arquivo.getName());
            }

            // Cria um PrintWriter para escrever no arquivo sobrescrevendo no caso de ja existir
            try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo, false))) {

                writer.print(conteudo);
                System.out.println("--> Conteudo escrito com sucesso no arquivo");

            }

        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo");

        }
    }

    //---------- LER O CONTEUDO DO ARQUIVO----------------
    
     /**
     * Este metodo le o conteudo do arquivo
     * @return String conteudoCompleto
     */
    public String lerConteudo() {

        File arquivo = getArquivo();
        StringBuilder conteudoCompleto = new StringBuilder();

        if (!arquivo.exists()) {
            return "ERRO: arquivo nao existe!";

        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {

                conteudoCompleto.append(linha).append(System.lineSeparator());

            }

        } catch (IOException e) {
            return "ERRO: Ocorreu algum erro ao ler o arquivo";

        }
        
        return conteudoCompleto.toString();
    }

    //---------- EXCLUIR O ARQUIVO----------------
     /**
     * Este metodo exclui um arquivo
     */
    public void excluir() {

        File arquivo = getArquivo();

        //Converte o file para path, com o intuito de utilizar java.nio.java
        Path pathDoArquivo = Paths.get(arquivo.getAbsolutePath());

        try {

            boolean excluido = Files.deleteIfExists(pathDoArquivo);
            if (excluido) {

                System.out.println("--> Arquivo excluido com sucesso");
            } else {

                System.out.println("--> Arquivo nao pode ser excluido");
            }

        } catch (IOException e) {
            System.out.println("Erro ao excluir o arquivo: " + e.getMessage());
        }

    }
    
     /**
     * Verifica se o arquivo existe
     * @return bollean
     */
    public boolean existe(){
        return getArquivo().exists();
    }

}
