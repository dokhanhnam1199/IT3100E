package aims.screen.manager;
import javax.swing.*;
import aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JLabel directorLabel;
    private JLabel lengthLabel;
    private JLabel artistLabel;
    private JTextField directorField;
    private JTextField lengthField;
    private JTextField artistField;
    public AddCompactDiscToStoreScreen(StoreManagerScreen parentScreen) {
    	super(parentScreen);
    }
    @Override
    public void initComponents() {
    	super.initComponents();
    	directorLabel =new JLabel("Director:");
        directorField = new JTextField();
        lengthLabel = new JLabel("Length: ");
        lengthField = new JTextField();
        artistLabel = new JLabel("Artist:");
        artistField = new JTextField();
        getLabelTextFields().add(new LabelTextField(directorLabel, directorField));
        getLabelTextFields().add(new LabelTextField(lengthLabel, lengthField));
        getLabelTextFields().add(new LabelTextField(artistLabel, artistField));
    }
    @Override // Xử Lý sự kiện
    void addMediaToStore() {
    	parentScreen.getStore().addMedia(new CompactDisc(Integer.parseInt(getIdField().getText()),getTitleField().getText(),getCategoryField().getText(),Float.parseFloat(getCostField().getText()),Integer.parseInt(lengthField.getText()),directorField.getText(),artistField.getText()));
    	super.addMediaToStore();
    }
    
}

