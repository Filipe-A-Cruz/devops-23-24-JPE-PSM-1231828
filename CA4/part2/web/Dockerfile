FROM ubuntu

RUN apt-get update -y
RUN apt-get install -y openjdk-17-jdk-headless
RUN apt-get install unzip -y

RUN apt-get install git -y
RUN apt-get install nodejs -y
RUN apt-get install npm -y

RUN mkdir -p /tmp/build

WORKDIR /tmp/build/

RUN git clone https://github.com/Filipe-A-Cruz/devops-23-24-JPE-PSM-1231828.git
WORKDIR /tmp/build/devops-23-24-JPE-PSM-1231828/CA2/part2
RUN rm -r node_modules
RUN npm install
RUN chmod u+x gradlew
RUN ./gradlew clean build

CMD java -jar build/libs/basic-0.0.1-SNAPSHOT.war

EXPOSE 8080
