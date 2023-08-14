package com.acceptiondevtest.ws.sftp;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;
import org.springframework.stereotype.Component;

@Component
public class Sftp {
	
	@Value("${sftp.user}")
	private String sftpUser;
	
	@Value("${sftp.pass}")
	private String sftpPass;
	
	@Value("${sftp.host}")
	private String sftpHost;
	
	public DefaultSftpSessionFactory getFactory() {
		System.out.println("ENTROU AQ");
		System.out.println(sftpUser);
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
	
	public String download(String remoteFilePath) throws IOException {
        try (SftpSession session = getFactory().getSession()) {
        	InputStream data = session.readRaw(remoteFilePath);
        	
        	BufferedReader reader = new BufferedReader(new InputStreamReader(data));
        	StringBuilder stringBuilder = new StringBuilder();
        	String line;
        	while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();

            //return data;
        }
    }
	
	
}
