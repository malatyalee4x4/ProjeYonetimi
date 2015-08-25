/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeyonetim.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cumali.gurgun
 */
@Entity
@Table(name = "kullanici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k"),
    @NamedQuery(name = "Kullanici.kullaniciKontrol", query = "SELECT k FROM Kullanici k WHERE k.kullaniciadi = :kullaniciadi and k.sifre = :sifre"),
    @NamedQuery(name = "Kullanici.findByKullaniciid", query = "SELECT k FROM Kullanici k WHERE k.kullaniciid = :kullaniciid"),
    @NamedQuery(name = "Kullanici.findByKullaniciadi", query = "SELECT k FROM Kullanici k WHERE k.kullaniciadi = :kullaniciadi"),
    @NamedQuery(name = "Kullanici.findBySifre", query = "SELECT k FROM Kullanici k WHERE k.sifre = :sifre")})
public class Kullanici implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "kullaniciid")
    private Integer kullaniciid;
    @Size(max = 255)
    @Column(name = "kullaniciadi")
    private String kullaniciadi;
    @Size(max = 255)
    @Column(name = "sifre")
    private String sifre;

    public Kullanici() {
    }

    public Kullanici(Integer kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public Integer getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(Integer kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciid != null ? kullaniciid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.kullaniciid == null && other.kullaniciid != null) || (this.kullaniciid != null && !this.kullaniciid.equals(other.kullaniciid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projeyonetim.entity.Kullanici[ kullaniciid=" + kullaniciid + " ]";
    }
    
}
