package com.gulimall.thirdparty.tools;
import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.google.gson.Gson;
import darabonba.core.client.ClientOverrideConfiguration;
import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;

@Component
public class SendCode {

    /**
     * 发送短信验证码
     * @param phone：手机号
     * @param code：短信内容；注意：内容格式为，例如：{"code":"1234"}，code为验证码（json格式）
     * @throws Exception
     */

    public void sendCode(String phone,   String code) throws Exception {

        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId("LTAI5tGahvykmFFs8sQnz8xW")
                .accessKeySecret("jYbzYuIl1weLwevQn8QrTAeTdSe3cf")
                .build());


        AsyncClient client = AsyncClient.builder()
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                )
                .build();

        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .phoneNumbers(phone)
                .signName("William的在线商城")
                .templateCode("SMS_464175474")
                .templateParam(code)
                .build();
        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
        SendSmsResponse resp = response.get();
        System.out.println(new Gson().toJson(resp));
        client.close();
    }

}
