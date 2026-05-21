package org.senai.exemplos;

import dao.ProdutoDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando o SistemaEstoquePadaria...");
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.listarProdutos();
        produtoDAO.verificarAlertasEstoque();
        System.out.println("\nExecutando entrada de +20 Pães Franceses...");
        produtoDAO.movimentarEstoque(1, 20);
        System.out.println("\nExecutando saída de -10 Pães Franceses...");
        produtoDAO.movimentarEstoque(1, -10);
        produtoDAO.listarProdutos();
    }
}