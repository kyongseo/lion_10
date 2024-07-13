package org.example.restexam.controller;

import org.example.restexam.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyRestController {
    @GetMapping("/api/greeting")
    public Map<String,String> greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("message", "Hello " + name);
        return response;
    }

    @GetMapping(value = "/productjson/{id}", produces = "application/json")
    public Product getProductJson(@PathVariable("id") Long id) {
        return new Product(id, "pen", 9.99);
    }

    @GetMapping(value = "productxml/{id}", produces = "application/xml")
    public Product getProductXml(@PathVariable("id") Long id) {
        return new Product(id, "pen2", 9.99);

    }}
