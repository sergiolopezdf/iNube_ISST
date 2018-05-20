package es.upm.dit.isst.inube.dao;

import java.util.List;

import es.upm.dit.isst.inube.dao.model.Merchant;

public interface MerchantDAO {

    public Merchant loginMerchant(String merchantId);

    //CRUD
    public void createMerchant(Merchant merchant);

    public Merchant readMerchant(String merchantId);

    public void updateMerchant(Merchant merchant);

    public void deleteMerchant(Merchant merchant);
    
    public int getNumberOfMerchants();
}
