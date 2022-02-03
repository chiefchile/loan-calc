# Loan Calculator

[https://alex-loan-calc.herokuapp.com/](https://alex-loan-calc.herokuapp.com/)

### Building the app
Prerequisites: JDK 8, Maven
1. Execute the following commands on your shell
```
mkdir loan-calc
cd loan-calc
git clone https://github.com/chiefchile/loan-calc .
mvn install
```

### Running the app
1. Build the app (see above)
2. Execute the following commands on the app's root directory
```
cd target
java -jar loan-calculator-1.0.0.jar
```
3. Open localhost:8080 in your browser


### Running the app on a Docker container
Prerequisites: Docker
1. Build the app (see above)
2. Execute the following commands on the app's root directory
```
docker build -t hoegh/loan-calc .
docker run -p 8080:8080 hoegh/loan-calc
```
3. Open localhost:8080 in your browser