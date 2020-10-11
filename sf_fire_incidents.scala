wget https://data.sfgov.org/api/views/wr8u-xric/rows.csv?accessType=DOWNLOAD -O sf_fire_incidents.csv


val sampleDF = spark
.read
.option("samplingRatio", 0.001)
.option("header", true)
.csv("""sf_fire_incidents.csv""")


fireDF.write.format("parquet").save("parquet_output")
