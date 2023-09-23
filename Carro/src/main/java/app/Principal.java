package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.CarroModel;

public class Principal {

	private final static String UNITY_NAME = "mysql_prod";
	private static EntityManagerFactory managerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		managerFactory = Persistence.createEntityManagerFactory(UNITY_NAME);
		entityManager = managerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		int opcao;
		do {
			opcao = menuInicial();
			switch (opcao) {
			case 1:
				criarCarro();
				break;

			default:
				break;
			}
		} while (opcao != 0);
		entityManager.getTransaction().commit();
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
