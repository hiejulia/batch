# batch
Batch data 


## Stack 
+ Spring batch 
+ MySQL 
+ Scheduling 
+ Database : Cassandra - PostgreSQL - MySQL 

+ ElasticSearch instance 
+ Kibana 




## Feature 
+ Read - Process - Write data in batches 
    + Cassandra 
        + 2 jobs 
            + Read CSV file - import to Cassandra 
            + Perform 2 join CSV file - order by join column 
+ Transform and save CSV data file - and write to MySQL database 
+ Transaction 
+ Write file XML config 
+ Scheduling 
+ 2 spring batch jobs : 
    + Job1 : read CSV file - import data to Cassandra 
    + Job2 : join between 2 CSV files - the csv files are ordered by the join column
+ Back up job : with Quazt scheduling 
+ Transaction Spring batch - and job state
+ Scalability : distributed batch processing  
+ Transfer file through SFTP



---
+ Feature 2 : 
    + Read data from database - MySQL database 
    + Process data in ItemProcess 
    + Save the out put  in CSV/ XML file 
    + Scheduled job run 10s 
    + 

--------- 



  


