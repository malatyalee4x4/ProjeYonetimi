/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeyonetim.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import projeyonetim.entity.Kullanici;

/**
 *
 * @author cumali.gurgun
 */
@Stateless
public class KullaniciFacade extends AbstractFacade<Kullanici> {
    @PersistenceContext(unitName = "ProjeYonetimiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KullaniciFacade() {
        super(Kullanici.class);
    }
    
    public boolean girisKontrol(Kullanici k)
    {
        Kullanici k1=em.createNamedQuery("Kullanici.kullaniciKontrol", Kullanici.class)
                .setParameter("kullaniciadi",k.getKullaniciadi())
                .setParameter("sifre", k.getSifre())
                .getSingleResult();
        
        if(k1!=null)
        {
           return true; 
        }
        else
        {
            return false;
        }
        
    }
    
}
