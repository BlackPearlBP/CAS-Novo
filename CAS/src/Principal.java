public class Principal {
    public static void main(String[] args) {
        ListaUsuarios l=new ListaUsuarios();
        boolean existente=false;
        boolean alterado = false;
        int selecaoConcluida = 0;
        int opcaoAdmin = 0;
        int opcaoTelaLogin = 0;
        String usuario="";
        String senha="";
        Admin a=new Admin();
        
        
        do{
            if(alterado ==false){
                a.usuario="admin";
                a.senha="admin";
            }
            opcaoTelaLogin = EntradaSaida.menuInicial();
            switch (opcaoTelaLogin) {
                case 1:
                    // entrar como usuario->tela inicial
                    usuario=EntradaSaida.solicitarDados("o usuario");
                    senha=EntradaSaida.solicitarDados("a senha");
                    existente=l.verificarUsuario(usuario,senha,existente);
                    
                    if(existente==true){
                        Usuarios u= new Usuarios();
                        double salarioBruto = EntradaSaida.solicitarSalarioBruto();
                        if(u.verificaLista()==true){
                            boolean selecionar= u.selecionarDesconto();
                        }
                        }else{
                            EntradaSaida.mostrarAlerta("Nenhum desconto para selecionar! ");
                        }
                break;
                case 2:
                    Usuarios u = new Usuarios();
                    u.usuario=EntradaSaida.cadastrarDadosUsuario("o usuario");
                    u.senha=EntradaSaida.cadastrarDadosUsuario("a senha");
                    l.adicionarUsuario(u);
                    //cadastrar novo usuario
                break;
                case 3:
                    usuario=EntradaSaida.solicitarDados("o usuario");
                    senha=EntradaSaida.solicitarDados("a senha");
                    existente=a.verificarAdmin(usuario,senha);
                    if(existente!=false){
                        do{
                            opcaoAdmin=EntradaSaida.menuAdmin();
                            switch(opcaoAdmin){
                                case 1:
                                //alterar descontos
                                    break;
                                case 2:
                                    String novoUsuario=EntradaSaida.solicitarDados("o novo usuario");
                                    String novaSenha=EntradaSaida.solicitarDados("a nova senha");
                                    a.usuario=novoUsuario;
                                    a.senha=novaSenha;
                                    alterado=true;                                      
                        }
                        }while(opcaoAdmin!=3);
                    }
                        break;
            }
        }while(opcaoTelaLogin!=4);
    }
}
