package online.patologia.bitcoincalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPage() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String showResult(@RequestParam Map params, Model model) throws IOException {
        model.addAttribute("result", service.calculate(params.get("type").toString(), params.get("summ").toString()));
        return "index";
    }
}
