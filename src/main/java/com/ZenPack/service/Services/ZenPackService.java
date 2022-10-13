package com.ZenPack.service.Services;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.FeaturedList;
import com.ZenPack.model.ZenPack;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface ZenPackService {
    ResponseEntity<ZenPack> saveZenPack(ZenPack zenPack);

    ResponseEntity<ZenPackDto> createZenPack(ZenPackDto createDto);

    List<ZenPack> getAllZenpack();

    List<ZenPack> findByKeyword(String keyword);

   // List<ZenPack> findAllOrderByNameAsc();

//    List<ZenPackDto> getZenPacks(String name);

    //List<ZenPackDto> getStudents(Date fromDate, Date toDate, String name, Pageable pageable);
}
