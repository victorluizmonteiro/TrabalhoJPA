package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Pedido;

public class PedidoDAOImpl extends GenericDAOImpl<Pedido, Integer>implements PedidoDAO {

	public PedidoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
