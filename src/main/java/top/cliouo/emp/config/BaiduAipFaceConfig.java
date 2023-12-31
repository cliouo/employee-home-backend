package top.cliouo.emp.config;

import com.baidu.aip.face.AipFace;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "baidu.aip")
@Component
@Data
public class BaiduAipFaceConfig {
    private String appId;
    private String apiKey;
    private String secretKey;

    @Bean
    public AipFace getAipFace(){
        AipFace client = new AipFace(appId, apiKey, secretKey);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }
}
