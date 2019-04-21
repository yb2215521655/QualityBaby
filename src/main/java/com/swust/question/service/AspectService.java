package com.swust.question.service;

import com.swust.question.common.restful.UnicomResponseEnums;
import com.swust.question.common.restful.UnicomRuntimeException;
import com.swust.question.dao.AspectDAO;
import com.swust.question.dao.AspectDetailDAO;
import com.swust.question.dao.UserAndAspectDAO;
import com.swust.question.entity.Aspect;
import com.swust.question.entity.AspectDetail;
import com.swust.question.entity.UserAndAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: AspectService
 * @Package com.swust.question.service
 * @description:
 * @date 2019/4/1
 */
@Service
public class AspectService {
    @Autowired
    private AspectDAO aspectDAO;
    @Autowired
    private AspectDetailDAO aspectDetailDAO;
    @Autowired
    private UserAndAspectDAO userAndAspectDAO;

    /**
     * 根据id获取大维度实体
     *
     * @param id
     * @return com.swust.question.entity.Aspect
     * @author phantaci
     * @date 2019/4/1
     */
    public Aspect getAspectById(int id) {
        return aspectDAO.getOne(id);
    }

    /**
     * 获取所有大维度的实体
     *
     * @param
     * @return java.util.List<com.swust.question.entity.Aspect>
     * @author phantaci
     * @date 2019/4/1
     */
    public List<Aspect> getAllAspect(){ return aspectDAO.findAll();}

    /**
     * 添加大维度实体
     *
     * @param
     * @return com.swust.question.entity.Aspect
     * @author phantaci
     * @date 2019/4/1
     */
    public Aspect addAspect(Aspect aspect) {
        return aspectDAO.save(aspect);
    }


    /**
     * 分页获取所有大维度
     *
     * @param
     * @return com.swust.question.entity.Aspect
     * @author phantaci
     * @date 2019/4/19
     */
    public List<Aspect> getAllAspect(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return aspectDAO.findAll(pageable).getContent();
    }


    /**
     * 根据大维度实体删除大维度
     *
     * @return com.swust.question.entity.Aspect
     * @author phantaci
     * @date 2019/4/1
     */
    public void deleteAspectById(Aspect aspect){
        if(aspect.getAspectId() == 0){
            try{
                aspectDAO.save(new Aspect());
            }catch (BindException e) {

            } finally {
                return;
            }
        }
        aspectDAO.delete(aspect);
    }

    /**
     * 根据ID删除大维度
     *
     * @param aspectId 要删除的活动ID
     * @return void
     * @author phantaci
     * @date 2019/4/20
     */
    public void deleteAspect(int aspectId) {
        aspectDAO.deleteById(aspectId);
    }
    /**
     * 修改大维度实体
     *
     * @param aspect
     * @return com.swust.question.entity.Aspect
     * @author phantaci
     * @date 2019/4/1
     */
    public Aspect editAspect(Aspect aspect) {
        if (aspect.getAspectId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT,"id不能为空");
        }
        return aspectDAO.saveAndFlush(aspect);
    }

    /**
     *  获得大维度总数
     * @author phantaci
     * @date 2019/4/19
     * @param
     * @return int
     */
    public int getSumAspect(){
        return (int) aspectDAO.count();
    }

    /**
     * 添加小维度实体
     *
     * @param
     * @return com.swust.question.entity.AspectDetail
     * @author phantaci
     * @date 2019/3/23
     */
    public AspectDetail addAspectDetail(AspectDetail aspectDetail) {
        return aspectDetailDAO.save(aspectDetail);
    }

    /**
     * 修改小维度实体
     *
     * @param aspectDetail
     * @return com.swust.question.entity.Questionnaire
     * @author phantaci
     * @date 2019/3/23
     */

    public AspectDetail editAspectDetail(AspectDetail aspectDetail) {
        if (aspectDetail.getDetailId() == 0) {
            throw new UnicomRuntimeException(UnicomResponseEnums.ILLEGAL_ARGUMENT,"id不能为空");
        }
        return aspectDetailDAO.saveAndFlush(aspectDetail);
    }


    /**
     * 获取所有小维度的实体
     *
     * @param
     * @return java.util.List<com.swust.question.entity.AspectDetail>
     * @author phantaci
     * @date 2019/3/31
     */
   // public List<AspectDetail> getAllAspectDetail(){ return aspectDetailDAO.findAll();}

    public List<AspectDetail> getAllAspectDetail(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return aspectDetailDAO.findAll(pageable).getContent();
    }



    /**
     * 根据id删除小维度
     *
     * @return com.swust.question.entity.AspectDetail
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteAspectDetailById(int id){
        aspectDetailDAO.deleteById(id);
    }

    /**
     * 根据小维度实体删除小维度
     *
     * @return com.swust.question.entity.AspectDetail
     * @author phantaci
     * @date 2019/3/23
     */
    public void deleteAspectDetailById(AspectDetail aspectDetail){
        if(aspectDetail.getDetailId() == 0){
            try{
                aspectDetailDAO.save(new AspectDetail());
            }catch (BindException e) {

            } finally {
                return;
            }
        }
        aspectDetailDAO.delete(aspectDetail);
    }

    /**
     *  获得小维度总数
     * @author phantaci
     * @date 2019/4/19
     * @param
     * @return int
     */
    public int getSumAspectDetail(){
        return (int) aspectDetailDAO.count();
    }

    /**
     * 根据大维度id获取小维度
     *
     * @author phantaci
     * @date 2019/4/1
     */

    public List<AspectDetail> getAspectDetailByAspectId(int aspectId){
        List<AspectDetail> aspectDetailList = aspectDetailDAO.findAllByAspectId(aspectId);
        return aspectDetailList;
    }

    /**
     * 根据用户ID获取雷达图列表，即查询用户参加的活动列表
     * @author phantaci
     * @date 2019/4/20
     * @param userId 用户ID
     * @return java.util.List<com.swust.question.entity.Activity>
     */
    public List<Aspect> getAspectByUserId(int userId){
        List<UserAndAspect> list = userAndAspectDAO.findAllByAspect_AspectId(userId);
        List<Aspect> aspectList=list.stream()
                .map(UserAndAspect::getAspect)
                .collect(Collectors.toList());
        return aspectList;
    }

    /**
     *  根据用户ID获取雷达图列表，即查询用户参加的活动列表（分页）
     * @author phantaci
     * @date 2019/4/20
     * @param userId 用户id
     * @param pageNumber 页码
     * @param pageSize 大小
     * @return java.util.List<com.swust.question.entity.Aspect>
     */
    public List<Aspect> getAspectByUserId(int userId,int pageNumber,int pageSize){
        Pageable pageable=PageRequest.of(pageNumber,pageSize);
        List<UserAndAspect> list = userAndAspectDAO.findAllByAspect_AspectId(userId,pageable).getContent();
        List<Aspect> aspectList=list.stream()
                .map(UserAndAspect::getAspect)
                .collect(Collectors.toList());
        return aspectList;
    }




    /**
     *  获得条件查询以后的总数
     * @author phantaci
     * @date 2019/4/20
     * @param userId
     * @return int
     */
    public int getSumAspect(int userId){
        return (int)userAndAspectDAO.countByUser_UserId(userId);
    }

    /**
     *
     * @author phantaci
     * @date 2019/4/20
     * @param aspectId
     * @return int
     */
//    public int getSumAspectDetail(int aspectId){
//        return (int)aspectDetailDAO.countByAspect_AspectId(aspectId);
//    }

}
