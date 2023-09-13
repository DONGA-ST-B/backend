package gip.sever.controller;

import gip.sever.dto.request.SearchRequest;
import gip.sever.dto.response.SearchResponse;
import gip.sever.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/search")
public class SearchController {


    private final SearchService searchService;

    @PostMapping()
    public List<SearchResponse> search(@RequestBody SearchRequest searchRequest) {
        return searchService.searchKeyword(searchRequest.getKeyword());
    }
}
