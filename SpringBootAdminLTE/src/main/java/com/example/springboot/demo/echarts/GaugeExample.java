package com.example.springboot.demo.echarts;

import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Gauge;
import com.github.abel533.echarts.series.gauge.Detail;

public class GaugeExample {
	public static GsonOption getChart1() {
		// 地址： http://echarts.baidu.com/doc/example/gauge1.html
        GsonOption option = new GsonOption();
        option.tooltip().formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.restore, Tool.saveAsImage);
        option.series(new Gauge("业务指标").detail(new Detail().formatter("{value}%")).data(new Data("完成率", 75)));
        return option;
	}
}
