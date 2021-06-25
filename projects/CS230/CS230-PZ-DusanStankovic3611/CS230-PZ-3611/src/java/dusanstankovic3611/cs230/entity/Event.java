package dusanstankovic3611.cs230.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
    , @NamedQuery(name = "Event.findByEventid", query = "SELECT e FROM Event e WHERE e.eventid = :eventid")
    , @NamedQuery(name = "Event.findByEventtitle", query = "SELECT e FROM Event e WHERE e.eventtitle = :eventtitle")
    , @NamedQuery(name = "Event.findByEventdate", query = "SELECT e FROM Event e WHERE e.eventdate = :eventdate")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EVENTID")
    private Integer eventid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 612)
    @Column(name = "EVENTTITLE")
    private String eventtitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "EVENTDATE")
    private String eventdate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "EVENTTEXT")
    private String eventtext;
    @OneToMany(mappedBy = "eventid")
    private Collection<Comment> commentCollection;

    public Event() {
    }

    public Event(Integer eventid) {
        this.eventid = eventid;
    }

    public Event(Integer eventid, String eventtitle, String eventdate, String eventtext) {
        this.eventid = eventid;
        this.eventtitle = eventtitle;
        this.eventdate = eventdate;
        this.eventtext = eventtext;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getEventtitle() {
        return eventtitle;
    }

    public void setEventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventtext() {
        return eventtext;
    }

    public void setEventtext(String eventtext) {
        this.eventtext = eventtext;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventid != null ? eventid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventid == null && other.eventid != null) || (this.eventid != null && !this.eventid.equals(other.eventid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dusanstankovic3611.cs230.entity.Event[ eventid=" + eventid + " ]";
    }
    
}
