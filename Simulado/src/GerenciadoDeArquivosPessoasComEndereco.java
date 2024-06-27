import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GerenciadoDeArquivosPessoasComEndereco {

    public String header = "Codigo; Nome; Rua; Cidade"; //Cria uma variável chamada header do tipo String, que contém o header igual o pedido em PessoasComEndereco.csv
    public String nomeDoArquivo; //Cria uma variável chamada nomeDoArquivo do tipo String que receberá o o nome do arquivo a ser lido

    public GerenciadoDeArquivosPessoasComEndereco(){ 
        Path caminhoArquivo = Paths.get("PessoasComEndereco.csv"); // cria uma variável chamada caminhoArquivo do tipo Path, onde é passado o caminho para chegar até o arquivo .csv
        nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString(); // a variável nomeDoArquivo recebe o caminho do arquivo com toAbsolutePath e toString
    }

    public boolean gravar(ArrayList<Pessoa> listaPessoas){ //Cria-se um método gravar, que retorna boolean, de parâmetro listaPessoas, um ArrayList<Pessoa>
        try { //Tente
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo); //Cria-se uma variável chamada arquivoGravar, do tipo FileWriter, e passa-se o nome do arquivo que será gravado
            PrintWriter gravador = new PrintWriter(arquivoGravar); //Cria-se uma variável chamada gravador, do tipo PrintWriter, e se passa o arquivoGravar, definido anteriormente

            gravador.println(header); //Grava o header com println

            for (Pessoa pessoa : listaPessoas){ //Para cada pessoa, do tipo Pessoa, em listaPessoas...
                gravador.println(pessoa.toCSV()); //o gravador grava pessoa.toCSV()
            } gravador.close(); //Fecha o gravador
        } catch (IOException e){ //no catch, caso dê o erro IOException e...
            System.out.println("Erro!"); //printa a mensagem "Erro!"
        }
        return false; //Retorna false
    }

}
