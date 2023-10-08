package service;

import java.util.ArrayList;

import model.ProdutoModel;

public class CarrinhoService {
	private long id;
	private boolean aberto;
	static private int totInst;
	private ArrayList<ProdutoModel> produtos;
	

	
	public long getId() {
		return id;
	}

	public boolean isAberto() {
		return aberto;
	}

	public static int getTotInst() {
		return totInst;
	}

	public ArrayList<ProdutoModel> getProdutos() {
		return produtos;
	}

	public CarrinhoService(long id) {
		this.produtos = new ArrayList<ProdutoModel>();
		this.id = id;
		this.aberto = true;
		this.totInst++;		
	}
	
	public boolean adicionar(ProdutoModel produto) {
		if(aberto) {
			produtos.add(produto);
			return true;
		}
		return false;
	}
	
	public boolean remover(int indice) {
		if(!aberto || indice < 0 || indice >= produtos.size()) {
			return false;
		}
		produtos.remove(indice);
		return true;
	}
	
	public Object finalizar() {
		if(!aberto || produtos.isEmpty()) {
			return false;
		}
		aberto = false;
		double total = 0;
		for(ProdutoModel produto : produtos) {
			total += produto.preco;
		}
		return total;
	}

	
	
	
}
