public class Admin {
    public String usuario;
    public String senha;
    

    public static boolean verificarAdmin(String usuarioAdmin, String senhaAdmin, boolean adminExistente,boolean jaAlteradoAdmin) {
        Admin a=new Admin();
        verificarAlteracaoAdmin(jaAlteradoAdmin);
        if(a.usuario.equals(usuarioAdmin) && a.senha.equals(senhaAdmin)){
                System.out.println("Entrou como administrador");
                adminExistente=true;
            }
            else{
                System.out.println("Não foi possivel entrar como administrador");
                adminExistente=false;
            };
        return adminExistente;
    }

    public static void verificarAlteracaoAdmin(boolean jaAlteradoAdmin) {
        Admin a=new Admin();
        if(jaAlteradoAdmin==false){
            a.usuario="admin";
            a.senha="admin";
        } 
    }
}
