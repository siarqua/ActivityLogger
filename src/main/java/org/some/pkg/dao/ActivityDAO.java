package org.some.pkg.dao;

import org.some.pkg.entity.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarqua on 10.08.15.
 */
@Repository
@Transactional
public interface ActivityDAO extends PagingAndSortingRepository<Activity, Long> {

    List<Activity> findByUserId(Long id);
    Activity findById(long id);
}
