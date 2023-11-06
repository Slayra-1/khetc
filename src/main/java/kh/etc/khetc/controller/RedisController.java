package kh.etc.khetc.controller;

import kh.etc.khetc.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Redis with lettuce를 사용한 테스트 컨트롤러
 *
 * @author khko
 **/
@Controller
@Slf4j
@RequestMapping("/redis")
public class RedisController {

    static final String SINGLE_STRING_KEY = "singleStringKey";

    @Autowired
    RedisTemplate<String, String> stringRedisTemplate;

    @RequestMapping(value = "/singleString", method = RequestMethod.GET)
    public String singleString(Model model) {
        String singleString = stringRedisTemplate.opsForValue().get(SINGLE_STRING_KEY);

        model.addAttribute("singleString", singleString);
        return "/redis/singleString";
    }

    @RequestMapping(value = "/singleString", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> singleStringPost(@RequestParam String str, Model model) {
        stringRedisTemplate.opsForValue().set(SINGLE_STRING_KEY, str);

        return ResponseUtils.RESULT_SUCCESS;
    }

    @RequestMapping(value = "/singleStringWithTimeout", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> singleStringWithTimeout(@RequestParam String str, @RequestParam long timeout, Model model) {
        String expiredKey = SINGLE_STRING_KEY + "1";

        stringRedisTemplate.opsForValue().set(expiredKey, str, timeout, TimeUnit.SECONDS);

        return ResponseUtils.RESULT_SUCCESS;
    }

}
