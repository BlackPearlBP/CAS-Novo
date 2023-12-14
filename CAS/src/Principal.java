import java.util.Iterator;
import java.util.ListIterator;

public class Principal {
    public static void main(String[] args) {
        ListaUsuarios listaUsuarios=new ListaUsuarios();
        ListaDesconto listaDesconto=new ListaDesconto();
        boolean usuarioExistente=false;
        boolean loginAlterado = false;
        int opcaoMenuAdmin = 0;
        int opcaoExclusao = 0;
        int opcaoMenuUsuario = 0;
        int opcaoTelaLoginUsuario = 0;
        String usuario="";
        String senha="";
        double salarioLiquido=0;
        Admin a=new Admin();
        listaDesconto.setarDescontoInss();
        listaDesconto.setarDescontoIrpf();
        listaDesconto.setarDescontoFgts();
        listaDesconto.setarDescontoVt();
        
        
        
        do{
            if(loginAlterado==false){
                a.usuario="admin";
                a.senha="admin";
            }
            opcaoTelaLoginUsuario = EntradaSaida.menuInicial();
            switch (opcaoTelaLoginUsuario) {
                case 1:
                    // entrar como usuario->tela inicial
                    usuario=EntradaSaida.solicitarDados("o usuario");
                    senha=EntradaSaida.solicitarDados("a senha");
                    usuarioExistente=listaUsuarios.verificarUsuario(usuario,senha,usuarioExistente);
                    if(usuarioExistente){
                        for(Usuario u : listaUsuarios.listaDeUsuarios){
                            if(u.usuario.equals(usuario)){
                                System.out.println("        Bem-vindo, "+u.usuario+"!");
                            do{
                                opcaoMenuUsuario=EntradaSaida.menuTelaUsuario();
                                switch(opcaoMenuUsuario){
                                    case 1:
                                    u.salarioBruto=EntradaSaida.solicitarSalarioBruto();  
                                    listaDesconto.setarValoresDesconto(u.salarioBruto);                             
                                    salarioLiquido=listaDesconto.somarDesconto(u.salarioBruto);
                                    EntradaSaida.mostrarSalarioLiquido(salarioLiquido);
                                    break;                                   
                        }
                        }while(opcaoMenuUsuario!=2);
                    } 
                    }
                }
                break;
                case 2:
                    //cadastrar novo usuario
                    Usuario u = new Usuario();
                    u.usuario=EntradaSaida.cadastrarDadosUsuario("o usuario");
                    u.senha=EntradaSaida.cadastrarDadosUsuario("a senha");
                    listaUsuarios.adicionarUsuario(u);
                break;
                case 3:
                    //Login Admin
                    usuario=EntradaSaida.solicitarDados("o usuario");
                    senha=EntradaSaida.solicitarDados("a senha");
                    usuarioExistente=a.verificarAdmin(usuario,senha);
                    if(usuarioExistente){
                        String nomeDescontoString="";
                        do{
                            opcaoMenuAdmin=EntradaSaida.menuAdmin();
                            switch(opcaoMenuAdmin){
                                case 1:
                                //Alterar descontos
                                
                                String mostrarDescontosString = listaDesconto.mostrarDescontos();
                                EntradaSaida.mostrarAlerta(mostrarDescontosString);

                                nomeDescontoString=EntradaSaida.solicitarDados("o nome do desconto a ser alterado");

                                EntradaSaida.mostrarAlerta(listaDesconto.alterarValorDesconto(nomeDescontoString));
                                break;
                                case 2:
                                    String novoUsuario=EntradaSaida.solicitarDados("o novo usuario");
                                    String novaSenha=EntradaSaida.solicitarDados("a nova senha");
                                    a.usuario=novoUsuario;
                                    a.senha=novaSenha;
                                    loginAlterado=true;      
                                break;
                                case 3:
                                //Excluir usuarios
                                do{
                                    opcaoExclusao=EntradaSaida.verificarExclusao();
                                    switch(opcaoExclusao){
                                        case 1:
                                        for(Usuario us : listaUsuarios.listaDeUsuarios){    
                                            listaUsuarios.removerUsuarios(us);
                                        }
                                        EntradaSaida.mostrarAlerta("Usuários excluídos!");
                                        break;
                                }
                                }while(opcaoExclusao!=2);
                                break;
                            }
                        }while(opcaoMenuAdmin!=4);
                    }
                        break;
            }
        }while(opcaoTelaLoginUsuario!=4);
    }
}
