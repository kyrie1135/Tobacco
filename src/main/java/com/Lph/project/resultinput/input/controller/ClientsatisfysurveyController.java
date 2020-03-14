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

    /**
     * 点击录入-》确定， 保存满意度录入信息
     * @param target
     * @return
     */
    @RequestMapping(value = "/saveinputresult", method = RequestMethod.POST)
    @ResponseBody
    public String saveInputResult(@RequestBody TCCSaitDescription target){
        return clientsatisfysurveyService.saveInputResult(target);
    }

    /**
     * 点击已录入时， 生成表单
     * @param satisfysurveytargetBickid
     * @param clientCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getinputresult", method = RequestMethod.GET)
    public String getInputResult(@RequestParam("satisfysurveytargetBickid") String satisfysurveytargetBickid,@RequestParam("clientCode") String clientCode){
        TCCSaitDescription target = new TCCSaitDescription();
        target.setSatisfysurveytargetBickid(satisfysurveytargetBickid.substring(1, satisfysurveytargetBickid.length()-1));
        target.setClientCode(clientCode.substring(1, clientCode.length()-1));
        return clientsatisfysurveyService.getInputResult(target);
    }

    /**
     * 点击已录入-》确定， 保存满意度录入信息
     * @param target
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editinputresult", method = RequestMethod.PUT)
    public String editInputResult(@RequestBody TCCSaitDescription target){
        return clientsatisfysurveyService.editInputResult(target);
    }

    //***********************************************************************************************

    /**
     * 跳转到满意度调查单打印界面
     * @return
     */
    @RequestMapping("/toinputprinting")
    public String toInputPrinting(){
        return "/project/resultinput/input/inputprinting.html";
    }
}
