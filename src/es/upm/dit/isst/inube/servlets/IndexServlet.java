package es.upm.dit.isst.inube.servlets;

import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Merchant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	String graficaIngresosDatos = "";
    	String graficaOcupacionDatos = "";
    	
    	for(int i = 0; i < 24; i++) {
    		graficaIngresosDatos += " { label: \"" + i + "h\", y:" + i+2 + " }," ;
    		graficaOcupacionDatos += " { label: \"" + i + "h\", y:" + i+2 + " }," ;
    	}

    	request.getSession().setAttribute("dataIngresos", graficaIngresosDatos);
    	request.getSession().setAttribute("dataOcupacion", graficaOcupacionDatos);
    	response.sendRedirect(request.getContextPath() + "/index.jsp");
    	


    }
}
