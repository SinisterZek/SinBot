package me.sinisterzek;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.OpenOption;

public class SinBotUtils {
	public static void save (byte[] key, byte[] value) {
	    
	    try {
	        String file = new String(key, "ASCII");
	        File f = new File("./save/" + file + ".bytes");
	        f.getParentFile().mkdirs();
	        Files.write(f.toPath(), value, new OpenOption[0]);
	    } catch (Exception e) {
	        
	    }
	    
	}

	public static byte[] load (byte[] key) {
	    
	    try {
	        String file = new String(key, "ASCII");
	        File f = new File("./save/" + file + ".bytes");
	        f.getParentFile().mkdirs();
	        return Files.readAllBytes(f.toPath());
	    } catch (Exception e) {
	        
	    }
	    
	    return new byte[0];
	    
	}
	public static byte[] intToByteArray(int value) {
	    return new byte[] {(byte)(value >> 24), (byte)(value >> 16), (byte)(value >> 8), (byte)value};
	}
	public static int byteArrayToInt(byte[] bytes) {
	    return bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
	}

	public static byte[] longToByteArray(long value) {
	    return new byte[] {(byte)(value >> 56), (byte)(value >> 48), (byte)(value >> 40), (byte)(value >> 32), (byte)(value >> 24), (byte)(value >> 16), (byte)(value >> 8), (byte)value};
	}
	public static long byteArrayToLong(byte[] bytes) {
	    long value = 0;
	    for (int i = 0; i < bytes.length; i++) {
	       value = (value << 8) + (bytes[i] & 0xff);
	    }
	    return value;
	}
	public static void save (String key, String value) {
	    save(key.getBytes(), value.getBytes());
	}

	public static String load (String key) {
	    return new String(load(key.getBytes()));
	}
}
