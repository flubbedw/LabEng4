package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdutoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public String nome;
	public String categoria;
	public double preco;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome + " - " + categoria + " - " + preco;
	}
	
	public ProdutoModel(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
	

}
