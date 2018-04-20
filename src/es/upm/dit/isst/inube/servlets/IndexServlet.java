package es.upm.dit.isst.inube.servlets;

import es.upm.dit.isst.inube.dao.MerchantDAOImplementation;
import es.upm.dit.isst.inube.dao.TransactionDAOImplementation;
import es.upm.dit.isst.inube.dao.model.Merchant;
import es.upm.dit.isst.inube.dao.model.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getSession().getAttribute("merchant") == null) {
    		response.sendRedirect(request.getContextPath() + "/login.jsp");
    		return;
    	}
    	
    	Merchant merchant = (Merchant) request.getSession().getAttribute("merchant");
    	
    	List<Transaction> transactions = TransactionDAOImplementation.getInstance().readAllTransactionsFromMerchant(merchant);
   
    	float[] importes = new float[24];
    	float[] ocupacion = new float[24];
    	
    	for(Transaction t: transactions) {
    		int hora = Integer.parseInt(t.getHora());
    		importes[hora] += t.getImporte();
    		ocupacion[hora]++;
    	}
    	
    	String graficaIngresosDatos = "";
    	String graficaOcupacionDatos = "";
    	
    	for(int i = 0; i < 24; i++) {
    		graficaIngresosDatos += " { label: \"" + i + "h\", y:" + importes[i] + " }," ;
    		graficaOcupacionDatos += " { label: \"" + i + "h\", y:" + ocupacion[i] + " }," ;
    	}

    	request.getSession().setAttribute("dataIngresos", graficaIngresosDatos);
    	request.getSession().setAttribute("dataOcupacion", graficaOcupacionDatos);
    	response.sendRedirect(request.getContextPath() + "/index.jsp");
    	


    }
}
