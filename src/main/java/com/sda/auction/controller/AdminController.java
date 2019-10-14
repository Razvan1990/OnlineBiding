package com.sda.auction.controller;

import com.sda.auction.dto.BidForm;
import com.sda.auction.dto.ItemForm;
import com.sda.auction.model.Item;
import com.sda.auction.repository.ItemRepository;
import com.sda.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value ={"/",""},method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		//practic aici in momentul in care te loghezi si nu introduci unde sa intri te redirecteaza pe admin/home
		modelAndView.setViewName("redirect:/admin/home");
		return modelAndView;
	}


	@RequestMapping(value = {"/home",}, method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();

		List<ItemForm> itemList = itemService.findAll();
		modelAndView.addObject("itemList",itemList);
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	@RequestMapping(value={"/myItem",},method=RequestMethod.GET)
	public ModelAndView itemControl() {
		ModelAndView modelAndView = new ModelAndView();
		ItemForm itemForm = new ItemForm();
//	punem asa ca atunci cand in jsp sa punem modelAttribute
		modelAndView.addObject(itemForm);

		modelAndView.setViewName("admin/myItem");
		return modelAndView;
	}


	@RequestMapping(value = {"/myItem",}, method = RequestMethod.POST)
	//BindingResult cauta validarile din itemForm
	public ModelAndView registerItem(@Valid ItemForm itemForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Ce am primit: " + itemForm);
		if(!bindingResult.hasErrors()){
			itemService.saveItem(itemForm);
			modelAndView.addObject("succesMessage2","Item has been saved");
			modelAndView.addObject(new ItemForm());

		}
		modelAndView.setViewName("admin/myItem");
		return modelAndView;
	}
	@RequestMapping(value ={"/item/{itemId}",} , method = RequestMethod.GET)
	//{itemId} practic se refera la idul pe care gaseste
	public ModelAndView viewItemPage(@PathVariable(value ="itemId") String itemId){
		ModelAndView modelAndView = new ModelAndView();

		ItemForm itemForm = itemService.findItemFormById(itemId);
		modelAndView.addObject(itemForm);
		/**
		 * practic am salvat itemForm
		 * creeam aacuma un formulat de Bid nou
		 */
		modelAndView.addObject(new BidForm());
		// trebuie sa vedem acest obiect creat in viewItem
		modelAndView.setViewName("admin/viewItem");
		return modelAndView;
	}
}
