package org.example;

public class Servico extends ItemVende{
    
    private double preco;
    private int quantidadeHoras;

    public Servico(String nome, double preco, int quantidadeHoras){
        super(nome);
        this.preco = preco;
        this.quantidadeHoras = quantidadeHoras;

        ItemVende.adcionarItem(this);
    }

    public int getQuant(){ return quantidadeHoras; }
    public double getValor() { return preco; }
    public void setQuant(int horas){ this.quantidadeHoras = horas; }
    @Override
    public double getPreco(){ return preco * quantidadeHoras; }

    public static void adicionaHoras(int ID, int value){
        ItemVende p = buscador(ID);
        if (p instanceof Servico) {
            Servico s = (Servico) p;
            s.setQuant(s.getQuant() + value);
        }
    }

    public static void removerHoras(int ID, int value){
        ItemVende p = buscador(ID);
        if (p instanceof Servico) {
            Servico s = (Servico) p;
            s.setQuant(s.getQuant() - value);
        }
    }


    @Override
    public String toString(){
        return "Servico Prestado:{ ID: " + getID() + 
        ", Nome: " + getNome() + "\n" +
        ", Total de Horas: " + getQuant() + "\n" +
        ", Preco por Hora: " + getValor() + "\n" +
        ", Total: " + getPreco() + "}";
    }
    
}
