package com.justin.app.rest.controller;

import com.justin.app.rest.models.Issue;
import com.justin.app.rest.repo.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private IssueRepo issueRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/issues")
    public List<Issue> getIssues() {
        return issueRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String  saveIssue(@RequestBody Issue issue) {
        issueRepo.save(issue);
        return "saved... ";
    }

}
