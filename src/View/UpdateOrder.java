/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
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
public class UpdateOrder extends JFrame implements KeyListener{
    
		private JLabel titleLabel, orderId, customerId, burgerQty, orderStatus, netTotal, name, msg, cusId, cusName,
				msg2,
				total;
		private JTextField oId, qty;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
		private JButton updateBtn, back;
		@SuppressWarnings("rawtypes")
		private JComboBox statusBox;
                public Controller controller=new Controller();

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public UpdateOrder() {
			setSize(700, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(null);
			setUndecorated(true);

			JPanel titlePanel = new JPanel();
			titlePanel.setLayout(null);
			titlePanel.setBounds(0, 0, 700, 50);
			titlePanel.setBackground(c1);

			JPanel orderPanel = new JPanel();
			orderPanel.setLayout(null);
			orderPanel.setBounds(0, 50, 700, 350);
			orderPanel.setBackground(c2);

			titleLabel = new JLabel("Update Order");
			titleLabel.setForeground(c2);
			titleLabel.setBounds(250, 15, 300, 20);
			titleLabel.setFont(new Font("", 1, 20));
			titlePanel.add(titleLabel);
			add(titlePanel);

			orderId = new JLabel("Order Id: ");
			orderId.setFont(new Font("Arial", 1, 15));
			orderId.setBounds(100, 100, 105, 20);
			orderPanel.add(orderId);

			orderStatus = new JLabel("Order Status: ");
			orderStatus.setFont(new Font("Arial", 1, 15));
			orderStatus.setBounds(100, 50, 110, 20);
			orderPanel.add(orderStatus);

			String[] statusArr = { "Cancelled", "Preparing", "Delivered" };
			statusBox = new JComboBox(statusArr);
			statusBox.setFont(new Font("Arial", 1, 15));
			statusBox.setBounds(220, 50, 120, 24);
			orderPanel.add(statusBox);

			msg = new JLabel();
			msg.setFont(new Font("Arial", 1, 10));
			msg.setBounds(350, 50, 200, 20);
			msg.setForeground(Color.RED);
			orderPanel.add(msg);

			msg2 = new JLabel();
			msg2.setFont(new Font("Arial", 1, 10));
			msg2.setBounds(350, 65, 200, 20);
			msg2.setForeground(Color.RED);
			orderPanel.add(msg2);

			oId = new JTextField();
			oId.setFont(new Font("Arial", 1, 15));
			oId.setBounds(220, 100, 120, 20);
			oId.setBorder(null);
			oId.addKeyListener(this);
			orderPanel.add(oId);

			customerId = new JLabel("Customer ID: ");
			customerId.setFont(new Font("Arial", 1, 15));
			customerId.setBounds(100, 130, 120, 20);
			orderPanel.add(customerId);

			cusId = new JLabel();
			cusId.setFont(new Font("Arial", 1, 15));
			cusId.setBounds(220, 130, 100, 20);
			orderPanel.add(cusId);

			name = new JLabel("Name: ");
			name.setFont(new Font("Arial", 1, 15));
			name.setBounds(100, 160, 100, 20);
			orderPanel.add(name);

			cusName = new JLabel();
			cusName.setFont(new Font("Arial", 1, 15));
			cusName.setBounds(220, 160, 100, 20);
			orderPanel.add(cusName);

			burgerQty = new JLabel("QTY: ");
			burgerQty.setFont(new Font("Arial", 1, 15));
			burgerQty.setBounds(100, 190, 100, 20);
			orderPanel.add(burgerQty);

			qty = new JTextField();
			qty.setFont(new Font("Arial", 1, 15));
			qty.setBounds(220, 190, 120, 20);
			qty.setBorder(null);
			qty.addKeyListener(this);
			orderPanel.add(qty);

			netTotal = new JLabel("Total: ");
			netTotal.setFont(new Font("Arial", 1, 15));
			netTotal.setBounds(100, 220, 100, 20);
			orderPanel.add(netTotal);

			total = new JLabel();
			total.setFont(new Font("Arial", 1, 15));
			total.setBounds(220, 220, 100, 20);
			total.setForeground(Color.RED);
			orderPanel.add(total);

			updateBtn = new JButton("Update");
			updateBtn.setFont(new Font("Arial", 1, 12));
			updateBtn.setBounds(440, 220, 100, 30);
			updateBtn.setBackground(c2);
			updateBtn.setForeground(c1);
			updateBtn.setBorder(BorderFactory.createLineBorder(c1));
			orderPanel.add(updateBtn);

			back = new JButton("Back");
			back.setFont(new Font("Arial", 1, 12));
			back.setBounds(550, 220, 100, 30);
			back.setBackground(c1);
			back.setForeground(c2);
			orderPanel.add(back);

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
					msg.setText("");
					msg2.setText("");
					oId.setText("");
					cusId.setText("");
					cusName.setText("");
					oId.setBorder(null);
					qty.setBorder(null);
					qty.setText("");
					total.setText("");
					controller.home.setVisible(true);
					setVisible(false);
				}
			});
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (qty.getText().equals("") || oId.getText().equals("")) {
						qty.setBorder(BorderFactory.createLineBorder(Color.RED));
						oId.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					for (int i = 0; i < controller.list.size(); i++) {
						if (oId.getText().equals(controller.list.get(i).getOrderId()) && controller.list.get(i).getOrderStatus() == 1) {
							try {
								if (qty.getText().equals("0")) {
									qty.setBorder(BorderFactory.createLineBorder(Color.RED));
								} else {
									qty.setBorder(null);
									controller.list.get(i).setQty(Integer.parseInt(qty.getText()));
									controller.list.get(i).setOrderStatus(statusBox.getSelectedIndex());
									double newValue = Integer.parseInt(qty.getText()) * 500.00;
									controller.list.get(i).setValue(newValue);
									JOptionPane.showMessageDialog(null, "Order updated successfully..!!!", "Updated",
											JOptionPane.INFORMATION_MESSAGE);
									msg.setText("");
									msg2.setText("");
									oId.setText("");
									cusId.setText("");
									cusName.setText("");
									oId.setBorder(null);
									qty.setText("");
									total.setText("");
								}

							} catch (NumberFormatException e) {
								qty.setBorder(BorderFactory.createLineBorder(Color.RED));
							}

						}
					}
				}
			});

			add(orderPanel);
		}

		public void keyReleased(KeyEvent e) {
			try {
				if (e.getSource() == qty) {
					double newPrice = Integer.parseInt(qty.getText()) * 500.0;
					total.setText(Double.toString(newPrice) + "0");
				}
			} catch (Exception er) {

			}

			if (e.getSource() == oId) {
				boolean isExist = false;

				for (int i = 0; i < controller.list.size(); i++) {
					if (oId.getText().equals(controller.list.get(i).getOrderId())) {
						qty.setBorder(null);
						isExist = true;
						if (controller.list.get(i).getOrderStatus() == 0) {
							msg.setText("This Order has been Cancelled.");
							msg2.setText("Sorry, you can not update this order");
							updateBtn.setEnabled(false);
							qty.setEditable(false);
							statusBox.setEnabled(false);
						} else if (controller.list.get(i).getOrderStatus() == 2) {
							msg.setText("This Order has been Delivered.");
							msg2.setText("Sorry, you can not update this order");
							updateBtn.setEnabled(false);
							qty.setEditable(false);
							statusBox.setEnabled(false);
						} else {
							updateBtn.setEnabled(true);
							qty.setEditable(true);
							statusBox.setEnabled(true);
						}
						cusName.setText(controller.list.get(i).getCustomerName());
						qty.setText(Integer.toString(controller.list.get(i).getQty()));
						cusId.setText(controller.list.get(i).getCustomerId());
						total.setText(Double.toString(controller.list.get(i).getValue()) + "0");
						statusBox.setSelectedIndex(controller.list.get(i).getOrderStatus());
						oId.setBorder(null);

					}

				}
				if (!isExist) {
					qty.setEditable(false);
					updateBtn.setEnabled(false);
					oId.setBorder(BorderFactory.createLineBorder(Color.RED));
					msg.setText("");
					msg2.setText("");
					cusName.setText("");
					qty.setText("");
					cusId.setText("");
					total.setText("");

				}
			}

		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
	}

