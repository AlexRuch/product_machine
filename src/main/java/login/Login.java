package login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by ralex on 01.07.16.
 */
@ManagedBean
@RequestScoped
public class Login {

    public Login() {
    }

    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    public void logout() throws IOException {
        externalContext.invalidateSession();
        externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
    }

    public String current_user_email() {
        return externalContext.getRemoteUser();
    }
}