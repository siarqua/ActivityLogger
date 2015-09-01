package org.some.pkg.dao;

import org.some.pkg.entity.Detail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by siarqua on 10.08.15.
 */
@Repository
@Transactional
public interface DetailDAO extends PagingAndSortingRepository<Detail,Long> {

    Detail findById(Long id);
}
