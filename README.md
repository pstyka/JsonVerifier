# JsonVerifier

JsonVerifier is a Java program that is able to validate JSON files representing AWS IAM role policies.
It checks if the "Resource" field in "Statement" objects does not contain just an asterisk (*).

##Config

To set up the project, user needs to clone this repository by typing in local terminal: 
git clone https://github.com/pstyka/JsonVerifier
then
cd [directory]

##Run the program

To run the program type:
mvn exec:java -D"exec.mainClass"="org.example.JsonVerifier" -D"exec.args"="src/main/resources/valid.json"

To run the tests:
mvn test


