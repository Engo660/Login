package dad.login;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController {

	private LoginModel model = new LoginModel();
	private LoginView view = new LoginView();

	public LoginController() {

		view.getUsuarioText().textProperty().bindBidirectional(model.usuarioProperty());
		view.getPassText().textProperty().bindBidirectional(model.passProperty());
		view.getLDAPCheck().selectedProperty().bindBidirectional(model.ldapCheckProperty());
		view.getAccederButton().setOnAction(e -> onAccederAction(e));
		view.getCancelarButton().setOnAction(e -> onCancelarAction(e));

	}

	private void onCancelarAction(ActionEvent e) {
		System.exit(0);
	}

	private void onAccederAction(ActionEvent e) {

		AuthService ldap = model.isLDAPChecked() ? new LdapAuthService() : new FileAuthService();

		try {
			if (ldap.login(model.getUsuarioProperty(), model.getPassProperty()) == true) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Iniciar sesión");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText("Las credenciales de acceso son válidas");
				alert.showAndWait();

			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Iniciar sesion");
				alert.setHeaderText("Acceso denegado");
				alert.setContentText("El usuario y/o contraseña no son válidos");
				alert.showAndWait();
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
	}

	public LoginView getView() {
		return view;
	}

	public LoginModel getModel() {
		return model;
	}

}
