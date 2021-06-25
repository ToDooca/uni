package dusanstankovic3611.cs230.beans;

import dusanstankovic3611.cs230.entity.Role;
import dusanstankovic3611.cs230.entity.User;
import dusanstankovic3611.cs230.util.Util;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

@Named
@ApplicationScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "CS230-PZ-3611PU")
    private EntityManager em;

    private String username;
    private String password;

    private Role role = null;
    private boolean loggedIn;

    private boolean regUser = false;
    private boolean admin = false;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isRegUser() {
        return regUser;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String login() {
        User user = null;
        boolean isValid = false;
        System.out.println("USAO SAM U LOGIN METODU");
        try {
            user = (User) em.createNamedQuery("User.findByUsername").setParameter("username", username).getSingleResult();
            System.out.println("POSTOJI KORISNIK SA USERNAME-om > " + username);
            isValid = validatePassword(user);
        } catch (NoResultException e) {
            System.out.println("NEPOSTOJI KORISNIK SA USERNAME-om > " + username);
            isValid = false;
        }

        if (isValid) {
            HttpSession session = Util.getSession();
            session.setMaxInactiveInterval(100 * 9999);

            System.out.println("KREIRAMO SESIJU");
            System.out.println("ID SESIJE :" + session.getId());

            session.setAttribute("user", user);
            System.out.println("SETUJEMO ATRIBUT SESIJE -user- u " + user);
            System.out.println("ATRIBUT SESIJE -user- : " + session.getAttribute("user"));

            session.setAttribute("userid", user.getUserid());
            System.out.println("SETUJEMO ATRIBUT SESIJE -userid- u " + user.getUserid());
            System.out.println("ATRIBUT SESIJE -userid- : " + session.getAttribute("userid"));

            session.setAttribute("role", user.getRoleid().getRolename());
            System.out.println("SETUJEMO ATRIBUT SESIJE -role- u " + user.getRoleid().getRolename());
            System.out.println("ATRIBUT SESIJE -role- : " + session.getAttribute("role"));

            loggedIn = true;
            System.out.println("KORISNIK JE LOGOVAN");

            if (user.getRoleid().getRolename().equalsIgnoreCase("admin")) {
                System.out.println("AKO JE ADMIN IDEMO NA ADMIN DASHBOARD");
                regUser = false;
                admin = true;
                return "admin/dashboard.xhtml?faces-redirect=true";
            } else {
                System.out.println("AKO JE USER IDEMO NA NJEGOV PROFIL");
                regUser = true;
                admin = false;
                return "welcome.xhtml?faces-redirect=true";
            }
        } else {
            System.out.println("USER NIJE VALIDAN, VRATI GA NA LOGIN");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Bad request", "Please check your account credentials and try again."));
            return "login";
        }
    }

    private boolean validatePassword(User user) {
        if (user.getPassword().equals(password)) {
            System.out.println("SIFRA JE DOBRA");
            return true;
        }
        System.out.println("SIFRA NIJE DOBRA");
        return false;
    }

    public String logout() {
        clearData();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("user");
        context.getExternalContext().getSessionMap().remove("userid");
        context.getExternalContext().getSessionMap().remove("role");
        context.getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    private void clearData() {
        username = "";
        password = "";
        role = null;
        loggedIn = false;
        regUser = false;
        admin = false;
    }
}
