package aims.screen.customer.controller;


import java.io.IOException;

import javax.naming.LimitExceededException;

import aims.cart.Cart;
import aims.media.Disc;
import aims.media.Media;
import aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ItemController {
	
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    @FXML
    void btnAddToCartClicked(ActionEvent event) {
    	try {
            cart.addMedia(this.media);
            showSuccessDialog("Media added successfully");
        } catch (LimitExceededException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	try {
			final String STORE_FXML_FILE_PATH = "/aims/screen/customer/view/Playing.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			fxmlLoader.setController(new PlayController((Disc)media));//
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			
			stage.setScene(new Scene(root));
			stage.setTitle("Play Disc");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private Media media;
    private Cart cart;
    public ItemController(Cart cart) {
    	this.cart = cart;
	}
    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost()+"$");
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    		
    	}else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0,0,0,120));
		}
    }

	private void showSuccessDialog(String message) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Notification");
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.initStyle(StageStyle.UTILITY);
	    alert.showAndWait();
	}  
}