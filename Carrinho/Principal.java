package Carrinho;

import javax.swing.JOptionPane;

import Carrinho.CarrinhoService;
import Carrinho.Produto;

public class Principal {

    public static void main(String[] args) {
        CarrinhoService carrinho = new CarrinhoService();
        int opcao;
        do {
            opcao = menuInicial();
            switch (opcao) {
                case 1:
                    carrinho.abrirCarrinho();
                    menuCarrinho(carrinho);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);

    }

    private static void menuCarrinho(CarrinhoService carrinho) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção: \n"
                    + "1 - Adicionar produto ao carrinho\n"
                    + "2 - Remover produto do carrinho\n"
                    + "3 - Exibir produtos no carrinho\n"
                    + "4 - Finalizar compra\n"
                    + "0 - Sair"));
            switch (opcao) {
                case 1:
                    adicionarProduto(carrinho);
                    menuCarrinho(carrinho);
                    break;
                case 2:
                    removerProduto(carrinho);
                    menuCarrinho(carrinho);
                    break;
                case 3:
                    carrinho.exibirProdutos();
                    break;
                case 4:
                    finalizarCompra(carrinho);
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }

    private static void adicionarProduto(CarrinhoService carrinho) {
        String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));
        Produto produto = new Produto();
        carrinho.adicionarProduto(produto);
    }

    private static void removerProduto(CarrinhoService carrinho) {
        String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto a ser removido:");
        Produto produto = new Produto();
        carrinho.removerProduto(produto);
    }

    private static void finalizarCompra(CarrinhoService carrinho) {
        double total = 0.0;
        for (Produto produto : carrinho.produtos) {
            if (produto != null) {
                total += produto.getPreco();
            }
            System.out.println("Total da compra: R$" + total);
            carrinho.produtos.clear();
        }
    }

    private static int menuInicial() {
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção: \n"
                + "1 - Abrir carrinho\n"
                + "0 - Sair"));
        return opcao;
    }
}