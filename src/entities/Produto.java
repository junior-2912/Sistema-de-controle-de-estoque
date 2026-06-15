package entities;

public class Produto {
    private String id;
    private String nome;
    private double preco;
    private int quantidade;
    
    public Produto(String id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return  id + " - " + nome + "\n" + 
        "R$" + String.format("%.2f", preco) + " - " + quantidade + " unidades";
    }
    
    
}
