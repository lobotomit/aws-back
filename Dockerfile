FROM  tomcat:9-jdk8
MAINTAINER Eduardo Reyes <eduardo_reyes@stratesys-ts.com>

RUN rm -rf /usr/local/tomcat/webapps/ROOT

COPY  ./target/ROOT.war      /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]