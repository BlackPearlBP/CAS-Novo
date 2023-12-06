public class Principal {
    public static void main(String[] args) {
        ListaUsuarios l=new ListaUsuarios();
        boolean usuarioExistente=false;
        boolean loginAlterado = false;
        int selecaoDeDescontosConcluida = 0;
        int opcaoMenuAdmin = 0;
        int opcaoTelaLoginUsuario = 0;
        String usuario="";
        String senha="";
        Admin a=new Admin();
        
        
        do{
            if(loginAlterado ==false){
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
                    if(usuarioExistente==true){
                        
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
                    if(usuarioExistente!=false){
                        do{
                            opcaoMenuAdmin=EntradaSaida.menuAdmin();
                            switch(opcaoMenuAdmin){
                                case 1:
                                //alterar descontos
                                    break;
                                case 2:
                                    String novoUsuario=EntradaSaida.solicitarDados("o novo usuario");
                                    String novaSenha=EntradaSaida.solicitarDados("a nova senha");
                                    a.usuario=novoUsuario;
                                    a.senha=novaSenha;
                                    loginAlterado=true;                                      
                        }
                        }while(opcaoMenuAdmin!=3);
                    }
                        break;
            }
        }while(opcaoTelaLoginUsuario!=4);
    }
}
