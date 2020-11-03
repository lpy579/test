package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springboot.common.MyEchartsTemplate;
import com.example.springboot.demo.echarts.BarExample;
import com.example.springboot.demo.echarts.FunnelExample;
import com.example.springboot.demo.echarts.GaugeExample;
import com.example.springboot.demo.echarts.HeatmapExample;
import com.example.springboot.demo.echarts.LineExample;
import com.example.springboot.demo.echarts.MapExample;
import com.example.springboot.demo.echarts.OtherExample;
import com.example.springboot.demo.echarts.PieExample;
import com.example.springboot.demo.echarts.RadarExample;
import com.example.springboot.demo.echarts.ScatterExample;
import com.example.springboot.demo.echarts.TreemapExample;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.abel533.echarts.json.GsonOption;

@Controller
@RequestMapping("/examples/echarts")
public class EChartsController {
	private MyEchartsTemplate myEchartsTemplate = new MyEchartsTemplate();

    @GetMapping
    public String index() {
        return "redirect:/examples/echarts/bar";
    }
    
	@GetMapping("/bar")
	public String barExample(Model model) throws JsonProcessingException {
		GsonOption optChart0 = BarExample.getChart0();
		GsonOption optChart1 = BarExample.getChart1();
		GsonOption optChart4 = BarExample.getChart4();
		GsonOption optChart12 = BarExample.getChart12();
		GsonOption optChart14 = BarExample.getChart14();
		String htmlChart0 = myEchartsTemplate.generateChartTag("chart0", 800, 400, optChart0);
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		String htmlChart4 = myEchartsTemplate.generateChartTag("chart4", 1000, 400, optChart4);
		String htmlChart12 = myEchartsTemplate.generateChartTag("chart12", 1000, 400, optChart12);
		String htmlChart14 = myEchartsTemplate.generateChartTag("chart14", 1000, 400, optChart14);
		model.addAttribute("htmlChart0", htmlChart0);
		model.addAttribute("htmlChart1", htmlChart1);
		model.addAttribute("htmlChart4", htmlChart4);
		model.addAttribute("htmlChart12", htmlChart12);
		model.addAttribute("htmlChart14", htmlChart14);
		return "examples/echarts/bar";
	}
	
	@GetMapping("/funnel")
	public String funnelExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = FunnelExample.getChart1();
		GsonOption optChart2 = FunnelExample.getChart2();
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		String htmlChart2 = myEchartsTemplate.generateChartTag("chart2", 1000, 400, optChart2);
		model.addAttribute("htmlChart1", htmlChart1);
		model.addAttribute("htmlChart2", htmlChart2);
		return "examples/echarts/funnel";
	}
	
	@GetMapping("/gauge")
	public String gaugeExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = GaugeExample.getChart1();
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		model.addAttribute("htmlChart1", htmlChart1);
		return "examples/echarts/gauge";
	}
	
	@GetMapping("/heatmap")
	public String heatmapExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = HeatmapExample.getChart1();
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		model.addAttribute("htmlChart1", htmlChart1);
		return "examples/echarts/heatmap";
	}
	
	@GetMapping("/line")
	public String lineExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = LineExample.getChart1();
		GsonOption optChart3 = LineExample.getChart3();
		GsonOption optChart5 = LineExample.getChart5();
		GsonOption optChart6 = LineExample.getChart6();
		GsonOption optChart9 = LineExample.getChart9();
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		String htmlChart3 = myEchartsTemplate.generateChartTag("chart3", 1000, 400, optChart3);
		String htmlChart5 = myEchartsTemplate.generateChartTag("chart5", 1000, 400, optChart5);
		String htmlChart6 = myEchartsTemplate.generateChartTag("chart6", 1000, 400, optChart6);
		String htmlChart9 = myEchartsTemplate.generateChartTag("chart9", 1000, 400, optChart9);
		model.addAttribute("htmlChart1", htmlChart1);
		model.addAttribute("htmlChart3", htmlChart3);
		model.addAttribute("htmlChart5", htmlChart5);
		model.addAttribute("htmlChart6", htmlChart6);
		model.addAttribute("htmlChart9", htmlChart9);
		return "examples/echarts/line";
	}
	
	@GetMapping("/map")
	public String mapExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = MapExample.getChart1();
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		model.addAttribute("htmlChart1", htmlChart1);
		return "examples/echarts/map";
	}
	
	@GetMapping("/other")
	public String otherExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = OtherExample.getChart1();
		GsonOption optChart2 = OtherExample.getChart2();
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		String htmlChart2 = myEchartsTemplate.generateChartTag("chart2", 1000, 400, optChart2);
		model.addAttribute("htmlChart1", htmlChart1);
		model.addAttribute("htmlChart2", htmlChart2);
		return "examples/echarts/other";
	}

	@GetMapping("/pie")
	public String pieExample(Model model) throws JsonProcessingException {
		GsonOption optChart6 = PieExample.getChart6();
		GsonOption optChart7 = PieExample.getChart7();
		String htmlChart6 = myEchartsTemplate.generateChartTag("chart6", 1000, 400, optChart6);
		String htmlChart7 = myEchartsTemplate.generateChartTag("chart7", 1000, 400, optChart7);
		model.addAttribute("htmlChart6", htmlChart6);
		model.addAttribute("htmlChart7", htmlChart7);
		return "examples/echarts/pie";
	}

	@GetMapping("/radar")
	public String radarExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = RadarExample.getChart1();
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		model.addAttribute("htmlChart1", htmlChart1);
		return "examples/echarts/radar";
	}
	
	@GetMapping("/scatter")
	public String scatterExample(Model model) throws JsonProcessingException {
		GsonOption optChart2 = ScatterExample.getChart2();
		GsonOption optChart3 = ScatterExample.getChart3();
		GsonOption optChart6 = ScatterExample.getChart6();
		String htmlChart2 = myEchartsTemplate.generateChartTag("chart2", 1000, 400, optChart2);
		String htmlChart3 = myEchartsTemplate.generateChartTag("chart3", 1000, 400, optChart3);
		String htmlChart6 = myEchartsTemplate.generateChartTag("chart6", 1000, 400, optChart6);
		model.addAttribute("htmlChart2", htmlChart2);
		model.addAttribute("htmlChart3", htmlChart3);
		model.addAttribute("htmlChart6", htmlChart6);
		return "examples/echarts/scatter";
	}
	
	@GetMapping("/treemap")
	public String treemapExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = TreemapExample.getChart1();
		String htmlChart1 = myEchartsTemplate.generateChartTag("chart1", 1000, 400, optChart1);
		model.addAttribute("htmlChart1", htmlChart1);
		return "examples/echarts/treemap";
	}
	
	/**
	 * JSON API example.
	 * http://localhost:8080/examples/echarts/barchart0.json
	 * 
	 * @return
	 */
	@ResponseBody
	@GetMapping("/barchart0.json")
	public GsonOption barChartData0() {
		GsonOption optChart0 = BarExample.getChart0();
		return optChart0;
	}
	
	/**
	 * JSON API example.
	 * http://localhost:8080/examples/echarts/barchart1.json
	 * 
	 * @return
	 */
	@ResponseBody
	@GetMapping("/barchart1.json")
	public GsonOption barChartData1() {
		GsonOption optChart1 = BarExample.getChart1();
		return optChart1;
	}

}
