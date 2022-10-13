package com.ZenPack.service.Impl;

import com.ZenPack.Dto.ZenPackDto;
import org.springframework.data.domain.Sort;
import com.ZenPack.converter.ZenPackConverter;
import com.ZenPack.model.ZenPack;
import com.ZenPack.repository.ZenPackRepository;
import com.ZenPack.service.Services.ZenPackService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j

public class ZenPackServiceImpl implements ZenPackService {
    @Autowired
    private ZenPackRepository repository;

    private static final Logger logger= LoggerFactory.getLogger(ZenPackServiceImpl.class);

    @Override
    public ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack) {
        repository.save(zenPack);
        logger.info("Zen-Pack Saved Successfully");
        return new ResponseEntity<>(zenPack, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ZenPackDto> createZenPack(ZenPackDto createDto) {
        ZenPack zenPack;
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        ZenPack zenPack1=mapper.map(createDto,ZenPack.class);
        zenPack=repository.save(zenPack1);
        ZenPackDto dto=mapper.map(zenPack, ZenPackDto.class);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @Override
    public List<ZenPack> getAllZenpack() {
        return repository.findAll();
    }

    @Override
    public List<ZenPack> findByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }

 //   @Override
//    public List<ZenPack> findAllOrderByNameAsc() {
 //       var sort = new Sort(Sort.Direction.ASC,"name");
 //       return repository.findAllOrderByNameAsc(sort);
 //   }

/*    @Override
    public List<ZenPackDto> getZenPacks(String name) {
        List<ZenPack> zenPacks = repository.findAll((Specification<ZenPack>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
//            if (Objects.nonNull(fromDate) && Objects.nonNull(toDate) && fromDate.before(toDate)) {
//                p = cb.and(p, cb.between(root.get("createdDate"), fromDate, toDate));
//            }
            if (!StringUtils.isEmpty(name)) {
                p = cb.and(p, cb.like(root.get("name"), "%" + name + "%"));
            }
            cq.orderBy(cb.desc(root.get("name")), cb.asc(root.get("id")));
            return p;
        }, ).getContent();
        return ZenPackConverter.convertToZenPackDTO(zenPacks);
    }*/
}
