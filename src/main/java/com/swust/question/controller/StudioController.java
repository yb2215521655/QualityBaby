package com.swust.question.controller;

import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.entity.Studio;
import com.swust.question.service.StudioService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: StudioController
 * @Package com.swust.question.comtroller
 * @description: 工作室操作
 * @date 2019/3/20 22:49
 */
@Api(tags = "工作室")
@RestController
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误", response = ResponseJSON.class)})
public class StudioController {
    @Autowired
    private StudioService studioService;

    /**
     * 根据id查找工作室
     *
     * @param id 工作室id
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Studio>
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("根据id查找工作室")
    @ApiImplicitParam(name = "id", value = "工作室id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/studio/{id}", method = RequestMethod.GET)
    public ResponseJSON<Studio> getStudioById(@PathVariable int id) {
        return new ResponseJSON<>(true, studioService.getStudioById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }


    /**
     * 查找所有工作室，可分页
     *
     * @param request
     * @return com.swust.question.common.restful.ResponseJSON<java.util.List   <   com.swust.question.entity.Studio>>
     * @author pang
     * @date 2019/3/26
     */
    @ApiOperation(value = "查找所有工作室（可分页）", notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/studio", method = RequestMethod.GET)
    public ResponseJSON<List<Studio>> getAllStudio(HttpServletRequest request) {
        int pageNumber = request.getParameter("pageNumber") == null ? 0 : Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = request.getParameter("pageSize") == null ? 0 : Integer.parseInt(request.getParameter("pageSize"));
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, studioService.getAllStudio(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON<>(true, studioService.getAllStudio(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }

    /**
     * 添加新的工作室
     *
     * @param studio 一个工作室对象
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Studio>
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("添加新的工作室")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studioTitle", value = "工作室名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "studioInformation", value = "工作室介绍", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "studioPeopleNumber", value = "工作室参加人数", dataType = "int", paramType = "query", required = true)
    })
    @RequestMapping(value = "/studio", method = RequestMethod.POST)
    public ResponseJSON<Studio> addStudio(Studio studio) {
        return new ResponseJSON<>(true, studioService.addStudio(studio), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 更新工作室的内容
     *
     * @param studio
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Studio>
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("更新工作室的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studioId", value = "工作室id", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "studioTitle", value = "工作室名", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "studioInformation", value = "工作室介绍", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "studioPeopleNumber", value = "工作室参加人数", dataType = "int", paramType = "query", required = false)
    })
    @RequestMapping(value = "/studio", method = RequestMethod.PUT)
    public ResponseJSON<Studio> editStudio(Studio studio) {
        return new ResponseJSON<>(true, studioService.editStudio(studio), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据工作室实体删除对象。一定要有工作室的id
     *
     * @param studio
     * @return com.swust.question.common.restful.ResponseJSON
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("根据工作室实体删除对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studioId", value = "工作室id", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "studioTitle", value = "工作室名", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "studioInformation", value = "工作室介绍", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "studioPeopleNumber", value = "工作室参加人数", dataType = "int", paramType = "query", required = false)
    })
    @RequestMapping(value = "/studio", method = RequestMethod.DELETE)
    public ResponseJSON delete(Studio studio) {
        studioService.deleteStudio(studio);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据ID删除工作室
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("根据id删除工作室")
    @ApiImplicitParam(name = "id", value = "工作室id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/studio/{id}", method = RequestMethod.DELETE)
    public ResponseJSON delete(@PathVariable int id) {
        studioService.deleteStudio(id);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 查找用户所参加的工作室
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON<java.util.List   <   com.swust.question.entity.Activity>>
     * @author pang
     * @date 2019/3/23
     */
    @ApiOperation("查找用户参加的工作室列表")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/studio/user/{id}", method = RequestMethod.GET)
    public ResponseJSON<List<Studio>> getStudioByUserId(@PathVariable int id) {
        return new ResponseJSON<>(true, studioService.getStudioByUserId(id));
    }
}
