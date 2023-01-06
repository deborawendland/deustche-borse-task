import pandas as pd
import sys

import attributes

input_file = sys.argv[1]
output_file = sys.argv[2]

print ("reading file {file}".format(file=input_file))
data = pd.read_csv(input_file, header=None, index_col=0)

print ("aggregating results")
aggregator = data.groupby([attributes.TEST_CATEGORY_INDEX, attributes.TEST_RESULT_INDEX], sort=True) \
                .value_counts() \
                .reset_index() \
                .sort_values([attributes.TEST_CATEGORY_INDEX, attributes.TEST_RESULT_INDEX], ascending=True)

print ("writing output file {file}".format(file=output_file))
aggregator.to_csv(output_file, header=None, index=False)

print ("...success")