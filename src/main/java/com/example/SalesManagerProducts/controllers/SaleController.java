package com.example.SalesManagerProducts.controllers;

import com.example.SalesManagerProducts.entities.Customers;
import com.example.SalesManagerProducts.entities.Products;
import com.example.SalesManagerProducts.entities.Sale;
import com.example.SalesManagerProducts.entities.Users;
import com.example.SalesManagerProducts.persistence.CustomersRepository;
import com.example.SalesManagerProducts.persistence.ProductsRepository;
import com.example.SalesManagerProducts.persistence.SalesRepository;
import com.example.SalesManagerProducts.persistence.UserRepository;
import com.example.SalesManagerProducts.service.ProductsService;
import com.example.SalesManagerProducts.service.SalesService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SaleController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private ProductsRepository productRepo;

    @Autowired
    private CustomersRepository customersRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/newSale")
    public String showNewSaleForm(Model model){
        List<Products> listProducts=productRepo.findAll();
        model.addAttribute("sale", new Sale());
        model.addAttribute("listProducts", listProducts);
        List<Customers> listCustomers=customersRepo.findAll();
        model.addAttribute("listCustomers", listCustomers);
//        Users user=request.getUserPrincipal().getName();
        return "newSale";
    }


    @PostMapping("/saveSale")
    public String saveSale(Sale sale){
        salesService.save(sale);
        return "redirect:/";
    }


//    @RequestMapping(method = RequestMethod.POST)
//    public String sellProduct(@RequestBody SaleModel sale, Authentication authentication){
//         Users salesRepresentative= userRepo.getUserByUsername(get
//    }

}
