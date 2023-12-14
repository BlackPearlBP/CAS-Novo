import java.text.DecimalFormat;
import java.util.ArrayList;

public class ListaDesconto {
    DecimalFormat df = new DecimalFormat("##,###.00");

    ArrayList<Desconto> descontosCadastrados = new ArrayList<Desconto>();

    public void adicionarDesconto(Desconto descontos) {
        this.descontosCadastrados.add(descontos);

    }

    public void setarDescontoFgts() {

        Desconto descontos = new Desconto();
        descontos.nome = "\n[FGTS]--------------------------------------------------------------------------------------------";
        descontos.descricao = "Saiba mais: O desconto do FGTS, ou Fundo de Garantia do Tempo de Serviço, é uma contribuição obrigatória do empregador que visa proteger o trabalhador, oferecendo recursos para situações específicas, como demissão sem justa causa e compra da casa própria.\nFonte: www.fgts.gov.br/Pages/sobre-fgts/visao-geral.aspx";
        descontos.valor = 0.08;
        descontos.ehDescontado = true;
        adicionarDesconto(descontos);
    }

    public void setarDescontoIrpf(double salarioBruto) {
        Desconto descontos = new Desconto();
        descontos.nome = "\n[IRRF]--------------------------------------------------------------------------------------------";
        descontos.descricao = "Saiba mais: O desconto do IRRF, ou Imposto de Renda Retido na Fonte, é uma dedução obrigatória sobre rendimentos, sendo recolhido diretamente na fonte pagadora, contribuindo para financiar as despesas governamentais.\nFonte: www.gov.br/receitafederal/pt-br/assuntos/orientacao-tributaria/tributos/IRRF";
        if(salarioBruto < 1903.99){
            descontos.valor = 0;
            descontos.ehDescontado = false;
        }
        else{
            if(salarioBruto > 1903.99 && salarioBruto <= 2826.65){
                descontos.valor = 0.075;
                descontos.ehDescontado = true;
            }
            else{
                if(salarioBruto > 2826.66 && salarioBruto <= 3751.05){
                    descontos.valor = 0.15;
                    descontos.ehDescontado = true;
                }
                else{
                    if(salarioBruto > 3751.05 && salarioBruto <= 4664.68){
                        descontos.valor = 0.225;
                        descontos.ehDescontado = true;
                    }
                    else{
                        if(salarioBruto > 4664.68){
                            descontos.valor = 0.275;
                            descontos.ehDescontado = true;
                            }
                        }
                    }
                }
            }
        
        adicionarDesconto(descontos);
    }

    public void setarDescontoInss(double salarioBruto) {
        Desconto descontos = new Desconto();
        descontos.nome = "\n[INSS]--------------------------------------------------------------------------------------------";
        descontos.descricao = "Saiba mais: O desconto do INSS, ou Instituto Nacional do Seguro Social, é uma contribuição obrigatória descontada dos salários para financiar a previdência social, garantindo benefícios como aposentadoria, pensão e auxílio-doença.\nFonte: www.gov.br/inss/pt-br/saiba-mais";
        
        if(salarioBruto <= 1320){
            descontos.valor = 0.075;
            descontos.ehDescontado = true;
        }
        else{
            if(salarioBruto > 1320.01 && salarioBruto <= 2571.29){
                descontos.valor = 0.09;
                descontos.ehDescontado = true;
            }
            else{
                if(salarioBruto > 2571.3 && salarioBruto <= 3856.94){
                    descontos.valor = 0.12;
                    descontos.ehDescontado = true;
                }
                else{
                    if(salarioBruto > 3856.95){
                        descontos.valor = 0.14;
                        descontos.ehDescontado = true;
                        }
                    }
                }
            }
        
        adicionarDesconto(descontos);
    }

    public void setarDescontoVt() {
        Desconto descontos = new Desconto();
        descontos.nome = "\n[VT]----------------------------------------------------------------------------------------------";
        descontos.descricao = "Saiba mais: O vale-transporte é um benefício opcional que visa subsidiar parcialmente os custos de deslocamento do trabalhador entre sua residência e local de trabalho, promovendo a acessibilidade e mobilidade urbana.\nFonte: www.pontotel.com.br/vale-alimentacao/";
        descontos.valor = 0.08;
        descontos.ehDescontado = EntradaSaida.recebeValeTransporte();
        adicionarDesconto(descontos);
    }

    public double somarDesconto(double salarioBruto) {
        double somaDesconto = 0;
        double resultado = 0;
        for (Desconto descontos : this.descontosCadastrados) {
            resultado = descontos.valor * salarioBruto;
            if (!descontos.nome.equals("VT")) {
                somaDesconto += descontos.valor;
                System.out.println("        " + descontos.nome);
                System.out.println("        " + descontos.descricao);
                System.out.println("        R$" + df.format(resultado));
            }
            if (descontos.nome.equals("VT") && descontos.ehDescontado) {
                somaDesconto += descontos.valor;
                System.out.println("        " + descontos.nome);
                System.out.println("        " + descontos.descricao);
                System.out.println("        R$" + df.format(resultado));
            }
        }

        System.out.println(("\nSoma dos descontos: R$" + (salarioBruto * somaDesconto)));
        return salarioBruto - (salarioBruto * somaDesconto);
    }

    public void alterarValorDesconto(String nomeDescontoString) {
        System.out.println("entrou");
        String msg="";
        for (Desconto descontos : this.descontosCadastrados) {
            if (descontos.nome.equals(nomeDescontoString)) {
                descontos.valor = EntradaSaida.solicitarValorDesconto();
                msg="Alterado!";
                break;
            } else {
                msg="Não foi possivel alterar";
            }
        EntradaSaida.mostrarAlerta(msg);
        }

    }

    public String mostrarDescontos() {
        String mostrarTodosDescontos="";
        for (Desconto descontos : this.descontosCadastrados) {
             System.out.println("entrou");
                mostrarTodosDescontos+="        Nome: " + descontos.nome+"\n"+"        Descrição: " + descontos.descricao+"\n        Valor: " +descontos.valor;
                mostrarTodosDescontos+= "toma";
        }
        return mostrarTodosDescontos;
    }
}
