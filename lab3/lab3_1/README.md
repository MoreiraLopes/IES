# Lab 3.1 Notes

### The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?
In the "UserController" class, the "userRepository" is instantiated through its constructor. When an instance of the "UserController" is created, a "UserRepository" instance is injected into it. This injection is likely managed by a Spring framework component, like Spring's dependency injection, which instantiates the "UserRepository" and provides it to the "UserController" when needed.

### List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?

* *findAll()* - returns all entities
* *findById()* - returns a certain entity specified by id
* *save()* - saves an entity
* *delete()* - deletes an entity

The *QuoteRepository* is an extension of the class *CrudRepository*, which means that it will inherit it's methods and constructors. Thus, the used methods come from it's super class.

### Where is the data being saved?
The data is being saved inside the userRepository object.

### Where is the rule for the “not empty” email address defined?
It's defined in the *User.java* class file:
```
@NotBlank(message = "Email is mandatory")
    private String email;
```