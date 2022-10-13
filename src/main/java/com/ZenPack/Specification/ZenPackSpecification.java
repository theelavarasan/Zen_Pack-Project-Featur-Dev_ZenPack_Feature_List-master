package com.ZenPack.Specification;

import com.ZenPack.Dto.SpecificationDto;
import com.ZenPack.model.ZenPack;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ZenPackSpecification implements Specification<ZenPack> {
    SpecificationDto criteria;

    public ZenPackSpecification(){
    }

    public ZenPackSpecification(final SpecificationDto specificationDto){
        super();
        this.criteria=specificationDto;
    }

    @Override
    public Predicate toPredicate(Root<ZenPack> root, CriteriaQuery<?> query, CriteriaBuilder builder){
        if(criteria.getOperation().equalsIgnoreCase("EQUAL_TO")){
            return.builder.equal(root.<->get(criteria.getKey()),cr)
        }

        return null;
    }
}
