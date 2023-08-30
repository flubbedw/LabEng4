package app;
import model.CarroModel;
import service.CarroService;

public class Principal {
  public static void main (String[] args) {
    CarroModel carro = new CarroModel(200);
    carro.setModelo("Fusca");
    carro.setMarca("Volks");
  }
  CarroModel carro2 = new CarroModel(280, "Fiat", "Uno com escada");

  //services
  CarroService carroService = new CarroService();
  carroService.acelerar(carro, 10);//acelera com carro desligado
  carroService.ligar(carro);
  carroService.acelerar(carro, 120);//acelera menos que veloMax
  carroService.acelerar(carro, 100);//acelera mais que veloMax
  carroService.acelerar(carro, 100);//desacelera menos que veloMin
  carroService.acelerar(carro, 150);//desacelera mais que veloMin
