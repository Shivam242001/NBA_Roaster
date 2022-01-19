run: compile
	java FrontendDeveloper ./BasketballStats.csv

compile: FrontendDeveloper.java Backend.java PlayerStatsReader.java Player.java
	javac FrontendDeveloper.java

test: testData testBackend testFrontend compile
	java -jar junit5.jar -cp . --scan-classpath

testFrontend: TestFrontend.java
	javac -cp .:junit5.jar TestFrontend.java

testBackend: BackEndDeveloperTests.java
	javac -cp .:junit5.jar BackEndDeveloperTests.java

testData: TestDataWrangler.java
	javac -cp .:junit5.jar TestDataWrangler.java

clean:
	rm *.class
