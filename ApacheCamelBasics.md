1. Apache Camel is in open source integration framework that enable us to quickly and easily integrate
    the various system consuming and producing data.
2. Apache Camel is open source integration framework based on Enterprise Integration Patterns
3. Apache camel is the industry standard for reducing the boilerplate code for complex integrations -- while maintaining feature like
    Automatic error handling
    Redelivery policies
    The ability to handle complex aggregations

4. **EIP(Enterprise integration pattern)** --> 1. EIP is catalog of design pattern for developing the systems to integrate new and existing
            software in a business env.
           2. EIP provides 65 design patterns and include an icon-based pattern language sometimes called GregorGrams

5. EIP like --> Aggregator , splitter , wiretap(to see the message when sender send to receiver)

**Why Integration Patterns** ?
1.  Different Software has different formats
    JSON, XML, Protocol buffer
2. Point-to-point connection vs Hub vs Spoke
   Point-to-point : expensive
   Hub and spoke : Each new endpoint simply requires a gateway to transform it to canonical model
3. Types
4. Frameworks

**EIP Types -**
1. Messaging System
2. Messaging channels
3. Message Construction
4. Message Routing
5. Message Transformation
6. Message Endpoints
7. System Management


**Apache Camel components**

    Camel Core
    Camel Spring boot
    Camel K
    Camel Kafka Connector
    Camel Quarkus
    Camel Karaf

**Camel Exchange**

* A Camel exchange is the message container during routing. The Camel exchange hold a pattern property that can be either
    * InOnly - A one-way message(also known as a event message)
    * InOut - A request and response message
     [exchange image](https://github.com/arjun3037/apache-camel/blob/main/Exchange.png)
    * MEP - Message exchange pattern (InOnly , Inout)

**Processor**

**Route**
 * Java DSL

        from("file:data/inbox"")
           .to("jms:queue:order")
 * Spring DSL
  
       <route>
         <from urk = "file:/data/inbox" />
        <to uri = "jms:queue:order"/>
       </route>

**Endpoint** - The end of channel through which a system can send a receive messages
 * Consumer Endpoint = from()
 * Producer Endpoint = to()
 * Expressed as URI : direct://to-my-component

**Expression & Predicates**
 * WE can add some condition based on we can opt different routes. predicate can be filter

**Camel Context**
 * Camel Runtime system which keeps all piece together
 * Usually we have one Camel context in an app but we can have more then 1 camel contect but do communicattion is complex between them


**Threading Model**
* Apache Camel threading model based on JDK concurrency API : ExecutorService
* SEDA (Staged Event-Driven Architecture)
* Threads DSL(on route level we can define the threading : async processing , we can provide different threadpool for better performance)
* At some components level: JMS Jetty
  * Default Profile

          poolSize = 10
          maxPoolSize = 20
          maxQueueSize=1000
          allowCoreThreadTimeOut = true
          rejectedPolicy=CallerRuns
* Wiretap - sending a copy of message somewhere else
* Throttler - limit a number of messages to an endpoint
* Multicast - Same message to number of endPoints





                




