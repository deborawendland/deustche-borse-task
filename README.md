## Python implementation

Application developed using Python 3.10.9.

Requirements:
- pandas==1.5.2
- to install the necessary requirements, run `python -m pip install -r python-task/requirements.txt`

Run:
- to run the application use the following command: `python python-task/sample/main.py {input_file} {output_file}`
- example: `python python-task/sample/main.py data/file-test.csv data/python-output-aggregator.csv`
- where:
    - data/file-test.csv is the input file
        - contains the dataset, which has the following attributes: test name, category and result.
        - the python-task/sample/attributes.py file contains the relation between the attributes and the columns indexes.
    - data/python-output-aggregator.csv is the output file
        - contains the aggregation values of the input based on category and test results.
        - if the file already exists, it is overwritten.


## Java Implementation

Application developed using Java 8 and Gradle 7.5.1.

Run:
- access the `java-task` directory and run the following commands:
    - `gradle wrapper`
    - `./gradlew clean build`
    - `./gradlew bootRun`
- the application will be running on http://localhost:8080

Usage: 
- POST: `http://localhost:8080/upload`: 
    - the resquest body expects form-data file: data/file-test.csv
- GET: `http://localhost:8080/report`:
    - generate report with the aggregate files submitted previously
- GET: `http://localhost:8080/delete`: 
    - deletes all of the previous sent files
- GET: `http://localhost:8080/actuator/health`: 
    - health check