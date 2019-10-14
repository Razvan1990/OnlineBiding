package com.sda.auction.controller;

import com.sda.auction.dto.BidForm;
import com.sda.auction.dto.ItemForm;
import com.sda.auction.service.BidService;
import com.sda.auction.service.ItemService;
import com.sda.auction.validator.BidFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private BidService bidService;

    @Autowired
    BidFormValidator bidFormValidator;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        //practic te redirecteaza daca introduci doar slash pe ccount/home
        modelAndView.setViewName("redirect:/account/home");
        return modelAndView;
    }


    @RequestMapping(value = {"/home",}, method = RequestMethod.GET)
    public ModelAndView accountHome() {
        ModelAndView modelAndView = new ModelAndView();
        List<ItemForm> itemList = itemService.findAvailableItems();
        //la liste trebuie sa ii dai neaparat numele aici jos
        modelAndView.addObject("itemList", itemList);
        modelAndView.setViewName("account/home");
        return modelAndView;
    }


    @RequestMapping(value = {"/item/{itemId}",}, method = RequestMethod.GET)
    public ModelAndView viewItemPage(@PathVariable(value = "itemId") String itemId) {
        ModelAndView modelAndView = new ModelAndView();
        ItemForm itemForm = itemService.findItemFormById(itemId);
        //poti lasa fara nume si iti ia numele itemForm
        modelAndView.addObject(itemForm);
        //i-am dat un formular gol ca sa putem lua prin post mai jos datele venite de la form
        modelAndView.addObject(new BidForm());
        modelAndView.setViewName("account/viewItem");
        return modelAndView;
    }

    @RequestMapping(value = {"/item/{itemId}"}, method = RequestMethod.POST)
    public ModelAndView viewItemPagePost(@PathVariable(value = "itemId") String itemId, @Valid BidForm bidForm) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("!!!!!!!" + bidForm);
        if (bidFormValidator.isValid(bidForm, itemId)) {
            //daca formularul este valid, atunci salvam formularul
            bidService.save(bidForm, itemId);
            modelAndView.setViewName("redirect:/account/item/" + itemId);

        } else {
            /**
             * afisam un mesaj de eroare
             * adaugam obiectul de tip itemForm
             * daca nu e valid itemul, atunci sa ne trimita pe pagina de viewItem
             * mai punem odata bidul
             */
            modelAndView.addObject("errorMessage", "Bid is not valid");
            ItemForm itemForm = itemService.findItemFormById(itemId);
            modelAndView.addObject(itemForm);
            modelAndView.setViewName("account/viewItem");

        }
        return modelAndView;

    }

}
