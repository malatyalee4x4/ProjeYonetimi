package projeyonetim.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import projeyonetim.entity.Kullanici;
import projeyonetim.service.KullaniciService;

@ManagedBean
@SessionScoped
public class KullaniciBean implements Serializable {

    private Kullanici kullanici = new Kullanici();

    @EJB
    private KullaniciService kullaniciService;

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public KullaniciBean() {
    }

    public String giriseYetkilimi() {

        boolean yetkilimi = kullaniciService.girisKontrol(kullanici);
        String isim = kullanici.getKullaniciadi();
        
        if (yetkilimi) {
           
            return "AnaSayfa.xhtml";

        } else {
            
            RequestContext.getCurrentInstance().update("msg");
           FacesContext context=FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"HATA","Kullanıcı adı veya şifre hatalı"));
            return "Login.xhtml";

        }
    
    }

}
