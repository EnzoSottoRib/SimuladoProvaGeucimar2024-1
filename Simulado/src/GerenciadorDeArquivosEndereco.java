import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeArquivosEndereco {
    String header = "Rua;Cidade;Codigo";
    String nomeDoArquivo;

    public GerenciadorDeArquivosEndereco(){ //Deu boleia
            /*Path caminhoArquivo = Paths.get("enderecos.csv"); //Deu boleia
            nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString(); //Deu boleia */
            nomeDoArquivo = "D:\\Faculdade\\Geucimar\\GeucimarJava\\SimuladoProvaGeucimar2024-1\\Simulado\\src\\enderecos.csv";
    }

    public ArrayList<Pessoa> getEndereco(){ //Boleia
    ArrayList<Pessoa> listaEnderecos = new ArrayList<>();

    try {
        File arquivo = new File(nomeDoArquivo); //Boleia
        Scanner leitor = new Scanner(arquivo);

        header = leitor.nextLine();

        while(leitor.hasNextLine()){
            String linhaAtual = leitor.nextLine(); //Semi boleia
            String[] dados = linhaAtual.split(";");

            String rua = dados[0];
            String cidade = dados[1];
            int codigo = Integer.parseInt(dados[2].trim());

            Pessoa enderecoObj = new Pessoa(codigo, rua, cidade);
            listaEnderecos.add(enderecoObj);

        } leitor.close();
        } catch(FileNotFoundException e) {
        System.out.println("Erro ao ler arquivo!");
    }
    return listaEnderecos;
    }
}
