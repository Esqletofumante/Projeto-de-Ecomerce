package org.example;

public class ClientePJ extends Cliente{
    private int CNPJ; 

    public int getCNPJ(){ return CNPJ; }

     public ClientePJ(String nome, String email, int CNPJ) {
        super(nome, email);
        this.CNPJ = CNPJ;
        
    }
    @Override
    public String toString(){
        return "ClientePJ{" +
                "ID: " + getID() +
                ", nome: " + getNome() + "\n" +
                ", email: " + getEmail() + "\n" +
                ", cnpj: " + getCNPJ() + "\n" +
                "}";
    }
    
    
}
