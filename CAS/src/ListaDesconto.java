import java.util.ArrayList;

public class ListaDesconto {

    ArrayList<Desconto> descontosCadastrados = new ArrayList<Desconto>();

    public void adicionarDesconto(Desconto d) {
        this.descontosCadastrados.add(d);

    }

    public void setarDescontoFgts() {

        Desconto d = new Desconto();
        d.nome = "FGTS";
        d.descricao = "Fundo de garantia de tempo de serviço";
        d.valor = 0.08;
        d.ehDescontado = true;
        adicionarDesconto(d);
    }

    public void setarDescontoIrpf() {
        Desconto d = new Desconto();
        d.nome = "IRRF";
        d.descricao = "Imposto de Renda Retido na Fonte";
        d.valor = 0.08;
        d.ehDescontado = true;
        adicionarDesconto(d);
    }

    public void setarDescontoInss() {
        Desconto d = new Desconto();
        d.nome = "INSS";
        d.descricao = "Instituto Nacional do Seguro Nacional";
        d.valor = 0.09;
        d.ehDescontado = true;
        adicionarDesconto(d);
    }

    public void setarDescontoVt() {
        Desconto d = new Desconto();
        d.nome = "VT";
        d.descricao = "Vale Transporte";
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
            if (d.nome.equals("VT") && d.ehDescontado) {
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
        for (Desconto d : this.descontosCadastrados) {
            if (nomeDescontoString.equals(d.nome)) {
                d.valor = EntradaSaida.solicitarValorDesconto();
                System.out.println("Alterado!");
            } else {
                System.out.println("Não foi possivel alterar");
            }
        }

    }

    public String mostrarDescontos() {
        String mostrarTodosDescontos="";
        for (Desconto d : this.descontosCadastrados) {
                mostrarTodosDescontos+="        Nome: " + d.nome+"\n"+"        Descrição: " + d.descricao+"\n        Valor: " + d.valor;
        }
        return mostrarTodosDescontos;
    }
}
