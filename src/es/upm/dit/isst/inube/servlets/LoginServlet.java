package es.upm.dit.isst.inube.servlets;

import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Merchant;
import es.upm.dit.isst.inube.data.DataProcessing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String merchantId = request.getParameter("merchantId");
        Merchant merchant = MerchantDAOImplementation.getInstance().loginMerchant(merchantId);

        if(merchant != null) {
        	request.getSession().setAttribute("merchant", merchant);
        	response.sendRedirect(request.getContextPath() + "/main.jsp");
            
        } else {
        	request.getSession().setAttribute("alertNotOk", "Merchant ID incorrecto");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            request.getSession().setAttribute("alertNotOk", null);
        }
        
        


    }
}
