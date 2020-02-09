package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.Area;
import com.fh.model.DataTableResult;
import com.fh.model.Good;
import com.fh.model.GoodQuery;
import com.fh.service.GoodService;
import com.fh.util.AliyunSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("GoodController")
public class GoodController {

    @Autowired
    private GoodService goodService;


    @RequestMapping("queryGoodList")
    public ServerResponse queryGoodList(GoodQuery goodQuery){
        DataTableResult dataTableResult = goodService.queryGoodList(goodQuery);
        return ServerResponse.success(dataTableResult);
    }

    @RequestMapping("queryAreaByPid")
    public ServerResponse queryAreaByPid(Integer pid) {
        List<Area> areaList = goodService.queryAreaByPid(pid);
        return ServerResponse.success(areaList);
    }


    @RequestMapping("addGood")
    public ServerResponse addGood(Good good) {
        goodService.addGood(good);
        return ServerResponse.success();
    }

    @RequestMapping("toUpdateGood")
    public ServerResponse toUpdateGood(Integer id){
        Good good =goodService.toUpdateGood(id);
        return ServerResponse.success(good);
    }

    @RequestMapping("updateGood")
    public ServerResponse updateGood(Good good) {
        goodService.updateGood(good);
        return ServerResponse.success();
    }


    @RequestMapping("updateGood2")
    public ServerResponse updateGood2(Good good) {
        goodService.updateGood2(good);
        return ServerResponse.success();
    }




    @RequestMapping("deleteGood")
    public ServerResponse deleteGood(Integer id){
        goodService.deleteGood(id);

        return ServerResponse.success();
    }

    @RequestMapping("batchDeleteMovie")
    public ServerResponse batchDeleteDrug(@RequestParam("idArr[]")String idArr) {

        String[] ids = idArr.split(",");
        for (String id : ids) {
            goodService.deleteGood(Integer.parseInt(id));
        }
        return ServerResponse.success();
    }

    //上传商品图片
    @RequestMapping("uploadFile")
    public Map<String,Object> uploadFile(@RequestParam("addPhoto") MultipartFile file, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        try {

            String originalFileName = file.getOriginalFilename();
            String url = AliyunSmsUtil.uploadFile(file.getInputStream(), originalFileName, "images");
            result.put("filePath",url);
            result.put("code",200);
        } catch (IOException e) {
            e.printStackTrace();
            result.put("code",500);
        }
        return result;
    }
}
