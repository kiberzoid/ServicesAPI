## API for sending notification by sms, push or email
##### Components: 
- discovery-service (port: 8761)
- gateway-service (port: 9095)
- email-service (port: 9092)
- sms-service (port: 9091)
- push-service (port: 9093)

Logs are stored in /opt/services/log/
##### Build & Run:
```
./mvnw clean package -DskipTests
docker-compose up
```
##### Endpoints: 
Send push notification:
- ``http://{DOCKER_IP}:9095/api/push/message``
- header ``Content-Type: application/json``
- method ``POST``
- body
```
{
    "title": "TOP NEWS",
    "body": "Military unit that conducts drone strikes bought location data from ordinary apps",
    "destination": ["ID-TOKEN-4758847784", "ID-TOKEN-1328749635", "ID-TOKEN-1328749635"]
}
```
- request's result is an entry in the log file like 
```
Push Message{title=TOP NEWS, body=Military unit that conducts drone strikes bought location data from ordinary apps, destination=[ID-TOKEN-4758847784, ID-TOKEN-1328749635]} was sent
```

Send sms notification:
- ``http://{DOCKER_IP}:9095/api/sms/message``
- header ``Content-Type: application/json``
- method ``POST``
- body
```
{
    "text": "Balance notification",
    "destination": ["79202909898", "79202909890", "79202909898"]
}
```
- request's result is an entry in the log file like 
```
SMS Message{destination=[79202909890, 79202909898], text=Balance notification} was sent
```

Send email notification:
- ``http://{DOCKER_IP}:9095/api/email/message``
- header ``Content-Type: multipart/form-data``
- method ``POST``
- message's parts
```
1.
    name = msg(required), json file describing your message like
    {
        "from": "source@gmail.ru",
        "destination": ["dest1@gmail.ru","dest2@gmail.ru", "dest3@gmail.ru"],
        "subject": "Software Updates",
        "text": "How to manually update an app on your device"
    }
2.
    name = attachment(optional), attachment for your message, max size of file 2MB(for request - 5MB)

```
- request's result is an entry in the log file like
```
Email Message{from=source@gmail.ru, destination=[dest2@gmail.ru, dest1@gmail.ru, dest3@gmail.ru], subject=Software Updates, text=How to manually update an app on your device} was sent
```