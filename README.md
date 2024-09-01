# socialMedia-restful-web-services
handson project with Spring boot

: swagger url - <i>http://localhost:8080/swagger-ui.html
</i>


<b><ul> Client side information:-</ul></b>

 <li>To receive response in json - 
 add key-value in Header Accept - application/json
 <li>To receive response in xml -
 add key-value in Header Accept - application/xml


<b><ul> Internationalization aka i18n (<i>uri - /hello-world-internationalized</i>):-</ul></b>
(<i>languages supported - dutch, french, deutsch and default english</i>)
 
<li>greeting in Dutch -
add key-value in Header Accept-Language - nl
 <li>greeting in French -
add key-value in Header Accept-Language - fr
 <li>greeting in Deutsch -
add key-value in Header Accept-Language - de
 <li>Default greeting is in English -
add key-value in Header Accept-Language - en or omit the header

<b><ul> Versioning:-</ul></b>
<li> URI - <i>/v1/person</i> ; <i>/v2/person</i>
<li> REQUEST PARAM - <i>/person/reqparam?version=1</i> ; <i>/person/reqparam?version=2</i>
<li> HEADER - add key-value X-API-VERSION=1 as a header ; or X-API-VERSION=2
<li> MEDIA TYPE - add key-value Accept-application/vnd.company.app-v1+json as header or Accept-application/vnd.company.app-v2+json

<b><ul> Dynamic Filtering:-</ul></b>
-return filter out fields based on different uris out of the same bean-

<li> URI - <i>http://localhost:8080/filtering-list</i>
 - will return list of user names
<li> URI - <i>http://localhost:8080/filtering</i>
 - will return username and security question
