package model;

import java.sql.Date;

public class Produto {
    private int idProduto;
    private String nome;
    private Date dataValidade;
    private int quantidadeAtual;
    private int quantidadeMinima;
    private int idCategoria;
    public Produto() {}
    public Produto(int idProduto, String nome, Date dataValidade, int quantidadeAtual, int quantidadeMinima, int idCategoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
        this.idCategoria = idCategoria;
    }
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Date getDataValidade() { return dataValidade; }
    public void setDataValidade(Date dataValidade) { this.dataValidade = dataValidade; }

    public int getQuantidadeAtual() { return quantidadeAtual; }
    public void setQuantidadeAtual(int quantidadeAtual) { this.quantidadeAtual = quantidadeAtual; }

    public int getQuantidadeMinima() { return quantidadeMinima; }
    public void setQuantidadeMinima(int quantidadeMinima) { this.quantidadeMinima = quantidadeMinima; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
}