package com.springapp.mvc.Controller;

import com.springapp.mvc.Service.RestApiManager;
import com.springapp.mvc.View.TransAccItem;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
public class TransAccController {

    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * Handle all transparent account data
     * @return ModelAndView object

     */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView getTransAccList() {
//        JSONArray arr = new JSONArray(RestApiManager.readFile("accounts.json", StandardCharsets.UTF_8));
        JSONArray arr = new JSONArray(RestApiManager.getAllTransAcc());
        List<TransAccItem> list = new ArrayList();
        for (int i = 0; i < arr.length(); i++) {
            TransAccItem tai = new TransAccItem();
            tai.setName((arr.getJSONObject(i).get("name") == JSONObject.NULL) ? " -- " : arr.getJSONObject(i).get("name").toString());
            tai.setAccBankCode(arr.getJSONObject(i).get("accBankCode").toString());
            tai.setBalance(arr.getJSONObject(i).get("balance").toString());
            tai.setCurrency((arr.getJSONObject(i).get("currency") == JSONObject.NULL) ? " -- " : arr.getJSONObject(i).get("currency").toString());
            tai.setDescription((arr.getJSONObject(i).get("description") == JSONObject.NULL) ? " -- " : arr.getJSONObject(i).get("description").toString());
            tai.setNote((arr.getJSONObject(i).get("note")== JSONObject.NULL) ? " -- " : arr.getJSONObject(i).get("note").toString());
            tai.setIban(arr.getJSONObject(i).get("iban").toString());
            tai.setAccNumber((arr.getJSONObject(i).get("accNumber")== JSONObject.NULL) ? " -- " : arr.getJSONObject(i).get("accNumber").toString());
            try {
                tai.setTransparencyFrom(sd.parse(arr.getJSONObject(i).get("transparencyFrom").toString()));
                tai.setTransparencyTo(sd.parse(arr.getJSONObject(i).get("transparencyTo").toString()));
                tai.setPublicationTo(sd.parse(arr.getJSONObject(i).get("publicationTo").toString()));
                tai.setActualizationDate(sdf.parse(arr.getJSONObject(i).get("actualizationDate").toString()));
            }catch(ParseException pe){
                System.out.println(pe);
            }

            list.add(tai);
        }
        ModelAndView mav = new ModelAndView("accList");
        mav.addObject("TransAccItemList", list);
		return mav;
	}

    /**
     * Handle Acount Detail Data
     * @param accNum - according account number returned detail account data
     * @return
     */
    @RequestMapping(value="/transDetail", method = RequestMethod.GET)
    public ModelAndView getTransDetail(@RequestParam(value = "accNum", required = true)String accNum) {
        JSONObject jObject = new JSONObject(RestApiManager.getDetailAcc(accNum));
        TransAccItem tai = new TransAccItem();
        tai.setName((jObject.get("name") == JSONObject.NULL)? " -- " : jObject.get("name").toString());
        tai.setIban((jObject.get("iban") == JSONObject.NULL)? " -- " : jObject.get("iban").toString());
        tai.setAccNumber((jObject.get("accNumber") == JSONObject.NULL)? " -- " : jObject.get("accNumber").toString());
        tai.setBalance((jObject.get("balance") == JSONObject.NULL)? " -- " : jObject.get("balance").toString());
        tai.setCurrency((jObject.get("currency") == JSONObject.NULL)? " -- " : jObject.get("currency").toString());
        tai.setAccBankCode((jObject.get("accBankCode") == JSONObject.NULL)? " -- " : jObject.get("accBankCode").toString());
        tai.setDescription((jObject.get("description") == JSONObject.NULL)? " -- " : jObject.get("description").toString());
        tai.setNote((jObject.get("note") == JSONObject.NULL)? " -- " : jObject.get("note").toString());
        try {
            tai.setTransparencyFrom(sd.parse(jObject.get("transparencyFrom").toString()));
            tai.setTransparencyTo(sd.parse(jObject.get("transparencyTo").toString()));
            tai.setPublicationTo(sd.parse(jObject.get("publicationTo").toString()));
            tai.setActualizationDate(sdf.parse(jObject.get("actualizationDate").toString()));
        }catch(ParseException pe){
            System.out.println(pe);
        }
        ModelAndView mav = new ModelAndView("accountDetail");
        System.out.println(accNum);
        mav.addObject("transAccItem", tai);
        return mav;


    }




    @RequestMapping(value="/xx", method = RequestMethod.GET)
	public String printWelcomexx(ModelMap model) {
		model.addAttribute("message", "Hello world!xxxx");
		return "accList";
	}



}