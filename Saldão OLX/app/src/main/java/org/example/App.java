package org.example;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Saldao OLX!");

        int operacao = 0;
        try (Scanner text = new Scanner(System.in)) {
            while (operacao != 7) {
                System.out.println("\n - Menu de Operacoes: -\n");
                System.out.println("1 - Cadastrar Cliente");
                System.out.println("2 - Cadastrar Produto ou Servico");
                System.out.println("3 - Exibir Catalogo e Manipular");
                System.out.println("4 - Exibir Clientes e Remover");
                System.out.println("5 - Fazer Pedido");
                System.out.println("6 - Mostrar Pedidos");
                System.out.println("7 - Sair\n");

                System.out.print("Digite o numero da operacao: ");

                operacao = text.nextInt();
                text.nextLine();

                switch (operacao) {
                    case 1 -> {
                        System.out.println("\n - Cadastrar Cliente: -\n");
                        
                        System.out.print("Digite o seu nome: ");
                        String nome = text.nextLine();
                        String email;
                        String tipo = ""; 
                        int cpf = 0;
                        int cnpj = 0;
                        Cliente clie = null;
                        do{
                            
                            System.out.print("\nDigite o seu email: ");
                            email = text.nextLine();
                            if (Cliente.buscadorCliente(email) != null)
                            System.out.println("Email já cadastrado!");

                        }while(Cliente.buscadorCliente(email) != null);
                        do{

                            System.out.print("\nDigite se é PJ ou PF: ");
                            tipo = text.nextLine().toLowerCase();
                            if (!(tipo.equals("pf")) && !(tipo.equals("pj"))) System.out.println("Inválido! Digite se é PJ ou PF!");

                        }while(!(tipo.equals("pf")) && !(tipo.equals("pj")));

                        if (tipo.equals("pf")){
                                System.out.print("\nDigite o seu CPF: ");
                                cpf = text.nextInt();
                                text.nextLine();
                                clie = new ClientePF(nome, email, cpf);
                            } else if (tipo.equals("pj")){
                                System.out.print("\nDigite o seu CNPJ: ");
                                cnpj = text.nextInt();
                                text.nextLine();
                                clie = new ClientePJ(nome, email, cnpj);
                            }
                        Cliente.adcionarCliente(clie);
                        System.out.println("\n- Cliente cadastrado com sucesso! -\n");
                        System.out.println("Total de clientes: " + clie.getTotalCliente());
                        System.out.println(clie.toString());
                        break;

                    }

                    case 2 -> {
                        System.out.println("\n - Cadastrar Produto ou Serviço: -\n");
                        char op;
                        String tipo = "";
                        String nome;
                        double preco;
                        int quantidade;
                        ItemVende item = null;
                        do{

                            do{
                                System.out.print("Digite se você gostaria de cadastrar um Porduto ou um Servico: ");
                                tipo = text.nextLine().toLowerCase();

                                if(!(tipo.equalsIgnoreCase("produto")) && !(tipo.equalsIgnoreCase("servico"))) System.out.println("Inválido! Digite se deseja cadastrar um produto ou um Servico!");
                            }while(!(tipo.equalsIgnoreCase("produto")) && !(tipo.equalsIgnoreCase("servico")));

                            if (tipo.equals("produto")){
                                System.out.print("\nDigite o nome do Produto: ");
                                nome = text.nextLine();
                                System.out.print("\nDigite o preço do seu Produto: R$");
                                preco = text.nextDouble();
                                text.nextLine();
                                System.out.print("\nDigite a quantidade de produtos em estoque: ");
                                quantidade = text.nextInt();
                                text.nextLine();
                                item = new Produto(nome, preco, quantidade);
                            } else if (tipo.equals("servico")) {
                                System.out.print("\nDigite o nome do Servico: ");
                                nome = text.nextLine();
                                System.out.print("\nDigite a quantidade de horas para prestar o Servico: ");
                                quantidade = text.nextInt();
                                text.nextLine();
                                System.out.print("\nDigite o valor por hora: R$");
                                preco = text.nextDouble();
                                text.nextLine();
                                item = new Servico(nome, preco, quantidade);
                            }
                            ItemVende.adcionarItem(item);
                            System.out.println("\n- Item cadastrado com sucesso! -\n");
                            System.out.println(item.toString());
                            System.out.println("===".repeat(30));

                            do{

                                System.out.println("Deseja cadastrar mais algum Produto? [S/N]");
                                op = text.nextLine().toLowerCase().charAt(0);
                                if (op != 's' && op != 'n') System.out.println("Opção inválida. Digite 'Sim' ou 'Não' para continuar.");

                            }while(op != 's' && op != 'n');

                        }while(op == 's');
                        break;

                    }

                    case 3 -> {
                        if (Produto.getCatalogo().isEmpty()){
                            System.out.println("Nenhum Item cadastrado!");
                            break;
                        } System.out.println("\n - Exibir Catalogo: -\n");
                        System.out.println("Total de itens cadastrados: " + ItemVende.getTotalProdutos());
                        ItemVende.mostrar();
                        int op = 0;
                        while(op != 6){
                            System.out.println("===".repeat(30));
                            System.out.println("\n - Manipulando Catalogo - \n");
                            System.out.println("1 - Adicionar um valor de um Produto.");
                            System.out.println("2 - Reduzir um valor de um Produto.");
                            System.out.println("3 - Adcionar horas de um Servico.");
                            System.out.println("4- Reduzir horas de um Servico.");
                            System.out.println("5 - Remover um Produto.");
                            System.out.println("6 - Voltar.\n");

                            System.out.println("Digite o numero da operação: ");
                            op = text.nextInt();
                            text.nextLine();

                            switch (op){
                                case 1 -> {
                                    int ID = 0;
                                    do{
                                        System.out.println("Digite o ID do Produto: ");
                                        ID = text.nextInt();
                                        text.nextLine();
                                        if (!(ItemVende.buscador(ID) instanceof Produto)) System.out.println("ID inválido! Digite um ID válido para Produto!");

                                    }while(ItemVende.buscador(ID) == null && !(ItemVende.buscador(ID) instanceof Produto));
                                    ItemVende.mostrarUm(ID);
                                    System.out.print("\nDigite a quantidade que você gostaria de adicionar ao estoque: ");
                                    int val = text.nextInt();
                                    text.nextLine();
                                    Produto.adicionaQuantidade(ID, val);
                                    System.out.println("\nValor adicionado com sucesso!\n");
                                    System.out.println("\n- Catalogo atualizado -\n");
                                    ItemVende.mostrar();
                                    break;
                                }
                                
                                case 2 -> {
                                    int ID = 0;
                                    do{
                                        System.out.println("Digite o ID do Produto: ");
                                        ID = text.nextInt();
                                        text.nextLine();
                                        if (!(ItemVende.buscador(ID) instanceof Produto)) System.out.println("ID inválido! Digite um ID válido para Produto!");

                                    }while(ItemVende.buscador(ID) == null && !(ItemVende.buscador(ID) instanceof Produto));
                                    ItemVende.mostrarUm(ID);
                                    System.out.print("\nDigite a quantidade que você gostaria de diminuir ao estoque: ");
                                    int val = text.nextInt();
                                    text.nextLine();
                                    Produto p = (Produto) ItemVende.buscador(ID);
                                    if(p.getQuant() < val){
                                        System.out.println("Valor grande demais para reduzir do estoque!");
                                    } else {
                                        Produto.reduzQuantidade(ID, val);
                                        System.out.println("\nValor retirado com sucesso!\n");
                                        System.out.println("\n- Catalogo atualizado -\n");
                                        ItemVende.mostrar();
                                    }
                                    break;
                                }
                                case 3 -> {
                                    int ID = 0;
                                    do{
                                        System.out.println("Digite o ID do Servico: ");
                                        ID = text.nextInt();
                                        text.nextLine();
                                        if (!(ItemVende.buscador(ID) instanceof Servico)) System.out.println("ID inválido! Digite um ID válido para Servico!");

                                    }while(ItemVende.buscador(ID) == null && !(ItemVende.buscador(ID) instanceof Servico));
                                    ItemVende.mostrarUm(ID);
                                    System.out.print("\nDigite a quantidade de horas que você gostaria de adcionar ao Servico: ");
                                    int val = text.nextInt();
                                    text.nextLine();
                                    Servico.adicionaHoras(ID, val);
                                    System.out.println("\nValor adicionado com sucesso!\n");
                                    System.out.println("\n- Catalogo atualizado -\n");
                                    ItemVende.mostrar();
                                    break;
                                }
                                case 4 -> {
                                    int ID = 0;
                                    do{
                                        System.out.println("Digite o ID do Servico: ");
                                        ID = text.nextInt();
                                        text.nextLine();
                                        if (!(ItemVende.buscador(ID) instanceof Servico)) System.out.println("ID inválido! Digite um ID válido para Servico!");

                                    }while(ItemVende.buscador(ID) == null && !(ItemVende.buscador(ID) instanceof Servico));
                                    ItemVende.mostrarUm(ID);
                                    System.out.print("\nDigite a quantidade de hora que você gostaria de diminuir: ");
                                    int val = text.nextInt();
                                    text.nextLine();
                                    Servico s = (Servico) ItemVende.buscador(ID);
                                    if(s.getQuant() < val){
                                        System.out.println("Valor grande demais para reduzir das horas!");
                                    } else {
                                        Servico.removerHoras(ID, val);
                                        System.out.println("\nValor retirado com sucesso!\n");
                                        System.out.println("\n- Catalogo atualizado -\n");
                                        ItemVende.mostrar();
                                    }
                                    break;
                                }
                                case 5 -> {
                                    int ID = 0;
                                    do{
                                        System.out.println("Digite o ID do Produto ou Servico: ");
                                        ID = text.nextInt();
                                        text.nextLine();
                                        if (ItemVende.buscador(ID) == null) System.out.println("ID inválido! Digite um ID válido!");
                                    }while(ItemVende.buscador(ID) == null);
                                    ItemVende.mostrarUm(ID);
                                    char op1;
                                    do{

                                        System.out.println("\nTem certeza que quer remover o Produto do catalogo? [S/N]");
                                        op1 = text.nextLine().toLowerCase().charAt(0);
                                        if (op1 != 's' & op1 != 'n') System.out.println("Opção inválida. Digite 'Sim' ou 'Não' para continuar.");

                                    }while(op1 != 's' && op1 != 'n');
                                    if (op1 == 's'){
                                        ItemVende.remover(ID);
                                        System.out.println("Item removido com sucesso!");
                                        System.out.println("\n- Catalogo atualizado -\n");
                                        ItemVende.mostrar();
                                        break;
                                    }
                                    if (op1 == 'n'){
                                        System.out.println("Item não foi removido.");
                                        break;
                                    }
                                }
                                default -> System.out.println("Operação invalida. Tente novamente.");
                            }
                        }    
                    }

                    case 4 -> {
                        if (Cliente.getUsuarios().isEmpty()){
                            System.out.println("Nenhum usuario cadastrado!");
                            break;
                        }
                        System.out.println("\n - Exibir Clientes: -\n");
                        System.out.println("Total de clientes cadastrados: " + Cliente.getTotalCliente());
                        Cliente.mostrarCliente();
                        char op = 's';
                        while(op != 'n'){
                            System.out.println("===".repeat(30));
                            do{
                                        System.out.println("\nGostaria de remover um Cliente? [S/N]");
                                        op = text.nextLine().toLowerCase().charAt(0);
                                        if (op != 's' & op != 'n') System.out.println("Opção inválida. Digite 'Sim' ou 'Não' para continuar.");

                            }while(op != 's' && op != 'n');
                            String email = "a";
                            if (op == 's'){
                                do{
                                    System.out.println("Digite o Email do Cliente que gostaria de remover: ");
                                    email = text.nextLine();
                                    if (Cliente.buscadorCliente(email) == null) System.out.println("Email inválido! Digite um Email válido!");

                                }while(Cliente.buscadorCliente(email) == null);
                                Cliente.mostrarUm(email);
                                System.out.println("\nO Cliente acima foi removido com sucesso!\n");
                                Cliente.remover(email);
                                break;
                            }
                        }
                        break;
                    }

                    case 5 -> {
                        if (Cliente.getUsuarios().isEmpty() || ItemVende.getCatalogo().isEmpty()){
                            System.out.println("Nenhum Cliente ou Item cadastrado! Impossível executar.");
                            break;
                        }
                        String email;
                        System.out.println("\n - Fazer Pedido: -\n");
                        do{
                            System.out.println("Digite o Email do usuario que fará o Pedido: ");
                            email = text.nextLine();
                            if (Cliente.buscadorCliente(email) == null ) System.out.println("Email inválido! ");
                        }while(Cliente.buscadorCliente(email) == null);
                        System.out.println("\nCliente validado! Bem vindo " + Cliente.buscadorCliente(email).getNome() + "!\n");
                        Cliente.mostrarUm(email);
                        System.out.println("===".repeat(30));
                        Carrinho carro = new Carrinho(Cliente.buscadorCliente(email));
                        int op = 0;
                        while(op != 3){
                            System.out.println("\n- Catalogo -\n");
                            ItemVende.mostrar();
                            int ID, quan = 0;
                            System.out.println("\n- O que gostaria de fazer? -\n");
                            System.out.println("1 - Adcionar Item ao Carrinho.");
                            System.out.println("2 - Remover Item do Carrinho.");
                            System.out.println("3 - Finalizar Pedido.");
                            op = text.nextInt();
                            text.nextLine();
                        switch (op) {
                            
                            case 1 : {

                                do{ 
                                    System.out.println("Digite o ID do Item que gostaria de adcionar ao Carrinho: ");
                                    ID = text.nextInt();
                                    text.nextLine();
                                    System.out.println("===".repeat(30));
                                    if (ItemVende.buscador(ID) == null) System.out.println("ID inválido, digite um ID válido!");
                                }while(ItemVende.buscador(ID) == null);
                                Produto p = (Produto) ItemVende.buscador(ID);
                                if(ItemVende.buscador(ID) instanceof Servico){
                                    ItemVende.mostrarUm(ID);
                                } else {
                                    do{
                                        ItemVende.mostrarUm(ID);
                                        System.out.println("Digite a quantidade que você gostaria de comprar: ");
                                        quan = text.nextInt();
                                        text.nextLine();
                                        
                                        if(p.getQuant() < quan){
                                            System.out.println("Quantidade requirida acima da quantidade em estoque! Digite uma quantidade menor.");
                                        }
                                    }while(p.getQuant() < quan || p.getQuant() == 0);
                                    Produto.reduzQuantidade(ID, quan);
                                }
                                
                                carro.adicionar(ItemVende.buscador(ID), quan);

                                System.out.println("\nItem adicionado ao Carrinho!\n");
                                carro.mostrarCarrinho();
                                System.out.println("Valor total dos produtos no Carrinho: R$" + carro.totalPreco());
                                System.out.println("===".repeat(30));
                                break;
                            }
                            case 2:{
                                do{ 
                                    System.out.println("Digite o ID do Item que gostaria de remover do Carrinho: ");
                                    ID = text.nextInt();
                                    text.nextLine();
                                    System.out.println("===".repeat(30));
                                    if (ItemVende.buscador(ID) == null) System.out.println("ID inválido, digite um ID válido!");
                                }while(ItemVende.buscador(ID) == null);
                                if (carro.getItens().contains(ItemVende.buscador(ID)) == false){
                                     System.out.println("O Produto não está no Carrinho. Impossível remover!");
                                     
                                } else{
                                    carro.remover(ID);
                                    System.out.println("Item removido do Carrinho com sucesso!");
                                    carro.mostrarCarrinho();
                                    System.out.println("Valor total dos itens no Carrinho: R$" + carro.totalPreco());
                                    System.out.println("===".repeat(30));
                                }
                                break;

                            }

                            case 3: {
                                if (carro.getItens().isEmpty()) {
                                    System.out.println("Impossível finalizar Pedido! Carrinhos esta vazio!");
                                    
                                }else {
                                    System.out.println("\nFinalizando Pedido...\n");
                                    Pedido pedi = new Pedido(carro, Cliente.buscadorCliente(email));
                                    carro.limpar();
                                    pedi.resumo();
                                }
                                break;

                            }
                            default : System.out.println("Operação invalida. Tente novamente.");
                        }
                    }


                    }
                    case 6 -> {
                        System.out.println("Todos os pedidos feitos: ");
                        Pedido.todosPedidos();
                        break;
                    }
                    case 7 -> System.out.println("Saindo...");
                    default -> System.out.println("Operação invalida. Tente novamente.");
                }
            }
        }

        System.out.println("Obrigado por usar o Saldao OLX!");
    }
}
