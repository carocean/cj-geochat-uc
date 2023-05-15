package cj.geochat.open.uc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface IReadFully {

    default byte[] readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[80960];
        int len = 0;
        while ((len = inputStream.read(buffer)) >= 0) {
            outputStream.write(buffer, 0, len);
        }
        return outputStream.toByteArray();
    }
}
