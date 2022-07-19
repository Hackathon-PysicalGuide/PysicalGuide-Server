package com.project.mirinae.domain.manual.service;

import com.project.mirinae.domain.manual.entity.Manual;
import com.project.mirinae.domain.manual.exception.ManualAlreadyExistsByTitleException;
import com.project.mirinae.domain.manual.presentation.dto.request.ManualAddRequest;
import com.project.mirinae.domain.manual.presentation.dto.response.ManualDataResponse;
import com.project.mirinae.domain.manual.presentation.dto.response.ManualResponse;
import com.project.mirinae.domain.manual.repository.ManualRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ManualAddService {

    private static final Logger log = LoggerFactory.getLogger(ManualAddService.class);
    private final ManualRepository manualRepository;

    @Transactional
    public ManualDataResponse execute(ManualAddRequest request) {

        manualRepository.findByTitle(request.getTitle()).ifPresent(m -> {
            throw ManualAlreadyExistsByTitleException.EXCEPTION;
        });

        Manual manual = Manual.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .build();

        manual = manualRepository.save(manual);

        ManualResponse manualData = ManualResponse.builder()
                .idx(manual.getIdx())
                .title(manual.getTitle())
                .content(manual.getContent())
                .category(manual.getCategory())
                .build();

        log.info("ManualAdd Success!!");

        return ManualDataResponse.builder()
                .manualData(manualData)
                .build();
    }

}
