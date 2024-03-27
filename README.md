# Open Source Kafka Startup Guide for Windows

This guide will walk you through the steps to set up and run Apache Kafka, an open-source distributed event streaming platform, on your local machine. Follow the steps below to get started with Kafka.

## Steps to Setup

**1. Download and Install Kafka**

Visit the Apache [Kafka download page](https://kafka.apache.org/downloads) to download the latest version of Kafka and extract it

**2. Start the Kafka Environment**

#### Start the ZooKeeper service

Open a terminal and navigate to the Kafka directory and start the ZooKeeper service:
```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
#### Start the Kafka broker service

In a new terminal window, start the Kafka server:
```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
**3. Create a Topic to Store Your Events**

To create a topic, open a new command prompt and navigate to the Kafka directory and run the following command:
```bash
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic <topic-name> --partitions 5 --replication-factor 1

```

**4. List All Topics**

To list all topics, run the following command:
```bash
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
```

**5. Describe a Topic**

To describe a specific topic, run the following command:
```bash
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic <topic-name>
```

**6. Write Events into the Topic**

To write events into the topic, use the Kafka console producer. Open a new command prompt and run the following command:
```bash
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic <topic-name>
```

**7. Read the Events**

To read the events from the topic, use the Kafka console consumer. Open a new command prompt and run the following command:
```bash
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <topic-name> --from-beginning
```
## Kafka Terminologies

**1. Kafka Cluster:** Since Kafka is a distributed system, it act as a cluster. A kafka cluster consists of a set of brokers. A cluster has a minimum of 3 brokers.

**2. Kafka Broker:** The broker is the Kafka server. It's just a meaningful name given to the Kafka server. And this name makes sense as well because all that Kafka does is act as a message broker between producer and consumer.
The producer and consumer don't interact directly. They use Kafka server as an agent or a broker to exchange messages.

*Producer ---->  Kafka Broker ----> Consumer*

**3. Producer:** Producer is an application that sends messages. It does not send messages directly to the recipient. It sends messages only to the Kafka server

**4. Consumer:** Consumer is an application that reads mesages from the Kafka server. Any application that requests data from a Kafka server is a consumer, and they can ask for data send by any producer provided they have permissions to read it.

**5. Kafka Topic:** Topic is like a table in database or folder in a file system. Topic is identified as name. You can have any number of topics. Topic is like a category that categories the message in a Kafka broker.

**6. Kafka Partitions:** Kafka topics are divided into a number of partitions, which contain records in an unchangeable sequence. Kafka Brokers will store messages for a topic. But the capacity of data can be enormous and it may not be possible to store in a single computer. Therefore it will partitioned into multiple parts and distributed among multiple computers, since Kafka is a distributed system.

**7. Offsets:** Offset is a sequence of ids given to messages as the arrive at a partition. Once the offset is assigned it will never be changed. The first message gets an offset zero. The next mesages receives an offset one and so on.

**8. Consumer Groups:** A consumer group contains one or more consumers working together to process the messages.
