package com.example.springboot.demo.echarts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.AxisTick;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.SplitArea;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.itemstyle.Normal;

public class BarExample {
	public static GsonOption getChart0() {
		String[] citis = { "广州", "深圳", "珠海", "汕头", "韶关", "佛山" };
		int[] datas = { 6030, 7800, 5200, 3444, 2666, 5708 };
		String[] colors = { "rgb(2,111,230)", "rgb(186,73,46)", "rgb(78,154,97)", "rgb(2,111,230)", "rgb(186,73,46)",
				"rgb(78,154,97)" };
		String title = "地市数据";
		boolean isHorizontal = true;

		// 底层调用gson的类
		GsonOption option = new GsonOption();
		option.title(title);

		// 工具栏(Tool.mark数据视图，Tool.mark辅助线，MagicType图切换，Tool.restore还原，Tool.saveAsImage保存为图片
		option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar),
				Tool.restore, Tool.saveAsImage);

		// 显示工具提示,设置提示格式
		option.tooltip().show(true).formatter("{a} <br/>{b} : {c}");

		// 图例
		option.legend(title);
		Bar bar = new Bar(title);
		CategoryAxis category = new CategoryAxis();// 轴分类

		// 轴数据
		category.data((Object[]) citis);
		for (int i = 0; i < citis.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>(2);
			map.put("value", datas[i]);
			map.put("itemStyle", new ItemStyle().normal(new Normal().color(colors[i])));
			bar.data(map);
		}
		if (isHorizontal) {// 横轴为类别、纵轴为值
			option.xAxis(category);// x轴
			option.yAxis(new ValueAxis());// y轴
		} else {// 横轴为值、纵轴为类别
			option.xAxis(new ValueAxis());// x轴
			option.yAxis(category);// y轴
		}
		option.series(bar);

		return option;
	}
	
	public static GsonOption getChart1() {
		//地址：http://echarts.baidu.com/doc/example/bar1.html
		GsonOption option = new GsonOption();
        option.title().text("某地区蒸发量和降水量").subtext("纯属虚构");
        option.tooltip().trigger(Trigger.axis);
        option.legend("蒸发量", "降水量");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
        option.calculable(true);
        option.xAxis(new CategoryAxis().data("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));
        option.yAxis(new ValueAxis());

        Bar bar = new Bar("蒸发量");
        bar.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3);
        bar.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
        bar.markLine().data(new PointData().type(MarkType.average).name("平均值"));

        Bar bar2 = new Bar("降水量");
        List<Double> list = Arrays.asList(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);
        bar2.data(list);
        bar2.markPoint().data(new PointData("年最高", 182.2).xAxis(7).yAxis(183).symbolSize(18), new PointData("年最低", 2.3).xAxis(11).yAxis(3));
        bar2.markLine().data(new PointData().type(MarkType.average).name("平均值"));

        option.series(bar, bar2);
        return option;
	}
	
	public static GsonOption getChart4() {
		//地址：http://echarts.baidu.com/doc/example/bar4.html
		GsonOption option = new GsonOption();
        option.tooltip().trigger(Trigger.axis).axisPointer().type(PointerType.shadow);
        option.legend("直接访问", "邮件营销", "联盟广告", "视频广告", "搜索引擎");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
        option.calculable(true);
        option.yAxis(new CategoryAxis().data("周一", "周二", "周三", "周四", "周五", "周六", "周日"));
        option.xAxis(new ValueAxis());

        Bar bar = new Bar("直接访问");
        bar.stack("总量");
        bar.itemStyle().normal().label().show(true).position("insideRight");
        bar.data(320, 302, 301, 334, 390, 330, 320);

        Bar bar2 = new Bar("邮件营销");
        bar2.stack("总量");
        bar2.itemStyle().normal().label().show(true).position("insideRight");
        bar2.data(320, 302, 301, 334, 390, 330, 320);

        Bar bar3 = new Bar("联盟广告");
        bar3.stack("总量");
        bar3.itemStyle().normal().label().show(true).position("insideRight");
        bar3.data(120, 132, 101, 134, 90, 230, 210);

        Bar bar4 = new Bar("视频广告");
        bar4.stack("总量");
        bar4.itemStyle().normal().label().show(true).position("insideRight");
        bar4.data(150, 212, 201, 154, 190, 330, 410);

        Bar bar5 = new Bar("搜索引擎");
        bar5.stack("总量");
        bar5.itemStyle().normal().label().show(true).position("insideRight");
        bar5.data(820, 832, 901, 934, 1290, 1330, 1320);

        option.series(bar, bar2, bar3, bar4, bar5);
        return option;
	}
	
	public static GsonOption getChart12() {
		//地址：http://echarts.baidu.com/doc/example/bar12.html
		GsonOption option = new GsonOption();
        option.title("ECharts2 vs ECharts1", "Chrome下测试数据");
        option.tooltip(Trigger.axis);
        option.legend(
                "ECharts1 - 2k数据", "ECharts1 - 2w数据", "ECharts1 - 20w数据", "",
                "ECharts2 - 2k数据", "ECharts2 - 2w数据", "ECharts2 - 20w数据");
        option.toolbox().show(true)
                .feature(
                        Tool.mark, Tool.dataView,
                        new MagicType(Magic.line, Magic.bar),
                        Tool.restore, Tool.saveAsImage);
        option.calculable(true);
        option.grid().y(70).y2(30).x2(20);
        option.xAxis(
                new CategoryAxis().data("Line", "Bar", "Scatter", "K", "Map"),
                new CategoryAxis()
                        .axisLine(new AxisLine().show(false))
                        .axisTick(new AxisTick().show(false))
                        .axisLabel(new AxisLabel().show(false))
                        .splitArea(new SplitArea().show(false))
                        .axisLine(new AxisLine().show(false))
                        .data("Line", "Bar", "Scatter", "K", "Map")
        );
        option.yAxis(new ValueAxis().axisLabel(new AxisLabel().formatter("{value} ms")));

        Bar b1 = new Bar("ECharts2 - 2k数据");
        b1.itemStyle().normal().color("rgba(193,35,43,1)").label().show(true);
        b1.data(40, 155, 95, 75, 0);

        Bar b2 = new Bar("ECharts2 - 2w数据");
        b2.itemStyle().normal().color("rgba(181,195,52,1)").label().show(true).textStyle().color("#27727B");
        b2.data(100, 200, 105, 100, 156);

        Bar b3 = new Bar("ECharts2 - 20w数据");
        b3.itemStyle().normal().color("rgba(252,206,16,1)").label().show(true).textStyle().color("#E87C25");
        b3.data(906, 911, 908, 778, 0);

        Bar b4 = new Bar("ECharts1 - 2k数据");
        b4.itemStyle().normal().color("rgba(193,35,43,0.5)").label().show(true).formatter("function(a,b,c){return c>0 ? (c +'\n'):'';}");
        b4.data(96, 224, 164, 124, 0).xAxisIndex(1);

        Bar b5 = new Bar("ECharts1 - 2w数据");
        b5.itemStyle().normal().color("rgba(181,195,52,0.5)").label().show(true);
        b5.data(491, 2035, 389, 955, 347).xAxisIndex(1);

        Bar b6 = new Bar("ECharts1 - 20w数据");
        b6.itemStyle().normal().color("rgba(252,206,16,0.5)").label().show(true).formatter("function(a,b,c){return c>0 ? (c +'+'):'';}");
        b6.data(3000, 3000, 2817, 3000, 0, 1242).xAxisIndex(1);

        option.series(b1, b2, b3, b4, b5, b6);
        return option;
	}
	
	public static GsonOption getChart14() {
		//地址：http://echarts.baidu.com/echarts2/doc/example/bar14.html
		GsonOption option = new GsonOption();
        option.title().text("ECharts例子个数统计").subtext("Rainbow bar example")
            .link("http://echarts.baidu.com/doc/example.html").x(X.center);
        option.tooltip().trigger(Trigger.item);
        option.calculable(true);
        option.grid().borderWidth(0).y(80).y2(60);
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
        option.xAxis(new CategoryAxis().data("Line", "Bar", "Scatter", "K", "Pie", "Radar", "Chord", "Force", "Map", "Gauge", "Funnel"));
        option.yAxis(new ValueAxis().show(false));

        Bar bar = new Bar("ECharts例子个数统计");
        bar.itemStyle().normal().color("function(params) {" +
                "                        var colorList = [" +
                "                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'," +
                "                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD'," +
                "                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'" +
                "                        ];" +
                "                        return colorList[params.dataIndex]" +
                "                    }")
                .label().show(true).position(Position.top).formatter("{b}\n{c}");
        bar.data(12,21,10,4,12,5,6,5,25,23,7);

        option.series(bar);
        return option;
	}
}
