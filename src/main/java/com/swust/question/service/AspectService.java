package com.swust.question.service;

import com.swust.question.dao.AspectDAO;
import com.swust.question.dao.AspectDetailDAO;
import com.swust.question.entity.Aspect;
import com.swust.question.entity.AspectDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

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
//    public Aspect create() {
//        Aspect aspect = new Aspect();
//        aspect.setAspectId(1);
//
//        List<AspectDetail> detailList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            AspectDetail aspectDetail = new AspectDetail();
//            aspectDetail.setDetailId(1);
//            //不用设置parentId哦
//            detailList.add(aspectDetail);
//        }
//
//        aspect.setDetailList(detailList);
//        return aspectDAO.save(aspect);
//    }

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
     * 修改大维度实体
     *
     * @param aspect
     * @return com.swust.question.entity.Aspect
     * @author phantaci
     * @date 2019/4/1
     */
    public Aspect editAspect(Aspect aspect) {
        if (aspect.getAspectId() == 0) {
            try {
                aspectDAO.save(new Aspect());
            } catch (BindException e) {

            } finally {
                return null;
            }
        }
        return aspectDAO.saveAndFlush(aspect);
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
            try {
                aspectDetailDAO.save(new AspectDetail());
            } catch (BindException e) {

            } finally {
                return null;
            }
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
    public List<AspectDetail> getAllAspectDetail(){ return aspectDetailDAO.findAll();}


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
     * 根据大维度id获取小维度
     *
     * @author phantaci
     * @date 2019/4/1
     */

    public List<AspectDetail> getAspectDetailByAspectId(int aspectId){
        List<AspectDetail> aspectDetailList = aspectDetailDAO.findAllByAspectId(aspectId);
        return aspectDetailList;
    }

//    /**
//     * 根据smallid获取big
//     *
//     * @author phantaci
//     * @date 2019/4/1
//     */
//
//    public List<AspectDetail> getAspectDetailByAspectId(int aspectId){
//        List<AspectDetail> aspectDetailList = aspectDetailDAO.findAllByAspectId(aspectId);
//        return aspectDetailList;
//    }
}
