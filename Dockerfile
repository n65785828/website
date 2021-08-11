FROM openjdk:8u302-jre-slim-buster
WORKDIR /home/apps
ADD website-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 82
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]