package net.oneandone.maven.plugins.fossjar;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FooITWeb {

    @Test
    public void checkTomcat() throws MalformedURLException, IOException {
        int port = Integer.valueOf(System.getProperty("tomcat.port", "8080"));
        URL url = new URL("http", "localhost", port, "/");
        InputStream stream = url.openStream();
        try {
            final byte[] bytes = ByteStreams.toByteArray(stream);
            final String body = new String(bytes, Charsets.UTF_8);
            assertThat(body, containsString("<h1>test</h1>"));
        } finally {
            stream.close();
        }
    }
}
