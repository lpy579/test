package com.example.springboot.demo.echarts;

import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.data.LineData;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;


public class PieExample {
	public static GsonOption getChart6() {
		//地址：http://echarts.baidu.com/doc/example/pie6.html
        ItemStyle dataStyle = new ItemStyle();
        dataStyle.normal().label(new Label().show(false)).labelLine().show(false);

        ItemStyle placeHolderStyle = new ItemStyle();
        placeHolderStyle.normal().color("rgba(0,0,0,0)").label(new Label().show(false)).labelLine().show(false);
        placeHolderStyle.emphasis().color("rgba(0,0,0,0)");

        GsonOption option = new GsonOption();
        option.title().text("你幸福吗？")
                .subtext("From ExcelHome")
                .sublink("http://e.weibo.com/1341556070/AhQXtjbqh")
                .x(X.center)
                .y(Y.center)
                .itemGap(20)
                .textStyle().color("rgba(30,144,255,0.8)")
                .fontFamily("微软雅黑")
                .fontSize(35)
                .fontWeight("bolder");
        option.tooltip().show(true).formatter("{a} <br/>{b} : {c} ({d}%)");
        option.legend().orient(Orient.vertical)
                .x("(function(){return document.getElementById('chart6').offsetWidth / 2;})()")
                .y(56)
                .itemGap(12)
                .data("68%的人表示过的不错", "29%的人表示生活压力很大", "3%的人表示“我姓曾”");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);

        Pie p1 = new Pie("1");
        p1.clockWise(false).radius(125, 150).itemStyle(dataStyle)
                .data(new Data("68%的人表示过的不错", 68), new Data("invisible", 32).itemStyle(placeHolderStyle));

        Pie p2 = new Pie("2");
        p2.clockWise(false).radius(100, 125).itemStyle(dataStyle)
                .data(new Data("29%的人表示生活压力很大", 29), new Data("invisible", 71).itemStyle(placeHolderStyle));

        Pie p3 = new Pie("3");
        p3.clockWise(false).radius(75, 100).itemStyle(dataStyle)
                .data(new Data("3%的人表示“我姓曾”", 3), new Data("invisible", 97).itemStyle(placeHolderStyle));

        option.series(p1, p2, p3);
        return option;
	}
	
    /**
     * 获取饼图数据
     *
     * @param idx
     * @return
     */
    private static Pie getPie(int idx) {
        return new Pie().name("浏览器（数据纯属虚构）").data(
                new PieData("Chrome", idx * 128 + 80),
                new PieData("Firefox", idx * 64 + 160),
                new PieData("Safari", idx * 32 + 320),
                new PieData("IE9+", idx * 16 + 640),
                new PieData("IE8-", idx * 8 + 1280));
    }
    
	public static GsonOption getChart7() {
		//地址：http://echarts.baidu.com/doc/example/pie7.html
		GsonOption option = new GsonOption();
        //时间轴
        option.timeline().data("2013-01-01", "2013-02-01", "2013-03-01", "2013-04-01", "2013-05-01",
                new LineData("2013-06-01", "emptyStart6", 8), "2013-07-01", "2013-08-01", "2013-09-01", "2013-10-01",
                "2013-11-01", new LineData("2013-12-01", "star6", 8));
        option.timeline().autoPlay(true);
        //timeline变态的地方在于多个Option
        GsonOption basic = new GsonOption();
        basic.title().text("浏览器占比变化").subtext("纯属虚构");
        basic.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
        basic.legend().data("Chrome", "Firefox", "Safari", "IE9+", "IE8-");
        basic.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage, new MagicType(Magic.pie, Magic.funnel)
                .option(new MagicType.Option().funnel(
                        new Funnel().x("25%").width("50%").funnelAlign(X.left).max(1548))));

        int idx = 1;
        Pie pie = getPie(idx++).center("50%", "45%").radius("50%");
        pie.label().normal().show(true).formatter("{b}{c}({d}%)");
        basic.series(pie);
        //加入
        option.options(basic);
        //构造11个数据
        Option[] os = new Option[11];
        for (int i = 0; i < os.length; i++) {
            os[i] = new GsonOption().series(getPie(idx++));
        }
        option.options(os);
        return option;
	}
}
