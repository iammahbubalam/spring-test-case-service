package com.mahbubalam.springtestcaseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseKey implements Serializable {
    private Long testCaseId;
    private Long problemId;
}
