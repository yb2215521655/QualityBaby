package com.swust.question.comtroller;

import com.swust.question.common.restful.ResponseJSON;
import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.dao.StudioDAO;
import com.swust.question.entity.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pang
 * @version V1.0
 * @ClassName: StudioController
 * @Package com.swust.question.comtroller
 * @description: 工作室访问类，仅仅是一个demo
 * @date 2019/3/20 22:49
 */
@RestController
public class StudioController {
    @Autowired
    private StudioDAO studioDAO;

    @RequestMapping(value = "/studio/{id}", method = RequestMethod.GET)
    public ResponseJSON<Studio> getStudioById(@PathVariable int id) {
        return new ResponseJSON<Studio>(true,studioDAO.findByStudioId(id), UnicomResponseEnums.SUCCESS_OPTION);
    }


}
