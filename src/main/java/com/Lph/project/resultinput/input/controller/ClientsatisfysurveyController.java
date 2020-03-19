package com.Lph.project.resultinput.input.controller;

import com.Lph.project.resultinput.input.model.ClassificationSearch;
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

    //***********************************************************************************************

    /**
     * 跳转到满意度调查单打印界面
     * @return
     */
    @RequestMapping("/toinputprinting")
    public String toInputPrinting(){
        return "/project/resultinput/input/inputprinting.html";
    }

    //***********************************************************************************************

    /**
     * 跳转到满意度综合查询界面
     * @return
     */
    @RequestMapping("/tocomprehensivelist")
    public String toComprehensiveList(){
        return "/project/resultinput/input/comprehensivelist.html";
    }

    @RequestMapping(value = "/comprehensivelist/{dateFrom}/{dateTo}/{clientName}/{geter}/{belongOrg}", method = RequestMethod.GET)
    @ResponseBody
    public List<TCCClientsatisfysurvey> getComprehensiveList(@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo, @PathVariable("clientName") String clientName, @PathVariable("geter") String geter, @PathVariable("belongOrg") String belongOrg) throws ParseException {
        TCCClientsatisfysurvey target = new TCCClientsatisfysurvey();
        target.setClientName(clientName);
        target.setGeter(geter);
        target.setDeptName(belongOrg);
        return clientsatisfysurveyService.getComprehensiveList(dateFrom, dateTo, target);
    }

    //***********************************************************************************************
    //满意度非类查询

    /**
     * 跳转到满意度分类查询界面
     * @return
     */
    @RequestMapping("/toclassification")
    public String toClassification(){
        return "/project/resultinput/input/classificatioinputlist.html";
    }

    /**
     * 为满意度非类查询填充table
     * @return
     */
    @RequestMapping(value = "/classificationsearch/{perName}", method = RequestMethod.GET)
    @ResponseBody
    public List<ClassificationSearch> getClassificationSearchs(@PathVariable("perName") String perName) {
        return clientsatisfysurveyService.getClassificationSearchs(perName);
    }

    //***********************************************************************************************
    //满意度汇总查询

    /**
     * 跳转到满意度汇总查询界面
     * @return
     */
    @RequestMapping("/tosummarylist")
    public String toSummaryList(){
        return "/project/resultinput/input/summarylist.html";
    }


}
