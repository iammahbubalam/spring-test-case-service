package com.mahbubalam.springtestcaseservice.repository;

import com.mahbubalam.springtestcaseservice.model.TestCase;
import com.mahbubalam.springtestcaseservice.model.TestCaseKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, TestCaseKey> {
}
