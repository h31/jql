package com.github.h31.mitmfuzzing;

public class OkHttpUsage {
    public void simple() throws Exception {
        OkHttpWrapper.OkHttpClient client = new OkHttpWrapper.OkHttpClient();

        OkHttpWrapper.Request request = new OkHttpWrapper.Request.Builder()
                .url("http://kspt.icc.spbstu.ru/media/css/new/main.css")
                .build();

        try (OkHttpWrapper.Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        try {
            new OkHttpUsage().simple();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
