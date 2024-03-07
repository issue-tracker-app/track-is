package com.mewebstudio.javaspringbootboilerplate.repository;

import com.mewebstudio.javaspringbootboilerplate.entity.Issue;
import com.mewebstudio.javaspringbootboilerplate.enums.IssueStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IssueRepository extends PagingAndSortingRepository<Issue, Long> {
    List<Issue> findByStatus(IssueStatus status, Sort by);

    Page<Issue> findByStatus(IssueStatus status, PageRequest pageRequest);

    Optional<Issue> findById(Long id);

    Issue save(Issue issue);
}
