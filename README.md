# hateoas-webflux-demo

Docker should be installed and configured on your machine prior to creating the image, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#getting-started-buildpacks).

Assuming everything is configured properly, build the image like below

```
mvn clean spring-boot:build-image
```

Once the container is built, run the container like so

```
docker run --rm -p8080:8080 demo:0.0.1-SNAPSHOT
```

In another terminal, submit a GET request to the running application, it should return the response indicated

request:
```
curl http://localhost:8080
```

response:
```
{
	"links": [
		{
			"rel": "accounts",
			"href": "http://localhost:8080/accounts"
		},
		{
			"rel": "roles",
			"href": "http://localhost:8080/roles"
		}
	]
}
```