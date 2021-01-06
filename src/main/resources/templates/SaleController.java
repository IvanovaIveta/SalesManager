package com.example.SalesManagerProducts.controllers;

import com.example.SalesManagerProducts.entities.Products;
import com.example.SalesManagerProducts.entities.Sale;
import com.example.SalesManagerProducts.persistence.ProductsRepository;
import com.example.SalesManagerProducts.persistence.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SaleController {

    @Autowired
    private SalesRepository salesRepo;

    @Autowired
    private ProductsRepository productRepo;

    @GetMapping("/newSale")
    public String showNewSaleForm(Model model){
        List<Products>listProducts=productRepo.findAll();
        model.addAttribute("sale", new Sale());
        model.addAttribute("listProducts", listProducts);
        return "newSale";
    }

}
