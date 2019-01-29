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
+ Apache Kafka : stream processing 
+ Apache zookeeper - for Apache kafka processing 



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
    
+ Feature 3 : 
    + CSV file processing sent to Apache Kafka producer for further processing  
    
+ Feature 4 : (ELK folder)
    + Transfer large data from rational database to NoSQL(Elasticsearch) for index search 
    + Elasticsearch logstash - kibana 
    + Elasticsearch - Mongodb - document store 
    + Import relational database with spring batch 
    + Spring data elasticsearch 
    + import index from elasticsearch to kibana 
    + Elasticsearch and Kibana instance 
    + 
    
    
    

--------- 



Setting up Apache Kafka
  # Start Zookeeper instance 
  $ zookeeper-server-start.bat ..\..\config\zookeeper.properties
  
  # Start Kafka server
  $ kafka-server-start.bat ..\..\config\server.properties
  
  # Create a topic
  $ kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic CSV_TOPIC_K
  

port = 9092
advertised.host.name = localhost 


## Cassandra 

+ Install Cassandra 
+ Start cassandra  


----- 


