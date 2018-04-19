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
    private Date fecha;

    @ManyToOne
    private Client client;


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

    public Date getFecha() {

        return fecha;
    }

    public void setFecha(Date fecha) {

        this.fecha = fecha;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
