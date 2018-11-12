# 1. 各工程端口
	EurekaServer 注册中心服务端 8900<br/>
	EurekaClient 服务提供者 8922<br/>
	EurekaClientCopy 服务提供者 8923<br/>
	Ribbon 服务消费者，负载均衡 8940<br/>
	Feign 服务消费者，声明式服务调用 8950<br/>
	Zuul 网关，路由  8960<br/>

# 2. 注册中心
	a.注册中心服务端管理界面，启动EurekaServer，访问： http://127.0.0.1:8900<br/>
	b. 演示注册中心客户端：<br/>
	  启动 EurekaClient 和 EurekaClientCopy<br/>
	  http://localhost:8922/hello?name=Avail<br/>
	  http://localhost:8923/hello?name=Avail<br/>

# 3. Ribbon
	a. 演示Ribbon负载均衡<br/>
	启动8922和8923，多次访问：http://127.0.0.1:8940/hello?name=Avail<br/>

	b. 演示断路器：<br/>
	EurekaClient必须先于Ribbon工程启动<br/>
	停止EurekaClient工程和EurekaClientCopy，访问 http://127.0.0.1:8940/hello?name=Avail<br/>
  
# 4. Feign
	启动EurekaServer工程<br/>
	启动EurekaClient工程<br/>
	启动Feign工程，访问 http://127.0.0.1:8950/hello?name=Avail<br/>
	因为Feign集成了Ribbon，所以可以实现负载均衡<br/>
 
	演示Feign中的断路器：<br/>
	停止EurekaClient工程，访问 http://127.0.0.1:8950/hello?name=Avail<br/>
 
	Hystrix仪表盘<br/>
		访问：http://localhost:8940/hystrix/

# 5. Zuul
	演示zuul根据path路由：<br/>
	访问：http://localhost:8960/api-ribbon/hello?name=Avail<br/>
	访问：http://localhost:8960/api-feign/hello?name=Avail<br/>
	访问：http://localhost:8960/api-gupao/hello?name=Avail<br/>