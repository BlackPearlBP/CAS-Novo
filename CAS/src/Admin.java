import java.util.Scanner;

public class Admin {
    public String usuario;
    public String senha;
    
    public boolean verificarAdmin(String usuarioAdmin, String senhaAdmin) {
        if((usuario.equals(usuarioAdmin)) && (senha.equals(senhaAdmin))){
                System.out.println("\n======================================================================================\n" +  
                    "|        Entrou como administrador                                                   |" + 
                    "\n======================================================================================\n");
                return true;
        }else{
                System.out.println("\n======================================================================================\n" + 
                    "|        Não foi possivel entrar como administrador                                  |" + 
                    "\n======================================================================================\n");
                return false;
        }
    }       
}
