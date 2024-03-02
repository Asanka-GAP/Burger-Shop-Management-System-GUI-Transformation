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
public class SearchCustomer extends JFrame implements KeyListener{
    
		private JLabel titleLabel, customerId, name, subTitle, cusName, msg;
		private JTextField oId;
		private JButton back, homeBtn;
		private DefaultTableModel dtm;
		private JTable tblCustomerDetails;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
                public Controller controller=new Controller();

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			Object[] rowData = new Object[3];
			boolean isExist = false;
			for (int i = 0; i < controller.list.size(); i++) {
				if (oId.getText().equals(controller.list.get(i).getCustomerId())) {
					cusName.setText(controller.list.get(i).getCustomerName());
					rowData[0] = controller.list.get(i).getOrderId();
					rowData[1] = controller.list.get(i).getQty();
					rowData[2] = controller.list.get(i).getValue() + "0";
					dtm.addRow(rowData);
					msg.setText("");
					oId.setBorder(null);
					isExist = true;
				}
			}
			if (!isExist) {
				msg.setText("*Invalid Customer Id..");
				oId.setBorder(BorderFactory.createLineBorder(Color.RED));
				cusName.setText("");

				for (int j = dtm.getRowCount() - 1; j >= 0; j--) {
					dtm.removeRow(j);

				}
			}
		}

		SearchCustomer() {
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
			orderPanel.setBounds(0, 50, 700, 70);
			orderPanel.setBackground(c2);

			JPanel subTitilePanel = new JPanel();
			subTitilePanel.setLayout(null);
			subTitilePanel.setBounds(0, 120, 700, 30);
			subTitilePanel.setBackground(c1);
			add(subTitilePanel);

			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(null);
			mainPanel.setBounds(0, 150, 700, 250);
			mainPanel.setBackground(c2);
			add(mainPanel);

			String[] columnName = { "Order ID", "Order QTY", "Total" };
			dtm = new DefaultTableModel(columnName, 0);

			tblCustomerDetails = new JTable(dtm);
			JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
			tablePane.setBounds(75, 15, 550, 100);
			mainPanel.add(tablePane);

			titleLabel = new JLabel("Search Customer");
			titleLabel.setForeground(c2);
			titleLabel.setBounds(250, 15, 300, 20);
			titleLabel.setFont(new Font("", 1, 20));
			titlePanel.add(titleLabel);
			add(titlePanel);

			subTitle = new JLabel("Order Details");
			subTitle.setForeground(c2);
			subTitle.setBounds(300, 6, 300, 20);
			subTitle.setFont(new Font("", 1, 15));
			subTitilePanel.add(subTitle);

			customerId = new JLabel("Enter Customer Id: ");
			customerId.setFont(new Font("Arial", 1, 15));
			customerId.setBounds(100, 10, 150, 20);
			orderPanel.add(customerId);

			oId = new JTextField();
			oId.setFont(new Font("Arial", 1, 15));
			oId.setBounds(250, 10, 100, 20);
			oId.addKeyListener(this);
			oId.setBorder(null);
			orderPanel.add(oId);

			msg = new JLabel();
			msg.setFont(new Font("Arial", 1, 10));
			msg.setBounds(250, 30, 170, 20);
			msg.setForeground(Color.RED);
			orderPanel.add(msg);

			name = new JLabel("Name: ");
			name.setFont(new Font("Arial", 1, 15));
			name.setBounds(100, 40, 70, 20);
			orderPanel.add(name);

			cusName = new JLabel();
			cusName.setFont(new Font("Arial", 1, 15));
			cusName.setBounds(160, 40, 100, 20);
			orderPanel.add(cusName);

			back = new JButton("Back");
			back.setFont(new Font("Arial", 1, 12));
			back.setBounds(550, 150, 100, 30);
			back.setBackground(c1);
			back.setForeground(c2);
			mainPanel.add(back);

			homeBtn = new JButton("Home");
			homeBtn.setFont(new Font("Arial", 1, 12));
			homeBtn.setBounds(440, 150, 100, 30);
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

