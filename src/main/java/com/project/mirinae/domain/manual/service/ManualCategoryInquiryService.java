package com.project.mirinae.domain.manual.service;

import com.project.mirinae.domain.manual.entity.Manual;
import com.project.mirinae.domain.manual.exception.ManualNotFoundByCategoryException;
import com.project.mirinae.domain.manual.presentation.dto.response.ManualListReponse;
import com.project.mirinae.domain.manual.presentation.dto.response.ManualResponse;
import com.project.mirinae.domain.manual.repository.ManualRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManualCategoryInquiryService {

    private static final Logger log = LoggerFactory.getLogger(ManualCategoryInquiryService.class);
    private final ManualRepository manualRepository;

    public ManualListReponse execute(String searhBy) {

        if(!(searhBy.equals("upperBody") || searhBy.equals("abs") || searhBy.equals("lowerBody"))) {
            throw ManualNotFoundByCategoryException.EXCEPTION;
        }

        List<Manual> found = manualRepository.findAllByCategory(searhBy);

        List<ManualResponse> list = found.stream().map(it ->
                ManualResponse.builder()
                        .idx(it.getIdx())
                        .title(it.getTitle())
                        .content(it.getContent())
                        .category(it.getCategory())
                        .build()).collect(Collectors.toList()
        );

        log.info("ManualCategoryInquiry Success!!");

        return ManualListReponse.builder()
                .list(list)
                .build();
    }

}
