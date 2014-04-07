package net.nunnerycode.bukkit.libraries.ivory.utils;

import java.io.*;

public final class IOHelper {

    private IOHelper() {
        // do nothing
    }

    public static void writeBytesToFile(File file, byte[] bytes) {
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null");
        }
        if (bytes == null) {
            throw new IllegalArgumentException("bytes cannot be null");
        }
        File parent = file.getParentFile();
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            return;
        }
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(bytes);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readBytesFromFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null");
        }

        int length = (int) file.length();
        byte[] bytes = new byte[length];

        try (InputStream inputStream = new FileInputStream(file)) {
            int i = 0;
            while (i < length) {
                i += inputStream.read(bytes, i, length - i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

}
