package com.swust.question.controller;

import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.entity.Questionnaire;
import com.swust.question.entity.Question;
import com.swust.question.entity.Option;
import com.swust.question.service.QuestionnaireService;
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
 * @ClassName: QuestionnaireController
 * @Package： com.swust.question.controller
 * @description: 问卷操作
 * @date 2019/3/23
 */
@Api(tags = "问卷")
@RestController
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误", response = ResponseJSON.class)})
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;
    /**
     * 根据id查找问卷
     *
     * @param id 问卷id
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("根据id查找问卷")
    @ApiImplicitParam(name = "id", value = "问卷id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/questionnaire/{id}", method = RequestMethod.GET)
    public ResponseJSON<Questionnaire> getQuestionnaireById(@PathVariable int id) {
        return new ResponseJSON<>(true, questionnaireService.getQuestionnaireById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation(value = "查找所有问卷（可分页）",notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/questionnaire", method = RequestMethod.GET)
    public ResponseJSON<List<Questionnaire>> getAllQuestionnaire(HttpServletRequest request) {
        int pageNumber=request.getParameter("pageNumber")==null?0:Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize=request.getParameter("pageSize")==null?0:Integer.parseInt(request.getParameter("pageSize"));
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, questionnaireService.getAllQuestionnaire(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON<>(true, questionnaireService.getAllQuestionnaire(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }

    /**
     * 添加新的问卷
     *
     * @param questionnaire 一个问卷对象
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("添加新的问卷")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "questionnaireInstruction", value = "问卷介绍", dataType = "String", paramType = "query", required = true),
    })
    @RequestMapping(value = "/questionnaire", method = RequestMethod.POST)
    public ResponseJSON<Questionnaire> addQuestionnaire(Questionnaire questionnaire) {
        return new ResponseJSON<>(true, questionnaireService.addQuestionnaire(questionnaire), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 更新问卷的内容
     *
     * @param questionnaire
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("更新问卷的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionnaireId", value = "问卷id", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "questionnaireInstruction", value = "问卷介绍", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/questionnaire", method = RequestMethod.PUT)
    public ResponseJSON<Questionnaire> editQuestionnaire(Questionnaire questionnaire) {
        return new ResponseJSON<>(true, questionnaireService.editQuestionnaire(questionnaire), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据问卷实体删除对象。一定要有问卷的id
     *
     * @param questionnaire
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("根据问卷实体删除对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionnaireId", value = "问卷id", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = false),
            @ApiImplicitParam(name = "questionnaireInstruction", value = "问卷介绍", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/questionnaire", method = RequestMethod.DELETE)
    public ResponseJSON delete(Questionnaire questionnaire) {
        questionnaireService.deleteQuestionnaireById(questionnaire);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation(value = "查找所有问题（可分页）",notes = "分页从第0页开始计算")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = false, dataType = "int", paramType = "query"),
    })
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public ResponseJSON<List<Question>> getAllQuestion(HttpServletRequest request) {
        int pageNumber=request.getParameter("pageNumber")==null?0:Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize=request.getParameter("pageSize")==null?0:Integer.parseInt(request.getParameter("pageSize"));
        if (pageNumber > 0 && pageSize > 0) {
            return new ResponseJSON<>(true, questionnaireService.getAllQuestion(pageNumber, pageSize), UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON<>(true, questionnaireService.getAllQuestion(), UnicomResponseEnums.SUCCESS_OPTION);
        }
    }

    /**
     * 根据ID删除问题
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/3/31
     */
    @ApiOperation("根据id删除问题")
    @ApiImplicitParam(name = "id", value = "问题id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
    public ResponseJSON delete(@PathVariable int id) {
        questionnaireService.deleteQuestionById(id);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }



    /**
     * 添加新的问题
     *
     * @param question 一个问卷对象
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("添加新的问题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionnaireId", value = "问卷id", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "questionDetail", value = "问题内容", dataType = "String", paramType = "query", required = true),
    })
    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public ResponseJSON<Question> addQuestion(Question question) {
        return new ResponseJSON<>(true, questionnaireService.addQuestion(question), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 更新问题的内容
     *
     * @param question
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("更新问题的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionId", value = "问题id", dataType = "int", paramType = "query", required = true),
            //@ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = false),
            //@ApiImplicitParam(name = "questionDetail", value = "问题内容", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/question", method = RequestMethod.PUT)
    public ResponseJSON<Question> editQuestion(Question question) {
        return new ResponseJSON<>(true, questionnaireService.editQuestion(question), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据问卷实体删除对象。一定要有问卷的id
     *
     * @param question
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("根据问题实体删除对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionId", value = "问题id", dataType = "Integer", paramType = "query", required = true),
            //@ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = false),
            //@ApiImplicitParam(name = "questionnaireInstruction", value = "问卷介绍", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/question", method = RequestMethod.DELETE)
    public ResponseJSON delete(Question question) {
        questionnaireService.deleteQuestionById(question);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }


    /**
     * 根据ID删除选项
     *
     * @param id
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/3/31
     */
//    @ApiOperation("根据id删除选项")
//    @ApiImplicitParam(name = "id", value = "选项id", dataType = "int", paramType = "path", required = true)
//    @RequestMapping(value = "/option/{id}", method = RequestMethod.DELETE)
//    public ResponseJSON delete(@PathVariable int id) {
//        questionnaireService.deleteOptionById(id);
//        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
//    }



    /**
     * 添加新的选项
     *
     * @param option 一个问卷对象
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("添加新的选项")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionId", value = "问题id", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "optionDetail", value = "选项内容", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "optionOrder", value = "选项顺序", dataType = "int", paramType = "query", required = true),
    })
    @RequestMapping(value = "/option", method = RequestMethod.POST)
    public ResponseJSON<Option> addOption(Option option) {
        return new ResponseJSON<>(true, questionnaireService.addOption(option), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 更新选项的内容
     *
     * @param option
     * @return com.swust.question.common.restful.ResponseJSON<com.swust.question.entity.Questionnaire>
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("更新选项的内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "optionId", value = "选项id", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "optionOrder", value = "选项顺序", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "questionId", value = "问题id", dataType = "Integer", paramType = "query", required = true),
            //@ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = false),
            //@ApiImplicitParam(name = "questionDetial", value = "问题内容", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/option", method = RequestMethod.PUT)
    public ResponseJSON<Option> editOption(Option option) {
        return new ResponseJSON<>(true, questionnaireService.editOption(option), UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据选项实体删除对象。一定要有选项的id
     *
     * @param option
     * @return com.swust.question.common.restful.ResponseJSON
     * @author phantaci
     * @date 2019/3/23
     */
    @ApiOperation("根据选项实体删除对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "optionId", value = "选项id", dataType = "Integer", paramType = "query", required = true),

            //@ApiImplicitParam(name = "questionnaireTitle", value = "问卷名", dataType = "String", paramType = "query", required = false),
            //@ApiImplicitParam(name = "questionnaireInstruction", value = "问卷介绍", dataType = "String", paramType = "query", required = false)
    })
    @RequestMapping(value = "/option", method = RequestMethod.DELETE)
    public ResponseJSON delete(Option option) {
        questionnaireService.deleteOptionById(option);
        return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
    }


    /**

     * 根据问题id查询里面含的选项
     * @author phantaci
     * @date 2019/3/25
     * @param id
     */

    @ApiOperation("根据问题id查询里面包含的选项")
    @ApiImplicitParam(name = "id", value = "问题id", dataType = "int", paramType = "path", required = true)
    @RequestMapping(value = "/option/question/{id}", method = RequestMethod.GET)
    public ResponseJSON<List<Option>> getOptionByQuestionId(@PathVariable int id){

        return new ResponseJSON<>(true,questionnaireService.getOptionByQuestionId(id));

    }



}
