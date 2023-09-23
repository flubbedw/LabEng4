package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.CarroModel;
import service.CarroService;

public class Principal {

	private final static String UNITY_NAME = "mysql_prod";
	private static EntityManagerFactory managerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		managerFactory = Persistence.createEntityManagerFactory(UNITY_NAME);
		entityManager = managerFactory.createEntityManager();
		int opcao;
		do {
			entityManager.getTransaction().begin();
			opcao = menuInicial();
			switch (opcao) {
			case 1:
				criarCarro();
				break;
			case 2:
				consultarCarro();
				break;
			default:
				break;
			}
			entityManager.getTransaction().commit();
		} while (opcao != 0);

	}

	private static void consultarCarro() {
		long id = Long.parseLong(
				JOptionPane.showInputDialog("Digite o Id"));
		
		CarroModel carro = entityManager.find(CarroModel.class, id);
		JOptionPane.showMessageDialog(null, "Carro selecionado:" + carro);
		int opcao;
		do {
			opcao = menuCarro();
			switch (opcao) {
			case 1:
				excluirCarro(carro);break;
			case 3:
				ligarCarro(carro);break;
			case 4:
			int veloAce = Integer.parseInt(
					JOptionPane.showInputDialog("Digite a aceleração"));
				acelerarCarro(carro, veloAce);break;
			default:break;
		}
		} while (opcao != 0 && opcao != 1);
	}

	private static void acelerarCarro(CarroModel carro, int veloAce) {
		CarroService carroService = new CarroService();
		carroService.acelerar(carro, veloAce);
		JOptionPane.showMessageDialog(null, carro);
		
	}

	private static void ligarCarro(CarroModel carro) {
		CarroService carroService = new CarroService();
		carroService.ligar(carro);
		JOptionPane.showMessageDialog(null, "Ligado");
		
	}

	private static void excluirCarro(CarroModel carro) {
		entityManager.remove(carro);
		JOptionPane.showMessageDialog(null, "Excluído");
		
	}

	private static int menuCarro() {
		int opcao = Integer.parseInt(JOptionPane
				.showInputDialog("Escolha a opção: \n" + 
		"1 - Excluir carro\n" + 
		"2 - Alterar carro\n" + 
		"3 - Ligar carro\n" + 
		"4 - Acelerar carro\n" + 
		"5 - Frear carro\n" + 
		"6 - Desligar carro\n" + 
		"0 - Sair"));
		
		return opcao;

	}
		
	

	private static void criarCarro() {
		int veloMax = Integer.parseInt(JOptionPane.showInputDialog("Digite a velocidade máxima"));
		String marca = JOptionPane.showInputDialog("Dig. a marca");
		String modelo = JOptionPane.showInputDialog("Dig. o modelo");

		CarroModel carro = new CarroModel(veloMax, marca, modelo);
		entityManager.persist(carro);
	}

	private static int menuInicial() {
		int opcao = Integer.parseInt(JOptionPane
				.showInputDialog("Escolha a opção: \n" + "1 - Criar carro\n" + "2 - Selecionar carro\n" + "0 - Sair"));
		return opcao;
	}

	private static void valorizaCarro() {

	}

}
