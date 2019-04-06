package com.swust.question.controller;

import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.entity.Aspect;
import com.swust.question.service.AspectService;
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
 * @Description: 雷达图
 * @Author: yangbin
 * @Time: 2019/3/30 21:38
 */
@Api(tags = "雷达图")
@RestController
public class AspectController {
    @Autowired
    private AspectService aspectService;

    /**
     * @Description: 根据id查找雷达图
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:40
     */
    @ApiOperation("根据id查找雷达图")
    @ApiImplicitParam(name = "id", value = "雷达图", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/aspect/{id}", method = RequestMethod.GET)
    public ResponseJSON<Aspect> getAspectById(@PathVariable int id){
        return new ResponseJSON<>(true, aspectService.getAspectById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation(value = "查找所有方面（可分页）",notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/aspect", method = RequestMethod.GET)
    public ResponseJSON<List<Aspect>> getAllAspect(HttpServletRequest request) {
        int pageNumber=request.getParameter("pageNumber")==null?0:Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize=request.getParameter("pageSize")==null?0:Integer.parseInt(request.getParameter("pageSize"));
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, aspectService.getAllAspect(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON<>(true, aspectService.getAllAspect(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }

    /**
     * @Description: 添加新雷达图
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:50
     */
    @ApiOperation("添加新雷达图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aspectId", value = "雷达图id", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "aspectName", value = "方面名称", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/aspect/add", method = RequestMethod.POST)
    public ResponseJSON<Aspect> addAspect(Aspect aspect){
        return new ResponseJSON<>(true, aspectService.addAspect(aspect), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 更新雷达图信息
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:57
     */
    @ApiOperation("更新雷达图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aspectId", value = "雷达图id", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "aspectName", value = "方面名称", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/aspect/edit", method = RequestMethod.PUT)
    public ResponseJSON<Aspect> editAspect(Aspect aspect){
        return new ResponseJSON<>(true, aspectService.editAspect(aspect), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 根据雷达图实体删除雷达图
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:01
     */
    @ApiOperation("根据雷达图实体删除雷达图")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aspectId", value = "雷达图id", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "aspectName", value = "方面名称", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/aspect/delete", method = RequestMethod.DELETE)
    public ResponseJSON delete(Aspect aspect){
        aspectService.deleteAspect(aspect);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 根据id删除雷达图
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:04
     */
    @ApiOperation("根据id删除雷达图")
    @ApiImplicitParam(name = "id", value = "雷达图id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/aspect/delete/{id}", method = RequestMethod.DELETE)
    public ResponseJSON delete(@PathVariable int id){
        aspectService.deleteAspect(id);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }
}
