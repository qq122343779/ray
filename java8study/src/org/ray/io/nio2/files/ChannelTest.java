package org.ray.io.nio2.files;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ChannelTest {

	Path file = Paths.get("myfile.txt");
	
	@Test
	public void test() {
		try (SeekableByteChannel channel = Files.newByteChannel(file)){
			ByteBuffer buf = ByteBuffer.allocate(100);
			
			String encoding = System.getProperty("file.encoding");
		    while (channel.read(buf) > 0) {
		        buf.rewind();
		        System.out.print(Charset.forName(encoding).decode(buf));
		        buf.flip();
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
