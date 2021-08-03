package com.gabriel.lunchfinder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.gabriel.lunchfinder.model.Restaurant;
import com.gabriel.lunchfinder.search.SearchRestaurants;

public class LunchFinder extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel labelName = new JLabel("Enter restaurant name: ");
	private JLabel labelDistance = new JLabel("Enter maximum distance: ");
	private JLabel labelRate = new JLabel("Enter minimal rate: ");
	private JLabel labelPrice = new JLabel("Enter maximum price: ");
	private JLabel labelCuisine = new JLabel("Enter cuisine name: ");

	private JTextField textName = new JTextField(20);
	private JTextField textDistance = new JTextField(5);
	private JTextField textRate = new JTextField(5);
	private JTextField textPrice = new JTextField(5);
	private JTextField textCuisine = new JTextField(20);

	private JButton buttonSearch = new JButton("Search");

	public LunchFinder() {
		super("Search Restaurant");

		JPanel newPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		constraints.gridx = 0;
		constraints.gridy = 0;
		newPanel.add(labelName, constraints);

		constraints.gridx = 1;
		newPanel.add(textName, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		newPanel.add(labelDistance, constraints);

		constraints.gridx = 1;
		newPanel.add(textDistance, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		newPanel.add(labelRate, constraints);

		constraints.gridx = 1;
		newPanel.add(textRate, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		newPanel.add(labelPrice, constraints);

		constraints.gridx = 1;
		newPanel.add(textPrice, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		newPanel.add(labelCuisine, constraints);

		constraints.gridx = 1;
		newPanel.add(textCuisine, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(buttonSearch, constraints);

		buttonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					validateNumber(textRate.getText(), "Rate");
					validateNumber(textDistance.getText(), "Distance");
					validateNumber(textPrice.getText(), "Price");

					List<Restaurant> result = new SearchRestaurants().search(textName.getText(),
							Integer.valueOf(textRate.getText()), Integer.valueOf(textDistance.getText()),
							Integer.valueOf(textPrice.getText()), textCuisine.getText());
					String restaurantsList = result.size() > 0 ? "Restaurants found:\n"
							: "No restaurants found with the given filters";
					for (Restaurant restaurant : result) {
						restaurantsList += restaurant.toString() + "\n";
					}
					JOptionPane.showMessageDialog(newPanel, restaurantsList);

				} catch (RuntimeException e) {
					JOptionPane.showMessageDialog(newPanel, e.getMessage());
				}
			}
		});

		newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Restaurant"));

		add(newPanel);

		pack();
		setLocationRelativeTo(null);
	}

	public void validateNumber(String value, String field) {
		try {
			Integer.parseInt(value);
		} catch (RuntimeException e) {
			throw new RuntimeException(field + " must be a number");
		}
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new LunchFinder().setVisible(true);
			}
		});
	}
}
