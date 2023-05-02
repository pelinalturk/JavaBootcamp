<details>
  <summary>Homework1</summary>

# Design Patterns

## Mediator Design Pattern
###  Message Dispatching System
This project is an implementation of the Mediator pattern with a simple message dispatching system.

- **User**: The User interface defines two methods: send and receive. The send method is used to send a message, while the receive method is used to receive a message.
- **OnSiteStudent**: The OnSiteStudent class represents a student who is physically present in the class. This class implements the User interface and defines the behavior of a user in the messaging system.
- **RemoteStudent**: The RemoteStudent class represents a student who is attending the class remotely. This class also implements the User interface and defines the behavior of a user in the messaging system.
- **Dispatcher**: The Dispatcher interface defines the methods that the mediator object must implement to be able to control communication between the users. The sendMessage method is used to send messages to users, while the addUser method is used to add a new user to the messaging system.
- **DispatcherMediator**: The DispatcherMediator class is the mediator object that controls communication between the users. It implements the Dispatcher interface and maintains a list of all users in the messaging system. The sendMessage method of this class sends a message to all users in the system except for the sender of the message.

### Usage
To use this messaging system, create an instance of the DispatcherMediator class. Then, create instances of the OnSiteStudent and RemoteStudent classes and pass them to the addUser method of the DispatcherMediator object. The OnSiteStudent and RemoteStudent classes represent the users of the messaging system. To send a message, call the send method on a user object, passing in the message as an argument. The message will be sent to all users in the messaging system except for the sender. The receive method of the user object is called when a message is received.
**Here is an example**:

```java
DispatcherMediator dispatcherMediator = new DispatcherMediator();

User onSiteStudentA = new OnSiteStudent("On-site Student A", dispatcherMediator);
User onSiteStudentB = new OnSiteStudent("On-site Student B", dispatcherMediator);
User remoteStudentA = new RemoteStudent("Remote Student A", dispatcherMediator);
User remoteStudentB = new RemoteStudent("Remote Student B", dispatcherMediator);

dispatcherMediator.addUser(onSiteStudentA);
dispatcherMediator.addUser(onSiteStudentB);
dispatcherMediator.addUser(remoteStudentA);
dispatcherMediator.addUser(remoteStudentB);

onSiteStudentA.send("Hi remote, how is going?");
remoteStudentA.send("Hi, great. I have lots of things to do, how about you?");
onSiteStudentB.send("It similar");
```

**The above code will output**:

```java
On-site Student A sends: Hi remote, how is going?
On-site Student B received : Hi remote, how is going?
Remote Student A received : Hi remote, how is going?
Remote Student B received : Hi remote, how is going?
Remote Student A send : Hi, great. I have lots of things to do, how about you?
On-site Student A received : Hi, great. I have lots of things to do, how about you?
On-site Student B received : Hi, great. I have lots of things to do, how about you?
Remote Student B received : Hi, great. I have lots of things to do, how about you?
On-site Student B sends: It similar
On-site Student A received : It similar
Remote Student A received : It similar
Remote Student B received : It similar
```

### Class Diagram
![mediator](https://user-images.githubusercontent.com/80326351/234931586-5e1468ca-9b24-46ce-93ce-d078745f8bc1.png)

## State Design Pattern
### User Filter
This Java project provides functionality for filtering a list of users by either their name or age. The project consists of the following classes:

- **User**: a class representing a user with a name and an age
- **State**: an interface defining the filter method and getStatus method
- **FilterByAge**: a class implementing the State interface and filtering users by their age
- **FilterByName**: a class implementing the State interface and filtering users by their name
- **Context**: a class defining the state and providing a method for filtering users

### Usage
To use the User Filter, you can create a list of users and use the Context class to filter them by name or age.
**Here is an example**:

```java
List<User> users = new ArrayList<>();
users.add(new User("Alice", 25));
users.add(new User("Bob", 30));
users.add(new User("Charlie", 25));

Context context = new Context();
context.setState(new FilterByName());
context.filterUsers(users, "Bob"); 
```
**The above code will output**:
```java
Filtered users by name:
User{name='Bob', age=30}
```

Similarly, you can filter the list of users by age:
```java
context.setState(new FilterByAge());
context.filterUsers(users, "25");
```
**The above code will output**:
```java
Filtered users by age:
User{name='Alice', age=25}
User{name='Charlie', age=25}
```
### Class Diagram
![state](https://user-images.githubusercontent.com/80326351/234932243-961cf4a2-5a8c-4bf2-9213-166fde74a598.png)


## Observer Design Pattern
### News Agency Subscription System
This Java project demonstrates the Observer pattern, which defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

- **Subscribe**: This interface defines a method for sending notifications.
- **EmailSubscribe**: This class implements the Subscribe interface and sends notifications via email.
- **SmsSubscribe**: This class implements the Subscribe interface and sends notifications via SMS.
- **Observer**: This interface defines methods for subscribing, unsubscribing, and sending notifications.
- **NewsAgency**: This class implements the Observer interface and keeps track of all the subscribers. It sends notifications to all subscribers when a news item is available.

### Usage
To use this project, you can create an instance of the NewsAgency class and then add subscribers using the subscribe method. You can remove subscribers using the unSubscribe method. To send notifications to all subscribers, use the sendNotifications method.
**Here is an example**:

```java
// Create a news agency
NewsAgency newsAgency = new NewsAgency();

// Create subscribers
Subscribe emailSubscribe = new EmailSubscribe("John");
Subscribe smsSubscribe = new SmsSubscribe("Jane");

// Subscribe to news agency
newsAgency.subscribe(emailSubscribe);
newsAgency.subscribe(smsSubscribe);

// Send notifications to subscribers
newsAgency.sendNotifications();

// Unsubscribe from news agency
newsAgency.unSubscribe(emailSubscribe);

// Send notifications to remaining subscribers
newsAgency.sendNotifications();
```
**The above code will output**:
```java
John received an SMS from the news agency.
Jane received an email from the news agency.

Jane received an email from the news agency.
```

### Class Diagram
![observer](https://user-images.githubusercontent.com/80326351/234931996-53922858-3b62-455a-a68c-f3226f033c46.png)

## Proxy Design Pattern
### Bank Account Debit System
This project demonstrates the use of the proxy design pattern to implement a debit system for a bank account.

- **BankAccount**: This interface declares the debit() method that is implemented by the SavingAccount and DebitCardProxy classes.
- **SavingAccount**: This class implements the BankAccount interface and contains the account balance as an integer. It also has a validate() method that checks if the balance is enough to withdraw 5 TL. The debit() method of this class withdraws 5 TL from the account balance if it is valid, otherwise it prints a message that there is not enough balance.
- **DebitCardProxy**:This class implements the BankAccount interface and acts as a proxy for a SavingAccount instance. Its debit() method calls the debit() method of the SavingAccount instance passed in the constructor.

### Usage
To use the debit system, create an instance of the SavingAccount class with an initial balance, and then create an instance of the DebitCardProxy class with the SavingAccount instance as a parameter. Finally, call the debit() method on the DebitCardProxy instance to withdraw 5 TL from the account balance.
**Here is an example**:
```java
BankAccount bankAccount = new DebitCardProxy(new SavingAccount(50));
bankAccount.debit();
```
**The above code will output**:
```java
5 TL withdrawn from SavingAccount
```

### Class Diagram
![proxy](https://user-images.githubusercontent.com/80326351/234932506-6bbec96c-e98e-4f1a-ad86-67db8b95277b.png)

## Strategy Design Pattern
### Shopping Cart Payment System
This project is a simple implementation of a shopping cart that allows users to add and remove items, calculate the total amount, and pay using different payment strategies.

- **Item**: The Item class represents a product that can be added to the shopping cart. It has two attributes: upcCode (a unique identifier for the product) and price (the price of the product). It has a constructor that takes these two attributes and a toString method that returns a string representation of the object.
- **PaymentStrategy**:The PaymentStrategy interface represents the payment strategy that will be used to pay for the items in the shopping cart. It has a single method pay that takes the total amount to be paid as an argument.
- **CreditCardStrategy**:The CreditCardStrategy class is an implementation of the PaymentStrategy interface that represents paying with a credit card. It has four attributes: name (the name of the cardholder), cardNumber (the card number), cvv (the security code on the back of the card), and dateOfExpiry (the expiration date of the card). It has a constructor that takes these four attributes and an implementation of the pay method that prints a message to the console indicating that the payment was made with a credit card.
- **PaypalStrategy**:The PaypalStrategy class is another implementation of the PaymentStrategy interface that represents paying with Paypal. It has two attributes: emailId (the email address associated with the Paypal account) and password (the password for the Paypal account). It has a constructor that takes these two attributes and an implementation of the pay method that prints a message to the console indicating that the payment was made with Paypal.
- **ShoppingCart**:The ShoppingCart class represents the shopping cart. It has a list of Item objects, and methods for adding and removing items from the cart, calculating the total amount of the items in the cart, and paying for the items using a payment strategy.

### Usage
To use this project, simply create instances of the Item class and add them to an instance of the ShoppingCart class. To pay for the items in the cart, create an instance of the CreditCardStrategy or PaypalStrategy class (depending on which payment method you want to use) and pass it to the pay method of the ShoppingCart class.

**Here is an example**:
```java
 Item item1 = new Item("upcCode001", 250);
Item item2 = new Item("upcCode002", 150);
Item item3 = new Item("upcCode003", 100);

ShoppingCart cart = new ShoppingCart();
cart.addItem(item1);
cart.addItem(item2);
cart.addItem(item3);

cart.pay(new CreditCardStrategy("Pelin","1234567891234567", "123","09/28"));

cart.removeItem(item3);
cart.pay(new PaypalStrategy("myemail@gmail.com", "mysecretpassword"));
```
**The above code will output**:
```java
item added: Item{upCode='upcCode001', price=250}
item added: Item{upCode='upcCode002', price=150}
item added: Item{upCode='upcCode003', price=100}
Paid with Credit Card: 500
item deleted: Item{upCode='upcCode003', price=100}
paid with paypal: 400
```
### Class Diagram
![strategy](https://user-images.githubusercontent.com/80326351/234932662-73861195-a97a-4e41-b621-4e4bf8b5a22f.png)

</details>

<details>
<summary>Homework2</summary>

# Book Management System
This is a simple Book Management System which allows to manage books and authors information. The system uses a RESTful API to communicate between the server and the client. The server side of this system is built with Spring Boot and MongoDB.

**Technologies**
- Java 11
- Spring Boot
- Spring Data MongoDB
- MapStruct
- Lombok
- Docker

### API Endpoints
#### Authors
* **Get all authors**

```bash
GET /authors
```
Returns a list of all authors.

* **Create an author**
```bash
POST /authors
```
Creates a new author with the given name.

* **Get a single author**
```bash
GET /authors/{id}
```
Returns the author with the given ID.

* **Update an author**
```bash
PUT /authors/{id}
```
Updates the name of the author with the given ID.

* **Delete an author**
```bash
DELETE /authors/{id}
```
Deletes the author with the given ID and all of their associated books.

#### Books
* **Get all books**
```bash
GET /books
```
Returns a list of all books.

* **Create a book**
```bash
POST /books
```
Creates a new book with the given name, release year, and author ID.

* **Get books by author**
```bash
GET /books?authorId={authorId}
```
Returns a list of all books written by the author with the given ID.

* **Get a single book**
```bash
GET /books/{id}
```
Returns the book with the given ID.

* **Update a book's name and release year**
```bash
PUT /books/{id}
```
Updates the name and release year of the book with the given ID.

* **Delete a book**
```bash
DELETE /books/{id}
```
Deletes the book with the given ID.

</details>