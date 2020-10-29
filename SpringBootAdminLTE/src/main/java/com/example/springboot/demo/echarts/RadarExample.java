package com.example.springboot.demo.echarts;

import com.github.abel533.echarts.Radar;
import com.github.abel533.echarts.data.RadarData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.RadarSeries;
import com.github.abel533.echarts.style.TextStyle;

public class RadarExample {
	public static GsonOption getChart1() {
		GsonOption option = new GsonOption();

        option.title().text("基础雷达图").subtext("基础雷达图subtext");

        option.legend("预算分配（Allocated Budget）", "实际开销（Actual Spending）");


        //设置 Radar
        Radar radar = new Radar();
        radar.name(new Radar.Name().textStyle(new TextStyle().color("#fff").backgroundColor("#999").borderRadius(3).padding(new Integer[]{3, 5})));


        radar.indicator(new Radar.Indicator().name("销售（sales）").max(6500),
                new Radar.Indicator().name("管理（Administration）").max(16000),
                new Radar.Indicator().name("信息技术（Information Techology）").max(30000),
                new Radar.Indicator().name("客服（Customer Support）").max(38000),
                new Radar.Indicator().name("研发（Development）").max(52000),
                new Radar.Indicator().name("市场（Marketing）").max(25000));

        option.radar(radar);

        //设置 Series
        RadarSeries radar1 = new RadarSeries("预算 vs 开销（Budget vs spending）");

        RadarData radarData1 = new RadarData("预算分配", new Integer[]{4300, 10000, 28000, 35000, 50000, 19000});
        RadarData radarData2 = new RadarData("实际开销", new Integer[]{5000, 14000, 28000, 31000, 42000, 21000});

        radar1.data(radarData1,radarData2);

        option.series(radar1);
        return option;
	}
}
