import pandas as pd

category_index = 1
test_index = 2

folder_path = "data"
input_file = "{path}/file-test.csv".format(path=folder_path)
output_file = "{path}/python-output-aggregator.csv".format(path=folder_path)

data = pd.read_csv(input_file, header=None, index_col=0)

aggregator = data.groupby([category_index, test_index], sort=True).value_counts()
aggregator.to_csv(output_file, header=None)
report = ""

for tuple in aggregator.keys():
    if tuple[0] not in report:
        report = "{report}\n{category}: ".format(report=report, category=tuple[0])
    else:
        report = "{report}, ".format(report=report)
    report = "{report} {count} {test}".format(report=report, count=str(aggregator[tuple]), test=tuple[1])

print (report)