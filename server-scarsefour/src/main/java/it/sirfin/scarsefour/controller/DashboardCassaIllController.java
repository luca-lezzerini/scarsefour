/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sirfin.scarsefour.controller;

import it.sirfin.scarsefour.dto.CreaRigaDto;
import it.sirfin.scarsefour.dto.CreaScontrinoDto;
import it.sirfin.scarsefour.dto.ProdottoDto;
import it.sirfin.scarsefour.dto.ReqEanDtoIll;
import it.sirfin.scarsefour.model.RigaScontrino;
import it.sirfin.scarsefour.service.DashboardCassaIllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class DashboardCassaIllController {

    @Autowired
    DashboardCassaIllService dashboardCassaIllService;

    @RequestMapping("/trova-ean")
    @ResponseBody
    public ProdottoDto trovaEan(@RequestBody ReqEanDtoIll dto) {
        return dashboardCassaIllService.trovaEan(dto.getCodiceABarre());
    }

    @RequestMapping("/crea-scontrino")
    @ResponseBody
    public CreaScontrinoDto creaScont(@RequestBody CreaScontrinoDto dto) {
        return dashboardCassaIllService.creaScont(dto.getScontrino());
    }

    @RequestMapping("/crea-riga-scontrino")
    @ResponseBody
    public CreaRigaDto creaRiga(@RequestBody CreaRigaDto dto) {
        return dashboardCassaIllService.creaRiga(dto.getRiga());
    }
}
