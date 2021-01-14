package com.github.h31.mitmfuzzing;

import java.io.*;

public class OkHttpWrapper {
    static public RandomnessReader randomnessSource;
    static public boolean recordEnabled;
    static public boolean fuzzingEnabled;
    static public Writer recordDest;

    static public class OkHttpClient {
        okhttp3.OkHttpClient internal = new okhttp3.OkHttpClient();
        public Call newCall(Request r) {
            okhttp3.Call c = internal.newCall(r.internal);
            return new Call(c);
        }
    }

    static public class Call {
        okhttp3.Call internal;
        Call(okhttp3.Call internal) {
            this.internal = internal;
        }

        public Response execute() throws IOException {
            okhttp3.Response response = internal.execute();
            return new Response(response);
        }
    }

    static public class Response implements AutoCloseable {
        okhttp3.Response internal;

        Response(okhttp3.Response internal) {
            this.internal = internal;
        }

        public ResponseBody body() {
            okhttp3.ResponseBody body = internal.body();
            return new ResponseBody(body);
        }

        @Override
        public void close() {
            internal.close();
        }
    }

    static public class ResponseBody {
        okhttp3.ResponseBody internal;

        ResponseBody(okhttp3.ResponseBody internal) {
            this.internal = internal;
        }

        public String string() throws IOException {
            String r = internal.string();
            if (recordEnabled) {
                recordDest.write("ResponseBody.string" + "\n");
                recordDest.write(r.length() + "\n");
                recordDest.write(r);
                recordDest.flush();
            }
            if (fuzzingEnabled) {
                String data = randomnessSource.readRecord("ResponseBody.string");
                System.out.println("Original:\n" + r);
                System.out.println("Fuzzed:\n" + data);

                return data;
            } else {
                return r;
            }
        }
    }

    static public class Request {
        okhttp3.Request internal;

        Request(okhttp3.Request internal) {
            this.internal = internal;
        }

        static public class Builder {
            okhttp3.Request.Builder internal = new okhttp3.Request.Builder();

            public Request.Builder url(String u) {
                internal.url(u);
                return this;
            }

            public Request build() {
                okhttp3.Request r = internal.build();
                return new Request(r);
            }
        }
    }
}

