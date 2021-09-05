package com.license.scanner.licensescanner.service;

import com.license.scanner.licensescanner.model.dto.Request;
import com.license.scanner.licensescanner.model.dto.Response;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IdScanService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${idScan.url}")
    private String idScanUrl;

    @Value("${idScan.authKey}")
    private String authKey;

    public String getLicense(String text) throws Exception {
        Base64 base64 = new Base64();
        String encodedString = String.valueOf(base64.encode(text.getBytes()));

        Request request = new Request();
        request.setText(encodedString);
        request.setAuthKey(authKey);

        ResponseEntity<Response> response = null;

        try {
            response = restTemplate.postForEntity(idScanUrl, request, Response.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody().getParseResult().getDriverLicense().getLicenseNumber();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Text cannot be parsed");
        }
        System.out.println("done");
        return null;
    }

}
