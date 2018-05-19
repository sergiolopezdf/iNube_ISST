package es.upm.dit.isst.inube.servlets;

import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Merchant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FilterServlet")
public class FilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	String fecha = request.getParameter("fecha");
    	
    	String horaInicial = request.getParameter("horaInicial");
    	String horaFinal = request.getParameter("horaFinal");
    	
    	request.getSession().setAttribute("fecha", fecha);
    	request.getSession().setAttribute("horaInicial", horaInicial);
    	request.getSession().setAttribute("horaFinal", horaFinal);
    	
    	response.sendRedirect(request.getContextPath() + "/main");
    	


    }
}
