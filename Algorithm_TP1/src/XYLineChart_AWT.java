import java.awt.Color;
import java.awt.Shape;
import java.util.Arrays;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYItemRenderer;

public class XYLineChart_AWT extends ApplicationFrame {
	public XYLineChart_AWT(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		JFreeChart xylineChart = ChartFactory.createScatterPlot(chartTitle, "Data Size", "Time", createDataset(),
				PlotOrientation.VERTICAL, true, false, false);

		Shape cross = ShapeUtilities.createDiagonalCross(3, 1);

		ChartPanel chartPanel = new ChartPanel(xylineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		final XYPlot plot = xylineChart.getXYPlot();
		XYItemRenderer renderer = plot.getRenderer();
		renderer.setSeriesPaint(2, Color.RED);
		renderer.setSeriesPaint(1, Color.GREEN);
		renderer.setSeriesPaint(0, Color.YELLOW);
		renderer.setSeriesShape(0, cross);

		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		setContentPane(chartPanel);
	}

	private long getTime(int size, int type) {
		Randomdata rd = new Randomdata();
		int[] tab = rd.generate1d(size, 0, 1000);
		long stime, etime, rtime;
		stime = System.currentTimeMillis();

		switch (type) {
		case -1:
			rd.generate1d(10, 0, 10000);
		case 0:
			BubbleSort bs = new BubbleSort();
			bs.sort(tab);
		case 1:
			SelectionSort ss = new SelectionSort();
			ss.sort(tab);
		case 2:
			MergeSort ms = new MergeSort();
			ms.sort(tab);
		case 3:
			QuickSort qs = new QuickSort();
			qs.sort(tab);
		case 4:
			Dichotomy dt = new Dichotomy();
			dt.main(tab);
		}

		etime = System.currentTimeMillis();
		rtime = etime - stime;
		//System.out.println(rtime);
		
		return rtime;
	}
	
	private long getTime2(int size) {
		long startTime = System.currentTimeMillis();
		Randomdata rd = new Randomdata();
		int tabrd[];
		tabrd = rd.generate1d(size, 0, 100);
		System.out.println("Random List : " + Arrays.toString(tabrd) + "");
		rd.MinData(tabrd);
		System.out.println("Minimum : " + rd.MinData(tabrd) + "");

		// Fin
		long endTime = System.currentTimeMillis();
		System.out.println("Total running time is :" + (endTime - startTime));
		
		return (endTime-startTime);
	}

	private XYDataset createDataset() {
		final XYSeries[] xys = new XYSeries[5];
		xys[0] = new XYSeries("BubbleSort");
		xys[1] = new XYSeries("SelectionSort");
		xys[2] = new XYSeries("MergeSort");
		xys[3] = new XYSeries("QuickSort");
		xys[4] = new XYSeries("BinarySearch");

		for (int i = 0; i < xys.length; i++) {
			for (int j = 500; j < 10000; j += 500) {
			//for (int j = 500000; j < 8000000; j += 500000) {
				xys[i].add(j, getTime(j, i));
			}
		}

		final XYSeriesCollection dataset = new XYSeriesCollection();
		for (int i = 0; i < xys.length; i++) {
			dataset.addSeries(xys[i]);
			System.out.println(i + "/"+xys.length+"...");
		}
		
		/*final XYSeries xyss = new XYSeries("Randomdata");
		for (int i=10; i<100; i+=10)
			xyss.add(i, getTime2(i));
		
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(xyss);*/

		return dataset;
	}

	public static void main(String[] args) {
		XYLineChart_AWT chart = new XYLineChart_AWT("Sorting Statistics", "Which Sorting are you using?");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
		System.out.println("finished");
	}
}
