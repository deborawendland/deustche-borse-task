package org.deborawendland.aggregator.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.deborawendland.aggregator.model.Test;
import org.deborawendland.aggregator.service.AggregatorService;
import org.deborawendland.aggregator.service.TestFileService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UploadController {
    // todo rename methods and paths

    private TestFileService testFileService = new TestFileService();
    private List<Test> tests = new ArrayList<Test>();
    private AggregatorService aggregatorService = new AggregatorService();

    @GetMapping("/")
    public String index() {
        return "redirect:upload";
    }

    @PostMapping ("/upload")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file){

        if (file.isEmpty()){
            return "file empty";
        } else {
            tests.addAll(testFileService.parseCSV(file));
        }
        return tests.toString(); // todo return status & message
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}
