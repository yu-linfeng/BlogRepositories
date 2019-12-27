package com.coderbuff.third1simple;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yulinfeng
 * @date 2019/12/26
 */
@Service
public class StockServiceImpl {

    /**
     * 申请的APPKEY
     */
    private static final String APPKEY = "71e065a2cdf2753a5d6261b5002498b7";

    /**
     * API URL
     */
    private static final String URL = "http://web.juhe.cn:8080/finance/stock/hs?gid=%s&key=%s";

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    /**
     * 根据股票代码获取股票
     *
     * @param code 股票代码
     * @return 股票信息
     */
    public StockDTO getStockByCode(String code) {
        StockDTO stockDTO = new StockDTO();
        try {
            String data = getResponse(code);
            JSONObject jsonObject = JSONObject.parseObject(data);
            if (jsonObject.getInteger("error_code") != 0) {
                return stockDTO;
            }
            JSONArray resultArray = JSONArray.parseArray(jsonObject.getString("result"));
            JSONObject result = JSONObject.parseObject(resultArray.getString(0));
            JSONObject stockObject = JSONObject.parseObject(result.getString("data"));
            stockDTO.setName(stockObject.getString("name"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stockDTO;
    }

    /**
     * 获取响应数据
     * @param code 股票代码
     * @return 响应数据
     * @throws IOException IOException
     */
    private String getResponse(String code) throws IOException {
        String strUrl = String.format(URL, code, APPKEY);
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-agent", USER_AGENT);
            conn.connect();
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }
}
