package org.some.pkg.dao;

import org.some.pkg.entity.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarqua on 10.08.15.
 */
@Repository
public interface ActivityDAO extends PagingAndSortingRepository<Activity, Long> {

    List<Activity> findByUserId(Long id);
    Activity findById(long id);
}
