package services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import entities.Produto;

public class ServicoEstoque {
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrarProdutos(Produto produto) {
        Produto produtoBuscado = buscarProdutoPorId(produto.getId());
        if (produtoBuscado == null) {
            produtos.add(produto);
            System.out.println("Produto adicionado ao catalogo!");
        } else {
            System.out.println("Ja existe um produto com esse ID!");
        }
    }

    public void listarProdutos() {
        produtos.forEach(System.out::println);
    }

    public Produto buscarProdutoPorId(String id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }

    public boolean entradaProduto(Produto produto, int quantidade) {
        if (quantidade > 0) {
            produto.setQuantidade(produto.getQuantidade() + quantidade);
            return true;
        } else {
            System.out.println("Quantidade deve ser maior que 0!");
            return false;
        }
    }

    public boolean saidaProduto(Produto produto, int quantidade) {
        if (quantidade > produto.getQuantidade()) {
            System.out.println("A quantidade é maior que o estoque!");
            return false;
        }
        if (quantidade > 0) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
            return true;
        } else {
            System.out.println("Digite um numero maior que 0!");
            return false;
        }
    }

    public Produto produtoMaisCaro() {
        Optional<Produto> produtoOptional = produtos.stream().max(Comparator.comparing(Produto::getPreco));

        return produtoOptional.orElse(null);
    }

    public Produto produtoMaiorQuantidade() {
        Produto produto = produtos.stream()
                .max(Comparator.comparing(Produto::getQuantidade))
                .orElse(null);
        return produto;
    }

    public double valorTotalEstoque() {
        double valorTotal = produtos.stream()
                .mapToDouble(produto -> produto.getPreco() * produto.getQuantidade())
                .sum();
        return valorTotal;
    }

    public List<Produto> ordenarPorPreco() {

    }

}
