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
@Table(name = "problem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Problem.findAll", query = "SELECT p FROM Problem p")
    , @NamedQuery(name = "Problem.findByProblemid", query = "SELECT p FROM Problem p WHERE p.problemid = :problemid")
    , @NamedQuery(name = "Problem.findByProblemname", query = "SELECT p FROM Problem p WHERE p.problemname = :problemname")})
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROBLEMID")
    private Integer problemid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 612)
    @Column(name = "PROBLEMNAME")
    private String problemname;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "PROBLEMDETALIS")
    private String problemdetalis;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private User userid;

    public Problem() {
    }

    public Problem(Integer problemid) {
        this.problemid = problemid;
    }

    public Problem(Integer problemid, String problemname, String problemdetalis) {
        this.problemid = problemid;
        this.problemname = problemname;
        this.problemdetalis = problemdetalis;
    }

    public Integer getProblemid() {
        return problemid;
    }

    public void setProblemid(Integer problemid) {
        this.problemid = problemid;
    }

    public String getProblemname() {
        return problemname;
    }

    public void setProblemname(String problemname) {
        this.problemname = problemname;
    }

    public String getProblemdetalis() {
        return problemdetalis;
    }

    public void setProblemdetalis(String problemdetalis) {
        this.problemdetalis = problemdetalis;
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
        hash += (problemid != null ? problemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Problem)) {
            return false;
        }
        Problem other = (Problem) object;
        if ((this.problemid == null && other.problemid != null) || (this.problemid != null && !this.problemid.equals(other.problemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dusanstankovic3611.cs230.entity.Problem[ problemid=" + problemid + " ]";
    }
    
}
