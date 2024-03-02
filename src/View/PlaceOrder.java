/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Model.Orders;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.*;
/**
 *
 * @author asanka
 */
public class PlaceOrder extends JFrame implements KeyListener{
    

		private JLabel titleLabel, orderId, customerId, burgerQty, orderStatus, netTotal, name, total, msg;
		private JTextField cusName, qty, cusId;
		private JButton placeOrder, back, cancel;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
                public Controller controller=new Controller();

	
		public PlaceOrder() {
			setSize(700, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(null);
			setUndecorated(true);

			addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent e) {
					
					
				}
	
				@Override
				public void windowClosing(WindowEvent e) {
					
				}
	
				@Override
				public void windowClosed(WindowEvent e) {
					
				}
	
				@Override
				public void windowActivated(WindowEvent e) {
					if (controller.list.size()==0) {
						cusId.setEnabled(false);
						
					}else{
						
						cusId.setEnabled(true);
					}
					
				}
	
				@Override
				public void windowDeactivated(WindowEvent e) {
					
				}
			});
			JPanel titlePanel = new JPanel();
			titlePanel.setLayout(null);
			titlePanel.setBounds(0, 0, 700, 50);
			titlePanel.setBackground(c1);

			JPanel orderPanel = new JPanel();
			orderPanel.setLayout(null);
			orderPanel.setBounds(0, 50, 700, 350);
			orderPanel.setBackground(c2);

			titleLabel = new JLabel("Place Order");
			titleLabel.setForeground(c2);
			titleLabel.setBounds(300, 15, 300, 20);
			titleLabel.setFont(new Font("", 1, 20));
			titlePanel.add(titleLabel);
			add(titlePanel);

			orderId = new JLabel("Order Id: ");
			orderId.setFont(new Font("Arial", 1, 15));
			orderId.setBounds(100, 50, 100, 20);
			orderPanel.add(orderId);

			JLabel oId = new JLabel(generateOrderId());
			oId.setFont(new Font("Arial", 1, 15));
			oId.setBounds(220, 50, 100, 20);
			orderPanel.add(oId);

			customerId = new JLabel("Customer Id: ");
			customerId.setFont(new Font("Arial", 1, 15));
			customerId.setBounds(100, 80, 100, 20);
			orderPanel.add(customerId);

			cusId = new JTextField(generateCustomerId());
			cusId.setFont(new Font("Arial", 1, 15));
			cusId.setBounds(220, 80, 100, 20);
			cusId.setBorder(null);
			cusId.addKeyListener(this);
			orderPanel.add(cusId);

			name = new JLabel("Name: ");
			name.setFont(new Font("Arial", 1, 15));
			name.setBounds(100, 110, 100, 20);
			orderPanel.add(name);

			cusName = new JTextField();
			cusName.setFont(new Font("Arial", 1, 15));
			cusName.setBounds(220, 110, 100, 20);
			cusName.setBorder(null);
			cusName.addKeyListener(this);
			orderPanel.add(cusName);

			burgerQty = new JLabel("Burger QTY: ");
			burgerQty.setFont(new Font("Arial", 1, 15));
			burgerQty.setBounds(100, 140, 100, 20);
			orderPanel.add(burgerQty);

			qty = new JTextField();
			qty.setFont(new Font("Arial", 1, 15));
			qty.setBounds(220, 140, 100, 20);
			qty.setBorder(null);
			qty.addKeyListener(this);
			orderPanel.add(qty);

			msg = new JLabel();
			msg.setFont(new Font("Arial", 1, 10));
			msg.setBounds(220, 154, 170, 20);
			msg.setForeground(Color.RED);
			orderPanel.add(msg);

			orderStatus = new JLabel("Order Status: ");
			orderStatus.setFont(new Font("Arial", 1, 15));
			orderStatus.setBounds(100, 170, 110, 20);
			orderPanel.add(orderStatus);

			JLabel status = new JLabel("Pending...");
			status.setFont(new Font("Arial", 1, 15));
			status.setBounds(220, 170, 110, 20);
			orderPanel.add(status);

			placeOrder = new JButton("Place Order");
			placeOrder.setFont(new Font("Arial", 1, 15));
			placeOrder.setBounds(450, 70, 180, 30);
			placeOrder.setBackground(c2);
			placeOrder.setForeground(c1);
			placeOrder.setBorder(BorderFactory.createLineBorder(c1));
			orderPanel.add(placeOrder);

			back = new JButton("Back to Home Page");
			back.setFont(new Font("Arial", 1, 12));
			back.setBounds(450, 120, 180, 30);
			back.setBackground(c1);
			back.setForeground(c2);
			orderPanel.add(back);

			cancel = new JButton("Cancel");
			cancel.setFont(new Font("Arial", 1, 15));
			cancel.setBounds(450, 170, 180, 30);
			cancel.setBackground(c1);
			cancel.setForeground(c2);
			orderPanel.add(cancel);

			netTotal = new JLabel("Net Total: ");
			netTotal.setFont(new Font("Arial", 1, 15));
			netTotal.setBounds(450, 225, 100, 30);
			orderPanel.add(netTotal);

			total = new JLabel();
			total.setFont(new Font("Arial", 1, 15));
			total.setBounds(530, 225, 100, 30);
			total.setForeground(Color.RED);
			orderPanel.add(total);

			JLabel x=new JLabel("X");
			x.setFont(new Font("Arial", 1, 20));
			x.setBounds(680, 0, 100, 30);
			x.setForeground(c2);
			titlePanel.add(x);

			x.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

					x.setForeground(Color.RED);
					
					
				}
	
				@Override
				public void mouseExited(MouseEvent e) {
					x.setForeground(c2);
				}
	
				@Override
				public void mouseClicked(MouseEvent e) {
					int response=JOptionPane.showConfirmDialog(null, "Are you sure want to exit?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});

			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					controller.home.setVisible(true);
					setVisible(false);
				}
			});
			placeOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					if (cusName.getText().equals("")) {

						cusName.setBorder(BorderFactory.createLineBorder(Color.RED));

					}
					if (qty.getText().equals("")) {
						qty.setBorder(BorderFactory.createLineBorder(Color.RED));
					} else if (!cusName.getText().equals("")) {

						try {

							int bQTY = Integer.parseInt(qty.getText());
							if (bQTY == 0) {
								qty.setBorder(BorderFactory.createLineBorder(Color.RED));
								msg.setText("*Quantity must be greater than 0");
							} else {
								qty.setBorder(null);
								cusName.setBorder(null);

								double price = bQTY * 500;
								Orders newOrder;
                                                            newOrder = new Orders(oId.getText(), cusId.getText(), cusName.getText(), bQTY,price, 1);
								controller.list.add(newOrder);
								cusId.setText(generateCustomerId());
								cusName.setText("");
								qty.setText("");
								oId.setText(generateOrderId());
								msg.setText("");
								total.setText("");
								cusName.setEnabled(true);
								JOptionPane.showMessageDialog(null, "Order placed successfully..!!!", "Placed",
										JOptionPane.INFORMATION_MESSAGE);

							}

						} catch (NumberFormatException e) {
							qty.setBorder(BorderFactory.createLineBorder(Color.RED));
							msg.setText("*Enter a valid number..!!!");
						}

					}

				}
			});
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					cusName.setText("");
					qty.setText("");
					total.setText("");
					qty.setBorder(null);
					msg.setText("");
					cusName.setBorder(null);
				}
			});

			add(orderPanel);
		}

		public String generateOrderId() {

			if (controller.list.size() == 0) {
				return "O0001";
			}
			String lastOrderId = controller.list.get(controller.list.size() - 1).getOrderId();
			int number = Integer.parseInt(lastOrderId.split("O")[1]);
			number++;// 2
			return String.format("O%04d", number);
		}

		private int index() {
			int index = 0;
			for (int i = 0; i < controller.list.size(); i++) {
				if (Integer.parseInt(controller.list.get(i).getCustomerId().split("C")[1]) > Integer
						.parseInt(controller.list.get(index).getCustomerId().split("C")[1])) {
					index = i;
				}
			}
			return index;
		}

		public String generateCustomerId() {

			int index = 0;
			if (controller.list.size() == 0) {
				return "C0001";
			}
			for (int i = 0; i < controller.list.size(); i++) {
				if (Integer.parseInt(controller.list.get(i).getCustomerId().split("C")[1]) > Integer
						.parseInt(controller.list.get(index).getCustomerId().split("C")[1])) {
					index = i;
				}
			}
			String lastOrderId = controller.list.get(index).getCustomerId();
			int number = Integer.parseInt(lastOrderId.split("C")[1]);
			number++;// 2
			return String.format("C%04d", number);
		}

		public void keyReleased(KeyEvent e) {

			boolean isExist = false;
			if (e.getSource() == cusId) {
				if (controller.list.size()>0) {
					try {
						if (cusId.getText().length()>5 || cusId.getText().length()<5 || cusId.getText().charAt(0) != 'C'
				|| Integer.parseInt(cusId.getText().split("C")[1]) == 0
				|| Integer.parseInt(controller.list.get(index()).getCustomerId().split("C")[1]) + 1 < Integer
						.parseInt(cusId.getText().split("C")[1])) {
					placeOrder.setEnabled(false);
					cusId.setBorder(BorderFactory.createLineBorder(Color.RED));
					
				}else{
					cusName.setEnabled(true);
				}
					} catch (NumberFormatException er) {
						cusId.setBorder(BorderFactory.createLineBorder(Color.RED));
						placeOrder.setEnabled(false);
					}
				
				
				
			}
				try {
					if (cusId.getText().length() == 5 && cusId.getText().charAt(0) == 'C'
							&& Integer.parseInt(cusId.getText().split("C")[1]) > 0
							&& Integer.parseInt(controller.list.get(index()).getCustomerId().split("C")[1]) + 1 >= Integer
									.parseInt(cusId.getText().split("C")[1])) {
						cusId.setBorder(null);
						for (int i = 0; i < controller.list.size(); i++) {
							if (cusId.getText().equals(controller.list.get(i).getCustomerId())) {
								cusName.setText(controller.list.get(i).getCustomerName());
								cusName.setEnabled(false);
								isExist = true;
							}
						}
						if (!isExist) {
							
							cusName.setText("");
						}
					}

				} catch (Exception er) {
					cusId.setBorder(BorderFactory.createLineBorder(Color.RED));
					// placeOrder.setEnabled(false);
				}

			}
			cusName.setBorder(null);
			qty.setBorder(null);

			if (e.getSource() == qty) {
				try {
					int num = Integer.parseInt(qty.getText());
					if (num > 0) {
						msg.setText("");
						double price = num * 500.00;
						total.setText(Double.toString(price) + "0");
					} else {
						total.setText("");
						qty.setBorder(BorderFactory.createLineBorder(Color.RED));
						msg.setText("*Quantity must be greater than 0");
					}
				} catch (NumberFormatException ev) {
					total.setText("");
					qty.setBorder(BorderFactory.createLineBorder(Color.RED));
					msg.setText("*Enter a valid number..!!!");
				}
			}

		}

		public void keyPressed(KeyEvent e) {
			if (e.getSource() == cusId) {
				if (cusId.getText().length() == 5) {
					placeOrder.setEnabled(false);
				} else {
					placeOrder.setEnabled(true);
				}
			}
		}

		public void keyTyped(KeyEvent e) {

		}

	}


