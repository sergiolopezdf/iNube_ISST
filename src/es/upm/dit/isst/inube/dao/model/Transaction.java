package es.upm.dit.isst.inube.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Transaction implements Serializable {

    @Id
    private int transactionId;

    private float importe;
    private String fecha;
    private String hora;

    @ManyToOne
    private Client client;

	@ManyToOne
    private Merchant merchant;


    public Transaction() {

    }

    public int getTransactionId() {

        return transactionId;
    }

    public void setTransactionId(int idTransaction) {

        this.transactionId = idTransaction;
    }

    public float getImporte() {

        return importe;
    }

    public void setImporte(float importe) {

        this.importe = importe;
    }

    public String getFecha() {

        return fecha;
    }

    public void setFecha(String fecha) {

        this.fecha = fecha;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
}
