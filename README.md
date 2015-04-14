spring-data-mongodb-mapping-indexes-test
========================================

This project is just to test a @Indexed under a some generics scenario that due to something it doesn't create the indexes appropriately.

To reproduce this error, just do a 'mvn test', this should run a mongodb server at a random free port (thanks to https://github.com/jirutka/embedmongo-spring), and run the test.
