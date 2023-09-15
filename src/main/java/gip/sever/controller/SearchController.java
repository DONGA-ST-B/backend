package gip.sever.controller;

import gip.sever.dto.request.SearchRequest;
import gip.sever.dto.response.SearchResponse;
import gip.sever.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/search")
public class SearchController {


    private final SearchService searchService;

    @PostMapping()
    public List<SearchResponse> search(@RequestBody SearchRequest searchRequest) {
        return searchService.searchKeyword(searchRequest.getKeyword());
    }

    @PostMapping("/{searchType}")
    public List<SearchResponse> search(@PathVariable("searchType") String type ,@RequestBody SearchRequest searchRequest) {
        return searchService.searchKeywordByType(searchRequest.getKeyword(),type);
    }
}
