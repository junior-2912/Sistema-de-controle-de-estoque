package services;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import exceptions.EstoqueNegativoException;

public class ServicoEstoque {
    List<Produto> produtos = new ArrayList<>();

    public void cadastrarProdutos(Produto produto) {
        if (produto != null) {
            produtos.add(produto);
            System.out.println("Produto adicionado ao catalogo!");
        } else {
            throw new NullPointerException("Produto nao pode ser vazio!");
        }
    }

    public void listarProdutos() {
        produtos.forEach(produto -> System.out.println(produto));
    }

    public Produto buscarProdutoPorId(String id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }

    public void entradaProduto(Produto produto, int quantidade) {
        if (quantidade > 0) {
            produto.setQuantidade(produto.getQuantidade() + quantidade);
            System.out.println("Foi dado entrada de " + quantidade + " unidades!");
        } else {
            System.out.println("Quantidade deve ser maior que 0!");
        }
    }

    public void saidaProduto(Produto produto, int quantidade) {
        if (produto.getQuantidade() <= quantidade) {
            throw new EstoqueNegativoException("A quantidade é maior que o estoque!");
        }
        if (quantidade > 0) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
            System.out.println("Foi dado saida de " + quantidade + " unidades!");
        } else {
            System.out.println("Digite um numero maior que 0!");
        }
    }
}
