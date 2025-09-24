package org.example;

import java.util.ArrayList;

public abstract  class ItemVende {
    private final int ID;
    private String nome;
    private static int totalProdutos = 0;
    private static ArrayList < ItemVende > catalogo = new ArrayList < >() ;


    public ItemVende(String nome){
        this.ID = getTotalProdutos();
        this.nome = nome;
        ItemVende.totalProdutos++;
    }
    
    public int getID() { return ID; }
    public String getNome() { return nome; }
    public static int getTotalProdutos() {return totalProdutos; }
    public static ArrayList<ItemVende> getCatalogo() {return catalogo; }    

    public abstract double getPreco();

    
    public static void adcionarItem(ItemVende p){
        catalogo.add(p);
    }

    public static ItemVende buscador(int ID){
        for (ItemVende p : getCatalogo()){
            if (p.getID() == ID) return p;
        }
        return null;
    }


    public static void remover(int ID) {
    ItemVende p = buscador(ID);
    if (p != null) {
        catalogo.remove(p);
        totalProdutos--;
         
    }
}
    public static void mostrarUm(int ID){
        ItemVende p = buscador(ID);
        if (p != null) {
            System.out.println(p.toString());
        }

    }

    public static void mostrar(){
        for(ItemVende p : getCatalogo()){
            System.out.println("---".repeat(30));
            System.out.println(p.toString());
            System.out.println("---".repeat(30));
        }
    }

    
}
