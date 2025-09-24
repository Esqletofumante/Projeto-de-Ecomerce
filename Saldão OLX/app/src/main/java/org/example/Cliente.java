package org.example;
import java.util.ArrayList;

public abstract class Cliente {
    private final int ID;
    private final String nome;
    private final String email; 
    private final Carrinho car;
    private static int totalCli = 0;
    private static ArrayList < Cliente > usuarios = new ArrayList < >() ;
    
    public Cliente(String nome, String email){
        this.ID = getTotalCliente();
        this.nome = nome;
        this.email = email;
        this.car = new Carrinho(this);

        Cliente.totalCli++;
    }
    public int getID() { return ID; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public static int getTotalCliente(){ return totalCli; }
    public static ArrayList<Cliente> getUsuarios() {return usuarios; } 

    public static void adcionarCliente(Cliente c){
        usuarios.add(c);
    }
    

    public static Cliente buscadorCliente(String email){
        for (Cliente p : usuarios){
            if (p.getEmail().equals(email)) return p;
        }
        
        return null;
    }
    public static void mostrarCliente(){
        for(Cliente p : usuarios){
            System.out.println(p.toString());
        }
    }

    public static void mostrarUm(String email){
        Cliente p = buscadorCliente(email);
        if (p != null) {
            System.out.println(p.toString());
        }
    }
    
    public static void remover(String email) {
    Cliente p = buscadorCliente(email);
    if (p != null) {
        usuarios.remove(p);
        totalCli--;
         
    }
}
}
