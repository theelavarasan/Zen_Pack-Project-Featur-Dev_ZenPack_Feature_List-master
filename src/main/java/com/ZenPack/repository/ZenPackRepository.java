package com.ZenPack.repository;

import com.ZenPack.model.FeaturedList;
import com.ZenPack.model.ZenPack;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZenPackRepository extends JpaRepository<ZenPack,Integer>, JpaSpecificationExecutor<ZenPack> {
//    List<ZenPack> findByZenPackName();

//    List<ZenPack> findAllByNameLikeAndCategoryIn(String name, List<ZenPack> categories);

    @Query("SELECT p FROM ZenPack p WHERE p.name LIKE %:keyword%")
    List<ZenPack> findByKeyword(String keyword);

    @Query("FROM City")
    List<ZenPack> findAllOrderByNameAsc(Sort sort);
}
