Rest to ODATA(V2) converter
==========================================
This project is used for converting an existing rest api to odata(V2). It uses Apache Olingo
framework.

Rest client is generated from swagger content.It should be placed in sr/main/resources/ in the
project.

Maven plugin swagger-codegen-maven-plugin generates the necessary client code in target folder

To run:

$ mvn clean install
$ bin/start.sh

Start script will generate a docker image with tomcat and will include the .war file generated from
the code.

As an alternative, a local installation of a container can be used to deploy the .war file.

Once tomcat is started go to http://localhost:8080/rest-2-odata/

Assume there is a DimLocation resource, you can  visit http://localhost:8080/rest-2-odata/MyFormula.svc/DimLocation?$format=application/json
this will fetch data from rest and put them into olingo.

Notes
=====
- Only a hypotetical DimLocation is coded as a sample.
- On each call to olingo, CXF interceptor will invoke service to remove in-memory data and fill again
according to rest call responses. While filling, in memory datastore is used directly.
- To add new resource following should be done for each ;
    * Implement the model (Ex: Address)
    * Implement the service (Ex: AddressService)

The source is based on tutorial at https://olingo.apache.org/doc/odata2/tutorials/AnnotationProcessorExtension.html

