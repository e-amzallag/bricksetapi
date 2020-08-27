# Java Brickset API

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.dajlab/bricksetapi/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.dajlab/bricksetapi)

Java API for Brickset webservices API v3.

See https://brickset.com/tools/webservices/v3 for more information about the official Brickset API

Support all methods (version 1.01, 20 July 2020):
* General
* Sets
* Set collection management
* Minifig collection management

## Basic cases

Create an instance:

```java
IBricksetService service = new BricksetServiceImpl("myApiKey");
```

Retrieve the userhash if not already known and if needed:

```java
try {
	String userhash = service.login("mylogin", "mypwd");
	// You may check the userhash
	service.checkUserHash(userhash);
	.
	.
	.
} catch (BricksetException e) {
	System.err.println(e.getCodeMessage() + ": " + e.getMessage());
}

```

Looking for a particular set:

```java
SetParameters params = new SetParameters();
// Look for set number 60132
params.addSetNumber("60132-1");
List<Set> sets = service.getSets(params);
if (!sets.isEmpty()) {
	Set set = sets.get(0);
} 
```

Using different criterias to query:

```java
SetParameters params = new SetParameters();
// Look for all the sets in themes Architecture and Classic, year 2020, ordered by number of pieces desc.
params.addTheme("Architecture").addTheme("Classic").addYear("2020").setOrderBy(OrderByEnum.PiecesDESC);
List<Set> sets = service.getSets(params);
```


Check IBricksetService to see the full list of methods, including collection management.

## Unit tests

To run the tests, you need to create a parameters.properties in test resources with the following properties :

    apikey=
    userhash=
    login=
    password=
    
Caution, CollectionManagement tests may alter your Brickset collection. Check what you are doing before!