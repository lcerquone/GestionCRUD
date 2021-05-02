package localhost.com.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import localhost.com.controlador.entity.Cliente;
import localhost.com.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controler {

	@RequestMapping("/lista")
	public String vistaClientes(Model model) {
		
		//Obtener los clientes desde el DAO
		
		List<Cliente> clientes = clienteDAO.getClientes();
		
		//Agregar los clientes al modelo
		
		model.addAttribute("clientes", clientes);

		return "lista-clientes";

	}
	
	@RequestMapping("/formularioAgregar")
	public String vistaFormularioAgregar(Model model) {
		
		//Bind de datos de los clientes.
		
		Cliente cliente = new Cliente();
		
		model.addAttribute("cliente", cliente);
		
		return "formulario-cliente";
	
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente cliente) {
		
		//Insertar cliente a la base de datos.
		
		clienteDAO.insertarCliente(cliente);
		
		return "redirect:/cliente/lista";
		
	}
	

	@GetMapping("/formularioActualizar")
	public String vistaFormularioActualizar(@RequestParam("clienteId") int id, Model model) {
		
		//Obtener el cliente.
		
		Cliente cliente = clienteDAO.getCliente(id);
		
		//Establecer el cliente como atributo del modelo.
		
		model.addAttribute("cliente", cliente);
		
		//Enviar al formulario
		
		return "formulario-cliente";
	
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int id) {
		
		//Elimnar el cliente.
		
		clienteDAO.eliminarCliente(id);
		
		//Redireccionar a la lista de clientes.
		
		return "redirect:/cliente/lista";
	
	}
	
	@Autowired
	private ClienteDAO clienteDAO;

}
