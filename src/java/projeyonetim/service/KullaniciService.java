
package projeyonetim.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import projeyonetim.entity.Kullanici;
import projeyonetim.facade.KullaniciFacade;

@Stateless
public class KullaniciService {
    @EJB
    KullaniciFacade kullaniciFacade;
    
    public boolean girisKontrol(Kullanici kullanici)
    {
        return kullaniciFacade.girisKontrol(kullanici);
    }
}
