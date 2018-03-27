loki = id de la tache
1) c)
curl -i -d  "nom=tache 2&description=dev JAX" http://localhost:8080/tasks



tache 2:

HTTP/1.1 200 OK
content-type: application/json; charset=utf-8
cache-control: no-cache
content-length: 109
accept-ranges: bytes
Date: Fri, 09 Mar 2018 07:31:53 GMT
Connection: keep-alive


tache 1:

HTTP/1.1 200 OK
content-type: application/json; charset=utf-8
cache-control: no-cache
content-length: 113
accept-ranges: bytes
Date: Fri, 09 Mar 2018 07:32:28 GMT
Connection: keep-alive


   d)

curl -i http://localhost:8080/tasks
curl -i http://localhost:8080/tasks/2

   e) 

curl -i -X PUT -d "description=recenser URI"  http://localhost:8080/tasks/2


   g) 

curl -i -X DELETE http://localhost:8080/tasks/1

