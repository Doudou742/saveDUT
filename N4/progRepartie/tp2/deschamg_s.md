geoffrey deschamps S

1.Découpage d'URI
A)
	1:  http://www.univ-lille1.fr/Accueil/Contacts/Services+étudiants/
       	    schema: http
       	    <host>: www.univ-lille1.fr
       	    <port>: 80
       	    <path>: Accueil/Contacts/Services+étudiants

	2:  https://tools.ietf.org/html/rfc3986
       	    schema: https
       	    <host>: toolls.ietf.org
       	    <port>: 80
       	    <path>: html/rfc3986


	3:  http://localhost:8080/users/1
	
            schema: http
            <host>: localhost
            <port>: 8080
            <path>: /users/1

	4: https://fr.wikipedia.org/wiki/Markdown#Titres
	
           schema: https
       	   <host>: fr.wikipedia.org
       	   <port>: 80
       	   <path>: wiki/Markdown
       	   <fragment>: Titres

        5: http://traduction.culturecommunication.gouv.fr/url/Result.aspx?to=en&url=http%3A%2F%2Fwww.culturecommunication.gouv.fr%2F
	
       	   schema: http
       	   <host>: traduction.culturecommunication.gouv.fr
       	   <port>: 80
       	   <path>: url/Result.aspx
       	   <query>: to=en&url=http%3A%2F%2Fwww.culturecommunication.gouv.fr%2F
       	   <fragment>:

B) url=http%3A%2F%2Fwww.culturecommunication.gouv.fr%2F donne url=http:/www.culturecommunication.gouv.fr/
   

2. Analyse requête http
A) 1:	   GET /code/ HTTP/1.1
   	   User-Agent: curl/7.38.
	   Host: graphql.org
	   Accept: */*

	   schema: http
	   <host>: graphql.org
       	   <port>: 80
       	   <path>: /code/
       	   <query>: 
       	   <fragment>:

	   =http://graphql.org/code/


   2:	   POST /post HTTP/1.1
   	   User-Agent: curl/7.38.0
	   Host: httpbin.org
	   Accept: */*
	   Content-Length: 17
	   Content-Type: application/x-www-form-urlencoded
	   foo=bar&toto=tutu
	   

	   schema: http
	   <host>: httpbin.org
       	   <port>: 80
       	   <path>: /post/
       	   <query>: foo=bar&toto=tutu
       	   <fragment>:

	   =http://httpbin.org/post?foo=bar&toto=tutu

	   
B)	   la méthode POST ou PUT a été utilisée
	   Permet d'ajouter une ressource sur le serveur. L'URI fourni est celui de la ressource en question.
	   L'effet sur le serveur est de créer des ressources

3) Gestion du cache
      	GET / HTTP/1.1
	Host : localhost

4)
A)
	curl -x cache.univ-lille1.fr:3128 -G --http1.1 -I  http://graphql.org/code/

	curl -x cache.univ-lille1.fr:3128 --http1.1  -v http://httpbin.org/post -d foo=bar&toto=tutu

B)

	curl -H 'if-None-Match:"12a0-56049ffc9a01f"' -I --head http://localhost

	HTTP/1.1 304 Not Modified
	Date: Fri, 23 Feb 2018 08:57:07 GMT
	Server: Apache/2.4.25 (Debian)
	ETag: "12a0-56049ffc9a01f"


C)	curl -l http://www.univ-lille1.fr


