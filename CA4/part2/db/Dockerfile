FROM ubuntu

RUN apt-get update -y
RUN apt-get install -y openjdk-17-jdk-headless
RUN apt-get install unzip -y

RUN apt-get install wget -y

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app/

RUN wget https://repo1.maven.org/maven2/com/h2database/h2/1.4.200/h2-1.4.200.jar

CMD java -cp ./h2-1.4.200.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpAllowOthers -ifNotExists

EXPOSE 8082
EXPOSE 9092
