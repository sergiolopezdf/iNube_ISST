package es.upm.dit.isst.inube.dao.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Serializable {

    @Id
    private int clientId;
    private int codigoPostal;

    @OneToMany (mappedBy = "client", fetch = FetchType.EAGER)
    private List<Transaction> transactions;



    public Client() {
        this.transactions = new ArrayList<>();
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int idClient) {
        this.clientId = idClient;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


}



