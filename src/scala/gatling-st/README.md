## Run the Microservice
```bash
docker run diegopacheco/time-microservice
```
## Run Gatling Stress Test
```bash 
./gradlew gatlingRun-com.github.diegopacheco.gatling.microservices.st.StressTest -DGATLING_URL="http://172.17.0.2:8080"
```
