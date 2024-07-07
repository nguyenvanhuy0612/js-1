gradlew cucumberTest --rerun-tasks

#### build

.\gradlew cucumberTestJar

#### run

java -jar .\build\libs\cucumber-automation-1.0-SNAPSHOT-cucumberTest.jar -g org.huy.stepdefinitions -p pretty src/test/resources/features
