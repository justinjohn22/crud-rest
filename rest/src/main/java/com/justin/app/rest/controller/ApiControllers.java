package com.justin.app.rest.controller;

import com.justin.app.rest.models.Issue;
import com.justin.app.rest.repo.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "update/{id}")
    public String updateIssue(@PathVariable long id, @RequestBody Issue issue) {
        Issue updatedIssue = issueRepo.findById(id).get();
        updatedIssue.setDescription(issue.getDescription());
        updatedIssue.setTitle(issue.getTitle());
        issueRepo.save(updatedIssue);
        return "updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteIssue(@PathVariable long id) {
        Issue deleteIssue = issueRepo.findById(id).get();
        issueRepo.delete(deleteIssue);
        return "deleted";
    }

}
