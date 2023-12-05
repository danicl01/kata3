package software.ulpgc.kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JFreeHistogramDisplay extends JPanel implements HistogramDisplay {
    public JFreeHistogramDisplay() {
        setLayout(new BorderLayout());
    }

    @Override
    public void show(Histogram histogram) {
        add(new ChartPanel(chart(dataset(histogram.bins(), histogram.employee()))));

    }

    private JFreeChart chart(HistogramDataset dataset) {
        return ChartFactory.createHistogram(
                "",
                "employees",
                "count",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
    }

    private HistogramDataset dataset(int bins, List<Double> employee) {
        HistogramDataset result = new HistogramDataset();

        double[] doubleValues = employee.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();

        result.addSeries("X", doubleValues, bins);
        return result;
    }
}
