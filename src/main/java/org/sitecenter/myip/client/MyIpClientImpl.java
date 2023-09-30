package org.sitecenter.myip.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MyIpClientImpl implements MyIpClient{

    private final String NOTIFICATION_API_URL = "https://myip.sitecenter.org";

    private final WebClient webClient;

    public MyIpClientImpl(@Qualifier("MyIpWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    private static volatile MyIpDTO cachedValue;
    @Override
    public MyIpDTO getMyIp() {
        MyIpDTO result = cachedValue;
        if (result == null) {
            synchronized (this) {
                if (cachedValue != null) return cachedValue;
                result = webClient.get().uri(NOTIFICATION_API_URL + "/api/myip")
                        .retrieve().bodyToMono(MyIpDTO.class).block();
                cachedValue = result;
            }
        }
        return result;
    }
}