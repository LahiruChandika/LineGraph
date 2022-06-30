import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class First {

	private JFrame frame;
	private Graph graph;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public First() throws JsonSyntaxException, JsonIOException, IOException {
		initialize();
	}

	private void initialize() throws JsonSyntaxException, JsonIOException, IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	
		graph = new Graph();
		scrollPane.setViewportView(graph);
		
	}

}
