
# v1
#FROM gradle
#WORKDIR /app
#COPY . .
#CMD gradle runServer
#EXPOSE 1337

# v2
FROM gradle
WORKDIR /app
COPY build/libs/part1-0.1.0.jar .
CMD java -cp part1-0.1.0.jar basic_demo.ChatServerApp 1337
EXPOSE 1337
