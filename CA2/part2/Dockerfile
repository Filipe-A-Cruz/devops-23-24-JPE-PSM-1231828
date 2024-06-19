FROM tomcat:jdk17-openjdk

COPY build/libs/basic-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]