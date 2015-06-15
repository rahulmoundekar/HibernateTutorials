package com.hibernate.apps;

import java.io.*;
import java.sql.Blob;
import java.sql.Clob;

public class LargeObjects {
	public static String readFileAsString(String filePath) throws Exception {
		String fileData = "";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData += readData;
		}
		reader.close();
		return fileData.toString();

	}

	public static byte[] getBytesArrayFromFile(String fpath) {
		try {
			File file = new File(fpath);
			InputStream is = new FileInputStream(file);
			long length = file.length();
			byte[] bytes = new byte[(int) length];
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
			if (offset < bytes.length) {
				throw new IOException("Could not complete read file"
						+ file.getName());
			}
			is.close();
			return bytes;
		} catch (Exception e) {
			return null;
		}
	}

	public static String createFileFromClob(Clob clb, String fpath) {
		try {
			Reader reader = clb.getCharacterStream();
			File data = new File(fpath);
			FileWriter writer = new FileWriter(data);
			char[] buffer = new char[1024];
			while (reader.read(buffer) > 0) {
				writer.write(buffer);
			}
			writer.close();
		} catch (Exception e) {
		}
		return "Data Stored Permanently in" + fpath;
	}

	public static String createFileFromBlob(Blob blb, String fpath) {
		try {
			InputStream in = blb.getBinaryStream();
			FileOutputStream fos = new FileOutputStream(fpath);
			int bytesRead = 0;
			byte buffer[] = new byte[4096];

			while ((bytesRead = in.read(buffer)) != 1) {
				fos.write(buffer, 0, bytesRead);
			}
			fos.close();
		} catch (Exception e) {
		}
		return "Photo stored Sucessfully in " + fpath;

	}
}