package com.swust.question.controller;

import com.swust.question.entity.Answer;
import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.service.AnswerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: AnswerController
 * @Package： com.swust.question.controller
 * @description: 答案操作
 * @date 2019/3/30
 */
@Api(tags = "答案")
@RestController
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误", response = ResponseJSON.class)})
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    /**
     * 根据id查找答案
     *
     * @param id 答案id
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Answer>
     * @author phantaci
     * @date 2019/3/30
     */
    @ApiOperation("根据id查找答案")
    @ApiImplicitParam(name = "id", value = "问卷id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/answer/{id}", method = RequestMethod.GET)
    public ResponseJSON<Answer> getAnswerById(@PathVariable int id) {
        return new ResponseJSON<>(true, answerService.getAnswerById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }


    /**

     * 根据用户id查询用户的答案
     * @author phantaci
     * @date 2019/3/30
     * @param id
     */

    @ApiOperation("根据用户id查询用户的答案")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/answer/User/{id}", method = RequestMethod.GET)
    public ResponseJSON<List<Answer>> getAnswerByUserId(@PathVariable int id){

        return new ResponseJSON<>(true,answerService.getAnswerByUserId(id));

    }

    /**
     * 添加新的问卷
     *
     * @param answer 一答案对象
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("添加新的答案")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "optionId", value = "选项id", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "int", paramType = "query", required = true),
    })
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public ResponseJSON<Answer> addAnswer(Answer answer) {
        return new ResponseJSON<>(true, answerService.addAnswer(answer), UnicomResponseEnums.SUCCESS_OPTION);
    }



    /**
     *
     *
     * @param answer
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("根据答案实体删除答案")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "answerId", value = "答案id", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "UserId", value = "用户id", dataType = "int", paramType = "query", required = true),
            //@ApiImplicitParam(name = "questionnaireInstruction", value = "问卷介绍", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/answer", method = RequestMethod.DELETE)
    public ResponseJSON delete(Answer answer) {
        answerService.deleteAnswerById(answer);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }
}
