#!/bin/bash


while getopts e:o:b: option
do
 case "${option}"
 in
 e) ENVIRONMENT=${OPTARG};;
 o) OPTIONS=${OPTARG};;
 b) BUILD_NUMBER=${OPTARG};;
 t) TESTING_TYPE=${OPTARG};;
 esac
done


echo "env=${ENVIRONMENT}"
echo "options=${OPTIONS}"
echo "build_number=${BUILD_NUMBER}"

if [ -z "$ENVIRONMENT" ]
then
      echo "\$ENVIRONMENT is empty"
      echo "Please use this format: ${0} -e dev1 -o \"--tags @WebShop\""
      exit -1
fi

# execute docker
docker run -d --name=grid-${BUILD_NUMBER} -p 24444 -p 25900 -e TZ="Europe/Berlin" --shm-size=1g elgalu/selenium
# wait to all is booted up
docker exec grid-${BUILD_NUMBER} wait_all_done 30s

DOCKER_PORT=`docker port grid-${BUILD_NUMBER} 24444`
echo "docker_port = ${DOCKER_PORT}"

# execute tests
mvn clean test -Denv=$ENVIRONMENT -Dcucumber.options="${OPTIONS} --tags ~@Deprecated" -Dremote=http://${DOCKER_PORT}/wd/hub || true
#stop docker container
docker exec grid-${BUILD_NUMBER} stop
docker stop grid-${BUILD_NUMBER}
docker rm -vf grid-${BUILD_NUMBER}
