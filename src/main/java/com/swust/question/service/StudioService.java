package com.swust.question.service;

import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.common.restful.UnicomRuntimeException;
import com.swust.question.dao.StudioDAO;
import com.swust.question.dao.UserAndStudioDAO;
import com.swust.question.entity.Studio;
import com.swust.question.entity.UserAndStudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pang
 * @version V1.0
 * @ClassName: StudioService
 * @Package com.swust.question.service
 * @description: Studio事务层
 * @date 2019/3/22 17:04
 */
@Service
public class StudioService {
    @Autowired
    private StudioDAO studioDAO;
    @Autowired
    private UserAndStudioDAO userAndStudioDAO;

    /**
     * 根据id获取工作室实体
     *
     * @param id
     * @return com.swust.question.entity.Studio
     * @author pang
     * @date 2019/3/22
     */
    public Studio getStudioById(int id) {
        return studioDAO.getOne(id);
    }

    /**
     * 获取所有工作室实体
     *
     * @param
     * @return java.util.List<com.swust.question.entity.Studio>
     * @author pang
     * @date 2019/3/22
     */
    public List<Studio> getAllStudio() {
        return studioDAO.findAll();
    }

    /**
     * 分页获取所有工作室实体
     *
     * @param pageNumber 页码
     * @param pageSize   每页大小
     * @return org.springframework.data.domain.Page<com.swust.question.entity.Studio>
     * @author pang
     * @date 2019/3/22
     */
    public List<Studio> getAllStudio(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return studioDAO.findAll(pageable).getContent();
    }

    /**
     * 添加工作室实体
     *
     * @param studio
     * @return com.swust.question.entity.Studio
     * @author pang
     * @date 2019/3/22
     */
    public Studio addStudio(Studio studio) {
        return studioDAO.save(studio);
    }

    /**
     * 修改工作室实体，注意，如果没有studioId属性的话，则会抛出异常，而且不会进行更新操作处理
     *
     * @param studio
     * @return com.swust.question.entity.Studio
     * @author pang
     * @date 2019/3/22
     */
    public Studio editStudio(Studio studio) {
        if (studio.getStudioId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT, "id不能为空");
        }
        return studioDAO.saveAndFlush(studio);
    }

    /**
     * 根据id删除工作室
     *
     * @param id
     * @return void
     * @author pang
     * @date 2019/3/22
     */
    public void deleteStudio(int id) {
        studioDAO.deleteById(id);
    }

    /**
     * 根据工作室实体删除工作室
     *
     * @param studio
     * @return void
     * @author pang
     * @date 2019/3/22
     */
    public void deleteStudio(Studio studio) {
        studioDAO.deleteById(studio.getStudioId());
    }

    /**
     * @param userId 用户ID
     * @return
     * @author pang
     * @date 2019/3/26
     */
    public List<Studio> getStudioByUserId(int userId) {
        List<UserAndStudio> list = userAndStudioDAO.findAllByUser_UserId(userId);
        List<Studio> studioList = list.stream()
                .map(UserAndStudio::getStudio)
                .collect(Collectors.toList());
        return studioList;
    }


    /**
     * 根据用户ID获取参加的工作室列表
     *
     * @param userId     用户id
     * @param pageNumber 页码
     * @param pageSize   大小
     * @return java.util.List<com.swust.question.entity.Studio>
     * @author pang
     * @date 2019/4/12
     */
    public List<Studio> getStudioByUserId(int userId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        List<UserAndStudio> list = userAndStudioDAO.findAllByUser_UserId(userId, pageable).getContent();
        List<Studio> studioList = list.stream()
                .map(UserAndStudio::getStudio)
                .collect(Collectors.toList());
        return studioList;
    }

    /**
     * 获得总数
     *
     * @param
     * @return int
     * @author pang
     * @date 2019/4/12
     */
    public int getSumStudio() {
        return (int) studioDAO.count();
    }

    /**
     * 获得条件查询以后的总数
     *
     * @param userId 用户ID
     * @return int
     * @author pang
     * @date 2019/4/12
     */
    public int getSumActivity(int userId) {
        return (int) userAndStudioDAO.countByUser_UserId(userId);
    }

}
