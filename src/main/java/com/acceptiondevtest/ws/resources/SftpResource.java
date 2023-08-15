package com.acceptiondevtest.ws.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acceptiondevtest.ws.services.VendaService;
import com.acceptiondevtest.ws.sftp.Sftp;
import com.acceptiondevtest.ws.entities.Venda;
import com.acceptiondevtest.ws.entities.enums.Bandeira;
import com.acceptiondevtest.ws.entities.enums.TipoTransacao;

@Component
public class SftpResource {

	@Autowired
	private VendaService vendaService;

	@Autowired
	private Sftp sftp;

	public void getData(String path) {
		try {
			String obj = sftp.download(path);

			List<Venda> vendas = new ArrayList<>();
	
			String[] linhas = obj.split("\n");

			for (String linha : linhas) {
				String[] campos = linha.split(";");

				if (campos.length > 3) { 
					Venda venda = new Venda();

					venda.setTipoRegistro(Integer.parseInt(campos[0]));
					venda.setDataVenda(LocalDate.parse(campos[1], DateTimeFormatter.ofPattern("ddMMyyyy")));
					venda.setCartao(campos[2]);
					venda.setCodigoAutorizacao(campos[3]);
					venda.setNsu(Integer.parseInt(campos[4])); 
					venda.setBandeira(Bandeira.valueOf(campos[5]));
					if(campos[6].isEmpty()) {
						venda.setParcelas(0);
					} else {
						venda.setParcelas(Integer.parseInt(campos[6]));
					};
					venda.setTipoTransacao(TipoTransacao.valueOf(campos[7])); 								
					venda.setValorTransacao(Double.parseDouble(campos[8].replace(",", ".")));												
					venda.setTaxaTransacao(Double.parseDouble(campos[9].replace(",", "."))); 
																								

					vendas.add(venda);
				}
			}

			vendaService.insertAll(vendas);

		} catch (Exception e) {
			e.printStackTrace();
		}
	};

}
