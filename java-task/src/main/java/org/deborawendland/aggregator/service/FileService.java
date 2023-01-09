package org.deborawendland.aggregator.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.deborawendland.aggregator.exceptions.CSVParsingException;
import org.deborawendland.aggregator.model.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

public class FileService {

    public List<Test> parseCSV (MultipartFile file){
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<Test> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Test.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();

        } catch (IOException e) {
            throw new CSVParsingException("Error parsing .csv file");
        }
    }
}
