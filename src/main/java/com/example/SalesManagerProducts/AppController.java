package com.example.SalesManagerProducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductsService service;
    @Autowired
    private CustomersService customers_service;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Products> listProducts= service.listAll();
        model.addAttribute("listProducts", listProducts);

        List<Customers> listCustomers=customers_service.listAll();
        model.addAttribute("listCustomers", listCustomers);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Products product= new Products();
        model.addAttribute("product", product);
        return "new_product";
    }
//    @RequestMapping("/new")
//    public String showNewCustomerForm(Model model){
//        Customers customer= new Customers();
//        model.addAttribute("customer", customer);
//        return "new_customer";
//    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Products product){
        service.save(product);
        return "redirect:/";
    }
//    @RequestMapping(value="/save", method = RequestMethod.POST)
//    public String saveCustomer(@ModelAttribute("customer") Customers customers){
//        customers_service.save(customers);
//        return "redirect:/";
//    }

    @RequestMapping("/edit/{product_id}")
    public ModelAndView showNewEditForm(@PathVariable(name="product_id") int product_id){
        ModelAndView mav= new ModelAndView("edit_product");

        Products product= service.get(product_id);
        mav.addObject("product", product);
        return mav;
    }

//    @RequestMapping("/edit/{customer_id}")
//    public ModelAndView showNewEditCustomerForm(@PathVariable(name="customer_id") int customer_id){
//        ModelAndView mav= new ModelAndView("edit_customer");
//
//        Customers customers= customers_service.get(customer_id);
//        mav.addObject("product", customers);
//        return mav;
//    }

    @RequestMapping("/delete/{product_id}")
    public String deleteProduct(@PathVariable(name="product_id") Integer product_id){
        service.delete(product_id);
        return "redirect:/";
    }

//    @RequestMapping("/delete/{customer_id}")
//    public String deleteCustomer(@PathVariable(name="customer_id") Integer customer_id){
//        service.delete(customer_id);
//        return "redirect:/";
//    }

}
