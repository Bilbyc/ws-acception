package com.acceptiondevtest.ws.sftp;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;

public class Sftp {
	
	@Value("${SFTP_USER}")
	private String sftpUser;
	
	@Value("${SFTP_PASS")
	private String sftpPass;
	
	@Value("${SFTP_HOST}")
	private String sftpHost;
	
	private DefaultSftpSessionFactory getFactory() {
		DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
		factory.setHost(sftpHost);
		factory.setUser(sftpUser);
		factory.setPassword(sftpPass);
		factory.setPort(2222);
		factory.setAllowUnknownKeys(true);
		
		return factory;
	}
	
	public void upload(InputStream inputStream, String filePath, String fileName) throws IOException {
		try(SftpSession session = getFactory().getSession()) {
			session.write(inputStream, filePath + "/" + fileName);
		}
	}
	
}
