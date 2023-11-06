package kh.etc.khetc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HTML과 관련된 내용 테스트용 컨트롤러
 *
 * @author khko
 **/
@Controller
@Slf4j
@RequestMapping("/html")
public class HTMLController {

    @RequestMapping(value = "/textArea", method = RequestMethod.GET)
    public String textArea() {
        return "/html/textArea";
    }

    @RequestMapping(value = "/textArea", method = RequestMethod.POST)
    public String textAreaValue(@RequestParam String textAreaValue, Model model) {
        String[] valueArr = textAreaValue.split("\n");

        model.addAttribute("serverValue", valueArr);
        return "/html/textArea";
    }
}
