package com.example.customermanagementspringmvc.controller;

import com.example.customermanagementspringmvc.model.Customer;
import com.example.customermanagementspringmvc.service.CustomerService;
import com.example.customermanagementspringmvc.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    //trả về trang list.jsp hiện danh sách customer
    @GetMapping(value = "")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    //trả về trang view.jsp hiện info mỗi customer với id tương ứng
    @GetMapping(value = "/view/{id}")
    public ModelAndView showInformation (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        Customer customer = customerService.findById(Math.toIntExact(id));
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    //trả về trang edit.jsp cập nhật info mỗi customer với id tương ứng
    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Customer customer = customerService.findById(Math.toIntExact(id));
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    //cập nhật customer và trả về trang edit.jsp với thông báo (dùng RedirectAttributes để tránh lỗi)
    @PostMapping(value = "/edit/{id}")
    public String updateCustomer (@PathVariable Long id,
                                  @RequestParam String name,
                                  @RequestParam String email,
                                  @RequestParam String address,
                                  RedirectAttributes redirectAttributes) {

        Customer customer = new Customer(Math.toIntExact(id), name, email, address);
        customerService.update(Math.toIntExact(id), customer);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:{id}";
    }


}
