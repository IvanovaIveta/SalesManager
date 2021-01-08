package com.example.SalesManagerProducts.controllers;


import com.example.SalesManagerProducts.entities.*;
import com.example.SalesManagerProducts.persistence.SalesRepository;
import com.example.SalesManagerProducts.service.CustomersService;
import com.example.SalesManagerProducts.service.ProductsService;
import com.example.SalesManagerProducts.service.SalesService;
import com.example.SalesManagerProducts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductsService service;
    @Autowired
    private CustomersService customersService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private SalesService salesService;

//    @Autowired
//    private SalesRepository salesRepo;


    @RequestMapping("/")
    public String viewHomePage(Model model) throws RoleNotFoundException {
        Iterable<Products> listProducts= service.listAll();
        model.addAttribute("listProducts", listProducts);

        List<Customers> listCustomers=customersService.listAll();
        model.addAttribute("listCustomers", listCustomers);

        //  List<Users> listUsers= usersService.listAll();

        List<Users> listUsers=  usersService.getRepresentatives();
        model.addAttribute("listUsers", listUsers);

//        List<Users> listUsers=  userService.getRepresentatives();
//        model.addAttribute("listUsers", listUsers);

//        List<Sale>listSales= salesService.listAll();
//        model.addAttribute("listSales",listSales);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Products product= new Products();
        model.addAttribute("product", product);
        return "new_product";
    }
    @RequestMapping("/new_customer")
    public String showNewCustomerForm(Model model){
        Customers customer= new Customers();
        model.addAttribute("customer", customer);
        return "new_customer";
    }
    @RequestMapping ("/newUserSR")
    public String showNewUserSRForm(Model model){
      //  Users user= new Users();
        model.addAttribute("user", new Users());
      //  model.addAttribute("user", user);
        //model.addAttribute("roles_id", 2);

        return "newUserSR";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Products product){

        service.save(product);
        return "redirect:/";
    }
    @RequestMapping(value="/save_customer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customers customers){
        customersService.save(customers);
        return "redirect:/";
    }
    @PostMapping (value="/saveUserSR")
    public String saveUserSR(@ModelAttribute("user") Users users){
//        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
//        String encodedPassword= encoder.encode(users.getPassword());
//        users.setPassword(encodedPassword);
        //usersService.save(users);
        usersService.save(users);
        return "redirect:/";
    }

    @RequestMapping("/edit/{product_id}")
    public ModelAndView showNewEditForm(@PathVariable(name="product_id") int product_id){
        ModelAndView mav= new ModelAndView("edit_product");

        Products product= service.get(product_id);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/edit_customer/{customer_id}")
    public ModelAndView showNewEditCustomerForm(@PathVariable(name="customer_id") int customer_id){
        ModelAndView mav= new ModelAndView("edit_customer");

        Customers customers= customersService.get(customer_id);
        mav.addObject("customers", customers);
        return mav;
    }
    @RequestMapping("/editUserSR/{user_id}")
    public ModelAndView showNewEditUserSRForm(@PathVariable(name="user_id") int user_id){
        ModelAndView mav= new ModelAndView("editUserSR");

        //  Users users= usersService.get(user_id);
        Users users= usersService.get(user_id);
        mav.addObject("users", users);
        return mav;
    }

    @GetMapping("/delete/{product_id}")
    public String deleteProduct(@PathVariable(name="product_id") Integer product_id){
        service.delete(product_id);
        return "redirect:/";
    }

    @GetMapping("/delete_customer/{customer_id}")
    public String deleteCustomer(@PathVariable(name="customer_id") Integer customer_id){
        customersService.delete(customer_id);
        return "redirect:/";
    }
    @GetMapping("/deleteUserSR/{user_id}")
    public String deleteUserSR(@PathVariable(name="user_id") Integer user_id){
        usersService.delete(user_id);

        return "redirect:/";
    }

//    @GetMapping("/decreaseAmount/{product_id}")
//    public String decreaseAmount(@PathVariable(name="product_id") Integer product_id) throws Exception {
//        salesService.decreaseAmount(products.getQuantity(),1);
//        return "redirect:/";
//    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }


    @GetMapping("/login")
    public String showLoginPage(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:/";
    }

//    @GetMapping("/newSale")
//    public String showNewSaleForm(Model model){
//        List<Products>listProducts=service.listAll();
//        model.addAttribute("sale", new Sale());
//        model.addAttribute("listProducts", listProducts);
//        return "newSale";
//    }
//
//    @RequestMapping(value="/saveSale", method = RequestMethod.POST)
//    public String saveSale(@ModelAttribute("sale") Sale sale){
//        salesService.save(sale);
//        return "redirect:/";
//    }

}
