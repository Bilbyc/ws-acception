package com.acceptiondevtest.ws.sftp;

import com.acceptiondevtest.ws.sftp.utils.CSVUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;

import com.acceptiondevtest.ws.entities.Loja;

class SftpTest {

	@Mock
	private DefaultSftpSessionFactory sessionFactory;

	@Mock
	private SftpSession sftpSession;

	@Test
	void upload() throws IOException {

		Loja[] lojas = new Loja[] { new Loja("123456", "123445"), new Loja("122333", "394883"),
				new Loja("vishvisah", "133333") };

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(Loja.CSV_HEADER.getBytes(StandardCharsets.UTF_8));

		for (int i = 0; i < 3; i++) {
			baos.write(CSVUtils.stringArrayToCSVLine(lojas[i].toStringArray()).getBytes(StandardCharsets.UTF_8));
		}

		byte[] bytes = baos.toByteArray();

		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

		new Sftp().upload(inputStream, "/data/in", "loja" + LocalDateTime.now() + ".csv");
	}

	@Test
	void download() throws IOException {

		String remoteFilePath = "/data/out/ACC01.csv";

		String downloadedStream = new Sftp().download(remoteFilePath);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println("CONTEUDO: " + downloadedStream);

	}

}
