package dusanstankovic3611.cs230.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p")
    , @NamedQuery(name = "Place.findByPlaceid", query = "SELECT p FROM Place p WHERE p.placeid = :placeid")
    , @NamedQuery(name = "Place.findByPlacename", query = "SELECT p FROM Place p WHERE p.placename = :placename")
    , @NamedQuery(name = "Place.findByPlaceadress", query = "SELECT p FROM Place p WHERE p.placeadress = :placeadress")
    , @NamedQuery(name = "Place.findByPlacetype", query = "SELECT p FROM Place p WHERE p.placetype = :placetype")})
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLACEID")
    private Integer placeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 612)
    @Column(name = "PLACENAME")
    private String placename;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "PLACEDESCRIPTION")
    private String placedescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "PLACEADRESS")
    private String placeadress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 612)
    @Column(name = "PLACETYPE")
    private String placetype;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private User userid;

    public Place() {
    }

    public Place(Integer placeid) {
        this.placeid = placeid;
    }

    public Place(Integer placeid, String placename, String placedescription, String placeadress, String placetype) {
        this.placeid = placeid;
        this.placename = placename;
        this.placedescription = placedescription;
        this.placeadress = placeadress;
        this.placetype = placetype;
    }

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getPlacedescription() {
        return placedescription;
    }

    public void setPlacedescription(String placedescription) {
        this.placedescription = placedescription;
    }

    public String getPlaceadress() {
        return placeadress;
    }

    public void setPlaceadress(String placeadress) {
        this.placeadress = placeadress;
    }

    public String getPlacetype() {
        return placetype;
    }

    public void setPlacetype(String placetype) {
        this.placetype = placetype;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placeid != null ? placeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.placeid == null && other.placeid != null) || (this.placeid != null && !this.placeid.equals(other.placeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dusanstankovic3611.cs230.entity.Place[ placeid=" + placeid + " ]";
    }
    
}
