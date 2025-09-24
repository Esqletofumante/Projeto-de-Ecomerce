package org.example;

public class ClientePF extends Cliente{
    private int CPF; 

    public int getCPF(){ return CPF; }

     public ClientePF(String nome, String email, int CPF) {
        super(nome, email);
        this.CPF = CPF;
    }
    @Override
    public String toString(){
        return "ClientePF{" +
                "ID: " + getID() +
                ", nome: " + getNome() + "\n" +
                ", email: " + getEmail() + "\n" +
                ", cnpj: " + getCPF() + "\n" +
                "}";
    }
    
}
