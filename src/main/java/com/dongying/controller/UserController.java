package com.dongying.controller;

import com.dongying.annotation.MyAnnotaion;
import com.dongying.dao.RecordEntityMapper;
import com.dongying.entity.RecordEntity;
import com.dongying.entity.UserEntity;
import com.dongying.service.RecordService;
import com.dongying.service.UserService;
import com.dongying.util.ExeclUtil;
import com.mysql.cj.api.Session;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "用户controller", description = "用户相关操作")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", httpMethod = "GET")
    public List<UserEntity> getAllUser() {

        return userService.getAllUser();
    }

    @ResponseBody
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "登录", httpMethod = "POST")
    public Map<String, Object> userLogin(String username, String password, HttpSession session) {
        session.setAttribute("loginUser", "token");
        Map<String, Object> map = new HashMap<>();
        map.put("token", "token");
        map.put("role", "admin");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    @ApiOperation(value = "用户信息", notes = "用户信息", httpMethod = "GET")
    public Map<String, Object> userInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", "token");
        map.put("role", "admin");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息根据id", notes = "int类型", httpMethod = "GET")
    //dataType为基本数据类型
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "query")
    public UserEntity getUserById(Integer id) {

        return userService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/getMap", method = RequestMethod.GET)
    public Map<String, Object> getmap() {
        Map<String, Object> map = new HashMap<>();
        map.put("test", "ceui");
        return map;
    }
    @MyAnnotaion
    @ResponseBody
    @RequestMapping(value = "/getAnnotation", method = RequestMethod.GET)
    public Map<String, Object> testAnnotation() {
        Map<String, Object> map = new HashMap<>();
        map.put("MyAnnotaion", "MyAnnotaion");
        return map;
    }

}
