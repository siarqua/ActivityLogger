package org.some.pkg.dao;

import org.some.pkg.entity.Detail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siarqua on 10.08.15.
 */
@Repository
public interface DetailDAO extends PagingAndSortingRepository<Detail,Long> {

    Detail findById(Long id);
}
