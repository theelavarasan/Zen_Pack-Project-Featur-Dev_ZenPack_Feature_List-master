package com.ZenPack.converter;

import com.ZenPack.Dto.ZenPackDto;
import com.ZenPack.model.ZenPack;

import java.util.List;
import java.util.stream.Collectors;

public class ZenPackConverter {
    public static List<ZenPackDto> convertToZenPackDTO(List<ZenPack> students) {
        return students.stream().map(s ->
                ZenPackDto.builder()
                        .name(s.getName())
                        .createdBy(s.getCreatedBy())
                        .createdDate(s.getCreatedDate())
                        .updatedBy(s.getUpdatedBy())
                        .updatedTime(s.getUpdatedTime())
                        .build()
        ).collect(Collectors.toList());
    }
}
