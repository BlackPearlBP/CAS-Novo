import java.util.ArrayList;

public class ListaDesconto {

    ArrayList<Desconto> descontosCadastrados = new ArrayList<Desconto>();

    public void adicionarDesconto(Desconto d) {
        this.descontosCadastrados.add(d);

    }

    public void setarDescontoFgts() {

        Desconto d = new Desconto();
        d.nome = "FGTS";
        d.descricao = "Saiba mais: O desconto do FGTS, ou Fundo de Garantia do Tempo de Serviço, é uma contribuição obrigatória do empregador que visa proteger o trabalhador, oferecendo recursos para situações específicas, como demissão sem justa causa e compra da casa própria.\nFonte: www.fgts.gov.br/Pages/sobre-fgts/visao-geral.aspx";
        d.valor = 0.08;
        d.ehDescontado = true;
        adicionarDesconto(d);
    }

    public void setarDescontoIrpf() {
        Desconto d = new Desconto();
        d.nome = "IRRF";
        d.descricao = "Saiba mais: O desconto do IRRF, ou Imposto de Renda Retido na Fonte, é uma dedução obrigatória sobre rendimentos, sendo recolhido diretamente na fonte pagadora, contribuindo para financiar as despesas governamentais.\nFonte: www.gov.br/receitafederal/pt-br/assuntos/orientacao-tributaria/tributos/IRRF";
        d.valor = 0.08;
        d.ehDescontado = true;
        adicionarDesconto(d);
    }

    public void setarDescontoInss() {
        Desconto d = new Desconto();
        d.nome = "INSS";
        d.descricao = "Saiba mais: O desconto do INSS, ou Instituto Nacional do Seguro Social, é uma contribuição obrigatória descontada dos salários para financiar a previdência social, garantindo benefícios como aposentadoria, pensão e auxílio-doença.\nFonte: www.gov.br/inss/pt-br/saiba-mais";
        d.valor = 0.09;
        d.ehDescontado = true;
        adicionarDesconto(d);
    }

    public void setarDescontoVt() {
        Desconto d = new Desconto();
        d.nome = "VT";
        d.descricao = "Saiba mais: O vale-transporte é um benefício opcional que visa subsidiar parcialmente os custos de deslocamento do trabalhador entre sua residência e local de trabalho, promovendo a acessibilidade e mobilidade urbana.\nFonte: www.pontotel.com.br/vale-alimentacao/";
        d.valor = 0.08;
        d.ehDescontado = EntradaSaida.recebeValeTransporte();
        adicionarDesconto(d);
    }

    public double somarDesconto(double salarioBruto) {
        double somaDesconto = 0;
        for (Desconto d : this.descontosCadastrados) {
            if (!d.nome.equals("VT")) {
                somaDesconto += d.valor;
                System.out.println("        " + d.nome);
                System.out.println("        " + d.descricao);
                System.out.println("        R$" + d.valor * salarioBruto);
            }
            else if (d.ehDescontado) {
                somaDesconto += d.valor;
                System.out.println("        " + d.nome);
                System.out.println("        " + d.descricao);
                System.out.println("        R$" + d.valor * salarioBruto);
            }
        }

        System.out.println(("Soma dos descontos: R$" + salarioBruto * somaDesconto));
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
        System.out.println("entrou");
        String mostrarTodosDescontos="";
        for (Desconto d : this.descontosCadastrados) {
                mostrarTodosDescontos+="        Nome: " + d.nome+"\n"+"        Descrição: " + d.descricao+"\n        Valor: " + d.valor;
                mostrarTodosDescontos+= "toma";
        }
        return mostrarTodosDescontos;
    }
}
