package com.justin.app.rest.repo;

import com.justin.app.rest.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepo extends JpaRepository<Issue, Long> {


}
