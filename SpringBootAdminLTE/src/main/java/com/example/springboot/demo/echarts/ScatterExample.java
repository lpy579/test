package com.example.springboot.demo.echarts;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.abel533.echarts.AxisPointer;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.axis.TimeAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.ScatterData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Scatter;
import com.github.abel533.echarts.style.LineStyle;

public class ScatterExample {
	public static GsonOption getChart2() {
		//地址：http://echarts.baidu.com/doc/example/scatter2.html
        GsonOption option = new GsonOption();
        option.tooltip(new Tooltip()
                .trigger(Trigger.axis)
                .showDelay(0)
                .axisPointer(new AxisPointer().type(PointerType.cross)
                        .lineStyle(new LineStyle()
                                .type(LineType.dashed).width(1))));
        option.legend("scatter1", "scatter2");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataZoom, Tool.dataView, Tool.restore, Tool.saveAsImage);
        ValueAxis valueAxis = new ValueAxis().power(1).splitNumber(4).scale(true);
        option.xAxis(valueAxis);
        option.yAxis(valueAxis);
        //注：这里的结果是一种圆形一种方形，是因为默认不设置形状时，会循环形状数组
        option.series(
                new Scatter("scatter1").symbolSize("function (value){" +
                        "                return Math.round(value[2] / 5);" +
                        "            }").data(randomDataArray())
                , new Scatter("scatter2").symbolSize("function (value){" +
                        "                return Math.round(value[2] / 5);" +
                        "            }").data(randomDataArray()));
        return option;
	}
	
	private static ScatterData[] randomDataArray() {
        ScatterData[] scatters = new ScatterData[100];
        for (int i = 0; i < scatters.length; i++) {
            scatters[i] = new ScatterData(random(), random(), Math.abs(random()));
        }
        return scatters;
    }

    private static int random() {
        int i = (int) Math.round(Math.random() * 100);
        return (i * (i % 2 == 0 ? 1 : -1));
    }
    
    public static GsonOption getChart3() {
    	//地址：http://echarts.baidu.com/doc/example/scatter3.html
        GsonOption option = new GsonOption();
        option.tooltip(new Tooltip()
                .trigger(Trigger.axis)
                .showDelay(0)
                .axisPointer(new AxisPointer().type(PointerType.cross)
                        .lineStyle(new LineStyle()
                                .type(LineType.dashed).width(1))));
        option.legend("sin", "cos");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataZoom, Tool.dataView, Tool.restore, Tool.saveAsImage);
        ValueAxis valueAxis = new ValueAxis().power(1).precision(2).scale(true);
        option.xAxis(valueAxis);
        option.yAxis(valueAxis);

        Scatter sin = new Scatter("sin");
        sin.large(true);
        Double[][] sinData = new Double[10000][2];
        for (int i = sinData.length; i > 0; i--) {
            double x = round(Math.random() * 10) - 0;
            double y = Math.sin(x) - x * (i % 2 == 0 ? 0.1 : -0.1) * round(Math.random()) - 0;
            sinData[sinData.length - i] = new Double[]{x, y};
        }
        sin.data(sinData);

        Scatter cos = new Scatter("cos");
        cos.large(true);
        Double[][] cosData = new Double[10000][2];
        for (int i = cosData.length; i > 0; i--) {
            double x = round(Math.random() * 10) - 0;
            double y = Math.cos(x) - x * (i % 2 == 0 ? 0.1 : -0.1) * round(Math.random()) - 0;
            cosData[sinData.length - i] = new Double[]{x, y};
        }
        cos.data(cosData);
        option.series(sin, cos);
        return option;
    }
    
    private static Double round(Double d) {
        BigDecimal bigDecimal = new BigDecimal(d.toString());
        bigDecimal = bigDecimal.round(new MathContext(3, RoundingMode.HALF_UP));
        return bigDecimal.doubleValue();
    }
    
    public static GsonOption getChart6() {
    	//地址：http://echarts.baidu.com/doc/example/scatter6.html
        // echarts只能认识js的Date...
        GsonOption option = new GsonOption();
        option.title("时间坐标散点图", "dataZoom支持");
        option.tooltip().trigger(Trigger.axis).axisPointer()
                .show(true)
                .type(PointerType.cross).lineStyle().type(LineType.dashed).width(1);
        option.legend("series1");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.dataZoomNew().show(true).start(30).end(70);
        option.dataRange().min(0).max(100).orient(Orient.horizontal).x(30).y(Y.center).color("lightgreen", "orange").splitNumber(5);
        option.grid().y2(80);
        option.xAxis(new TimeAxis().splitNumber(10));
        option.yAxis(new ValueAxis());
        option.animation(false);

        Scatter series1 = new Scatter("series1");
        series1.tooltip().formatter("function(params){" +
                "                    var date = new Date(params.value[0]);" +
                "                    return params.seriesName " +
                "                           + ' （'" +
                "                           + date.getFullYear() + '-'" +
                "                           + (date.getMonth() + 1) + '-'" +
                "                           + date.getDate() + ' '" +
                "                           + date.getHours() + ':'" +
                "                           + date.getMinutes()" +
                "                           +  '）<br/>'" +
                "                           + params.value[1] + ', ' " +
                "                           + params.value[2];" +
                "                }");
        series1.symbolSize("function (value){" +
                "                return Math.round(value[2]/10);" +
                "            }");
        series1.data(getData().toArray());

        option.series(series1);
        return option;
    }
    
    private static List<Object[]> getData(){
        List<Object[]> dataList = new ArrayList<Object[]>(1500);
        for (int i = 0; i < 1500; i++) {
            dataList.add(new Object[]{getDateStr(new Date(114,9,1,0,(int)Math.round(Math.random()*10000))),
                            (int)(round(Math.random()*30) - 0),
                            (int)(round(Math.random()*100) - 0)
            });
        }
        return dataList;
    }

    private static String getDateStr(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }
}
