package Carrinho;

import Carrinho.Produto;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CarrinhoService {
            
        private static long totInst = 0;
        private boolean aberto = false;
        public ArrayList<Produto> produtos = new ArrayList<Produto>();

        public CarrinhoService() {
            totInst++;
        }
    
        public void abrirCarrinho() {
            aberto = true;
        }

        public void adicionarProduto(Produto produto) {
            produtos.add(produto);
        }
    
        public void removerProduto(Produto produto) {
            produtos.remove(produto);
        }
    
        public void exibirProdutos() {
            int totalProdutos = produtos.size();
            if (totalProdutos == 0) {
                JOptionPane.showMessageDialog(null, "Não há produtos no carrinho");
            } else {
                String mensagem = "Produtos no carrinho:\n";
                for (Produto produto : produtos) {
                    mensagem += produto.getNome() + " - R$" + produto.getPreco() + "\n";
                }
                JOptionPane.showMessageDialog(null, mensagem);
            }
        }

        public static long getTotInst() {
            return totInst;
        }
    }
