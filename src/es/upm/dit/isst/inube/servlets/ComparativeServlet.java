package es.upm.dit.isst.inube.servlets;

import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Merchant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comparative")
public class ComparativeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	if(request.getSession().getAttribute("merchant") == null) {
    		response.sendRedirect(request.getContextPath() + "/login.jsp");
    		return;
    	}
    	
    	
    	
    	
    	
    	String graficaIngresosDatos = "";
    	String graficaOcupacionDatos = "";
    	String graficaOcupacionCodigoPostal = "";
    	
    	
    	for(int i = 0; i < 24; i++) {
    		graficaIngresosDatos += " { label: \"" + i + "h\", y:" + i+2 + " }," ;
    		graficaOcupacionDatos += " { label: \"" + i + "h\", y:" + i+2 + " }," ;
    	}
    	
    	
    	for (int i = 28029; i< 28035; i++) {
    		graficaOcupacionCodigoPostal += "{y: " + 3 + ", name: '"+ i +"'},";
    	}

    	request.getSession().setAttribute("dataIngresosCompetencia", graficaIngresosDatos);
    	request.getSession().setAttribute("dataOcupacionCompetencia", graficaOcupacionDatos);
    	request.getSession().setAttribute("dataOcupacionCodigoPostal", graficaOcupacionCodigoPostal);
    	response.sendRedirect(request.getContextPath() + "/comparative.jsp");


    }
}
