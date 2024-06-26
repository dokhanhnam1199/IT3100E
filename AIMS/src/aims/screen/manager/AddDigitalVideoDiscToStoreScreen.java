package aims.screen.manager;
import javax.swing.*;
import aims.media.DigitalVideoDisc;
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JLabel directorLabel;
    private JLabel lengthLabel;
    private JTextField directorField;
    private JTextField lengthField;
    public AddDigitalVideoDiscToStoreScreen(StoreManagerScreen parentScreen) {
    	super(parentScreen);
    }
    @Override
    public void initComponents() {
    	super.initComponents();
    	directorLabel =new JLabel("Director:");
        directorField = new JTextField();
        lengthLabel = new JLabel("Length: ");
        lengthField = new JTextField();
        getLabelTextFields().add(new LabelTextField(directorLabel, directorField));
        getLabelTextFields().add(new LabelTextField(lengthLabel, lengthField));
    }
    @Override // Xử Lý sự kiện
    void addMediaToStore() {
    	parentScreen.getStore().addMedia(new DigitalVideoDisc(Integer.parseInt(getIdField().getText()),getTitleField().getText(),getCategoryField().getText(),Float.parseFloat(getCostField().getText()),Integer.parseInt(lengthField.getText()), directorField.getText()));
    	super.addMediaToStore();
    }   
}

