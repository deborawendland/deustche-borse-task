package org.deborawendland.aggregator.service;

import org.deborawendland.aggregator.exceptions.NoTestFileException;
import org.deborawendland.aggregator.model.Report;
import org.deborawendland.aggregator.model.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ReportService {

    public Report createReport(List<Test> tests) {
        if (tests.isEmpty()) {
            throw new NoTestFileException();
        } else {
            return new Report(tests.stream()
                              .collect(Collectors.groupingBy(Test::getCategory,
                                       Collectors.groupingBy(Test::getResult, Collectors.counting()))),
                              tests);
        }
    }
}
