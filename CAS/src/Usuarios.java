import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {
    public String senha;
    public String usuario;
    public double salarioBruto;
    
    ArrayList<Desconto> listaDeDescontos = new ArrayList<Desconto>();
    public void adicionarDesconto(Desconto d) {
        this.listaDeDescontos.add(d);
    }
    public boolean verificaLista() {
        if(this.listaDeDescontos.isEmpty()){
            return false;
        }else{
            return true;
        
        }
    }
    public boolean selecionarDesconto(){
        String lista="";
        boolean fim=false;
        int entrada=0;
        for(Desconto d : this.listaDeDescontos){
            lista+="\nDesconto: "+d.nomeDesconto+"\nDescrição: "+d.descricaoDesconto+"\nValor a ser descontado: "+d.valorDesconto;
            System.out.println("Recebe esse desconto?[1] sim [0]não");
            do{
            Scanner entradaDesconto = new Scanner(System.in);
            entrada = entradaDesconto.nextInt();
            if(entrada == 1){
                d.descontado=true;
            }else if(entrada ==0){
                d.descontado=false;
            }else{
                EntradaSaida.mostrarAlerta("Digite apenas os numeros informados");
            }
            }while(entrada!=1||entrada!=2);
        }
        return fim;
    }
}