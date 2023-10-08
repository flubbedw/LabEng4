package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

@Entity
public class CarroModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String modelo;
	private String marca;
	private int veloAtual;
	private int veloMax;
	private boolean ligado;
	
	public CarroModel(int veloMax) {
		this.veloMax = veloMax;
	}
	
	public CarroModel() {

	}

	
	public CarroModel(int veloMax, String marca, String modelo) {
		this.veloMax = veloMax;
		this.marca = marca;
		this.modelo = modelo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getVeloAtual() {
		return veloAtual;
	}


	public void setVeloAtual(int veloAtual) {
		this.veloAtual = veloAtual;
	}


	public int getVeloMax() {
		return veloMax;
	}


	public void setVeloMax(int veloMax) {
		this.veloMax = veloMax;
	}


	public boolean isLigado() {
		return ligado;
	}


	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Marca: " + this.marca +
				"\nModelo: " + this.modelo +
				"\nVelo atual: " + this.veloAtual +
				"\nVelo max: " + this.veloMax;
	}
	
	
	


}
