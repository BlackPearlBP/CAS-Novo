import java.text.DecimalFormat;
import java.util.ArrayList;

public class ListaDesconto {
    DecimalFormat df = new DecimalFormat("##,###.00");

    ArrayList<Desconto> descontosCadastrados = new ArrayList<Desconto>();

    public void adicionarDesconto(Desconto d) {
        this.descontosCadastrados.add(d);

    }

    public void setarDescontoFgts() {

        Desconto d = new Desconto();
        d.nome = "\n[FGTS]--------------------------------------------------------------------------------------------";
        d.descricao = "Saiba mais: O desconto do FGTS, ou Fundo de Garantia do Tempo de Serviço, é uma contribuição obrigatória do empregador que visa proteger o trabalhador, oferecendo recursos para situações específicas, como demissão sem justa causa e compra da casa própria.\nFonte: www.fgts.gov.br/Pages/sobre-fgts/visao-geral.aspx";
        d.valor = 0.08;
        d.ehDescontado = true;
        adicionarDesconto(d);
    }

    public void setarDescontoIrpf(double salarioBruto) {
        Desconto d = new Desconto();
        d.nome = "\n[IRRF]--------------------------------------------------------------------------------------------";
        d.descricao = "Saiba mais: O desconto do IRRF, ou Imposto de Renda Retido na Fonte, é uma dedução obrigatória sobre rendimentos, sendo recolhido diretamente na fonte pagadora, contribuindo para financiar as despesas governamentais.\nFonte: www.gov.br/receitafederal/pt-br/assuntos/orientacao-tributaria/tributos/IRRF";
        if(salarioBruto < 1903.99){
            d.valor = 0;
            d.ehDescontado = false;
        }
        else{
            if(salarioBruto > 1903.99 && salarioBruto <= 2826.65){
                d.valor = 0.075;
                d.ehDescontado = true;
            }
            else{
                if(salarioBruto > 2826.66 && salarioBruto <= 3751.05){
                    d.valor = 0.15;
                    d.ehDescontado = true;
                }
                else{
                    if(salarioBruto > 3751.05 && salarioBruto <= 4664.68){
                        d.valor = 0.225;
                        d.ehDescontado = true;
                    }
                    else{
                        if(salarioBruto > 4664.68){
                            d.valor = 0.275;
                            d.ehDescontado = true;
                            }
                        }
                    }
                }
            }
        
        adicionarDesconto(d);
    }

    public void setarDescontoInss(double salarioBruto) {
        Desconto d = new Desconto();
        d.nome = "\n[INSS]--------------------------------------------------------------------------------------------";
        d.descricao = "Saiba mais: O desconto do INSS, ou Instituto Nacional do Seguro Social, é uma contribuição obrigatória descontada dos salários para financiar a previdência social, garantindo benefícios como aposentadoria, pensão e auxílio-doença.\nFonte: www.gov.br/inss/pt-br/saiba-mais";
        
        if(salarioBruto <= 1320){
            d.valor = 0.075;
            d.ehDescontado = true;
        }
        else{
            if(salarioBruto > 1320.01 && salarioBruto <= 2571.29){
                d.valor = 0.09;
                d.ehDescontado = true;
            }
            else{
                if(salarioBruto > 2571.3 && salarioBruto <= 3856.94){
                    d.valor = 0.12;
                    d.ehDescontado = true;
                }
                else{
                    if(salarioBruto > 3856.95){
                        d.valor = 0.14;
                        d.ehDescontado = true;
                        }
                    }
                }
            }
        
        adicionarDesconto(d);
    }

    public void setarDescontoVt() {
        Desconto d = new Desconto();
        d.nome = "\n[VT]----------------------------------------------------------------------------------------------";
        d.descricao = "Saiba mais: O vale-transporte é um benefício opcional que visa subsidiar parcialmente os custos de deslocamento do trabalhador entre sua residência e local de trabalho, promovendo a acessibilidade e mobilidade urbana.\nFonte: www.pontotel.com.br/vale-alimentacao/";
        d.valor = 0.08;
        d.ehDescontado = EntradaSaida.recebeValeTransporte();
        adicionarDesconto(d);
    }

    public double somarDesconto(double salarioBruto) {
        double somaDesconto = 0;
        double resultado = 0;
        for (Desconto d : this.descontosCadastrados) {
            resultado = d.valor * salarioBruto;
            if (!d.nome.equals("VT")) {
                somaDesconto += d.valor;
                System.out.println("        " + d.nome);
                System.out.println("        " + d.descricao);
                System.out.println("        R$" + df.format(resultado));
            }
            if (d.nome.equals("VT") && d.ehDescontado) {
                somaDesconto += d.valor;
                System.out.println("        " + d.nome);
                System.out.println("        " + d.descricao);
                System.out.println("        R$" + df.format(resultado));
            }
        }

        System.out.println(("\nSoma dos descontos: R$" + (salarioBruto * somaDesconto)));
        return salarioBruto - (salarioBruto * somaDesconto);
    }

    public void alterarValorDesconto(String nomeDescontoString) {
        System.out.println("entrou");
        String msg="";
        for (Desconto d : this.descontosCadastrados) {
            if (d.nome.equals(nomeDescontoString)) {
                d.valor = EntradaSaida.solicitarValorDesconto();
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
        for (Desconto d : this.descontosCadastrados) {
             System.out.println("entrou");
                mostrarTodosDescontos+="        Nome: " + d.nome+"\n"+"        Descrição: " + d.descricao+"\n        Valor: " +d.valor;
                mostrarTodosDescontos+= "toma";
        }
        return mostrarTodosDescontos;
    }
}
