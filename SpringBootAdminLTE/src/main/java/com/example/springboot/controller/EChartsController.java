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
		model.addAttribute("jsChart0", myEchartsTemplate.generateChartJS("chart0", optChart0));
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
		model.addAttribute("jsChart4", myEchartsTemplate.generateChartJS("chart4", optChart4));
		model.addAttribute("jsChart12", myEchartsTemplate.generateChartJS("chart12", optChart12));
		model.addAttribute("jsChart14", myEchartsTemplate.generateChartJS("chart14", optChart14));
		return "examples/echarts/bar";
	}
	
	@GetMapping("/funnel")
	public String funnelExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = FunnelExample.getChart1();
		GsonOption optChart2 = FunnelExample.getChart2();
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
		model.addAttribute("jsChart2", myEchartsTemplate.generateChartJS("chart2", optChart2));
		return "examples/echarts/funnel";
	}
	
	@GetMapping("/gauge")
	public String gaugeExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = GaugeExample.getChart1();
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
		return "examples/echarts/gauge";
	}
	
	@GetMapping("/heatmap")
	public String heatmapExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = HeatmapExample.getChart1();
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
		return "examples/echarts/heatmap";
	}
	
	@GetMapping("/line")
	public String lineExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = LineExample.getChart1();
		GsonOption optChart3 = LineExample.getChart3();
		GsonOption optChart5 = LineExample.getChart5();
		GsonOption optChart6 = LineExample.getChart6();
		GsonOption optChart9 = LineExample.getChart9();
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
		model.addAttribute("jsChart3", myEchartsTemplate.generateChartJS("chart3", optChart3));
		model.addAttribute("jsChart5", myEchartsTemplate.generateChartJS("chart5", optChart5));
		model.addAttribute("jsChart6", myEchartsTemplate.generateChartJS("chart6", optChart6));
		model.addAttribute("jsChart9", myEchartsTemplate.generateChartJS("chart9", optChart9));
		return "examples/echarts/line";
	}
	
	@GetMapping("/map")
	public String mapExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = MapExample.getChart1();
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
		return "examples/echarts/map";
	}
	
	@GetMapping("/other")
	public String otherExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = OtherExample.getChart1();
		GsonOption optChart2 = OtherExample.getChart2();
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
		model.addAttribute("jsChart2", myEchartsTemplate.generateChartJS("chart2", optChart2));
		return "examples/echarts/other";
	}

	@GetMapping("/pie")
	public String pieExample(Model model) throws JsonProcessingException {
		GsonOption optChart6 = PieExample.getChart6();
		GsonOption optChart7 = PieExample.getChart7();
		model.addAttribute("jsChart6", myEchartsTemplate.generateChartJS("chart6", optChart6));
		model.addAttribute("jsChart7", myEchartsTemplate.generateChartJS("chart7", optChart7));
		return "examples/echarts/pie";
	}

	@GetMapping("/radar")
	public String radarExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = RadarExample.getChart1();
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
		return "examples/echarts/radar";
	}
	
	@GetMapping("/scatter")
	public String scatterExample(Model model) throws JsonProcessingException {
		GsonOption optChart2 = ScatterExample.getChart2();
		GsonOption optChart3 = ScatterExample.getChart3();
		GsonOption optChart6 = ScatterExample.getChart6();
		model.addAttribute("jsChart2", myEchartsTemplate.generateChartJS("chart2", optChart2));
		model.addAttribute("jsChart3", myEchartsTemplate.generateChartJS("chart3", optChart3));
		model.addAttribute("jsChart6", myEchartsTemplate.generateChartJS("chart6", optChart6));
		return "examples/echarts/scatter";
	}
	
	@GetMapping("/treemap")
	public String treemapExample(Model model) throws JsonProcessingException {
		GsonOption optChart1 = TreemapExample.getChart1();
		model.addAttribute("jsChart1", myEchartsTemplate.generateChartJS("chart1", optChart1));
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
