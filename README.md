# batch
Batch data 


## Stack 
+ Spring batch 
+ MySQL 
+ Scheduling 
+ Database : Cassandra - PostgreSQL - MySQL
    + Cassandra  

+ ElasticSearch instance 
+ Kibana 
+ Apache Kafka 



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

SpringBatch-KafkaDB Demo
What is it?
A small demo that leverages Spring batch's capabilities to do job processing and Apache Kafka's stream processing. A simple CSV file is used in a batch job which then writes it to a Kafka Producer for further processing. A Kafka consumer can then verify by consuming the messages from the correct topic.

image

Spring Batch pipeline
Below mentioned pipeline has been followed through out the codebase. The implementation is trivial once you modularize the responsibilities of each relevant class.

image

Prerequisites
Spring Boot + Batch + JPA
Apache Kafka
Apache Zookeeper
Expectation
Batch systems offer tremendous advantages as compared to interactive systems.

Repeated jobs are done fast in batch systems without user interaction.
You don’t need special hardware and system support to input data in batch systems.
Best for large organizations but small organizations can also benefit from it.
Expectation is to convert the following flat file into something meaningful when run as a batch process.

image

Such as a Kafka stream like this *
image

Or to a datastore like this *
image

Setting up Apache Kafka
  # Start Zookeeper instance 
  $ zookeeper-server-start.bat ..\..\config\zookeeper.properties
  
  # Start Kafka server
  $ kafka-server-start.bat ..\..\config\server.properties
  
  # Create a topic
  $ kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic CSV_TOPIC_K
  
Make sure following is appended to config\server.properties

port = 9092
advertised.host.name = localhost 
What are the list of branches
Branch	Description
master	Base branch that reads from CSV and processes them to a topic in a Kafka producer
batch-db-upload	Similar to master except that it deserializes the CSV to a H2 Database instead of Kafka

  


