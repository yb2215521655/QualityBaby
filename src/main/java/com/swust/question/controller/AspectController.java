package com.swust.question.controller;

import com.swust.question.entity.Aspect;
import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.entity.AspectDetail;
import com.swust.question.service.AspectService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: AspectController
 * @Package com.swust.question.controller
 * @description:
 * @date 2019/4/20
 */

@Api(tags = "雷达图大维度")
@RestController
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误", response = ResponseJSON.class)})
public class AspectController {

    @Autowired
    private AspectService aspectService;


    /**
     * 查找所有大维度
     *
     * @param request
     * @return com.swust.question.common.restful.ResponseJSON<java.util.List   <   com.swust.question.entity.Aspect>>
     * @author phantaci
     * @date 2019/4/20
     */
    @ApiOperation(value = "查找所有雷达图（可分页）", notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/aspect", method = RequestMethod.GET)
    public ResponseJSON<List<Aspect>> getAllAspect(HttpServletRequest request) {
        int pageNumber = request.getParameter("pageNumber") == null ? 0 : Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = request.getParameter("pageSize") == null ? 0 : Integer.parseInt(request.getParameter("pageSize"));
        int total=aspectService.getSumAspect();
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, aspectService.getAllAspect(pageNumber-1, pageSize), UnicomResponseEnums.SUCCESS_OPTION)
                    .setPageNumber(pageNumber)
                    .setPageSize(pageSize)
                    .setTotal(total)
                    .setTotalPage(total/pageSize);
        } else {
            return new ResponseJSON<>(true, aspectService.getAllAspect(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }

    /**
     * 添加新的大维度
     *
     * @param aspect 一大维度对象
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Aspect>
     * @author phantaci
     * @date 2019/4/1
     */
    @ApiOperation("添加新的大维度")
    @ApiImplicitParams({
            //@ApiImplicitParam(name = "aspectId", value = "大维度id", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "aspectName", value = "大维度名字", dataType = "String", paramType = "query", required = true),
    })
    @RequestMapping(value = "/aspect", method = RequestMethod.POST)
    public ResponseJSON<Aspect> addAspect(Aspect aspect) {
        return new ResponseJSON<>(true, aspectService.addAspect(aspect), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 更新大维度的内容
     *
     * @param aspect
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Aspect>
     * @author phantaci
     * @date 2019/4/20
     */
    @ApiOperation("更新大维度的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aspectId", value = "大维度Id", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "aspectName", value = "大维度名字", dataType = "String", paramType = "query", required = false),
    })
    @RequestMapping(value = "/aspect", method = RequestMethod.PUT)
    public ResponseJSON<Aspect> editAspect(Aspect aspect) {
        return new ResponseJSON<>(true, aspectService.editAspect(aspect), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     *
     *
     * @param aspect
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/4/1
     */
    @ApiOperation("根据大维度实体删除大维度")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aspectId", value = "大维度id", dataType = "Integer", paramType = "query", required = true),
            //@ApiImplicitParam(name = "UserId", value = "用户id", dataType = "int", paramType = "query", required = true),
            //@ApiImplicitParam(name = "questionnaireInstruction", value = "问卷介绍", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/aspect", method = RequestMethod.DELETE)
    public ResponseJSON delete(Aspect aspect) {
        aspectService.deleteAspectById(aspect);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据ID删除大维度
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/4/20
     */
    @ApiOperation("根据id删除大维度")
    @ApiImplicitParam(name = "id", value = "大维度id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/aspect/{id}", method = RequestMethod.DELETE)
    public ResponseJSON delete(@PathVariable int id) {
        aspectService.deleteAspect(id);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }


//    @ApiOperation(value = "查找所有小维度")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
//            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
//    })
//    @RequestMapping(value = "/detail", method = RequestMethod.GET)
//    public ResponseJSON<List <AspectDetail> > getAllAspectDetail(HttpServletRequest request) {
//        int pageNumber=request.getParameter("pageNumber")==null?0:Integer.parseInt(request.getParameter("pageNumber"));
//        int pageSize=request.getParameter("pageSize")==null?0:Integer.parseInt(request.getParameter("pageSize"));
////        if (pageNumber > 0 && pageSize > 0) {
////            return new ResponseJSON<>(true, aspectService.getAllAspectDetail(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION);
////        } else {
//            return new ResponseJSON<>(true, aspectService.getAllAspectDetail(), UnicomResponseEnums.SUCCESS_OPTION);
//        //}
//    }

    /**
     * 根据ID删除小维度
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/3/31
     */
//    @ApiOperation("根据id删除小维度")
//    @ApiImplicitParam(name = "id", value = "问题id", dataType = "int", paramType = "path", required = true)
//    @RequestMapping(value = "/detail/{id}", method = RequestMethod.DELETE)
//    public ResponseJSON delete(@PathVariable int id) {
//        aspectService.deleteAspectDetailById(id);
//        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
//    }



    /**
     * 添加新的小维度
     *
     * @param aspectDetail 一个问卷对象
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("添加新的小维度")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aspectId", value = "所属大维度id", dataType = "int", paramType = "query", required = true),
           // @ApiImplicitParam(name = "detailId", value = "小维度id", dataType = "int", paramType = "query", required = true),
            //@ApiImplicitParam(name = "questionDetail", value = "问题内容", dataType = "String", paramType = "query", required = true),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseJSON<AspectDetail> addAspectDetail(AspectDetail aspectDetail) {
        return new ResponseJSON<>(true, aspectService.addAspectDetail(aspectDetail), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 更新小维度的内容
     *
     * @param aspectDetail
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("更新小维度的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "detailId", value = "小维度id", dataType = "int", paramType = "query", required = true),
            //@ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = false),
            //@ApiImplicitParam(name = "questionDetail", value = "问题内容", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/detail", method = RequestMethod.PUT)
    public ResponseJSON<AspectDetail> editAspectDetail(AspectDetail aspectDetail) {
        return new ResponseJSON<>(true, aspectService.editAspectDetail(aspectDetail), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据小维度实体删除对象。
     *
     * @param aspectDetail
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("根据小维度实体删除小维度")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "detailId", value = "小维度id", dataType = "Integer", paramType = "query", required = true),
            //@ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = false),
            //@ApiImplicitParam(name = "questionnaireInstruction", value = "问卷介绍", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/detail", method = RequestMethod.DELETE)
    public ResponseJSON delete(AspectDetail aspectDetail) {
        aspectService.deleteAspectDetailById(aspectDetail);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 查找用户所关联的雷达图
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON<java.util.List   <   com.swust.question.entity.Aspect>>
     * @author phantaci
     * @date 2019/4/20
     */
    @ApiOperation("查找用户的雷达图列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/aspect/user/{id}", method = RequestMethod.GET)
    public ResponseJSON<List<Aspect>> getAspectByUserId(@PathVariable int id,HttpServletRequest request) {
        int pageNumber = request.getParameter("pageNumber") == null ? 0 : Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = request.getParameter("pageSize") == null ? 0 : Integer.parseInt(request.getParameter("pageSize"));
        int total=aspectService.getSumAspect(id);
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, aspectService.getAllAspect(pageNumber-1, pageSize), UnicomResponseEnums.SUCCESS_OPTION)
                    .setPageNumber(pageNumber)
                    .setPageSize(pageSize)
                    .setTotal(total)
                    .setTotalPage(total/pageSize);
        } else {
            return new ResponseJSON<>(true, aspectService.getAspectByUserId(id));
        }


    }


    /**
     * 查找大维度下的小维度
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON<java.util.List   <   com.swust.question.entity.Aspect>>
     * @author phantaci
     * @date 2019/4/20
     */
//    @ApiOperation("查找大维度下的小维度")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "大维度id", dataType = "int", paramType = "path", required = true),
//            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
//            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query")
//    })
//    @RequestMapping(value = "/detail/aspect/{id}", method = RequestMethod.GET)
//    public ResponseJSON<List<Aspect>> getAspectDetailByAspectId(@PathVariable int id,HttpServletRequest request) {
//        int pageNumber = request.getParameter("pageNumber") == null ? 0 : Integer.parseInt(request.getParameter("pageNumber"));
//        int pageSize = request.getParameter("pageSize") == null ? 0 : Integer.parseInt(request.getParameter("pageSize"));
//        int total=aspectService.getSumAspectDetail(id);
//        if (pageNumber > 0 && pageSize > 0) {
//            return new ResponseJSON<>(true, aspectService.getAllAspectDetail(pageNumber-1, pageSize), UnicomResponseEnums.SUCCESS_OPTION)
//                    .setPageNumber(pageNumber)
//                    .setPageSize(pageSize)
//                    .setTotal(total)
//                    .setTotalPage(total/pageSize);
//        } else {
//            return new ResponseJSON<>(true, aspectService.getAspectDetailByAspectId(id));
//        }
//
//
//    }
}
