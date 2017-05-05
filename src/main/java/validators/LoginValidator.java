package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;

@FacesValidator("validators.LoginValidator")
public class LoginValidator implements Validator {
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        String userName = o.toString().trim();
        if (userName.length() < 5)
        {
            FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("login_length_error"));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
        else if (!Character.isLetter(userName.charAt(0)))
        {
            FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("letter_begin_error"));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
        else if (userName.equals("username") || userName.equals("login"))
        {
            FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("wrong_name_error"));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
    }
}
