package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Produto;
import services.ServicoEstoque;

public class Main {
    // Classe pra controlar o menu de opcoes e mandar os dados para os metodos da
    // classe de servico.
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ServicoEstoque servicoEstoque = new ServicoEstoque();

        try {
            while (true) {
                System.out.println();
                System.out.println("1 - Cadastrar produto");
                System.out.println("2 - Listar produtos");
                System.out.println("3 - Entrada de produto");
                System.out.println("4 - Saida de produto");
                System.out.println("5 - Busca de produto por ID");
                System.out.println("6 - Produto mais caro");
                System.out.println("7 - Produto com maior estoque");
                System.out.println("8 - Valor total do estoque");
                System.out.println("9 - Ordenar por preço");
                System.out.println("10 - Sair do menu");

                int indice = entrada.nextInt();
                System.out.println();
                switch (indice) {
                    case 1 -> {
                        System.out.println("---CADASTRO DE PRODUTO---");
                        // Limpando o buffer do scanner.
                        entrada.nextLine();
                        System.out.print("Digite o nome do produto: ");
                        String nome = entrada.nextLine();
                        System.out.print("Digite o ID do produto: ");
                        String id = entrada.nextLine();
                        System.out.print("Digite o valor do produto: ");
                        double preco = entrada.nextDouble();
                        // Insere todos os dados do produto e chama o metodo para cadastra-lo.
                        Produto produto = new Produto(id, nome, preco);
                        servicoEstoque.cadastrarProdutos(produto);

                        System.out.println("---FIM DO CADASTRO---");
                    }
                    case 2 -> {
                        System.out.println("---LISTAGEM DE PRODUTOS---");
                        // Chama o metodo que lista todos os produtos formatados.
                        servicoEstoque.listarProdutos();
                        System.out.println("---FIM DA LISTAGEM---");
                    }
                    case 3 -> {
                        System.out.println("---ENTRADA DE PRODUTO---");
                        entrada.nextLine();
                        System.out.print("Digite o ID do produto a dar entrada: ");
                        String id = entrada.nextLine();
                        System.out.print("Digite a quantidade a dar entrada: ");
                        int quantidade = entrada.nextInt();

                        Produto produto = servicoEstoque.buscarProdutoPorId(id);
                        if (produto != null) {
                            if (servicoEstoque.entradaProduto(produto, quantidade)) {
                                System.out.println("Foi dado entrada de " + quantidade + " unidades!");
                            }
                        } else {
                            System.out.println("Produto nao encontrado!");
                        }
                        System.out.println("---FIM DA ENTRADA---");
                    }
                    case 4 -> {
                        System.out.println("---SAIDA DE PRODUTO---");
                        entrada.nextLine();
                        System.out.print("Digite o ID do produto a dar saida: ");
                        String id = entrada.nextLine();
                        System.out.print("Digite a quantidade a dar saida: ");
                        int quantidade = entrada.nextInt();

                        Produto produto = servicoEstoque.buscarProdutoPorId(id);
                        if (produto != null) {
                            if (servicoEstoque.saidaProduto(produto, quantidade)) {
                                System.out.println("Foi dado saida de " + quantidade + " unidades!");
                            }
                        } else {
                            System.out.println("Produto nao encontrado!");
                        }
                        System.out.println("---FIM DA SAIDA---");
                    }
                    case 5 -> {
                        System.out.println("---BUSCA DE PRODUTOS---");
                        entrada.nextLine();
                        System.out.print("Digite o ID do produto: ");
                        String id = entrada.nextLine();

                        Produto produto = servicoEstoque.buscarProdutoPorId(id);
                        if (produto != null) {
                            System.out.println("Produto encontrado!");
                            System.out.println(produto);
                        } else {
                            System.out.println("Produto nao encontrado!");
                        }

                    }

                    case 6 -> {
                        System.out.println("---PRODUTO MAIS CARO---");
                        System.out.println();
                        Produto produtoMaisCaro = servicoEstoque.produtoMaisCaro();
                        if (produtoMaisCaro != null) {
                            System.out.println(produtoMaisCaro.getNome());
                        }
                        System.out.println("------------------------");
                    }
                    case 7 -> {
                        System.out.println("---PRODUTO COM MAIOR ESTOQUE---");
                        System.out.println();
                        Produto produto = servicoEstoque.produtoMaiorQuantidade();
                        if (produto != null) {
                            System.out.println(produto.getNome());
                        }
                    }
                    case 8 -> {
                        System.out.println();
                    }

                    case 10 -> {
                        System.out.println("Adeus! Fechando o programa...");
                        entrada.close();
                        return;
                    }

                    default -> {
                        System.out.println("Digite um numero valido!");
                        break;
                    }

                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas o que é requerido!");
            return;
        }
    }
}
