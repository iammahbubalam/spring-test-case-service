package com.mahbubalam.springtestcaseservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(TestCaseKey.class)
public class TestCase {

    @Id
    private Long testCaseId;

    @Id
    @Column(name = "problem_id", nullable = false)
    private Long problemId;

    @Column(name = "test_case", columnDefinition = "json")
    private String testCase;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    // Constructors, getters, and setters
}

