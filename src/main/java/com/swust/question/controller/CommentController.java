package com.swust.question.controller;

import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.entity.Comment;
import com.swust.question.entity.User;
import com.swust.question.service.CommentService;
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
 * @Description: 用户留言Controller
 * @Author: yangbin
 * @Time: 2019/4/7 0:01
 */
@Api(tags = "用户留言")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * @Description: 查找用户留言
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/4/6 23:39
     */
    @ApiOperation("根据id查找用户留言")
    @ApiImplicitParam(name = "id", value = "用户留言", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResponseJSON<Comment> getCommentById(@PathVariable int id){
        return new ResponseJSON<>(true, commentService.getCommentById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation(value = "查找所有用户留言（可分页）",notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public ResponseJSON<List<Comment>> getAllComment(HttpServletRequest request) {
        int pageNumber=request.getParameter("pageNumber")==null?0:Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize=request.getParameter("pageSize")==null?0:Integer.parseInt(request.getParameter("pageSize"));
        int total = commentService.getSumComment();
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, commentService.getAllComment(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION)
                    .setPageNumber(pageNumber)
                    .setPageSize(pageSize)
                    .setTotal(total)
                    .setTotalPage(total / pageSize);
        } else {
            return new ResponseJSON<>(true, commentService.getAllComment(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }

    /**
     * @Description: 添加新留言
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:50
     */
    @ApiOperation("添加新留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentTime", value = "用户留言时间", dataType = "java.util.Date", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentDetail", value = "用户留言信息", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentLike", value = "用户留言点赞数", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentSender", value = "用户留言评论人id", dataType = "Integer", paramType = "query", required = true),
    })
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ResponseJSON<Comment> addComment(Comment comment){
        return new ResponseJSON<>(true, commentService.addComment(comment), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 更新用户留言信息
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 20:57
     */
    @ApiOperation("更新用户留言信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentId", value = "用户留言ID", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentTime", value = "用户留言时间", dataType = "java.util.Date", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentDetail", value = "用户留言信息", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentLike", value = "用户留言点赞数", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentSender", value = "用户留言评论人id", dataType = "Integer", paramType = "query", required = true),
    })
    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    public ResponseJSON<Comment> editComment(Comment comment){
        return new ResponseJSON<>(true, commentService.editComment(comment), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 根据用户留言实体删除用户留言
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:01
     */
    @ApiOperation("根据用户留言实体删除用户留言")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentId", value = "用户留言ID", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentTime", value = "用户留言时间", dataType = "java.util.Date", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentDetail", value = "用户留言信息", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentLike", value = "用户留言点赞数", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "commentSender", value = "用户留言评论人id", dataType = "Integer", paramType = "query", required = true),
    })
    @RequestMapping(value = "/comment", method = RequestMethod.DELETE)
    public ResponseJSON deleteComment(Comment comment){
        commentService.deleteComment(comment);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 根据id删除留言
     * @Param:
     * @Return:
     * @Author: yangbin
     * @Date: 2019/3/30 21:04
     */
    @ApiOperation("根据id删除留言")
    @ApiImplicitParam(name = "id", value = "用户留言id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public ResponseJSON deleteComment(@PathVariable int id){
        commentService.deleteComment(id);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * @Description: 查找用户留言列表
     * @Param: 
     * @Return: 
     * @Author: yangbin
     * @Date: 2019/4/13 17:17
     */
    @ApiOperation("查找用户留言列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/comment/user/{id}", method = RequestMethod.GET)
    public ResponseJSON<List<Comment>> getCommentByUserId(@PathVariable int id, HttpServletRequest request) {
        int pageNumber = request.getParameter("pageNumber") == null ? 0 : Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = request.getParameter("pageSize") == null ? 0 : Integer.parseInt(request.getParameter("pageSize"));
        int total = commentService.getSumComment(id);
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, commentService.getAllComment(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION)
                    .setPageNumber(pageNumber)
                    .setPageSize(pageSize)
                    .setTotal(total)
                    .setTotalPage(total / pageSize);
        } else {
            return new ResponseJSON<>(true, commentService.getCommentByUserId(id));
        }
    }
}
