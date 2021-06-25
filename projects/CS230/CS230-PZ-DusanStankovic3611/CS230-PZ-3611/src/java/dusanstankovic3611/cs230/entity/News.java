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
@Table(name = "news")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n")
    , @NamedQuery(name = "News.findByNewsid", query = "SELECT n FROM News n WHERE n.newsid = :newsid")
    , @NamedQuery(name = "News.findByNewstitle", query = "SELECT n FROM News n WHERE n.newstitle = :newstitle")
    , @NamedQuery(name = "News.findByNewsdate", query = "SELECT n FROM News n WHERE n.newsdate = :newsdate")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NEWSID")
    private Integer newsid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 612)
    @Column(name = "NEWSTITLE")
    private String newstitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 612)
    @Column(name = "NEWSDATE")
    private String newsdate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "NEWSTEXT")
    private String newstext;
    @OneToMany(mappedBy = "newsid")
    private Collection<Comment> commentCollection;

    public News() {
    }

    public News(Integer newsid) {
        this.newsid = newsid;
    }

    public News(Integer newsid, String newstitle, String newsdate, String newstext) {
        this.newsid = newsid;
        this.newstitle = newstitle;
        this.newsdate = newsdate;
        this.newstext = newstext;
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewsdate() {
        return newsdate;
    }

    public void setNewsdate(String newsdate) {
        this.newsdate = newsdate;
    }

    public String getNewstext() {
        return newstext;
    }

    public void setNewstext(String newstext) {
        this.newstext = newstext;
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
        hash += (newsid != null ? newsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsid == null && other.newsid != null) || (this.newsid != null && !this.newsid.equals(other.newsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dusanstankovic3611.cs230.entity.News[ newsid=" + newsid + " ]";
    }
    
}
