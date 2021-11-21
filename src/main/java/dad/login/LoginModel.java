package dad.login;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty pass = new SimpleStringProperty();
	private BooleanProperty ldapCheck = new SimpleBooleanProperty();

	public final StringProperty usuarioProperty() {
		return usuario;
	}

	public String getUsuarioProperty() {
		return usuarioProperty().get();
	}

	public void setUsuarioProperty(String a) {
		usuarioProperty().set(a);
	}

	public StringProperty passProperty() {
		return pass;
	}

	public String getPassProperty() {
		return passProperty().get();
	}

	public void setPassProperty(String a) {
		passProperty().set(a);
	}

	public BooleanProperty ldapCheckProperty() {
		return ldapCheck;
	}

	public boolean isLDAPChecked() {
		return ldapCheckProperty().get();
	}

	public void setLDAPCheck(boolean a) {
		ldapCheckProperty().set(a);
	}

}
