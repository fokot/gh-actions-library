## GH actions library

Project created with

```
sbt new scala/scala3.g8
```

Used to teach github actions, building and pushing to repository

Library will be used in `gs-actions-webserver` project.

Looks how secrets to registry are passed in the `ci.yml` and also in `build.sbt` file.

Secrets are set in `Settings -> Secrets and variables -> Actions -> Repository secrets`.
They can be set also on the organisation level.

I started testing nexus with
```
docker run -d -p 8081:8081 --name nexus sonatype/nexus3
```
and got pwd via

It starts on [http://localhost:8081/nexus](http://localhost:8081/nexus).
Default user is `admin` and password you can get via
```
docker exec nexus cat /nexus-data/admin.password
```
And then I exposed it via `ngrok`
```
ngrok http 8081 --url kodiak-helped-fawn.ngrok-free.app    
```