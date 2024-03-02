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
public class Search extends JFrame {
    
		private JButton bestCus, cus, order, back;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
                public Controller controller=new Controller();

		

		public Search() {
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

			back = new JButton("Back");
			back.setFont(new Font("Arial", 1, 12));
			back.setBounds(550, 245, 100, 30);
			back.setBackground(c1);
			back.setForeground(c2);
			orderPanel.add(back);



			JLabel titleLabel = new JLabel("Search");
			titleLabel.setForeground(c2);
			titleLabel.setBounds(320, 15, 300, 20);
			titleLabel.setFont(new Font("", 1, 20));
			titlePanel.add(titleLabel);
			add(titlePanel);

			bestCus = new JButton("Best Customer");
			bestCus.setFont(new Font("Arial", 1, 17));
			bestCus.setBounds(250, 50, 200, 40);
			bestCus.setBackground(c2);
			bestCus.setForeground(c1);
			bestCus.setBorder(BorderFactory.createLineBorder(c1));

			orderPanel.add(bestCus);

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

			bestCus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					new BestCustomer().setVisible(true);
					setVisible(false);
				}
			});

			cus = new JButton("Search Customer");
			cus.setFont(new Font("Arial", 1, 17));
			cus.setBounds(250, 100, 200, 40);
			cus.setBackground(c2);
			cus.setForeground(c1);
			cus.setBorder(BorderFactory.createLineBorder(c1));

			orderPanel.add(cus);

			cus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					new SearchCustomer().setVisible(true);
					setVisible(false);
				}
			});

			order = new JButton("Search Order");
			order.setFont(new Font("Arial", 1, 17));
			order.setBounds(250, 150, 200, 40);
			order.setBackground(c2);
			order.setForeground(c1);
			order.setBorder(BorderFactory.createLineBorder(c1));
			orderPanel.add(order);

			order.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					new SearchOrder().setVisible(true);
					setVisible(false);
				}
			});

			add(orderPanel);

		}
	}

