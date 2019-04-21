package com.swust.question.dao;

import com.swust.question.entity.Aspect;
import com.swust.question.entity.AspectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author phantaci
 * @version V1.0
 * @ClassName: AspectDetailDAO
 * @Package com.swust.question.dao
 * @date 2019/4/1 20：04
 */
public interface AspectDetailDAO extends JpaRepository<AspectDetail,Integer> , PagingAndSortingRepository<AspectDetail,Integer> {

    /**
     * 根据大维度ID查找大维度里面包含的小维度
     * @author phantaci
     * @version V1.0
     * @date 2019/4/1 23：04
     */
    List<AspectDetail> findAllByAspectId(Integer aspectId);

    /**
     * 根据大维度ID查找小维度的数量
     *
     * @param aspectId 大维度ID
     * @return java.lang.Long
     * @author phantaci
     * @date 2019/4/20
     */
    //long countByAspect_AspectId(Integer aspectId);
}
