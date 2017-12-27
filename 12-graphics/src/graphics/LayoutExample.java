package graphics;

import javax.swing.*;
import java.awt.*;

public class LayoutExample {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.add(new JButton("shock me"));
		panel.add(new JButton("bliss"));
		panel.setBackground(Color.DARK_GRAY);
		// frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(250, 200);
		frame.setVisible(true);
		frame.setContentPane(panel);
	}
}
