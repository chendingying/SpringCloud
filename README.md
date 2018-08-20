# SpringCloud
SpringCloud
spring-cloud-client: 微服务消费者（ribbon，feign）
spring-cloud-common: 微服务核心（工具类及核心类）
spring-cloud-eureka: 微服务注册中心
spring-cloud-service: 微服务提供者（advertising-广告系统，swagger，test）
spring-cloud-sidecar：微服务访问第三方网站（访问php）
spring-cloud-upload-server: 微服务上传提供者
spring-cloud-upload-client: 微服务上传消费者
spring-cloud-zuul: 微服务网关

待优化（spring cloud 热部署，核心模块的优化，swagger的实现）


启动顺序：
1.EurekaServerApplication（端口8761）
2.Application（提供者端口8763）
3.FeignAdvertisingApplication（消费者端口8765）

调用php启动顺序：
1.EurekaServerApplication（端口8761）
2.SpringZuulApplication（网关端口8200）
3.SpringSidecarApplication（调用php服务端口8210）
必须要在php服务器上添加/health.json 文件在SpringCloud 文件夹中
访问：http://localhost:8200/spring-sidecar/
