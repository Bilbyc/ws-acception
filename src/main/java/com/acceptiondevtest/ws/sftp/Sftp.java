package com.acceptiondevtest.ws.sftp;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpSession;
import org.springframework.stereotype.Component;

@Component
public class Sftp {
	
	public DefaultSftpSessionFactory getFactory() {
		DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
		factory.setHost("192.168.0.133");
		factory.setUser("acception");
		factory.setPassword("@cceptiontest");
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

        }
    }
	
	
}
