package com.swust.question.controller;

import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.entity.User;
import com.swust.question.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description: 用户操作
 * @author: yangbin
 * @time: 2019/3/30 19:47
 */
@Api(tags = "用户")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @Description: 根据id查找用户
     * @Param:
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 20:47
     */
    @ApiOperation("根据id查找用户")
    @ApiImplicitParam(name = "id", value = "用户", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseJSON<User> getUserById(@PathVariable int id){
        return new ResponseJSON<>(true, userService.getUserById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation(value = "查找所有用户（可分页）",notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseJSON<List<User>> getAllUser(HttpServletRequest request) {
        int pageNumber=request.getParameter("pageNumber")==null?0:Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize=request.getParameter("pageSize")==null?0:Integer.parseInt(request.getParameter("pageSize"));
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, userService.getAllUser(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON<>(true, userService.getAllUser(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }
    
    /**
     * @Description: 添加新用户
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 20:50
     */
    @ApiOperation("添加新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tellNumber", value = "电话号码", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "className", value = "班级", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "userGender", value = "性别", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "userName", value = "姓名", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseJSON<User> addUser(User user){
        return new ResponseJSON<>(true, userService.addUser(user), UnicomResponseEnums.SUCCESS_OPTION);
    }
    
    /**
     * @Description: 更新用户信息
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 20:57
     */
    @ApiOperation("更新新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tellNumber", value = "电话号码", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "className", value = "班级", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "userGender", value = "性别", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "userName", value = "姓名", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/user/edit", method = RequestMethod.PUT)
    public ResponseJSON<User> editUser(User user){
        return new ResponseJSON<>(true, userService.editUser(user), UnicomResponseEnums.SUCCESS_OPTION);
    }
    
    /**
     * @Description: 根据用户实体删除用户
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:01
     */
    @ApiOperation("根据用户实体删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tellNumber", value = "电话号码", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "className", value = "班级", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "userGender", value = "性别", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "userName", value = "姓名", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
    public ResponseJSON delete(User user){
        userService.deleteUser(user);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }
    
    /**
     * @Description: 根据id删除用户
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/3/30 21:04
     */
    @ApiOperation("根据id删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public ResponseJSON delete(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }
}
