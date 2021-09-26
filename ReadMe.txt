How to Run Test from Command Line ?

1. Open the command prompt and cd until the project root directory

2. Since it's a Maven project and we have added Cucumber in test scope dependency and all features are also added in
   src/test packages, run the following command in the command prompt: mvn clean test

3. Test will get triggered and Build Success Output should get displayed.

4. Cucumber reports will be generated under following location:

    Cucumber Html Reports will be generated under:

    Project_Root_Dir\target\cucumber-reports.html

    Cucumber json and xml reports will be generated under:

    Project_Root_Dir\cucumber-reports\Cucumber.json
    Project_Root_Dir\cucumber-reports\Cucumber.xml
