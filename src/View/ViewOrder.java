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
public class ViewOrder extends JFrame {
    

		private JLabel titleLabel;
		private ImageIcon image;
		private JButton deliverdBtn, processingBtn, canceledBtn;
		private JButton exitBtn;
		Color c1 = new Color(49, 71, 58);
		Color c2 = new Color(237, 244, 242);
                public Controller controller=new Controller();

		public ViewOrder() {
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

			JPanel titlePanel = new JPanel();
			titlePanel.setLayout(null);
			titlePanel.setBounds(300, 0, 400, 50);
			titlePanel.setBackground(c2);
			add(titlePanel);

			JLabel subTitle = new JLabel("View Orders");
			subTitle.setForeground(c1);
			subTitle.setBounds(140, 15, 300, 20);
			subTitle.setFont(new Font("", 1, 20));
			titlePanel.add(subTitle);

			JPanel leftPanel = new JPanel();
			JPanel rightPanel = new JPanel();
			leftPanel.setBackground(c1);
			rightPanel.setBackground(c2);
			leftPanel.setBounds(0, 0, 300, 400);
			rightPanel.setBounds(300, 50, 400, 400);
			rightPanel.setLayout(null);
			leftPanel.setLayout(null);
			leftPanel.add(titleLabel);
			leftPanel.add(imgJLabel);

			add(leftPanel);
			add(rightPanel);

			deliverdBtn = new JButton("Deliverd Orders");
			deliverdBtn.setFont(new Font("Arial", 1, 15));
			deliverdBtn.setBounds(100, 65, 200, 30);
			deliverdBtn.setBackground(c2);
			deliverdBtn.setForeground(c1);
			deliverdBtn.setBorder(BorderFactory.createLineBorder(c1));
			rightPanel.add(deliverdBtn);

			deliverdBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					new DeliverdOrders().setVisible(true);
					setVisible(false);
				}
			});

			processingBtn = new JButton("Processing Orders");
			processingBtn.setFont(new Font("Arial", 1, 15));
			processingBtn.setBounds(100, 105, 200, 30);
			processingBtn.setBackground(c2);
			processingBtn.setForeground(c1);
			processingBtn.setBorder(BorderFactory.createLineBorder(c1));
			rightPanel.add(processingBtn);

			processingBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					new ProcessingOrders().setVisible(true);
					setVisible(false);
				}
			});

			canceledBtn = new JButton("Canceled Orders");
			canceledBtn.setFont(new Font("Arial", 1, 15));
			canceledBtn.setBounds(100, 145, 200, 30);
			canceledBtn.setBackground(c2);
			canceledBtn.setForeground(c1);
			canceledBtn.setBorder(BorderFactory.createLineBorder(c1));
			rightPanel.add(canceledBtn);

			JLabel x=new JLabel("X");
			x.setFont(new Font("Arial", 1, 20));
			x.setBounds(380, 0, 100, 30);
			x.setForeground(c1);
			titlePanel.add(x);

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

			canceledBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					new CancelledOrders().setVisible(true);
					setVisible(false);
				}
			});

			exitBtn = new JButton("back");
			exitBtn.setFont(new Font("Arial", 1, 15));
			exitBtn.setBounds(295, 255, 75, 30);
			exitBtn.setBackground(c1);
			exitBtn.setForeground(c2);
			
			exitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					controller.home.setVisible(true);
					setVisible(false);
				}
			});
			rightPanel.add(exitBtn);

		}

	}

