package localhost.com.dao;

import java.util.List;

import localhost.com.controlador.entity.Cliente;

public interface ClienteDAO {
	
	public List<Cliente> getClientes();

	public void insertarCliente(Cliente cliente);

	public Cliente getCliente(int id);

	public void eliminarCliente(int id);
}
