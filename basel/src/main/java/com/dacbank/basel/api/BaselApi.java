package com.dacbank.basel.api;

import com.dacbank.basel.dto.Basel;
import com.dacbank.basel.service.BaselService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/basel/v1/analyzes", produces = "application/hal+json")
public class BaselApi {

    /**
     * = BASEL related methods =
     *
     *     > BaselResponse newAnalysis(BaselRequest): calculate and set category & PD (generating a Basel analysis) of
     *                                                  an operation given a BaselRequest object
     *     > BaselResponse getAnalysis(Long): get an analysis given the analysis id
     *     > List<BaselResponse> getAllAnalysis(): get all existing analysis
     *
     *      = Mapping methods =
     *     > Basel convertToBaselEntity(BaselRequest): map BaselRequest DTO to Basel entity
     *     > BaselResponse convertToBaselResponseDTO(Basel): map Basel entity to BaselResponse DTO
     *     > List<Basel> convertToBaselEntity(List<BaselRequest>): map List<BaselRequest DTO> to List<Basel entity>
     *     > List<BaselResponse> convertToBaselResponseDTO(List<Basel>): map List<Basel entity> to
     *                                                                      List<BaselResponse DTO>
     */

    @Autowired
    private BaselService baselService;
    @Autowired
    private ModelMapper modelMapper;
    public BaselApi(BaselService baselService, ModelMapper modelMapper){
        this.baselService = baselService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value="")
    public BaselResponse newAnalysis(@RequestBody @Valid BaselRequest baselRequest){
        Basel basel = convertToBaselEntity(baselRequest);
        baselService.baselAnalysis(basel);
        return convertToBaselResponseDTO(baselService.newAnalysis(basel));
    }

    @GetMapping(value="", params={"page", "size"})
    public List<BaselResponse> getAllAnalyzesPaginated(@RequestParam("page") int page,
                                                       @RequestParam("size") int size) {
        List<BaselResponse> baselResponseList = convertToBaselResponseDTO(
                baselService.getAllAnalyzesPaginated(page, size));
        return baselResponseList;
    }

    @GetMapping(value="/{idAnalysis}")
    public BaselResponse getAnalysis(@PathVariable("idAnalysis") Long idAnalysis){
        BaselResponse baselResponse = convertToBaselResponseDTO(baselService.getAnalysis(idAnalysis));
        return baselResponse;
    }

    /**
     * ****************************************************************
     * < Mapping methods >
     */

    private Basel convertToBaselEntity(BaselRequest baselRequest){
        Basel basel = modelMapper.map(baselRequest, Basel.class);
        return basel;
    }

    private List<Basel> convertToBaselEntity(List<BaselRequest> baselRequestList){
        List<Basel> baselList = baselRequestList.stream()
                .map(BaselRequest -> modelMapper.map(BaselRequest, Basel.class))
                .collect(Collectors.toList());
        return baselList;
    }

    private BaselResponse convertToBaselResponseDTO(Basel basel){
        BaselResponse baselResponse = modelMapper.map(basel, BaselResponse.class);
        return baselResponse;
    }

    private List<BaselResponse> convertToBaselResponseDTO(List<Basel> baselList){
        List<BaselResponse> baselResponseList = baselList.stream()
                .map(Basel -> modelMapper.map(Basel, BaselResponse.class))
                .collect(Collectors.toList());
        return baselResponseList;
    }

}
