package com.offcn.sys.controller;

import com.offcn.commons.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/code")
public class CodeController {

    @RequestMapping(value="getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) {
        ValidateCode code = new ValidateCode(81, 25, 4, 30, 25, "validateCode");
        code.getCode(request, response);
    }
}
