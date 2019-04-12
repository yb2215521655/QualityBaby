package com.swust.question.controller;

import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.entity.Tag;
import com.swust.question.service.TagService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 用户标签Controller
 * @Author: yangbin
 * @Time: 2019/4/6 23:36
 */

@Api(tags = "用户标签")
@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * @Description: 查找用户标签
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/6 23:39
     */
    @ApiOperation("根据id查找用户标签")
    @ApiImplicitParam(name = "id", value = "用户标签", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/tag/{id}", method = RequestMethod.GET)
    public ResponseJSON<Tag> getTagById(@PathVariable int id){
        return new ResponseJSON<>(true, tagService.getTagById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation(value = "查找所有用户标签（可分页）",notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public ResponseJSON<List<Tag>> getAllTag(HttpServletRequest request) {
        int pageNumber=request.getParameter("pageNumber")==null?0:Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize=request.getParameter("pageSize")==null?0:Integer.parseInt(request.getParameter("pageSize"));
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, tagService.getAllTag(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON<>(true, tagService.getAllTag(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }

    /**
     * @Description: 添加新标签
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:50
     */
    @ApiOperation("添加新标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tagName", value = "用户标签名", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/tag/add", method = RequestMethod.POST)
    public ResponseJSON<Tag> addTag(Tag tag){
        return new ResponseJSON<>(true, tagService.addTag(tag), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 更新用户标签信息
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:57
     */
    @ApiOperation("更新用户标签信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tagName", value = "用户标签名", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/tag/edit", method = RequestMethod.PUT)
    public ResponseJSON<Tag> editTag(Tag tag){
        return new ResponseJSON<>(true, tagService.editTag(tag), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 根据用户标签实体删除标签
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:01
     */
    @ApiOperation("根据用户标签实体删除标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tagName", value = "用户标签名", dataType = "String", paramType = "query", required = true)
    })
    @RequestMapping(value = "/tag/delete", method = RequestMethod.DELETE)
    public ResponseJSON delete(Tag tag){
        tagService.deleteTag(tag);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 根据id删除标签
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:04
     */
    @ApiOperation("根据id删除标签")
    @ApiImplicitParam(name = "id", value = "用户标签id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/tag/delete/{id}", method = RequestMethod.DELETE)
    public ResponseJSON delete(@PathVariable int id){
        tagService.deleteTag(id);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }
}
