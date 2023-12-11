public class Principal {
    public static void main(String[] args) {
        ListaUsuarios l=new ListaUsuarios();
        ListaDesconto ld=new ListaDesconto();
        boolean usuarioExistente=false;
        boolean loginAlterado = false;
        int opcaoMenuAdmin = 0;
        int opcaoMenuUsuario = 0;
        int opcaoTelaLoginUsuario = 0;
        String usuario="";
        String senha="";
        double salarioLiquido=0;
        Admin a=new Admin();
        
        
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
                    usuarioExistente=l.verificarUsuario(usuario,senha,usuarioExistente);
                    if(usuarioExistente){
                        for(Usuario u : l.listaDeUsuarios){
                            if(u.usuario.equals(usuario)){
                                System.out.println("        Bem-vindo, "+u.usuario+"!");
                            do{
                                opcaoMenuUsuario=EntradaSaida.menuTelaUsuario();
                                switch(opcaoMenuUsuario){
                                    case 1:
                                    u.salarioBruto=EntradaSaida.solicitarSalarioBruto();                                    
                                    ld.setarDescontoInss();
                                    ld.setarDescontoIrpf();
                                    ld.setarDescontoFgts();
                                    ld.setarDescontoVt();
                                    salarioLiquido=ld.somarDesconto(u.salarioBruto);
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
                    l.adicionarUsuario(u);
                break;
                case 3:
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
                                EntradaSaida.mostrarAlerta(ld.mostrarDescontos());
                                nomeDescontoString=EntradaSaida.solicitarDados("o nome do desconto a ser alterado");
                                ld.alterarValorDesconto(nomeDescontoString);
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
                                break;
                        }
                        }while(opcaoMenuAdmin!=4);
                    }
                        break;
            }
        }while(opcaoTelaLoginUsuario!=4);
    }
}
