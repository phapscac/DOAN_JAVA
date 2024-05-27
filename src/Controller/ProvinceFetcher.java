/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Admin
 */
import UI.Setting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProvinceFetcher {

    public static String[] fetchProvinceNames(String apiUrl) throws Exception {
        // Tạo URL object từ apiUrl
        URL url = new URL(apiUrl);
        
        // Mở kết nối đến URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Đọc dữ liệu từ API với mã hóa UTF-8
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        // Đóng các stream và kết nối
        in.close();
        connection.disconnect();

        // Chuyển đổi chuỗi JSON thành JSONObject
        JSONObject jsonObject = new JSONObject(content.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        // Lấy tên tỉnh thành từ JSONArray
        List<String> provinceNames = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject province = jsonArray.getJSONObject(i);
            provinceNames.add(province.getString("name"));
        }

        // Chuyển đổi List thành mảng và trả về
        return provinceNames.toArray(new String[0]);
    }

    public static void main(String[] args) {
        try {
            String apiUrl = "https://esgoo.net/api-tinhthanh/1/0.htm";
            String[] provinceNames = fetchProvinceNames(apiUrl);

            // In danh sách các tên tỉnh thành
            for (String name : provinceNames) {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


