package com.mewebstudio.javaspringbootboilerplate.controller;

import com.mewebstudio.javaspringbootboilerplate.dto.response.PaginationResponse;
import com.mewebstudio.javaspringbootboilerplate.entity.Issue;
import com.mewebstudio.javaspringbootboilerplate.enums.IssueStatus;
import com.mewebstudio.javaspringbootboilerplate.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController extends AbstractBaseController {



    @Autowired
    private final IssueService issueService;

    @GetMapping
    public ResponseEntity<PaginationResponse> getAllIssues(@RequestParam Map<String,String> searchQuery) {

        return ResponseEntity.ok(issueService.getAll(searchQuery));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssue(@PathVariable String id) throws Exception {
        return ResponseEntity.ok(issueService.getOne(Long.parseLong(id)));
    }

    @PostMapping
    public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) throws Exception {
        issue.setStatus(IssueStatus.OPEN);
        return ResponseEntity.ok(issueService.create(issue));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Issue> updateIssue(@PathVariable String id, @RequestBody Issue issue) throws Exception {
        return ResponseEntity.ok(issueService.update(Long.parseLong(id),issue));
    }

    @GetMapping("/paginate")
    public List<Issue> getIssuesWithPaging(@RequestParam(defaultValue = "0") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize){

        return issueService.getIssuesByPagination(pageNo,pageSize, Sort.by("title"));

    }
}
