package es.upm.dit.isst.inube.servlets;

import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Merchant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	if(request.getSession().getAttribute("merchant") == null) {
    		response.sendRedirect(request.getContextPath() + "/login.jsp");
    		return;
    	}
    	
    	
    	//El merchant ya está guardado en req
    	response.sendRedirect(request.getContextPath() + "/settings.jsp");
    	


    }
}
