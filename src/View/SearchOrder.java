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
public class SearchOrder extends JFrame implements KeyListener{
 
		private JLabel titleLabel, status, orderId, msg, cusId, cusName, qty, total, customerId, burgerQty, orderStatus,
				netTotal, name;
		private JTextField oId;
		private JButton back, homeBtn;
		private String[] dataArray;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
                public Controller controller=new Controller();

		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			dataArray = new String[controller.list.size()];
			String[] nameArray = new String[controller.list.size()];
			String[] qtyArray = new String[controller.list.size()];
			String[] totalArray = new String[controller.list.size()];
			String[] cusIdArray = new String[controller.list.size()];
			int[] statusArray = new int[controller.list.size()];

			for (int i = 0; i < dataArray.length; i++) {
				cusIdArray[i] = controller.list.get(i).getCustomerId();
				dataArray[i] = controller.list.get(i).getOrderId();
				nameArray[i] = controller.list.get(i).getCustomerName();
				qtyArray[i] = Integer.toString(controller.list.get(i).getQty());
				totalArray[i] = Double.toString(controller.list.get(i).getValue());
				statusArray[i] = controller.list.get(i).getOrderStatus();

			}
			for (int i = 0; i < dataArray.length; i++) {
				if (oId.getText().equals(dataArray[i])) {
					cusName.setText(nameArray[i]);
					cusId.setText(cusIdArray[i]);
					qty.setText(qtyArray[i]);
					total.setText(totalArray[i] + "0");
					switch (statusArray[i]) {
						case 0:
							status.setText("Cancelled...");
							break;
						case 1:
							status.setText("Preparing...");
							break;
						default:
							status.setText("Delivered...");
							break;
					}
					oId.setBorder(null);
					msg.setText("");
					return;
				} else {
					cusName.setText("");
					cusId.setText("");
					qty.setText("");
					total.setText("");
					status.setText("");
					oId.setBorder(BorderFactory.createLineBorder(Color.RED));
					msg.setText("*Invalid Order Id...");

				}
			}

		}

		public SearchOrder() {

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

			titleLabel = new JLabel("Search Order Details");
			titleLabel.setForeground(c2);
			titleLabel.setBounds(250, 15, 300, 20);
			titleLabel.setFont(new Font("", 1, 20));
			titlePanel.add(titleLabel);
			add(titlePanel);

			orderId = new JLabel("Enter OrderID: ");
			orderId.setFont(new Font("Arial", 1, 15));
			orderId.setBounds(100, 50, 120, 20);
			orderPanel.add(orderId);

			oId = new JTextField();
			oId.setFont(new Font("Arial", 1, 15));
			oId.setBounds(220, 50, 100, 20);
			oId.setBorder(null);
			oId.addKeyListener(this);
			orderPanel.add(oId);

			msg = new JLabel();
			msg.setFont(new Font("Arial", 1, 10));
			msg.setBounds(220, 70, 170, 20);
			msg.setForeground(Color.RED);
			orderPanel.add(msg);

			customerId = new JLabel("Customer ID: ");
			customerId.setFont(new Font("Arial", 1, 15));
			customerId.setBounds(100, 100, 105, 20);
			orderPanel.add(customerId);

			cusId = new JLabel();
			cusId.setFont(new Font("Arial", 1, 15));
			cusId.setBounds(220, 100, 100, 20);
			orderPanel.add(cusId);

			name = new JLabel("Name: ");
			name.setFont(new Font("Arial", 1, 15));
			name.setBounds(100, 130, 100, 20);
			orderPanel.add(name);

			cusName = new JLabel();
			cusName.setFont(new Font("Arial", 1, 15));
			cusName.setBounds(220, 130, 100, 20);
			orderPanel.add(cusName);

			burgerQty = new JLabel("QTY: ");
			burgerQty.setFont(new Font("Arial", 1, 15));
			burgerQty.setBounds(100, 160, 100, 20);
			orderPanel.add(burgerQty);

			qty = new JLabel();
			qty.setFont(new Font("Arial", 1, 15));
			qty.setBounds(220, 160, 100, 20);
			orderPanel.add(qty);

			netTotal = new JLabel("Total: ");
			netTotal.setFont(new Font("Arial", 1, 15));
			netTotal.setBounds(100, 190, 100, 20);
			orderPanel.add(netTotal);

			total = new JLabel();
			total.setFont(new Font("Arial", 1, 15));
			total.setBounds(220, 190, 100, 20);
			orderPanel.add(total);

			orderStatus = new JLabel("Order Status: ");
			orderStatus.setFont(new Font("Arial", 1, 15));
			orderStatus.setBounds(100, 220, 110, 20);
			orderPanel.add(orderStatus);

			status = new JLabel("Pending...");
			status.setFont(new Font("Arial", 1, 15));
			status.setBounds(220, 220, 110, 20);
			orderPanel.add(status);

			back = new JButton("Back");
			back.setFont(new Font("Arial", 1, 12));
			back.setBounds(550, 220, 100, 30);
			back.setBackground(c1);
			back.setForeground(c2);
			orderPanel.add(back);

			homeBtn = new JButton("Home");
			homeBtn.setFont(new Font("Arial", 1, 12));
			homeBtn.setBounds(440, 220, 100, 30);
			homeBtn.setBackground(c1);
			homeBtn.setForeground(c2);
			orderPanel.add(homeBtn);

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

			homeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					controller.home.setVisible(true);
					setVisible(false);
				}
			});

			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					new Search().setVisible(true);
					setVisible(false);
				}
			});
			add(orderPanel);
		}

	}
   
