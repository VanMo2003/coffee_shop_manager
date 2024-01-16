package org.example.CnJava_Project.view.manager.frame;

import org.example.CnJava_Project.model.BillModel;
import org.example.CnJava_Project.respository.BillRepository;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RevenueView {
	static public BillRepository billRepository;
	public static JFreeChart createChart(BillRepository billRepository) {
		RevenueView.billRepository = billRepository;
		JFreeChart barChart = ChartFactory.createBarChart(
				"Doanh thu trong năm 2024 theo tháng",
				"Tháng", "Doanh thu",
				createDataset(), PlotOrientation.VERTICAL, false, false, false);
		return barChart;
	}

	private static CategoryDataset createDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		ArrayList<Double> listRevenue = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			listRevenue.add(i, 0.0);
		}

		List<BillModel> billModelList = billRepository.findAll();
		billModelList.forEach(billModel -> {
			String orderDate = billModel.getOrderDate();
			Integer monthOrder = Integer.parseInt(orderDate.split(" ")[0].split("/")[1]);
			Double revenue = listRevenue.get(monthOrder-1);
			revenue += billModel.getTotalMoney();

			listRevenue.set(monthOrder - 1, revenue);
		});

		for (int i = 0; i < 12; i++) {
			dataset.addValue(listRevenue.get(i), "Tr", i+1+"");
		}



//		dataset.addValue(68, "Tr", "1");
//		dataset.addValue(80, "Tr", "2");
//		dataset.addValue(88, "Tr", "3");
//		dataset.addValue(79, "Tr", "4");
//		dataset.addValue(95, "Tr", "5");
//		dataset.addValue(81, "Tr", "6");
//		dataset.addValue(71, "Tr", "7");
//		dataset.addValue(93, "Tr", "8");
//		dataset.addValue(10, "Tr", "9");
//		dataset.addValue(80, "Tr", "10");
//		dataset.addValue(95, "Tr", "11");
//		dataset.addValue(73, "Tr", "12");
		return dataset;
	}
}
