# Gradle #
### Build Api ###
```console
$ gradle build
```

### Run ###
```console
$ java -jar ./build/libs/api-0.0.1-SNAPSHOT.jar
```

### pgAdmin4 ###

To connect the PostgreSQL Db container to the pgAdmin4 container, use the following credentials:

```
name: container-postgresdb
host: host.docker.internal
database: restful-api
user: postgres
password: admin
```

### Frontend ###

```console
$ cd src 

$ npm install -g @vue/cli

$ vue create frontend
```

Select -
```console
❯ Default ([Vue 3] babel, eslint) 
```
```console
$ cd frontend
$ npm run serve
```

# Local CICD

By utilsing Kind and Tilt we can build a local CICD process with Kubernetes (k8s)

Tilt will build K8s pods for each ktrack solution.

## To use the TiltFile
### Prerequisites - MacBook Pro x86 or ARM

#### Use HomeBrew to add prerequisites

#### Install HomeBrew
```
$ /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

Run local Kubernetes cluster in Docker
```
$ brew install kind
```

Define your dev environment as code. For microservice apps on Kubernetes
```
$ brew install tilt
```
#### To launch local CICD

First create a Kind Cluster to host the Worker Nodes
```
$ kind create cluster
```

At the root of the Tiltfile. The argument "--stream" will output logs to the console
```
tilt up --stream
```
To view Tilt dashboard, navigate to;
```
http://localhost:10350
```


Further Reading
```
https://kind.sigs.k8s.io
```
```
https://tilt.dev
```