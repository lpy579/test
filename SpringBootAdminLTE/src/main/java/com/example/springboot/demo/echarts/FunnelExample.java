package com.example.springboot.demo.echarts;

import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.LabelLine;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Sort;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.style.LineStyle;
import com.github.abel533.echarts.style.TextStyle;

public class FunnelExample {
	public static GsonOption getChart1() {
		//地址：http://echarts.baidu.com/doc/example/funnel.html
        GsonOption option = new GsonOption();
        option.title().text("漏斗图").subtext("纯属虚构");
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.legend("展现", "点击", "访问", "咨询", "订单");
        option.calculable(true);

        Funnel funnel = new Funnel("漏斗图");
        funnel.x("10%").y(60).width("80%").
                min(0).max(100).
                minSize("0%").maxSize("100%").
                sort(Sort.descending).
                gap(10);
        funnel.itemStyle().normal().borderColor("#fff").borderWidth(1).
                label(new Label().show(true).position(Position.inside)).
                labelLine(new LabelLine().show(false).length(10).lineStyle(new LineStyle().width(1).type(LineType.solid)));
        funnel.itemStyle().emphasis().borderColor("red").borderWidth(5).
                label(new Label().show(true).formatter("{b}:{c}%").textStyle(new TextStyle().fontSize(20))).
                labelLine(new LabelLine().show(true));

        funnel.data(new Data().value(60).name("访问"),
                new Data().value(40).name("咨询"),
                new Data().value(20).name("订单"),
                new Data().value(80).name("点击"),
                new Data().value(100).name("展现")
        );

        option.series(funnel);
        return option;
	}
	
	public static GsonOption getChart2() {
		GsonOption option = new GsonOption();
        option.color("rgba(255, 69, 0, 0.5)",
                "rgba(255, 150, 0, 0.5)",
                "rgba(255, 200, 0, 0.5)",
                "rgba(155, 200, 50, 0.5)",
                "rgba(55, 200, 100, 0.5)");
        option.title().text("漏斗图").subtext("纯属虚构");
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.legend("展现", "点击", "访问", "咨询", "订单");
        option.calculable(true);

        Funnel funnel = new Funnel("预期");
        funnel.x("10%").y(60).width("80%");
        funnel.itemStyle().normal().label(new Label().formatter("{b}预期")).
                labelLine(new LabelLine().show(false));
        funnel.itemStyle().emphasis().label(new Label().formatter("{b}预期 : {c}%").position(Position.inside)).
                labelLine(new LabelLine().show(true));

        funnel.data(new Data().value(60).name("访问"),
                new Data().value(40).name("咨询"),
                new Data().value(20).name("订单"),
                new Data().value(80).name("点击"),
                new Data().value(100).name("展现")
        );

        Funnel funnel2 = new Funnel("实际");
        funnel2.x("10%").y(60).width("80%").maxSize("80%");
        funnel2.itemStyle().normal().label(new Label().formatter("{c}%").position(Position.inside).textStyle(new TextStyle().color("#fff"))).
                borderColor("#fff").borderWidth(2);
        funnel2.itemStyle().emphasis().label(new Label().formatter("{b}实际 : {c}%").position(Position.inside)).
                labelLine(new LabelLine().show(true));

        funnel2.data(new Data().value(30).name("访问"),
                new Data().value(10).name("咨询"),
                new Data().value(5).name("订单"),
                new Data().value(50).name("点击"),
                new Data().value(80).name("展现")
        );

        option.series(funnel,funnel2);
        return option;
	}
}
