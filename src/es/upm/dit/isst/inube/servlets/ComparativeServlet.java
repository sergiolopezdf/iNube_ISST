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

@WebServlet("/comparative")
public class ComparativeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	if(request.getSession().getAttribute("merchant") == null) {
    		response.sendRedirect(request.getContextPath() + "/login.jsp");
    		return;
    	}
    	
    	Merchant merchant = (Merchant) request.getSession().getAttribute("merchant");
    	
    	List<Transaction> transactions = TransactionDAOImplementation.getInstance().readAllTransactionsFromCompetencia(merchant);
    	
    	String horaInicial = (String) request.getSession().getAttribute("horaInicial");
    	String horaFinal = (String) request.getSession().getAttribute("horaFinal");
    	
    	int horaInicialInt = 0;
    	int horaFinalInt = 23;
    	
    	if (horaFinal != null && horaInicial != null) {
    		horaInicialInt = Integer.parseInt(horaInicial);
        	horaFinalInt = Integer.parseInt(horaFinal);
    	}
    	
    	String fecha = (String) request.getSession().getAttribute("fecha");
    	
    	int c1 = Character.getNumericValue(fecha.charAt(3));
    	int c2 = Character.getNumericValue(fecha.charAt(4));
    	
    	
    	String dateToPick = Integer.toString(((c1 + c2) % 7) +1);
    	
    	float[] importes = new float[24];
    	float[] ocupacion = new float[24];
    	
    	for(Transaction t: transactions) {
    		if(t.getFecha().equals(dateToPick)) {
    			int hora = Integer.parseInt(t.getHora());
        		importes[hora] += t.getImporte();
        		ocupacion[hora]++;
    		}
    			
    	}
    	
    
    	int nMerchant = MerchantDAOImplementation.getInstance().getNumberOfMerchants();
    	
    	TransactionDAOImplementation.getInstance().readAllTransactionsFromZones();
    	
    	
    	
    	for(int i = 0; i<importes.length; i++) {
    		importes[i] /= (nMerchant-1);
    	}
    	
    	
    	for(int i = 0; i<ocupacion.length; i++) {
    		ocupacion[i] /= (nMerchant-1);
    	}
    	
    	
    	
    	String graficaIngresosDatos = "";
    	String graficaOcupacionDatos = "";
    	String graficaOcupacionCodigoPostal = "";
    	
    	
    	for(int i = horaInicialInt; i <= horaFinalInt; i++) {
    		graficaIngresosDatos += " { label: \"" + i + "h\", y:" + importes[i] + " }," ;
    		graficaOcupacionDatos += " { label: \"" + i + "h\", y:" + ocupacion[i] + " }," ;
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
