# java-ee-advanced
Repository used for practice on advanced Java EE trainings.

<h2><b>lecture3</b></h2>

Implement two applications. The first one should consist of ejb-jar, war modules and be packaged in ear. It should have:
- component1 which implements two local interfaces: interface1 & interface2; 
- component2 which implements interface2, interface3;
- component3 in which component1 should be injected using interface2;
- component3 which should have reference on component2 using JNDI search for all possible names;
- component3 which should have reference on component1 via interface1 using <code>SessionContext</code> class;
- standalone component to store string representation of the system timezone retrieved from the environment;
- component3 which should have reference to standalone component to obtain timezone value

The result of all such requirements should be displayed on xhtml page located in war module in any form. <br>The second application should implement Glassfish embedded container and call first application. 

<h2><b>lecture4</b></h2>

Implement enterprice application which includes:
- data producer for <code>EntityManager</code>. <code>EntityManager</code> should be injected using such producer;
- car JPA entry with any fields and one mandatory field 'type' which could be either 'passcar' either 'truck';
- CDI component <code>CarService</code> which manages car entries from the database;
- data producer to create <code>PassCar</code> or <code>Truck</code> instances based on data retrieved from the database. Producer shoud have speciefic bean name, to be accessible from JSF pages;
- JSF page showing data about <code>PassCar</code> or <code>Truck</code> instances

Implement Java SE application using WELD. It should create <code>IStorage</code> interface and 4 implementations. It's required to store data of all implementations using <code>@Any</code>, <code>Instance\<T\></code>, <code>AnnotationLiteral\<T\></code>

<h2><b>lecture5</b></h2>

Create the TV store application. It should be implemented as online-shop with several web pages allowing navigation. It should have:
- at least one 'wizard' page backed by <code>@ConversationScoped</code> bean;
- main page with orders list;
- page(s) to pick the products;
- page to provide delivery address;
- page to confirm order

Logging should be implemented using EJB interceptors.
