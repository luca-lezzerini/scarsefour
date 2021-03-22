/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.dto.ReqEanDtoGal;
import it.sirfin.scarsefour.service.DashboardCassaGalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DashboardCassaGalController {

    @Autowired
    DashboardCassaGalService dashboardCassaGalService;

    @RequestMapping("verifica-ean-gal")
    @ResponseBody
    public ProdottoDto verificaEan(@RequestBody ReqEanDtoGal dto) {
        return dashboardCassaGalService.verificaEan(dto.getBarcode());
    }

}
