import java.util.Scanner;

public class Menu {
    Controle controle = new Controle();
    Scanner leitor = new Scanner(System.in);

    public void executar(){
        controle.fundirListas();
        controle.gravar();
    }
}
