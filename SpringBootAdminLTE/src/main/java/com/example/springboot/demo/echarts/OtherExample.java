package com.example.springboot.demo.echarts;

import java.util.ArrayList;
import java.util.List;

import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitArea;
import com.github.abel533.echarts.axis.SplitLine;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.style.LineStyle;

public class OtherExample {
	// 数据对象
	static class AccessData {
		private String date; // 日期
		private Integer nums; // 访问量

		public AccessData(String date, Integer nums) {
			this.date = date;
			this.nums = nums;
		}

		public String getDate() {
			return date;
		}

		public Integer getNums() {
			return nums;
		}
	}

	/**
	 * 模拟从数据库获取数据
	 *
	 * @return
	 */
	private static List<AccessData> getWeekData() {
		List<AccessData> list = new ArrayList<AccessData>(7);
		list.add(new AccessData("09-16", 4));
		list.add(new AccessData("09-17", 7));
		list.add(new AccessData("09-18", 14));
		list.add(new AccessData("09-19", 304));
		list.add(new AccessData("09-20", 66));
		list.add(new AccessData("09-21", 16));
		list.add(new AccessData("09-22", 205));
		return list;
	}

	public static GsonOption getChart1() {
		// 获取数据
		List<AccessData> datas = getWeekData();
		// 创建Option对象
		GsonOption option = new GsonOption();
		// 设置图表标题，并且居中显示
		option.title().text("最近7天访问量图表").x(X.center);
		// 设置图例,居中底部显示，显示边框
		option.legend().data("访问量").x(X.center).y(Y.bottom).borderWidth(1);
		// 设置y轴为值轴，并且不显示y轴，最大值设置400（实际上这个属性不必设置，默认即可）
		option.yAxis(new ValueAxis().name("IP").axisLine(new AxisLine().show(true).lineStyle(new LineStyle().width(0)))
				.max(400).min(-100));
		// 创建类目轴，并且不显示竖着的分割线
		CategoryAxis categoryAxis = new CategoryAxis().splitLine(new SplitLine().show(false))
				.axisLine(new AxisLine().onZero(false));
		// 不显示表格边框，就是围着图标的方框
		option.grid().borderWidth(0);
		// 创建Line数据
		Line line = new Line("访问量").smooth(true);
		// 根据获取的数据赋值
		for (AccessData data : datas) {
			// 增加类目，值为日期
			categoryAxis.data(data.getDate());
			// 日期对应的数据
			line.data(data.getNums());
		}
		// 设置x轴为类目轴
		option.xAxis(categoryAxis);
		// 设置数据
		option.series(line);
		return option;
	}
	
	public static GsonOption getChart2() {
		GsonOption option = new GsonOption();
        option.title("tubiao").animation(false);

        option.xAxis(new CategoryAxis().data("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        option.yAxis(new ValueAxis().splitArea(new SplitArea().show(true)));

        Line line = new Line("蒸发量");
        line.data(12, 5, 4, 10, 15, 7, 13).smooth(true);

        Line line2 = new Line("降水量");
        line2.data(10, 15, 7, 13, 12, 5, 3);

        option.series(line, line2);
        //转换为json
        //System.out.println(option.toString());
        //格式化的json，不利于传输，适合阅读
        //System.out.println(option.toPrettyString());
		return option;
	}
}
