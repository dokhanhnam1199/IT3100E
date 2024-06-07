package aims.screen.manager;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aims.cart.Cart;


public class CartManagerScreen extends JFrame {
	private Cart cart;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public CartManagerScreen(Cart cart) {
		this.cart = cart;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	public Cart getCart() {
		return cart;
	}

}
