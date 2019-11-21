package dad.template.javafx;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InicioController implements Initializable {
	 
    @FXML
    private BorderPane root;

    @FXML
    private VBox vertiBox;

    @FXML
    private HBox usuarioBox;

    @FXML
    private TextField usuarioText;

    @FXML
    private HBox contraBox;

    @FXML
    private PasswordField contraText;

    @FXML
    private HBox butonBox;

    @FXML
    private Button accederButon;

    @FXML
    private Button cancelarButon;

    @FXML
    void OnCancelar(ActionEvent event) {
    	cerrar();
    }

    @FXML
    void onAcceder(ActionEvent event) {
    	


    	      BufferedReader br = null;
    	      int cont =0;
    	      try {
    	         
    	         br =new BufferedReader(new FileReader("D:\\Users\\Profesor\\eclipse-workspace\\inicioMVC\\src\\main\\resources\\contra\\contra.csv"));
    	         String line = br.readLine();
    	         while (null!=line) {
    	            String [] fields = line.split(",");
    	            if((fields[0].equals(usuarioText.getText())) && (fields[1].equals(DigestUtils.md5Hex(contraText.getText()).toUpperCase()))) {
    	            	cont=1;
    	            	Alert alert = new Alert(AlertType.INFORMATION);
    	            	alert.setTitle("Iniciar sesión");
    	            	alert.setHeaderText("Acceso permitido.");
    	            	alert.setContentText("Las credenciales son validas.");

    	            	alert.showAndWait();
    	            	cerrar();
    	            }
    	            line = br.readLine();
    	         }
    	         if(cont==0) {
    	        	 Alert alert = new Alert(AlertType.ERROR);
    	        	 alert.setTitle("Iniciar sesión");
    	        	 alert.setHeaderText("Acceso denegado");
    	        	 alert.setContentText("La contraseña y/o usuario son erroneos");

    	        	 alert.showAndWait();
    	        	 contraText.setText("");
    	         }
    	        	 
    	        	 
    	         
    	      } catch (Exception e) {
    	         try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    	      }

    }
	
	private void cerrar() {
		Stage stage = (Stage) cancelarButon.getScene().getWindow();
	    stage.close();
		
	}

	public InicioController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InicioView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public BorderPane getRoot() {
		return root;
	}

}
