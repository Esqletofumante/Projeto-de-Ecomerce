package org.example;

public class Produto extends ItemVende {
    
    private double valor;
    private int quantidade;
    
    


    public Produto(String nome, double valor, int quantidade){
        super(nome);
        this.valor = valor;
        this.quantidade = quantidade;
        
        
        
    }
    
    public int getQuant() { return quantidade; }
    public double getValor() {return valor; }
    public void setQuant(int val) {this.quantidade = val;}
    @Override
    public double getPreco() { return valor * quantidade;}  


    public static  void adicionaQuantidade(int ID, int value){
        ItemVende p = buscador(ID);
        if (p instanceof Produto) {
            Produto s = (Produto) p;
            s.setQuant(s.getQuant() + value);
        }
        
    }
    public static  void reduzQuantidade(int ID, int value){
        ItemVende p = buscador(ID);
        if (p instanceof Produto) {
            Produto s = (Produto) p;
            s.setQuant(s.getQuant() - value);
        }
        
    }

    @Override
    public String toString(){
        return "Produto:{ ID:" + getID() +
        ", Nome: " + getNome() + ",  Quantidade: " + getQuant() + 
        ", Preco: " + getValor() + "]";
    }
  
    
}
