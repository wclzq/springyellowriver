package com.dongying.controller;

import com.dongying.dao.RecordEntityMapper;
import com.dongying.entity.RecordEntity;
import com.dongying.entity.UserEntity;
import com.dongying.service.RecordService;
import com.dongying.util.ExeclUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(description = "档案管理")
public class RecordController {
    @Resource
    RecordService recordService;
    @Autowired
    RecordEntityMapper recordEntityMapper;
    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    @ApiOperation(value = "增加用户", notes = "int类型", httpMethod = "GET")
    //dataType为基本数据类型
    public UserEntity addRecordByExcel(String filePath) throws ParseException {
        //解析excel，
        List<RecordEntity> list = ExeclUtil.importExcel(filePath,0,1,RecordEntity.class);
        for (int i=0;i<list.size();i++){
            recordEntityMapper.insertSelective(list.get(i));
        }
        return null;
    }
    @ResponseBody
    @RequestMapping(value = "/getAllRecord",method = RequestMethod.GET)
    @ApiOperation(value = "获取档案", notes = "获取档案", httpMethod = "GET")
    public  List<RecordEntity> getAllRecord(){

        return recordService.getAllRecord();
    }
    @RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
    @Transactional
    public @ResponseBody
    Map<String,Object> handleFileUpload1(HttpServletRequest request) {
        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        List<MultipartFile> files = multipartRequest.getFiles("file");
        String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"upload/";
        MultipartFile file = null;
        Map<String,Object> map=new HashMap<>();
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            // 获取文件名
            String fileName = file.getOriginalFilename();
            System.out.println("上传的文件名为：" + fileName);

            if (!file.isEmpty()) {
                File dest = new File(filePath + fileName);
                String excelPath=filePath + fileName;
                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                    addRecordByExcel(excelPath);
                } catch (Exception e) {
                    map.put("success",false);
                    String msg="上传失败 " + i + " => " + e.getMessage();
                    map.put("msg",msg);
                    return map;
                }
            } else {
                map.put("success",false);
                String msg="上传失败 " + i + " 文件为空.";
                map.put("msg",msg);
                return map;
            }
        }
        map.put("success",true);
        map.put("msg","上传成功");
        return map;
    }
}
