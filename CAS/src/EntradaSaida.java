import java.util.Scanner;

public class EntradaSaida{
    public static Scanner entradaUser = new Scanner(System.in);
    

    public static int menuInicial(){
        //String[] opcoes = {"1 - Login Usuário","2 - Cadastrar Usuário","3 - Login Admin","4 - Sair"}; 
        System.out.println("1 - Login Usuário\n2 - Cadastrar Usuário\n3 - Login Admin\n4 - Sair");
        return entradaUser.nextInt();
    }
    public static String cadastrarDadosUsuario(String msg){
        System.out.println("Digite "+msg);
        Scanner entradaDois = new Scanner(System.in);
        String entrada = entradaDois.nextLine();
        return entrada;
    }
    public static String solicitarDados(String msg){
        System.out.println("Digite "+msg);
        Scanner entradaTres = new Scanner(System.in);
        String entrada = entradaTres.nextLine();
        return entrada;
    }
    public static double solicitarSalarioBruto() {
        System.out.println("Informe o salario *BRUTO*: ");
        Scanner entradaQuatro = new Scanner(System.in);
        double entrada = entradaQuatro.nextDouble();
        return entrada;
    }
    public static int menuAdmin() {
        System.out.println("Escolha uma opção:\n1- Alterar descontos\n2- Alterar login administrador\n3- Voltar");
        Scanner entradaCinco = new Scanner(System.in);
        int entrada = entradaCinco.nextInt();
        return entrada;
    }
     public static String solicitarInformacoesDesconto(String msg){
        System.out.println("Digite "+msg);
        Scanner entradaSeis = new Scanner(System.in);
        String entrada = entradaSeis.nextLine();
        return entrada;
    }
}