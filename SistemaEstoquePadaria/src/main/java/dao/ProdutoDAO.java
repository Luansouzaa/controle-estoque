package dao;

import conexao.Conexao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    public void listarProdutos() {
        String sql = "SELECT * FROM produtos";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("\n--- LISTA DE PRODUTOS ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_produto") +
                        " | Nome: " + rs.getString("nome") +
                        " | Qtd: " + rs.getInt("quantidade_atual") +
                        " | Validade: " + rs.getDate("data_validade"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
    }
    public void verificarAlertasEstoque() {
        String sql = "SELECT nome, quantidade_atual, quantidade_minima FROM produtos WHERE quantidade_atual < quantidade_minima";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("\n--- ALERTAS DE ESTOQUE (ABAIXO DO MÍNIMO) ---");
            boolean temAlerta = false;
            while (rs.next()) {
                temAlerta = true;
                System.out.println("ALERTA -> Produto: " + rs.getString("nome") +
                        " | Estoque Atual: " + rs.getInt("quantidade_atual") +
                        " | Mínimo Esperado: " + rs.getInt("quantidade_minima"));
            }
            if (!temAlerta) {
                System.out.println("Todos os produtos estão com níveis de estoque saudáveis.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar alertas de estoque: " + e.getMessage());
        }
    }

    public void movimentarEstoque(int idProduto, int quantidadeAlterada) {
        String sql = "UPDATE produtos SET quantidade_atual = quantidade_atual + ? WHERE id_produto = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantidadeAlterada);
            stmt.setInt(2, idProduto);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("[Sucesso] Estoque movimentado com sucesso para o produto ID: " + idProduto);
            } else {
                System.out.println("[Aviso] Nenhum produto encontrado com o ID: " + idProduto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao movimentar estoque: " + e.getMessage());
        }
    }
}