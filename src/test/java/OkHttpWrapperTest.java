import static com.github.h31.mitmfuzzing.OkHttpWrapper.OkHttpClient;
import static com.github.h31.mitmfuzzing.OkHttpWrapper.Request;
import static com.github.h31.mitmfuzzing.OkHttpWrapper.Response;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.github.h31.mitmfuzzing.OkHttpWrapper;
import com.github.h31.mitmfuzzing.RandomnessReader;
import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;

@RunWith(JQF.class)
public class OkHttpWrapperTest {
    public void simple() throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://kspt.icc.spbstu.ru/media/css/new/main.css")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String data = response.body().string();
            System.out.println(data);
            assertTrue(data.startsWith("@import"));
//            assertTrue(data.endsWith("\n"));
//            assertTrue(data.contains("#000000"));
        }
    }

    @Test
    public void simpleTest() throws Exception {
        OkHttpWrapper.recordDest = new FileWriter("input/fuzzData.log", false);
        OkHttpWrapper.recordEnabled = true;
        simple();
    }

    @Fuzz
    public void simpleFuzz(InputStream input) throws Exception {
        OkHttpWrapper.randomnessSource = new AFLRandomnessReader(input);
        OkHttpWrapper.fuzzingEnabled = true;
        simple();
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }

    static class AFLRandomnessReader implements RandomnessReader {
        public AFLRandomnessReader(InputStream source) {
            randomnessSource = new BufferedReader(new InputStreamReader(source));
        }

        public BufferedReader randomnessSource;

        @Override
        public String readRecord(String expectedMethod) {
            try {
                String method = randomnessSource.readLine();
                Assume.assumeTrue(method.equals(expectedMethod));

                String lengthString = randomnessSource.readLine();
                int length = Integer.parseInt(lengthString);
                Assume.assumeTrue(length <= 1000000);

                char[] data = new char[length];
                randomnessSource.read(data);
                return new String(data);
            } catch (IOException e) {
                Assume.assumeNoException(e);
                return null;
            }
        }
    }
}
