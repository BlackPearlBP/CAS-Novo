import java.util.Scanner;

public class EntradaSaida{
    public static Scanner entradaUser = new Scanner(System.in);
    

    public static int menuInicial(){
        //String[] opcoes = {"1 - Login Usuário","2 - Cadastrar Usuário","3 - Login Admin","4 - Sair"}; 
        System.out.println("\n======================================================================================\n" +  
                    "|        Escolha uma opção:                                                          |" + 
                    "\n======================================================================================");
        System.out.println("\n======================================================================================\n" +
            "|        [1] - Login Usuário                                                         |\n" + 
            "|        [2] - Cadastrar Usuário                                                     |\n" + 
            "|        [3] - Login Admin                                                           |\n" + 
            "|        [4] - Sair                                                                  |\n" + 
            "======================================================================================");
        return entradaUser.nextInt();
    }
    public static String cadastrarDadosUsuario(String msg){
        System.out.println("\n======================================================================================\n" + "        Digite "+msg);
        Scanner entradaDois = new Scanner(System.in);
        String entrada = entradaDois.nextLine();
        //System.out.println("\n======================================================================================");
        return entrada; 
    }
    public static String solicitarDados(String msg){
        System.out.println("\n======================================================================================\n" + "        Digite "+msg);
        Scanner entradaTres = new Scanner(System.in);
        String entrada = entradaTres.nextLine();
        //System.out.println("\n======================================================================================\n");
        return entrada;
    }
    public static double solicitarSalarioBruto() {
        System.out.println("\n======================================================================================\n"+
        "        Informe o salario *BRUTO*: ");
        Scanner entradaQuatro = new Scanner(System.in);
        double entrada = entradaQuatro.nextDouble();
        //System.out.println("\n======================================================================================\n");
        return entrada;
    }
    public static int menuAdmin() {
        System.out.println("\n======================================================================================\n" +  
                    "|        Escolha uma opção:                                                          |" + 
                    "\n======================================================================================");
        System.out.println("\n======================================================================================\n" + 
            "|        [1] - Alterar descontos                                                     |\n" + 
            "|        [2] - Alterar login administrador                                           |\n" + 
            "|        [3] - Excluir usuarios                                                      |\n" + 
            "|        [4] - Voltar                                                                |" + 
            "\n======================================================================================\n");
        Scanner entradaAdmin = new Scanner(System.in);
        int entrada = entradaAdmin.nextInt();
        return entrada;
    }
     public static String solicitarInformacoesDesconto(String msg){
        System.out.println("\n======================================================================================\n"+
            "        Digite "+msg+
            "\n======================================================================================\n");
        Scanner entradaSeis = new Scanner(System.in);
        String entrada = entradaSeis.nextLine();
        return entrada;
    }        
    public static int verificarSaida() {
        System.out.println("\n======================================================================================\n" +
            "        Deseja sair? \n     [1] - Sim        [0] - Não" + "\n======================================================================================\n");
        Scanner entradaSete = new Scanner(System.in);
        int sair = entradaSete.nextInt();
        return sair;
    }
	public static void mostrarAlerta(String msg) {
        System.out.println(msg);
	}
    public static int menuTelaUsuario() {
        System.out.println("\n======================================================================================\n"+
            "        Escolha uma opção:\n        [1] - Calcular Salario\n        [2] - Voltar"+
            "\n======================================================================================\n");
        Scanner entradaOito = new Scanner(System.in);
        int entrada = entradaOito.nextInt();
        return entrada;
    }
    public static boolean recebeValeTransporte(){
        System.out.println("\n======================================================================================\n"+
            "        Recebe Vale-Transporte?\n        [1] - Sim \n        [2] - Não"+
            "\n======================================================================================\n");
        Scanner entradaNove = new Scanner(System.in);
        int entrada = entradaNove.nextInt();
        do{
            if(entrada==1){
                return true;
            }else{        
                return false; 
            }
        }while(entrada!=2 && entrada!=1);
}
    public static void mostrarSalarioLiquido(double salarioLiquido) {
        System.out.println("        O salário líquido a receber é: R$"+salarioLiquido); 
    }
    public static double solicitarValorDesconto() {
        System.out.println("\n======================================================================================\n"+
            "        Digite o novo valor do desconto: (Utilize virgula ',')" + 
            "\n======================================================================================\n");
        Scanner entradaDez = new Scanner(System.in);
        double entrada = entradaDez.nextDouble();
        return entrada;
    }
     public static boolean verificarExclusao() {
        System.out.println("\n======================================================================================\n"+
            "        Continuar excluindo? \n        [1] - Sim        [2] - Não"+"\n======================================================================================\n");
        Scanner entradaOnze = new Scanner(System.in);
        int sair = entradaOnze.nextInt();
        if(sair ==1){
            return true;
        }else{
            return false;
        }
    }
}