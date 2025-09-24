package org.example;
import java.util.ArrayList;

public class Pedido {
    private int numpedido;
    private Cliente clie;
    private double total;
    private static int totalped = 0;
    private ArrayList <ItemVende> copia;
    private static ArrayList < Pedido > pedi = new ArrayList<>();
    public static Object catalogo;
    
    public static int getTotalped(){ return totalped; }
    public int getNumpedido() { return numpedido; }
    public double getTotal() { return total; }
    public Cliente getCliente() { return clie; }
    
    public Pedido( Carrinho car, Cliente clie){
        Pedido.totalped++;
        this.numpedido = getTotalped();
        this.clie = clie;
        this.total = 0;
        this.copia = new ArrayList<>();
        

        for (ItemVende p : car.getItens()) {
            ItemVende copiaItem = null;
            if (p instanceof Produto){
                Produto pro = (Produto) p;
                copiaItem = new Produto(p.getNome(), pro.getValor(), pro.getQuant());
            } else if (p instanceof Servico) { 
                Servico s = (Servico) p;
                copiaItem = new Servico(p.getNome(), s.getValor(), s.getQuant());
            }

            if (copiaItem != null){
                this.copia.add(copiaItem);
                this.total += p.getPreco();
            }
        }
        pedi.add(this);
    }

    public void resumo(){
        System.out.println("Resumo do Pedido #" + getNumpedido());
        System.out.println(clie.toString());
        for (ItemVende p : copia) {
            System.out.println(p.toString());
        }
        System.out.println("Total do Pedido: R$" + getTotal());
        System.out.println("===".repeat(30));
    }

    public static void todosPedidos(){
        System.out.println("Total de pedidos feitos: " + getTotalped());
        for (Pedido p : pedi) {
            p.resumo();
        }
    }
    
}
