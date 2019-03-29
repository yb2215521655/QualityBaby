package com.swust.question.controller;

import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.entity.Activity;
import com.swust.question.service.ActivityService;
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
 * @author pang
 * @version V1.0
 * @ClassName: ActivityController
 * @Package com.swust.question.controller
 * @description: 活动的控制器
 * @date 2019/3/23 14:00
 */
@Api(tags = "活动")
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 根据id查找活动
     *
     * @param id 活动id
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Activity>
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("根据id查找活动")
    @ApiImplicitParam(name = "id", value = "活动id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/activity/{id}", method = RequestMethod.GET)
    public ResponseJSON<Activity> getActivityById(@PathVariable int id) {
        return new ResponseJSON<>(true, activityService.getActivityById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }


    @ApiOperation(value = "查找所有活动（可分页）",notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public ResponseJSON<List<Activity>> getAllActivity(HttpServletRequest request) {
        int pageNumber=request.getParameter("pageNumber")==null?0:Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize=request.getParameter("pageSize")==null?0:Integer.parseInt(request.getParameter("pageSize"));
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, activityService.getAllActivity(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON<>(true, activityService.getAllActivity(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }

    /**
     * 添加新的活动
     *
     * @param activity 一个活动对象
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Activity>
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("添加新的活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityName", value = "活动名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityInformation", value = "活动介绍", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityStart", value = "活动开始时间", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityEnd", value = "活动结束时间", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityPeopleNumber", value = "活动参加人数", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "studioId", value = "活动所属的工作室", dataType = "int", paramType = "query", required = true)
    })
    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    public ResponseJSON<Activity> addActivity(Activity activity) {
        return new ResponseJSON<>(true, activityService.addActivity(activity), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 更新活动的内容
     *
     * @param activity
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Activity>
     * @author pang
     * @date 2019/3/22
     */
    /**
     *
     * @author pang
     * @date 2019/3/23
     * @param activity
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Activity>
     */
    @ApiOperation("更新活动的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityName", value = "活动名", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "activityInformation", value = "活动介绍", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "activityStart", value = "活动开始时间", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "activityEnd", value = "活动结束时间", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "activityPeopleNumber", value = "活动参加人数", dataType = "int", paramType = "query", required = false),
            @ApiImplicitParam(name = "studioId", value = "活动所属工作室的ID", dataType = "int", paramType = "query", required = false)
    })
    @RequestMapping(value = "/activity", method = RequestMethod.PUT)
    public ResponseJSON<Activity> editActivity(Activity activity) {
        return new ResponseJSON<>(true, activityService.editActivity(activity), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据活动实体删除对象。一定要有活动的id
     *
     * @param activity
     * @return com.swust.question.common.restful.ResponseJSON
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("根据活动实体删除对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityName", value = "活动名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityInformation", value = "活动介绍", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityStart", value = "活动开始时间", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityEnd", value = "活动结束时间", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "activityPeopleNumber", value = "活动参加人数", dataType = "int", paramType = "query", required = true)
    })
    @RequestMapping(value = "/activity", method = RequestMethod.DELETE)
    public ResponseJSON delete(Activity activity) {
        activityService.deleteActivity(activity);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据ID删除活动
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON
     * @author pang
     * @date 2019/3/22
     */
    @ApiOperation("根据id删除活动")
    @ApiImplicitParam(name = "id", value = "活动id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/activity/{id}", method = RequestMethod.DELETE)
    public ResponseJSON delete(@PathVariable int id) {
        activityService.deleteActivity(id);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 查找用户所参加的活动
     * @author pang
     * @date 2019/3/23
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON<java.util.List<com.swust.question.entity.Activity>>
     */
    @ApiOperation("查找用户参加的活动列表")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/activity/user/{id}", method = RequestMethod.GET)
    public ResponseJSON<List<Activity>> getActivityByUserId(@PathVariable int id){
        return new ResponseJSON<>(true,activityService.getActivityByUserId(id));
    }
}
