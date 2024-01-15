import java.util.ArrayList;

public class ListaUsuarios {
    public ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
    

    public boolean adicionarUsuario(Usuario u,String nome) {
        boolean adicionado=false;
        for (Usuario usuario:this.listaDeUsuarios){
            if (usuario.usuario.equals(nome)){
                adicionado=false;
            }else{
                this.listaDeUsuarios.add(u);
                adicionado= true;
                break;
            }
        }
        return adicionado;
        
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
                usuarioExistente=false;
            };
        }
        return usuarioExistente;
    }
    public void removerUsuarios(Usuario u){
        this.listaDeUsuarios.remove(u);
    }
    
}