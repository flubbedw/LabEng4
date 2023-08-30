package model;

public class CarroModel {
	private String modelo;
	private String marca;
	private int veloAtual;
	private int veloMax;
	private boolean ligado;

	public CarroModel(int veloMax) {
		this.veloMax = veloMax;
	}

	public CarroModel(int veloMax, String marca, String modelo) {
		this.veloMax = veloMax;
		this.marca = marca;
		this.modelo = modelo;
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

  public String toString() {
    return "Marca: " + this.marca +
            "\nModelo: " + this.modelo +
            "\nVelo atual: " + this.veloAtual +
            "n\Velo max: " + this.veloMax;
  }

}
