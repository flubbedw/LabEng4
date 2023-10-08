package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ProdutoModel;
import service.CarrinhoService;

public class Principal {

	public static void main(String[] args) {
		ProdutoModel produtoModel = new ProdutoModel(0);
		produtoModel.nome = "Teclado";
		produtoModel.categoria = "TI";
		produtoModel.preco = 50.00;
		
		ProdutoModel produtoModel2 = new ProdutoModel(0);
		produtoModel2.nome = "Cama";
		produtoModel2.categoria = "Móveis";
		produtoModel2.preco = 500.00;
		
		ProdutoModel produtoModel3 = new ProdutoModel(0);
		produtoModel3.nome = "Mouse sem fio";
		produtoModel3.categoria = "TI";
		produtoModel3.preco = 40.00;
		
		
		CarrinhoService carrinhoService = new CarrinhoService(0);
		CarrinhoService carrinhoService2 = new CarrinhoService(0);
		System.out.println("Finaz. sem prod: " +carrinhoService.finalizar());
		System.out.println("Remov. ind. inv: " +carrinhoService.remover(1));
		System.out.println("Add prod " +carrinhoService.adicionar(produtoModel));
		System.out.println("Add prod " +carrinhoService.adicionar(produtoModel2));
		System.out.println("Add prod " +carrinhoService.adicionar(produtoModel3));
		imprimeProdutos(carrinhoService);
		System.out.println("Tot. inst deve ser 2: " + CarrinhoService.getTotInst());
		System.out.println("Remov. correto: " + carrinhoService.remover(1));
		imprimeProdutos(carrinhoService);
		System.out.println("Total deve ser 90: " + carrinhoService.finalizar());
		System.out.println("Add fechado" + carrinhoService.adicionar(produtoModel3));
		System.out.println("Remo fechado" + carrinhoService.remover(0));
		System.out.println("Final fechado" + carrinhoService.finalizar());
		
		testarHibernate();
		

	}

	private static void testarHibernate() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = factory.createEntityManager();
		
		ProdutoModel produtoModel = new ProdutoModel(0);
		produtoModel.nome = "Mouse sem fio";
		produtoModel.categoria = "TI";
		produtoModel.preco = 40.00;
		
		entityManager.getTransaction().begin();
		entityManager.persist(produtoModel);//inserir
		entityManager.getTransaction().commit();

		ProdutoModel produtoCons = entityManager.find(ProdutoModel.class, 1L);
		System.out.println(produtoCons);
		
		entityManager.getTransaction().begin();
		produtoCons.nome = "Novo nome";
		entityManager.persist(produtoModel);//alterar
		entityManager.getTransaction().commit();
		produtoCons = entityManager.find(ProdutoModel.class, 1L);
		System.out.println(produtoCons);
		
		entityManager.getTransaction().begin();
		entityManager.remove(produtoModel);//deletar
		entityManager.getTransaction().commit();
		produtoCons = entityManager.find(ProdutoModel.class, 1L);
		System.out.println(produtoCons);

		
		
	}

	private static void imprimeProdutos(CarrinhoService carrinhoService) {
		for(ProdutoModel produto : carrinhoService.getProdutos()) {
			System.out.println(produto);
		}
		
	}

}








