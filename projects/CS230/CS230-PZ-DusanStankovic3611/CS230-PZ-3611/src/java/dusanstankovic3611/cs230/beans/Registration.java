package dusanstankovic3611.cs230.beans;

import dusanstankovic3611.cs230.controller.UserController;
import dusanstankovic3611.cs230.entity.Role;
import dusanstankovic3611.cs230.entity.User;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Named
@RequestScoped
public class Registration {

    @PersistenceContext(unitName = "CS230-PZ-3611PU")
    private EntityManager em;

    @Inject
    private UserController uc;

    private String username = "";
    private String email = "";
    private String password = "";
    private String confPassword = "";
    private String firstName = "";
    private String lastName = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void validateUsername(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        String newUserName = (String) value;
        String oldUserName = "";
        try {
            oldUserName = (String) em.createNamedQuery("User.findUsername").setParameter("username", newUserName).getSingleResult();
        } catch (Exception ex) {
            oldUserName = "";
        }

        if (newUserName.equals(oldUserName)) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username already exists", "");
            throw new ValidatorException(facesMessage);
        }
    }

    public void validatePasswords(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        UIInput passwordComponent = (UIInput) component.getAttributes().get("passwordComponent");

        String pass = (String) passwordComponent.getValue();
        String confPass = (String) value;

        if (!confPass.equals(pass)) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords must match", "");
            throw new ValidatorException(facesMessage);
        }
    }

    public String register() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("ULAZAK U Register.register");
        try {
            System.out.println("UZIMAM SLEDECI ID ZA USER-a");
            int userID = (int) em.createNamedQuery("User.getNextid").getSingleResult();
            System.out.println("ID je " + userID);

            User user = new User(userID);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstname(firstName);
            user.setLastname(lastName);

            Role userRole = em.createNamedQuery("Role.findByRoleid", Role.class).setParameter("roleid", 2).getSingleResult();

            user.setRoleid(userRole);

            System.out.println("UPISUJEM...");
            if (uc.registerUser(user)) {
                System.out.println("UPISAO USERA");
                System.out.println("USPEH!");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You registered successfully", null));
                return "register";
            } else {
                System.out.println("NIJE PROSLA REGISTRACIJA. USER ERROR.");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "An error occured", null));
                return "register";

            }
        } catch (NoResultException e) {
            System.out.println("NEPOSTOJI KORISNIK SA USERNAME-om > " + username);
            return "index";
        }
    }
}
