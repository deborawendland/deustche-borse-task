package org.deborawendland.aggregator.model;

import java.util.List;
import java.util.Map;

public class Report {

    private Map<String, Map<String, Long>> reportByTestResult;
    private List<Test> tests;

    public Report(Map<String, Map<String, Long>> reportByTestResult, List<Test> tests) {
        this.reportByTestResult = reportByTestResult;
        this.tests = tests;
    }

    public Map<String, Map<String, Long>> getReportByTestResult() {
        return reportByTestResult;
    }

    public void setReportByTestResult(Map<String, Map<String, Long>> reportByTestResult) {
        this.reportByTestResult = reportByTestResult;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
