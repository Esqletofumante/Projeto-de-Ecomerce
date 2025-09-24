package org.example;
import java.util.ArrayList;

public class Carrinho {
    private Cliente dono;
    private ArrayList<ItemVende> itens; 

    public Carrinho(Cliente dono){
        this.dono = dono;
        this.itens = new ArrayList<>();   
    }

    public ArrayList<ItemVende> getItens(){
        return itens;
    }

    

    public void adicionar(ItemVende p, int Quantidade) {
        itens.add(p);
        if(p instanceof Produto){
            Produto s = (Produto) p;
            s.setQuant(Quantidade);
        }
    }

    public void remover(int ID){
        itens.removeIf(p -> p.getID() == ID);
    }

    public void limpar(){
        itens.clear();
    }

    public double totalPreco(){
        double total = 0;
        for ( ItemVende p : getItens()) {
            total += p.getPreco();
        }
        return total;
    }

    public void mostrarCarrinho(){
        for(ItemVende p : itens){
            System.out.println(p.toString());
        }
    }
    
}