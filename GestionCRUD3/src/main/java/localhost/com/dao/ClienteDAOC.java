package localhost.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import localhost.com.controlador.entity.Cliente;

@Repository
public class ClienteDAOC implements ClienteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Cliente> getClientes() {

		// Obtener la session

		Session session = sessionFactory.getCurrentSession();

		// Crear la consulta(Query)

		Query<Cliente> query = session.createQuery("from Cliente", Cliente.class);

		// Ejecutar la consulta y devolver los resultados

		List<Cliente> clientes = query.getResultList();

		return clientes;
	}

	@Override
	@Transactional
	public void insertarCliente(Cliente cliente) {

		// Obtener la session

		Session session = sessionFactory.getCurrentSession();
		
		//Insertar o actualizar el cliente.
		
		//session.save(cliente); el metodo save hace un insert into.
		
		session.saveOrUpdate(cliente);

	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {
		
		// Obtener la session

		Session session = sessionFactory.getCurrentSession();
		
		//Obtener la información del cliente seleccionado.
		
		Cliente cliente = session.get(Cliente.class, id);
		
		return cliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {
		
		// Obtener la session

		Session session = sessionFactory.getCurrentSession();
		
		//Eliminar el cliente de la base de datos utilizando su id pasado por parametros.
		
		Query consulta = session.createQuery("delete from Cliente where id=:idDelCliente");
		
		consulta.setParameter("idDelCliente", id);
		
		consulta.executeUpdate();
		
	}

}
