import java.util.ArrayList;

public class ListaUsuarios {
    public ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
    

    public void adicionarUsuario(Usuario usuario,String nome) {
        this.listaDeUsuarios.add(usuario);
        
    }
    public boolean verificarUsuario(String nomeDeUsuarioInserido, String senhaInserida,boolean usuarioExistente) {
        for (Usuario u : this.listaDeUsuarios){
            if(u.usuario.equals(nomeDeUsuarioInserido) && u.senha.equals(senhaInserida)){
                System.out.println("\n======================================================================================\n" + 
                    "|        Usuário válido                                                              |" + 
                    "\n======================================================================================\n");
                usuarioExistente=true;
                break;
            }
            else{
                EntradaSaida.mostrarAlerta("\n======================================================================================\n" + 
                        "|        Usuário ou senha inválida                                                   |" + 
                        "\n======================================================================================\n");
                usuarioExistente=false;
            };
        }
        return usuarioExistente;
    }

    public boolean verificaExistenciaUsuario(String nomeDeUsuarioInserido, boolean usuarioExistente) {
        for (Usuario u : this.listaDeUsuarios){
            if(u.usuario.equals(nomeDeUsuarioInserido)){
                System.out.println("\n======================================================================================\n" + 
                    "|        Usuário inválido                                                              |" + 
                    "\n======================================================================================\n");
                usuarioExistente=true;
                break;
            }
            else{
                System.out.println("\n======================================================================================\n" + 
                    "|        Usuário válido                                                              |" + 
                    "\n======================================================================================\n");
                usuarioExistente=false;
            };
        }
        return usuarioExistente;
    }
    public void removerUsuarios(Usuario u){
        this.listaDeUsuarios.remove(u);
    }
    
}