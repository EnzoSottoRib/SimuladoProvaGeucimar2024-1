import java.util.ArrayList;

public class Controle {

    private GerenciadorDeArquivosEndereco leitorE;
    private GerenciadorDeArquivosPessoa leitorP;
    private GerenciadoDeArquivosPessoasComEndereco gravador;

    ArrayList<Pessoa> listaPessoaE = new ArrayList<>(); //Cria uma ArrayList<Pessoa> chamada listaPessoaE 
    ArrayList<Pessoa> listaPessoaP = new ArrayList<>(); //Cria uma ArrayList<Pessoa> chamada ListaPessoaP
    ArrayList<Pessoa> listaPessoa = new ArrayList<>(); //Cria uma ArrayList<Pessoa> chamada Pessoa

    public Controle(){
        this.leitorE = new GerenciadorDeArquivosEndereco();
        this.leitorP = new GerenciadorDeArquivosPessoa();
        this.gravador = new GerenciadoDeArquivosPessoasComEndereco();
        this.listaPessoaE = leitorE.getEndereco();
        this.listaPessoaP = leitorP.getPessoa();
    }

    public void adicionarPessoa(Pessoa pessoa){
        listaPessoa.add(pessoa);
    }

    public void deletarPessoa(int index){
        listaPessoa.remove(index);
    }

    public String listarPessoas() {
        StringBuilder sb = new StringBuilder();
        if (listaPessoa == null) {
            return "Lista vazia.";
        } else {
            for (Pessoa pessoa : listaPessoa) {
                sb.append(pessoa.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    public void fundirListas(){
        for (Pessoa pessoaE : listaPessoaE){
            for(Pessoa pessoaP : listaPessoaP){
                if (pessoaE.getCodigo() == pessoaP.getCodigo()){
                    Pessoa pessoa = new Pessoa(pessoaE.getCodigo(), pessoaP.getNome(), pessoaE.getRua(), pessoaE.getCidade());
                    listaPessoa.add(pessoa);
                    break;
                }
            }
        }
    }

    public boolean gravar(){
        return gravador.gravar(listaPessoa);
    }

}
