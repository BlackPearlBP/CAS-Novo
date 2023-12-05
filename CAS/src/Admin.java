import java.util.Scanner;

public class Admin {
    public String usuario;
    public String senha;
    
    public boolean verificarAdmin(String usuarioAdmin, String senhaAdmin) {
        if((usuario.equals(usuarioAdmin)) && (senha.equals(senhaAdmin))){
                System.out.println("Entrou como administrador");
                return true;
        }else{
                System.out.println("Não foi possivel entrar como administrador");
                return false;
        }
    }       
        public static int menuAdmin() {
        System.out.println("Escolha uma opção:\n1- Alterar descontos\n2- Alterar login administrador\n3- Voltar");
        Scanner entradaAdmin = new Scanner(System.in);
        int entrada = entradaAdmin.nextInt();
        return entrada;
        
    }
}
