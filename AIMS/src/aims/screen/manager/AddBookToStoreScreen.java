package aims.screen.manager;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import aims.media.Book;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    private JLabel authorsLabel;
    private JTextField authorsField;
    ArrayList<String> authors;
    public AddBookToStoreScreen(StoreManagerScreen parentScreen) {
    	super(parentScreen);
    }
    @Override
    public void initComponents() {
    	super.initComponents();
        authorsLabel = new JLabel("Authors:");
        authorsField = new JTextField();
        authors = new ArrayList<>(Arrays.asList(authorsField.getText().split("\\s*,\\s*")));
        getLabelTextFields().add(new LabelTextField(authorsLabel, authorsField));
 
    }
    @Override
    void addMediaToStore() {
    	parentScreen.getStore().addMedia(new Book(Integer.parseInt(getIdField().getText()),getTitleField().getText(),getCategoryField().getText(),Float.parseFloat(getCostField().getText()),authors));
    	parentScreen.getStore().print();
    	super.addMediaToStore();
    }
    
}