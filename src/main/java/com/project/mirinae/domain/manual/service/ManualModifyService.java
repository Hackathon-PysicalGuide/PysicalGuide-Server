package com.project.mirinae.domain.manual.service;

import com.project.mirinae.domain.manual.entity.Manual;
import com.project.mirinae.domain.manual.exception.ManualNotFoundByTitleException;
import com.project.mirinae.domain.manual.presentation.dto.request.ManualModifyRequest;
import com.project.mirinae.domain.manual.presentation.dto.response.ManualDataResponse;
import com.project.mirinae.domain.manual.presentation.dto.response.ManualResponse;
import com.project.mirinae.domain.manual.repository.ManualRepository;
import com.project.mirinae.global.utils.ModifyUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ManualModifyService {

    private static final Logger log = LoggerFactory.getLogger(ManualModifyService.class);
    private final ManualRepository manualRepository;

    @Transactional
    public ManualDataResponse execute(int idx, ManualModifyRequest request) {

        manualRepository.findById(idx)
                .orElseThrow(() -> {
                    throw ManualNotFoundByTitleException.EXCEPTION;
                });

        ModifyUtil<String> modify = new ModifyUtil<>();

        Manual manual = manualRepository.getReferenceById(idx);

        manual = Manual.builder()
                .title(modify.getUpdated(manual.getTitle(), request.getTitle()))
                .content(modify.getUpdated(manual.getContent(), request.getContent()))
                .category(modify.getUpdated(manual.getCategory(), request.getCategory()))
                .build();

        manualRepository.save(manual);

        ManualResponse manualData = ManualResponse.builder()
                .idx(manual.getIdx())
                .title(manual.getTitle())
                .content(manual.getContent())
                .category(manual.getCategory())
                .build();

        log.info("ManualModify Success!!");

        return ManualDataResponse.builder()
                .manualData(manualData)
                .build();
    }

}
