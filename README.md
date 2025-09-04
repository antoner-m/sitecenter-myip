# MyIp

Sample Java Spring Boot project for getting your external public Ip address.

Sometimes you need to know external ip address of your application, but it's hard to find out because application could be in docker, DMZ, virtual machine or behind NAT.  

MyIpClient - is a Spring Component that allows you to determine your public ip behind all containers, vms and firewalls.
It accesses external url: https://myip1.com/raw and get information about public as it sees you there.

If you want to use such a service in your application:

1. include in pom.xml:
<pre>
   &lt;dependency&gt;
   &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
   &lt;artifactId&gt;spring-boot-starter-webflux&lt;/artifactId&gt;
   &lt;/dependency&gt;

   &lt;dependency&gt;
   &lt;groupId&gt;com.fasterxml.jackson.datatype&lt;/groupId&gt;
   &lt;artifactId&gt;jackson-datatype-jsr310&lt;/artifactId&gt;
   &lt;/dependency&gt;
</pre>
2. Create Bean MyIpWebClient as in AppConfig.java
3. Copy MyIpDTO, MyIpClient and MyIpClientImpl to your project.
4. Use it anywhere you want:
   
   @Autowired
   private MyIpClient myIpClient;

https://myip1.com

Credits: https://myip1.com
