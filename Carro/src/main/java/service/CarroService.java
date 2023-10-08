package service;

import model.CarroModel;

public class CarroService {
	private final int VELO_MINIMA = 0;
	
	public void ligar(CarroModel carro) {
		carro.setLigado(true);
		System.out.println("Ligou");
	}
	public void desligar (CarroModel carro) {
		carro.setLigado(false);
		carro.setVeloAtual(0);
		System.out.println("Desligou");		
	}
	public boolean acelerar (CarroModel carro, int velo) {
		if(carro.isLigado()) {
			carro.setVeloAtual(carro.getVeloAtual() + velo);
			if(carro.getVeloAtual() > carro.getVeloMax()) {
				carro.setVeloAtual(carro.getVeloMax());
			}
			System.out.println(carro.getVeloAtual());
			return true;
		}
		System.out.println("Carro desligado");
		return false;
	}
	public void desacelerar (CarroModel carro, int velo) {
			carro.setVeloAtual(carro.getVeloAtual() - velo);
			if(carro.getVeloAtual() < VELO_MINIMA) {
				carro.setVeloAtual(VELO_MINIMA);
			}
			System.out.println(carro.getVeloAtual());
	}
}
