import java.util.ArrayList;

public class Usuarios {
    public String senha;
    public String usuario;
    public double salarioBruto;
    
    ArrayList<Desconto> listaDeDescontos = new ArrayList<Desconto>();
    public void adicionarDesconto(Desconto d) {
        this.listaDeDescontos.add(d);
    }
    
    public String selecionarDescontos(){
        String conclusao="nao deu";
        String texto = "";
        for(Desconto d : this.listaDeDescontos){
            texto="\nDesconto: "+d.nomeDesconto+"\nDescrição: "+d.descricaoDesconto+"\n";
            d.descontado=EntradaSaida.recebeDesconto();
            conclusao="deu";
        }
        return conclusao;
    }
}
