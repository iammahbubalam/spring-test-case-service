package com.mahbubalam.springtestcaseservice.service;


import com.mahbubalam.springtestcaseservice.model.TestCase;
import com.mahbubalam.springtestcaseservice.model.TestCaseKey;
import com.mahbubalam.springtestcaseservice.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;
    public TestCase saveTestCase(TestCase testCase){
        return testCaseRepository.save(testCase);
    }

    public Optional<TestCase> getTestCase(TestCaseKey id){
        return testCaseRepository.findById(id);
    }


}
