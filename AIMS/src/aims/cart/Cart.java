package aims.cart;
import java.util.Collections;
import java.util.Comparator;

import javax.naming.LimitExceededException;

import aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart  {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	@SuppressWarnings("unused")
	private static final int MAX_NUMBERS_ORDERED =1000;
	private int qtyOrdered = 0;
	
	public void addMedia(Media media) throws LimitExceededException  {
		if( itemsOrdered.size() <  MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			qtyOrdered++;
			System.out.println("The media has been added!");
		}
		else {
			throw new LimitExceededException("ERROR: The number of"+ "media has reached its limit");
		}

	}
	
	public void removeMedia(Media media) {
		itemsOrdered.remove(media);
		qtyOrdered--;
		System.out.println("The media has been removed!");
	}

	public ObservableList< Media > getItemsOrdered() {
		return itemsOrdered;
	}

	public float totalCost() {
		float total=0;
		for(Media media : itemsOrdered) {
			total+=media.getCost();
		}
		return total;
	}

	public void searchByID(int id) {
		for(Media media : itemsOrdered) {
			if(media.getId() == id){
				System.out.println(media.toString());
			}
		}
		System.out.println("Can't found this DVD\n");
	}

	@SuppressWarnings("unlikely-arg-type")
	public Media searchByTitle(String title) {
		for(Media media : itemsOrdered) {
			if(media.equals(title)) {
				System.out.println(media.toString());
				return media;
			}
			
		}
		System.out.println("Can't found this DVD\n");
		return null;
	}

	public void sortPrint(Comparator<Media> comparator) {
		Cart cartClone = new Cart();
		cartClone.itemsOrdered.addAll(itemsOrdered);
		Collections.sort(cartClone.itemsOrdered,comparator);
		cartClone.print();
	}
	public void reset() {
		itemsOrdered.clear();
	}
	// In ra thông tin chi tiết đơn hàng
	public void print() {
		int stt=0;
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		System.out.printf("%5s%-5s%-5s%-20s%-10s%5s\n","STT","Type","ID","Title","Category","Cost");
		for(Media media : itemsOrdered) {
			stt++;
			System.out.printf("%5d%s\n",stt,media.toString());
		}
		System.out.printf("%45s,%5f\n","Total Cost",totalCost());
		System.out.println("***************************************************");
	}
	
}
