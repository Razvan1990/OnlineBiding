package com.sda.auction.controller;

import com.sda.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class ImageController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/displayImage",method = RequestMethod.GET)
    //vrem sa afisam imaginea pe baza id-ului
    public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response) throws IOException, SQLException {
        //NE FOLOSIM DE METODA CREATA IN ITEMSERVICE CE RETURNEAZA UN ARRAY
        byte [] byteArray = itemService.getItemImageByItemId(itemId);

        /**aici setam practic ce fel de raspuns sa fie ptr byteArray
         * conform documentatiei practic trebuie sa apelam aceasta metoda inainte de a
         * scrie body-ul principal -> va arunca o exceptie
         */
        response.setContentType("image/jpeg,image/jpg,image/png,image/gif");
        //practic scriem ca un stream vectorul
        response.getOutputStream().write(byteArray);
        response.getOutputStream().close();
    }
}
