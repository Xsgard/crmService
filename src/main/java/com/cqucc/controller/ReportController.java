package com.cqucc.controller;

import com.cqucc.pojo.Report;
import com.cqucc.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {
    @Autowired
    private customerService customerService;

    /**
     * 获取按客户地区统计数量的柱状图的X、Y轴数据
     *
     * @return
     */
    @RequestMapping("/getCusNumByCusRegion")
    public Map<String, Object> getCusNumByCusRegion() {
        HashMap<String, Object> map = new HashMap<>();
        //获取report列表对象
        List<Report> reportList = customerService.getCusNumByCusRegion();
        //for循环列表数据，把item放到xData数组，把num放到yData数组
        ArrayList<String> xData = new ArrayList<>();
        ArrayList<Integer> yData = new ArrayList<>();
        //把xData、yData放到Map
        for (Report report : reportList) {
            String res = null;
            switch (report.getItem()){
                case "1":
                    res="东北";
                    break;
                case "2":
                    res="华北";
                    break;
                case "3":
                    res="西北";
                    break;
                case "4":
                    res="西南";
                    break;
                case "5":
                    res="华南";
                    break;
                case "6":
                    res="华中";
                    break;
                case "7":
                    res="华东";
                    break;

            }

            xData.add(res);
            yData.add(report.getNum());
        }
        map.put("xData", xData);
        map.put("yData", yData);

        return map;
    }

}
