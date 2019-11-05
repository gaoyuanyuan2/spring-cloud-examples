
http://www.ityouknow.com/springcloud/2017/05/22/springcloud-config-git.html

特别注意：上面这些与spring-cloud相关的属性必须配置在bootstrap.properties中，config部分内容才能被正确加载。因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。

我们在进行一些小实验，手动修改`neo-config-dev.properties`中配置信息为：`neo.hello=hello im dev update1`提交到github,
再次在浏览器访问`http://localhost:8002/hello`，返回：`neo.hello: hello im dev update`，说明获取的信息还是旧的参数，这是为什么呢？
因为springboot项目只有在启动的时候才会获取配置文件的值，修改github信息后，client端并没有在次去获取，所以导致这个问题。如何去解决这个问题呢？