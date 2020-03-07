package com.Lph.project.resultinput.input.controller;

import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.resultinput.input.service.ClientsatisfysurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ClientsatisfysurveyController {

    @Autowired
    private ClientsatisfysurveyService clientsatisfysurveyService;

    @RequestMapping(value = "/inputlist", method = RequestMethod.GET)
    public List<TCCClientsatisfysurvey> getList(String dateFrom, String dateTo) throws ParseException {
        return clientsatisfysurveyService.getList(dateFrom, dateTo);
    }
}
