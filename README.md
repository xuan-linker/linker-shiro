# Getting Started

### DockerStart

启动redis 并设置密码
```
docker run -p 6379:6379 --name redis -d redis  --requirepass "admin"
```

启动 mysql
```
docker run -p  3306:3306 --name mysql2 -v ~/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7
```
### Guides
The following guides illustrate how to use some features concretely:

* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

