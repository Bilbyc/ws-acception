package com.acceptiondevtest.ws.sftp;

import static org.junit.jupiter.api.Assertions.*;

import com.acceptiondevtest.ws.sftp.utils.CSVUtils;

//import com.acceptiondevtest.ws.sftp.Sftp;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;

import com.acceptiondevtest.ws.entities.Loja;

class SftpTests {

	@Test
	void upload() throws IOException{
		
		Loja[] lojas = new Loja[] {
			new Loja("123456", "123445"),
			new Loja("122333", "394883"),
			new Loja("vishvisah", "133333")
		};
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//baos.write
		
		for(int i = 0; i<3; i++) {
			baos.write(CSVUtils.stringArrayToCSVLine(lojas[i].toStringArray()).getBytes(StandardCharsets.UTF_8));
		}
		
		byte[] bytes = baos.toByteArray();
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		
		new Sftp().upload(inputStream, "/data/in", "loja" + LocalDateTime.now() + ".csv");
	}

}
