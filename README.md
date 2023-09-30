# MyIp

Sample Java Spring Boot project for getting your external public Ip address.

Sometimes you need to know external ip address of your application, but it's hard to find out because application could be in docker, DMZ, virtual machine or behind NAT.  

MyIpClient - is a Spring Component that allows you to determine your public ip behind all containers, vms and firewalls.
It accesses external url: https://myip.sitecenter.org/api/myip and get information about public as it sees you there.

If you want to use such a service in your application:

1. Create Bean MyIpWebClient as in AppConfig.java
2. Copy MyIpDTO, MyIpClient and MyIpClientImpl to your project.
3. Use it anywhere you want:
   
   @Autowired
   private MyIpClient myIpClient;

https://www.sitecenter.org/tools/myip

Credits: https://www.sitecenter.org