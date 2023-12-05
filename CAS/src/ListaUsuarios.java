import java.util.ArrayList;

public class ListaUsuarios {
    public ArrayList<Usuarios> listaDeUsuarios = new ArrayList<Usuarios>();
    

    public void adicionarUsuario(Usuarios u) {
        this.listaDeUsuarios.add(u);
    }
    public boolean verificarUsuario(String nomeDeUsuarioInserido, String senhaInserida,boolean usuarioExistente) {
        for (Usuarios u : this.listaDeUsuarios){
            if(u.usuario.equals(nomeDeUsuarioInserido) && u.senha.equals(senhaInserida)){
                System.out.println("Usuario valido");
                usuarioExistente=true;
            }
            else{
                System.out.println("Usuário inexistente");
                usuarioExistente=false;
            };
        }
        return usuarioExistente;
    }
}