package com.offcn.sys.controller;

import com.offcn.sys.bean.Position;
import com.offcn.sys.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping("/info")
    @ResponseBody
    public List<Position> infoPosition(){
        return positionService.infoPosition();
    }
}
