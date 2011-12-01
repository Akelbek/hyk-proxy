package org.arch.compress;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.arch.compress.fastlz.JFastLZ;
import org.arch.compress.fastlz.JFastLZLevel;
import org.arch.compress.jsnappy.SnappyBuffer;
import org.arch.compress.jsnappy.SnappyCompressor;
import org.arch.compress.jsnappy.SnappyDecompressor;
import org.arch.compress.lzf.LZFDecoder;
import org.arch.compress.lzf.LZFEncoder;
import org.junit.Test;

public class CompressTest
{

	@Test
	public void testFastLZ() throws IOException
	{
		InputStream fis = getClass().getResourceAsStream("sina.htm");
		byte[] buffer = new byte[1024*1024];
		int len = fis.read(buffer);
		byte[] cmp = new byte[len];
		
		System.arraycopy(buffer, 0, cmp, 0, len);
		JFastLZ fastlz = new JFastLZ();
		byte[] newbuf = new byte[len];
		long start = System.currentTimeMillis();
		int newlen = fastlz.fastlzCompress(JFastLZLevel.One, cmp, 0, cmp.length, newbuf,0,newbuf.length);
		long end = System.currentTimeMillis();
		System.out.println("FastLZ Compressed size:" + newlen + " for uncompressed size:" + len+", cost " + (end - start) + "ms");
		start = System.currentTimeMillis();
		int newlen2 = fastlz.fastlzDecompress(newbuf, 0, newlen, buffer, 0, buffer.length);
		end = System.currentTimeMillis();
		byte[] resume = new byte[newlen2];
		System.arraycopy(buffer, 0, resume, 0, newlen2);
		System.out.println("FastLZ Decompress cost " + (end - start) + "ms");
		assertArrayEquals(cmp, resume);
	}
	
	@Test
	public void testLZF() throws IOException
	{
		InputStream fis = getClass().getResourceAsStream("sina.htm");
		byte[] buffer = new byte[1024*1024];
		int len = fis.read(buffer);
		byte[] cmp = new byte[len];
		
		System.arraycopy(buffer, 0, cmp, 0, len);
		long start = System.currentTimeMillis();
		byte[] newbuf = LZFEncoder.encode(cmp,0,cmp.length);
		long end = System.currentTimeMillis();
		System.out.println("LZF Compressed size:" + newbuf.length + " for uncompressed size:" + len+", cost " + (end - start) + "ms");
		start = System.currentTimeMillis();
		byte[] resume = LZFDecoder.decode(newbuf, 0, newbuf.length);
		end = System.currentTimeMillis();
		System.out.println("LZF Decompress cost " + (end - start) + "ms");
		assertArrayEquals(cmp, resume);
	}

	
	@Test
	public void testSnappy() throws IOException
	{
		InputStream fis = getClass().getResourceAsStream("sina.htm");
		byte[] buffer = new byte[1024*1024];
		int len = fis.read(buffer);
		byte[] cmp = new byte[len];
		
		System.arraycopy(buffer, 0, cmp, 0, len);
		byte[] newbuf = new byte[len];
		long start = System.currentTimeMillis();
		SnappyBuffer afterCompress = SnappyCompressor.compress(cmp);
		
		long end = System.currentTimeMillis();
		System.out.println("Snappy Compressed size:" + afterCompress.getLength() + " for uncompressed size:" + len+", cost " + (end - start) + "ms");
		start = System.currentTimeMillis();
		SnappyBuffer resume = SnappyDecompressor.decompress(afterCompress);
		end = System.currentTimeMillis();
		System.out.println("Snappy Decompress cost " + (end - start) + "ms");
		assertArrayEquals(cmp, resume.toByteArray());
		//Snappy.compress(uncompressed, uncompressedOffset, uncompressedLength, compressed, compressedOffset)
	}

}
