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
public class ProcessingOrders extends JFrame implements WindowListener{
 
		private JLabel titleLabel;
		private JButton back, homeBtn;
		private DefaultTableModel dtm;
		private JTable tblCustomerDetails;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
                public Controller controller=new Controller();

		public void windowActivated(WindowEvent arg0) {
		}

		public void windowClosed(WindowEvent arg0) {
		}

		public void windowClosing(WindowEvent arg0) {
		}

		public void windowDeactivated(WindowEvent arg0) {
		}

		public void windowDeiconified(WindowEvent arg0) {
		}

		public void windowIconified(WindowEvent arg0) {
		}

		public void windowOpened(WindowEvent arg0) {
			for (int i = 0; i < controller.list.size(); i++) {
				if (controller.list.get(i).getOrderStatus() == 1) {
					Object[] rowData = new Object[5];

					rowData[0] = controller.list.get(i).getOrderId();
					rowData[1] = controller.list.get(i).getCustomerId();
					rowData[2] = controller.list.get(i).getCustomerName();
					rowData[3] = controller.list.get(i).getQty();
					rowData[4] = controller.list.get(i).getValue();
					dtm.addRow(rowData);

				}
			}
		}

		ProcessingOrders() {
			setSize(700, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(null);
			addWindowListener(this);
			setUndecorated(true);

			JPanel titlePanel = new JPanel();
			titlePanel.setLayout(null);
			titlePanel.setBounds(0, 0, 700, 50);
			titlePanel.setBackground(c1);

			JPanel orderPanel = new JPanel();
			orderPanel.setLayout(null);
			orderPanel.setBounds(0, 50, 700, 350);
			orderPanel.setBackground(c2);

			titleLabel = new JLabel("Processing Orders");
			titleLabel.setForeground(c2);
			titleLabel.setBounds(250, 15, 300, 25);
			titleLabel.setFont(new Font("", 1, 20));
			titlePanel.add(titleLabel);
			add(titlePanel);

			String[] columnName = { "Order Id", "Customer ID", "Name", "Order QTY", "Total" };
			dtm = new DefaultTableModel(columnName, 0);

			tblCustomerDetails = new JTable(dtm);
			JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
			tablePane.setBounds(75, 15, 550, 200);
			orderPanel.add(tablePane);

			back = new JButton("Back");
			back.setFont(new Font("Arial", 1, 12));
			back.setBounds(550, 245, 100, 30);
			back.setBackground(c1);
			back.setForeground(c2);
			orderPanel.add(back);

			homeBtn = new JButton("Home");
			homeBtn.setFont(new Font("Arial", 1, 12));
			homeBtn.setBounds(440, 245, 100, 30);
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

			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					new ViewOrder().setVisible(true);
					setVisible(false);
				}
			});
			homeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					controller.home.setVisible(true);
					setVisible(false);
				}
			});

			add(orderPanel);

		}
	}
   

