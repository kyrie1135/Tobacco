package com.Lph.project.resultinput.input.controller;

import com.Lph.project.resultinput.input.model.TCCClientsatisfysurvey;
import com.Lph.project.resultinput.input.model.TCCSaitDescription;
import com.Lph.project.resultinput.input.service.ClientsatisfysurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ClientsatisfysurveyController {

    @Autowired
    private ClientsatisfysurveyService clientsatisfysurveyService;

    /**
     * 跳转到满意度调查录入
     * @return
     */
    @RequestMapping("/toresultinputlist")
    public String toResultInputList(){
        return "/project/resultinput/input/inputlist.html";
    }

    /**
     * 满意度调查录入填充table
     * @param dateFrom
     * @param dateTo
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/inputlist/{dateFrom}/{dateTo}", method = RequestMethod.GET)
    @ResponseBody
    public List<TCCClientsatisfysurvey> getList(@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo) throws ParseException {
        return clientsatisfysurveyService.getList(dateFrom, dateTo);
    }

    /**
     * 点击录入时， 生成表单
     * @param subscriptBickid
     * @return
     */
    @RequestMapping("/toInputResult")
    @ResponseBody
    public TCCSaitDescription toInputResult(@RequestParam("subscriptBickid") String subscriptBickid){
        return clientsatisfysurveyService.toInputResult(subscriptBickid);
    }

    @RequestMapping(value = "/saveinputresult", method = RequestMethod.POST)
    @ResponseBody
    public String saveInputResult(@RequestBody TCCSaitDescription target){
        return clientsatisfysurveyService.saveInputResult(target);
    }
}
