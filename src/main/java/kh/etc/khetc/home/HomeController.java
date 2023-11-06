package kh.etc.khetc.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 인덱스 페이지 컨트롤러
 *
 * @author khko
 **/
@Controller
public class HomeController {

    @RequestMapping(value = {"/", ""})
    public String home() {
        return "/home/index";
    }
}
