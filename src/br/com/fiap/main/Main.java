package br.com.fiap.main;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;



import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ClienteDAOImpl;
import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.PedidoDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Main {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDAO daoCliente = new ClienteDAOImpl(em);
		PedidoDAO daoPedido = new PedidoDAOImpl(em);
		
		
		Cliente c1 = new Cliente();
		c1.setNome("Victor");
		c1.setEmail("victor@zup.com.br");
		
		Cliente c2 = new Cliente();
		c2.setNome("Lucas");
		c2.setEmail("lucas@zup.com.br");
		
		Pedido p1 = new Pedido();
		p1.setDescricao("Maquina de lavar");
		p1.setData(LocalDateTime.now());
		p1.setValor(500.0);
		
		Pedido p2 = new Pedido();
		p2.setDescricao("Fogão");
		p2.setData(LocalDateTime.now().plusYears(1));
		p2.setValor(1000.0);
		
		c1.addPedido(p1);
		c2.addPedido(p2);
		
		daoCliente.insert(c1);
		daoCliente.insert(c2);
		
		daoCliente.list().stream().forEach(System.out::println);
		daoPedido.list().stream().forEach(System.out::println);
		
		Pedido findPedido = daoPedido.findById(c1.getId());
		System.out.println(findPedido.toString());
		
		Cliente findCliente = daoCliente.findById(c2.getId());
		System.out.println(findCliente.toString());
		
		daoCliente.remove(c1.getId());
		
		daoCliente.list().stream().forEach(System.out::println);
		
		findCliente.setNome("MAURICIO");
		findCliente.setEmail("mauricio@ig.com.br");
		daoCliente.update(findCliente);
		
		System.out.println(c2.toString());
	}

}
