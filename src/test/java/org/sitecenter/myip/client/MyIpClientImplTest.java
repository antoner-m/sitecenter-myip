package org.sitecenter.myip.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j

class MyIpClientImplTest {
    @Autowired
    private MyIpClient myIpClient;

    @Test
    void getMyIp() {
        log.info("getMyIp");

        MyIpDTO result = myIpClient.getMyIp();
        assert(result != null);
        log.info(result.getIp());
        MyIpDTO result2 = myIpClient.getMyIp();
        //There must be only one request to site, after that same object will be returned
        assert(result == result2);

    }
}