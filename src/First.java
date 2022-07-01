import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartPanel;

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
		frame.setBounds(100, 100, 652, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		graph = new Graph();
		panel.add(graph, BorderLayout.CENTER);	

	    frame.addComponentListener(new ComponentListener() {
	    	@Override
			public void componentResized(ComponentEvent e) {
	    	frame.repaint();
	    	ChartPanel cp = (ChartPanel)graph.getComponents()[0];
	    	cp.setPreferredSize(new java.awt.Dimension(graph.getWidth(), graph.getHeight()));
	    	cp.setSize(new java.awt.Dimension(graph.getWidth(), graph.getHeight()));
	    	// frame.invalidate();
	    	frame.validate();
	    	// frame.repaint();
	    	}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
				
	}
}
