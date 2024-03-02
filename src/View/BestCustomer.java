/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.*;
import Controller.Controller;
import Model.Orders;
/**
 *
 * @author asanka
 */
public class BestCustomer extends JFrame implements WindowListener{
    
		private JLabel titleLabel;
		private JButton back, homeBtn;
		private DefaultTableModel dtm;
		private JTable tblCustomerDetails;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
                public Controller controller=new Controller();
                

		public void windowActivated(WindowEvent arg0) {
			String[] sortCustomerIdArray = new String[0];
			String[] sortCustomerName = new String[0];
			double[] customerTotalBuyingArray = new double[0];

			for (int i = 0; i < controller.list.size(); i++) {
				boolean isExist = false;
				for (int j = 0; j < sortCustomerIdArray.length; j++) {
					if (sortCustomerIdArray[j].equals(controller.list.get(i).getCustomerId())) {
						if(controller.list.get(i).getOrderStatus()!=0){
							customerTotalBuyingArray[j] += controller.list.get(i).getValue();
							isExist = true;
						}
						
						
						
					}
				}
				if (!isExist && controller.list.get(i).getOrderStatus()!=0) {
					String[] tempSortCustomerArray = new String[sortCustomerIdArray.length + 1];
					String[] tempSortCustomerName = new String[sortCustomerName.length + 1];
					double[] tempCustomerTotalBuyingArray = new double[customerTotalBuyingArray.length + 1];
					for (int j = 0; j < sortCustomerIdArray.length; j++) {
						tempSortCustomerArray[j] = sortCustomerIdArray[j];
						tempSortCustomerName[j] = sortCustomerName[j];
						tempCustomerTotalBuyingArray[j] = customerTotalBuyingArray[j];
					}
					sortCustomerIdArray = tempSortCustomerArray;
					sortCustomerName = tempSortCustomerName;
					customerTotalBuyingArray = tempCustomerTotalBuyingArray;

					

					sortCustomerIdArray[sortCustomerIdArray.length - 1] = controller.list.get(i).getCustomerId();
					sortCustomerName[sortCustomerName.length - 1] = controller.list.get(i).getCustomerName();
					customerTotalBuyingArray[customerTotalBuyingArray.length - 1] = controller.list.get(i).getValue();
				}
			}
			// sort
			for (int i = 1; i < sortCustomerIdArray.length; i++) {
				for (int j = 0; j < i; j++) {
					if (customerTotalBuyingArray[j] < customerTotalBuyingArray[i]) {
						String temp = sortCustomerIdArray[j];
						sortCustomerIdArray[j] = sortCustomerIdArray[i];
						sortCustomerIdArray[i] = temp;
						temp = sortCustomerName[j];
						sortCustomerName[j] = sortCustomerName[i];
						sortCustomerName[i] = temp;
						double tempd = customerTotalBuyingArray[j];
						customerTotalBuyingArray[j] = customerTotalBuyingArray[i];
						customerTotalBuyingArray[i] = tempd;
					}
				}
			}

			Object[] rowData = new Object[3];

			for (int i = 0; i < sortCustomerIdArray.length; i++) {

				rowData[0] = sortCustomerIdArray[i];
				rowData[1] = sortCustomerName[i];
				rowData[2] = customerTotalBuyingArray[i];
				dtm.addRow(rowData);

			}
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
			
		}

		BestCustomer() {
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

			titleLabel = new JLabel("Search Best Customer");
			titleLabel.setForeground(c2);
			titleLabel.setBounds(250, 15, 300, 20);
			titleLabel.setFont(new Font("", 1, 20));
			titlePanel.add(titleLabel);
			add(titlePanel);

			String[] columnName = { "Customer ID", "Name", "Total" };

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
					new Search().setVisible(true);
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


