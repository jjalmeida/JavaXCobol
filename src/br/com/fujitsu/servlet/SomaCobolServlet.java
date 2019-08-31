package br.com.fujitsu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fujitsu.cobol.SomaCobol;

@WebServlet("/soma")
public class SomaCobolServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param1 = req.getParameter("param1");

		String param2 = req.getParameter("param2");
		
		PrintWriter writer = resp.getWriter();

		if (validaParametros(param1, param2)) {

			SomaCobol soma = new SomaCobol();

			int resultado = soma.chamaLibCobol(param1, param2);

			System.out.println("RESULTADO = " + resultado);

			writer.println("<html>");
			writer.println("<body>");
				writer.println("<div align=\"center\">");
					writer.println("<h3>RESULTADO DA SOMA</h3>");
					writer.println("<h1>" + param1 + " + " + param2 + " = " + resultado + "</h1>");
				writer.println("</div>");
			writer.println("</body>");
			writer.println("</html>");
		}else {
			writer.println("<html>");
			writer.println("<body>");
				writer.println("<div align=\"center\">");
					writer.println("<h1>Numeros invalidos</h1>");
				writer.println("</div>");
			writer.println("</body>");
			writer.println("</html>");
		}
	}

	private boolean validaParametros(String param1, String param2) {
		try {
			Integer.parseInt(param1);
			Integer.parseInt(param2);
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}

	}

}
