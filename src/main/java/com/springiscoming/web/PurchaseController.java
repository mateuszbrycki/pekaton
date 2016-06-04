package com.springiscoming.web;

import com.springiscoming.model.Purchase;
import com.springiscoming.service.PurchaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

/**
 * Created by winio_000 on 2016-06-04.
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Inject
    private PurchaseService purchaseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Purchase> getAll() {
        return purchaseService.findAll();
    }

    @RequestMapping(path = "/statistics/daily", method = RequestMethod.GET)
    public List<Purchase> getPurchasesByDay() {
        return Collections.emptyList();
    }
}
