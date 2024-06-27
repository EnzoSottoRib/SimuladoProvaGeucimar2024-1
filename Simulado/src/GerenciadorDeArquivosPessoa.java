import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



public class GerenciadorDeArquivosPessoa {


    public String header = "codigo;nome"; //Define uma variável chamada header do tipo String, e coloca nela igual está no CSV
    public String nomeDoArquivo; //Já cria uma variável de tipo String que receberá o nome do arquivo a ser lido

    public GerenciadorDeArquivosPessoa(){
        /*Path caminhoArquivo = Paths.get("pessoas.csv"); //Define o caminho do arquivo como pessoas.csv
        nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString(); //O nome do arquivo agora recebe uma String, que é o caminho do arquivo definido anteriormente */
        nomeDoArquivo = "D:\\Faculdade\\Geucimar\\GeucimarJava\\SimuladoProvaGeucimar2024-1\\Simulado\\src\\pessoas.csv";

    }

    public ArrayList<Pessoa> getPessoa(){ //Cria uma função chamada getPessoa, do tipo ArrayList
        ArrayList<Pessoa> listaPessoas = new ArrayList<>(); //Agora cria uma ArrayList listaPessoas que receberá Pessoas

        try {
            File arquivo = new File (nomeDoArquivo); //Cria uma variável do tipo File chamada arquivo, que recebe os dados do arquivo anteriormente definido como nomeDoArquivo
            Scanner leitor = new Scanner(arquivo); //Cria um scanner chamado leitor, que irá ler os dados do arquivo chamado arquivo
            
            header = leitor.nextLine(); //Define como header a próxima linha ?!

            while (leitor.hasNextLine()) { //Enquanto houverem linhas à serem lidas no arquivo...
                String linhaAtual = leitor.nextLine(); //É definida uma variável chamada linhaAtual do tipo String, que recebe a linha atual lida
                String[] dados = linhaAtual.split(";"); //É criado um vetor chamado dados do tipo String, que recebe apenas o dado que está entre os pontos e vírgulas (;)

                int codigo = Integer.parseInt(dados[0]); //Criada uma variável chamada codigo de tipo inteiro que recebe apenas o dado que está no índice 0 do vetor dados ?!?! (Integer.parseInt é para transformar de String para inteiro)
                String nome = dados[1]; //Criada variável chamada nome do tipo String que recebe o dado no índice 1 do vetor dados

                Pessoa pessoaObj = new Pessoa(codigo, nome); //Cria um novo objeto chamado pessoaObj, do tipo Pessoa
                listaPessoas.add(pessoaObj); //Adiciona o novo objeto pessoaObj à uma lista de pessoas, criada anteriormente
            }
            leitor.close(); //Fecha o leitor (n sei pq, mas faço tbm)
        } catch (FileNotFoundException e) { //Caso dê erro, ele emite a mensagem abaixo
            System.out.println("Arquivo 'Pessoas' não foi encontrado"); //Mensagem emitida caso dê erro
        }

        
        return listaPessoas; //Retorna a lista de pessoas, sendo 3, 1 código e 1 nome para cada uma 
    }

}
