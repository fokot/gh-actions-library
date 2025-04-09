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
