package org.deborawendland.aggregator.controller;

import com.google.gson.Gson;
import org.deborawendland.aggregator.exceptions.EmptyFileException;
import org.deborawendland.aggregator.model.Test;
import org.deborawendland.aggregator.service.ReportService;
import org.deborawendland.aggregator.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private FileService fileService = new FileService();
    private ReportService reportService = new ReportService();
    private Gson gson = new Gson();


    private List<Test> allTests = new ArrayList<>();

    @PostMapping ("/upload")
    public ResponseEntity<String> uploadTestFile(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            throw new EmptyFileException("{message: \"Empty .csv file.\"}");
        } else {
            List<Test> inputTests = fileService.parseCSV(file);
            allTests.addAll(inputTests);
            return new ResponseEntity<>(gson.toJson(inputTests), HttpStatus.CREATED);
        }
    }

    @GetMapping("/report")
    public ResponseEntity<String> createReport() {
        return new ResponseEntity<>(gson.toJson(reportService.createReport(allTests).getReportByTestResult()),
                                    HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteTests() {
        if (allTests.isEmpty()) {
            return new ResponseEntity<>("{message: \"No previous tests result files were uploaded.\"}",
                                        HttpStatus.OK);
        } else {
            allTests.clear();
            return new ResponseEntity<>("{message: \"Previous submitted test result files deleted.\"}",
                                        HttpStatus.OK);
        }
    }

    // todo add healthcheck

}
