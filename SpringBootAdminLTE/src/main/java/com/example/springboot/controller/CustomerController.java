package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springboot.config.AppConstant;
import com.example.springboot.model.Customer;
import com.example.springboot.service.CustomerService;

@Controller
@RequestMapping("/examples/customer")
public class CustomerController {
    private final CustomerService service;

    /** Default constructor */
    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return "redirect:/examples/customer/";
    }

    @GetMapping(value = {"/", "/{pageNumber}"})
    public String list(@PathVariable(required = false) Integer pageNumber, Model model) {
    	if (pageNumber == null) {
    		pageNumber = 1;
    	}
    	
        Page<Customer> page = service.getList(pageNumber, AppConstant.DEFAULT_PAGE_SIZE);
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        return "examples/customer/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "examples/customer/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("customer", service.findById(id));
        return "examples/customer/form";
    }

    @PostMapping(value = "/save")
    public String save(Customer customer, Model model, final RedirectAttributes redirectAttributes) {
        service.save(customer);
        redirectAttributes.addFlashAttribute("successFlash", "Customer was successfully saved.");
        return "redirect:/examples/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model, final RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("successFlash", "Customer was successfully deleted.");
        return "redirect:/examples/customer";
    }
}
