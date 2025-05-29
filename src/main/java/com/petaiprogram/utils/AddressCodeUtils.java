package com.petaiprogram.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AddressCodeUtils {

    public static String getDistrictCode(String address) throws Exception {
        String key = "9ae7719eaf1cf237d415fc2fd1f7bdeb"; // 替换为你自己的API Key
        String apiUrl = "http://api.map.com/api/geocode?address=" + URLEncoder.encode(address, "UTF-8") + "&key=" + key;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // 解析API返回的JSON数据并获取省市区编码
        String districtCode = response.toString();
        return districtCode;
    }

}
