package com.project.mirinae.domain.manual.presentation;

import com.project.mirinae.domain.manual.presentation.dto.request.ManualAddRequest;
import com.project.mirinae.domain.manual.presentation.dto.request.ManualModifyRequest;
import com.project.mirinae.domain.manual.presentation.dto.response.ManualDataResponse;
import com.project.mirinae.domain.manual.presentation.dto.response.ManualListReponse;
import com.project.mirinae.domain.manual.service.ManualAddService;
import com.project.mirinae.domain.manual.service.ManualCategoryInquiryService;
import com.project.mirinae.domain.manual.service.ManualFullInquiryService;
import com.project.mirinae.domain.manual.service.ManualModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/manual")
public class ManualController {

    private final ManualAddService manualAddService;
    private final ManualModifyService manualModifyService;
    private final ManualFullInquiryService manualFullInquiryService;
    private final ManualCategoryInquiryService manualCategoryInquiryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public ManualDataResponse manualAdd(
            @RequestBody ManualAddRequest request
    ) {
        return manualAddService.execute(request);
    }

    @PatchMapping("/modify")
    public ManualDataResponse manualModify(
            @RequestParam("idx") int idx,
            @RequestBody ManualModifyRequest request
    ) {
        return manualModifyService.execute(idx, request);
    }

    @GetMapping("/")
    public ManualListReponse manualFullInquiry() {
        return manualFullInquiryService.execute();
    }

    @GetMapping("/category/{search-by}")
    public ManualListReponse manualCategoryInquiry(
            @PathVariable("search-by") String searchBy
    ) {
        return manualCategoryInquiryService.execute(searchBy);
    }

}
