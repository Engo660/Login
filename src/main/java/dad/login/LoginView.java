package dad.login;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class LoginView extends GridPane {

	TextField usuarioText;
	PasswordField passText;
	Button accederButton;
	Button cancelarButton;
	CheckBox ldapCheck;

	public LoginView() {
		super();

		usuarioText = new TextField();
		usuarioText.setMaxWidth(150);
		usuarioText.setAlignment(Pos.BASELINE_LEFT);

		passText = new PasswordField();
		passText.setMaxWidth(150);
		passText.setAlignment(Pos.BASELINE_LEFT);

		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		cancelarButton = new Button("Cancelar");

		ldapCheck = new CheckBox("Usar LDAP");

		HBox buttonBox = new HBox();
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(5);
		buttonBox.setPadding(new Insets(5));
		buttonBox.getChildren().addAll(accederButton, cancelarButton);

		setPadding(new Insets(5));
		setVgap(5);
		setAlignment(Pos.CENTER);
		addRow(0, new Label("Usuario: "), usuarioText);
		addRow(1, new Label("Contraseña: "), passText);
		addRow(2, ldapCheck);
		addRow(3, buttonBox);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints() };
		getColumnConstraints().setAll(cols);

		cols[0].setHalignment(HPos.RIGHT);
		cols[0].setHgrow(Priority.ALWAYS);
		cols[0].setFillWidth(false);

		cols[1].setHalignment(HPos.LEFT);
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);

		setHalignment(ldapCheck, HPos.CENTER);
		setHalignment(buttonBox, HPos.CENTER);
		setColumnSpan(ldapCheck, REMAINING);
		setColumnSpan(buttonBox, REMAINING);

	}

	public CheckBox getLDAPCheck() {
		return ldapCheck;
	}

	public TextField getUsuarioText() {
		return usuarioText;
	}

	public PasswordField getPassText() {
		return passText;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

}
