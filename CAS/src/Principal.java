import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ListaUsuarios l=new ListaUsuarios();
        boolean jaAlteradoAdmin = false;
        boolean existente=false;
        int opcaoTelaLogin = 0;
        int opcaoAdmin=0;
        String usuario="";
        String senha="";
        double salarioBruto=0;
        do{
            opcaoTelaLogin = EntradaSaida.menuInicial();

            switch (opcaoTelaLogin) {
                case 1:
                    // entrar como usuario->tela inicial 
                    usuario=EntradaSaida.solicitarDados("o usuario");
                    senha=EntradaSaida.solicitarDados("a senha");
                    existente=l.verificarUsuario(usuario,senha,existente);
                    System.out.println(existente);
                    if(existente==true){
                        salarioBruto=EntradaSaida.solicitarSalarioBruto();
                    }
                break;
            
                case 2:
                    Usuarios u = new Usuarios();
                    u.usuario=EntradaSaida.cadastrarDadosUsuario("o usuario");
                    u.senha=EntradaSaida.cadastrarDadosUsuario("a senha");
                    l.adicionarUsuario(u);
                    
                    //cadastrar novo usuario2
                break;

                case 3:
                    usuario=EntradaSaida.solicitarDados("o usuario");
                    senha=EntradaSaida.solicitarDados("a senha");
                    existente=Admin.verificarAdmin(usuario,senha,existente, jaAlteradoAdmin);
                    System.out.println(existente);
                    if(existente==true){
                        do{
                            opcaoAdmin=EntradaSaida.menuAdmin();
                            switch(opcaoAdmin){
                                case 1:
                                //alterar descontos
                                    break;
                                case 2:
                                    String novoUsuario = EntradaSaida.solicitarDados("o novo usuario");
                                    String novaSenha = EntradaSaida.solicitarDados("a nova senha");
                                    usuario=novoUsuario;
                                    senha=novaSenha;
                                    jaAlteradoAdmin=true;
                                    System.out.println("Usuario e Senha alterado");

                        }
                        }while(opcaoAdmin!=3);
                    }
                        break;
            }
        }while(opcaoTelaLogin!=4);
    }
}
