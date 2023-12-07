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
                                System.out.println("Bem-vindo, "+u.usuario+"!");
                            do{
                                opcaoMenuUsuario=EntradaSaida.menuTelaUsuario();
                                switch(opcaoMenuUsuario){
                                    case 1:
                                    u.salarioBruto=EntradaSaida.solicitarSalarioBruto();                                    
                                    ld.setarDescontos();
                                    ld.mostra();
                                    System.out.println(u.senha);
                                    System.out.println(u.salarioBruto);
                                    salarioLiquido=u.somarDesconto(u.salarioBruto);
                                    EntradaSaida.mostrarSalarioLiquido(salarioLiquido);
                                    
                                //setar descontos
                                //devolver salario liquido
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
                        do{
                            opcaoMenuAdmin=EntradaSaida.menuAdmin();
                            switch(opcaoMenuAdmin){
                                case 1:
                                //Excluir usuarios
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
/*
 * ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣇⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⢯⢣⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣯⢿⡀⠟⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢯⣻⣇⠈⢻⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣜⣻⢿⠀⢛⡼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢮⡹⣿⡀⠢⢁⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢎⡷⣻⣇⠘⠨⠗⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣴⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⡯⣗⣻⣽⠀⠡⢼⢄⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡦⣻⠯⠟⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢿⠼⣭⣿⡔⢁⠂⡽⠀⠀⠀⠀⠀⠀⣰⠞⣯⣵⠾⠃⢌⡞⠀⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢀⣀⠀⡀⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡻⣴⢻⣇⠢⢉⡟⠀⠀⠀⢠⡖⠫⣧⣞⠗⠡⠐⡈⠇⠀⠀⠀⠀⠀⠀⠄⡼⢧⡀⠀⠀⠀⠀⠀⠀
⠀⠘⠿⣯⣭⣋⠋⠣⠳⠶⢖⣤⣠⡀⡀⠀⢻⣲⡟⣯⠐⠂⣭⠀⢠⡼⢃⡴⣿⠟⠠⠈⡄⡏⠁⠀⠀⠀⠀⠀⠀⡀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠈⠺⣭⢳⣵⡦⢔⡂⠄⡉⠛⠧⠶⣤⡀⡈⢣⢟⣻⡌⡐⢱⣴⠞⣰⣯⢿⠁⡄⢃⡶⠁⠀⠀⠀⠀⠀⠀⠀⠀⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠛⢦⣏⢟⡾⣍⣖⡭⣘⡤⢈⡙⠳⡜⣯⠞⣧⠴⠸⢃⣾⠟⡁⠄⣂⠼⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠶⢭⣶⡹⣓⢾⣣⣤⢣⣤⣋⢿⣹⢀⢢⣘⢁⠂⠼⢧⣔⣢⣴⣶⣦⣖⣶⡤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⣉⡶⠽⠖⢯⢖⡹⢮⣛⡎⡆⢡⣞⠾⡛⡃⢋⢉⡉⠡⢠⡠⠖⠈⠀⠀⠀⠀⠀⠀⠀⠀⣠⡞⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠶⢊⣆⣠⣐⣤⡾⣴⢲⡹⢧⣻⢧⣬⣍⡠⢲⢥⠥⠝⠊⠂⡇⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢾⣿⡇⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠤⠾⠻⠷⠻⠿⠟⢫⠹⠪⠵⢫⢫⣶⣿⠏⢷⡉⠻⡽⣶⣻⣇⣄⠀⠀⢘⢷⣄⠀⠀⠀⠀⠀⠀⠀⣴⢋⣼⣿⡃⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢼⣫⡾⠟⠁⠀⠘⣥⠀⠀⠉⠚⠈⠃⠛⠂⠈⣎⢳⣷⠄⠀⠀⠀⢀⡾⢁⣼⣿⡏⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠛⠉⠀⠀⠀⠀⠀⢳⢂⠀⠀⠀⠀⠀⠀⠀⠀⢘⡤⠻⣿⢥⠀⠀⡾⢀⣾⢿⡻⠁⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⠀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢫⢆⠀⠀⠀⠀⠀⠀⠀⠀⠰⡅⠹⣯⣇⢰⠃⣼⡿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠐⠒⡟⡕⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢲⢳⠀⠀⠀⠀⠙⡗⢳⣶⡌⢢⠛⣥⡏⣼⢻⠋⠀⣴⣴⣶⣶⣶⢰⣤⡄⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠁⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠐⠪⠊⡽⠻⣦⢒⣴⢿⣛⣛⡼⢯⣥⣖⣒⣮⡾⠿⠟⠋
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣯⡶⢯⣿⣽⣈⣓⠻⡓⠊⠂⠉⠉⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀420⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠃⠸⣷⡟⠻⢳⣮⣵⣄⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡜⠁⠀⠀⠈⠹⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ass: Gaba$$tarbucK$⠀⠀⠀⠀
 */
