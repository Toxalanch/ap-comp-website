FROM alpine:latest
RUN apk update
RUN apk add openjdk11
ENV JAVA_HOME=/usr/lib/jvm/default-jvm
RUN adduser -D app
USER app
WORKDIR /home/app
ENV CLASS_NAME="null"
CMD ["java -version"]