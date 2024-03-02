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
public class Home extends JFrame{
    

		private JLabel titleLabel;
		private ImageIcon image;
		private JButton placeOrderBtn;
		private JButton searchBtn;
		private JButton viewOrderBtn;
		private JButton updateOrderBtn;
		private JButton exitBtn;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
                public Controller controller=new Controller();

		public Home() {
			setSize(700, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(null);
			setUndecorated(true);

			titleLabel = new JLabel("Welcome to Burgers");
			titleLabel.setForeground(c2);
			titleLabel.setFont(new Font("", 1, 20));
			titleLabel.setBounds(60, 3, 300, 50);

			image = new ImageIcon(getClass().getResource("img1.png"));
			JLabel imgJLabel = new JLabel();
			imgJLabel.setIcon(image);
			imgJLabel.setBounds(60, 50, 200, 300);

			JPanel leftPanel = new JPanel();
			JPanel rightPanel = new JPanel();
			leftPanel.setBackground(c1);
			rightPanel.setBackground(c2);
			leftPanel.setBounds(0, 0, 300, 400);
			rightPanel.setBounds(300, 0, 400, 400);
			rightPanel.setLayout(null);
			leftPanel.setLayout(null);
			leftPanel.add(titleLabel);
			leftPanel.add(imgJLabel);

			add(leftPanel);
			add(rightPanel);

			placeOrderBtn = new JButton("Place Order");
			placeOrderBtn.setFont(new Font("Arial", 1, 15));
			placeOrderBtn.setBounds(100, 75, 200, 30);
			placeOrderBtn.setBackground(c2);
			placeOrderBtn.setForeground(c1);
			placeOrderBtn.setBorder(BorderFactory.createLineBorder(c1));
			rightPanel.add(placeOrderBtn);

			placeOrderBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					controller.placeOrder.setVisible(true);
					setVisible(false);
				}
			});

			searchBtn = new JButton("Search");
			searchBtn.setFont(new Font("Arial", 1, 15));
			searchBtn.setBounds(100, 115, 200, 30);
			searchBtn.setBackground(c2);
			searchBtn.setForeground(c1);
			searchBtn.setBorder(BorderFactory.createLineBorder(c1));

			rightPanel.add(searchBtn);

			searchBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					controller.search.setVisible(true);
					setVisible(false);
				}
			});

			viewOrderBtn = new JButton("View Orders");
			viewOrderBtn.setFont(new Font("Arial", 1, 15));
			viewOrderBtn.setBounds(100, 155, 200, 30);
			viewOrderBtn.setBackground(c2);
			viewOrderBtn.setForeground(c1);
			viewOrderBtn.setBorder(BorderFactory.createLineBorder(c1));

			rightPanel.add(viewOrderBtn);

			viewOrderBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					controller.viewOrder.setVisible(true);
					setVisible(false);
				}
			});

			updateOrderBtn = new JButton("Update Order Detais");
			updateOrderBtn.setFont(new Font("Arial", 1, 15));
			updateOrderBtn.setBounds(100, 195, 200, 30);
			updateOrderBtn.setBackground(c2);
			updateOrderBtn.setForeground(c1);
			updateOrderBtn.setBorder(BorderFactory.createLineBorder(c1));

			rightPanel.add(updateOrderBtn);

			updateOrderBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					controller.updateOrder.setVisible(true);
					setVisible(false);
				}
			});

			JLabel x=new JLabel("X");
			x.setFont(new Font("Arial", 1, 20));
			x.setBounds(380, 0, 100, 30);
			x.setForeground(c1);
			rightPanel.add(x);

			x.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {

					x.setForeground(Color.RED);
					
					
				}
	
				@Override
				public void mouseExited(MouseEvent e) {
					x.setForeground(c1);
				}
	
				@Override
				public void mouseClicked(MouseEvent e) {
					int response=JOptionPane.showConfirmDialog(null, "Are you sure want to exit?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});

			exitBtn = new JButton("Exit");
			exitBtn.setFont(new Font("Arial", 1, 15));
			exitBtn.setBounds(295, 305, 75, 30);
			exitBtn.setBackground(c1);
			exitBtn.setForeground(c2);
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int response=JOptionPane.showConfirmDialog(null, "Are you sure want to exit?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (response==JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
			});
			rightPanel.add(exitBtn);

		}

	}


