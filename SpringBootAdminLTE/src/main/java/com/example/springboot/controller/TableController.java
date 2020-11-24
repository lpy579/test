package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.common.MyDataTablesTemplate;
import com.example.springboot.common.MyTablesawTemplate;
import com.example.springboot.model.Customer;
import com.example.springboot.service.CustomerService;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

@Controller
@RequestMapping("/examples/table")
public class TableController {
    private final CustomerService service;

    /** Default constructor */
    @Autowired
    public TableController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return "redirect:/examples/table/datatable";
    }
    
	private static Table getTablesawTable1() {
		String[] animals = { "bear", "cat", "giraffe" };
		double[] cuteness = { 90.1, 84.3, 99.7 };

		Table cuteAnimals = Table.create("Cute Animals").addColumns(
				StringColumn.create("Animal types", animals),
				DoubleColumn.create("rating", cuteness));

		return cuteAnimals;
	}

    @GetMapping(value = "/datatable")
    public String datatable(Model model) {
    	List<Customer> custList = service.findAll();
    	
		model.addAttribute("datatable_custList", custList);
		
        return "examples/table/datatable";
    }
    
    @GetMapping(value = "/tablesaw")
    public String tablesaw(Model model) {
    	String tableId1 = "tablesaw1";
		Table tableObj1 = getTablesawTable1();
		MyTablesawTemplate mtt = new MyTablesawTemplate();
		String htmlTag = mtt.generateTag(tableId1, tableObj1);

    	MyDataTablesTemplate mdtt = new MyDataTablesTemplate();
    	mdtt.add(tableId1, "{ 'paging': false, 'ordering': true, 'info': true }");
    	String jsDataTables = mdtt.generateBodyJS_001();
    	
		model.addAttribute(tableId1, htmlTag);
		model.addAttribute("jsDataTables", jsDataTables);
		
        return "examples/table/tablesaw";
    }

}
