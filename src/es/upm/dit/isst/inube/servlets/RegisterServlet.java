package es.upm.dit.isst.inube.servlets;

import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Merchant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String merchantId = request.getParameter("merchantId");
        int codigoPostal = Integer.parseInt(request.getParameter("cp"));
        String nombreNegocio = request.getParameter("name");
        
        Merchant merchant = new Merchant();
        merchant.setCodigoPostal(codigoPostal);
        merchant.setNombreNegocio(nombreNegocio);
        merchant.setMerchantId(merchantId);

        MerchantDAOImplementation.getInstance().createMerchant(merchant);
        
        request.getSession().setAttribute("alertOk", "Registro completado con éxito");
        
        response.sendRedirect(request.getContextPath() + "/register.jsp");
        
        request.getSession().setAttribute("alertOk", null);


    }
}
