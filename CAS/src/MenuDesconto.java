
public class MenuDesconto {
    
    public void descontosCadastrados(){
        
        Usuarios listaDescontos = new Usuarios();
        
        Desconto d = new Desconto();
        d.nomeDesconto="FGTS";
        d.descricaoDesconto="Fundo de garantia de tempo de serviço";
        d.valorDesconto=0.08;
        d.descontado=false;
        listaDescontos.adicionarDesconto(d);
        Desconto d1 = new Desconto();
        d.nomeDesconto="IRRF";
        d.descricaoDesconto="Imposto de Renda Retido na Fonte";
        d.valorDesconto=0.08;
        listaDescontos.adicionarDesconto(d1);
        Desconto d2 = new Desconto();
        d.nomeDesconto="INSS";
        d.descricaoDesconto="Instituto Nacional do Seguro Nacional";
        d.valorDesconto=0.09;
        listaDescontos.adicionarDesconto(d2);
        Desconto d3 = new Desconto();
        d.nomeDesconto="VT";
        d.descricaoDesconto="Vale Transporte";
        d.valorDesconto=0.08;
        listaDescontos.adicionarDesconto(d3);
        Desconto d4 = new Desconto();
        d.nomeDesconto="asdad";
        d.descricaoDesconto="amo fude";
        d.valorDesconto=0.08;
        listaDescontos.adicionarDesconto(d4);
        Desconto d5 = new Desconto();
        d.nomeDesconto="sdfsdf";
        d.descricaoDesconto="sarsicha";
        d.valorDesconto=0.08;
        listaDescontos.adicionarDesconto(d5);
        Desconto d6 = new Desconto();
        d.nomeDesconto="qweqe";
        d.descricaoDesconto="vino";
        d.valorDesconto=0.08;
        listaDescontos.adicionarDesconto(d6);

    }
}
