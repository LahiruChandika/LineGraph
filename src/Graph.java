import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import java.io.IOException;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Graph extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    
    public Graph() throws JsonSyntaxException, JsonIOException, IOException {
        final JPanel chartPanel = this.createChartPanel();
        chartPanel.setMinimumSize(new Dimension(200, 200));
        this.add(chartPanel, "Center");
    }
    
    private JPanel createChartPanel() throws JsonSyntaxException, JsonIOException, IOException {
        final String chartTitle = "Employee Achivement level";
        final String categoryAxisLabel = "Time(Weeks)";
        final String valueAxisLabel = "Level (*1000) ";
        final CategoryDataset dataset = this.createDataset();
        final JFreeChart chart = ChartFactory.createLineChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.getRenderer().setSeriesStroke(1, new BasicStroke(2.0f));
        
      
        
        ChartPanel cp = new ChartPanel(chart);
        cp.setPreferredSize(new Dimension(600, 600));
        
        
        //Change background colors in chart
        chart.setBackgroundPaint(new Color(146, 148, 150));
        chart.getTitle().setPaint(new Color(255, 255, 255));
        chart.getPlot().setBackgroundPaint(new Color(146, 148, 150));
        
        
        return (JPanel)new ChartPanel(chart);
    }
    
    private CategoryDataset createDataset() throws JsonSyntaxException, JsonIOException, IOException {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 2; ++i) {
            final double tmpVal = Math.random() * 1000.0;
            for (int j = 0; j < 30; ++j) {
                final double val = (i == 0) ? tmpVal : (Math.random() * 1000.0);
                //dataset = value , Comparablerow key (series) , Comparablecolumn key (x Axis)
                dataset.addValue(val, (Comparable<?>)(String.valueOf(i) + " user"), (Comparable<?>)(String.valueOf(j + 1) + " day"));
            }
        }
        return (CategoryDataset)dataset;
    }
}