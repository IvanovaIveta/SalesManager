package com.example.SalesManagerProducts.controllers;

import com.example.SalesManagerProducts.entities.Customers;
import com.example.SalesManagerProducts.entities.Products;
import com.example.SalesManagerProducts.entities.Sale;
import com.example.SalesManagerProducts.persistence.CustomersRepository;
import com.example.SalesManagerProducts.persistence.ProductsRepository;
import com.example.SalesManagerProducts.persistence.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SaleController {

    @Autowired
    private SalesRepository salesRepo;

    @Autowired
    private ProductsRepository productRepo;

    @Autowired
    private CustomersRepository customersRepo;

    @GetMapping("/newSale")
    public String showNewSaleForm(Model model){
        List<Products> listProducts=productRepo.findAll();
        model.addAttribute("sale", new Sale());
        model.addAttribute("listProducts", listProducts);

        List<Customers> listCustomers=customersRepo.findAll();
        model.addAttribute("listCustomers", listCustomers);
        return "newSale";
    }


    @PostMapping("/saveSale")
    public String saveProduct(Sale sale){
        salesRepo.save(sale);
        return "sales";
    }


}
