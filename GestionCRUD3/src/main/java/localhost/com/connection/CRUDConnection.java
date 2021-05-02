package localhost.com.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CRUDConnection
 */
@WebServlet("/CRUDConnection")
public class CRUDConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Prueba
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uriJdbc = "jdbc:sqlserver://LAPTOP-O8GP8LD8:1433;databasename=gestionPedidosCRUD;user=sa;password=melomama;";
		
		try {

			//Inentando conectar con la base de datos

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			PrintWriter out = response.getWriter();
			
			out.print("Nombre de la base de datos: " + uriJdbc + "<br>");

			Connection connect = DriverManager.getConnection(uriJdbc);

			out.print("Conexión exitosa!!");

			connect.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
