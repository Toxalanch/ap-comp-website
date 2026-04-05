FROM alpine:latest
WORKDIR /app
RUN apk add openjdk11
ENV CLASS_NAME="null"
CMD ["sh", "-c","timeout", "300s" "javac ${CLASS_NAME}.java && java ${CLASS_NAME}"]