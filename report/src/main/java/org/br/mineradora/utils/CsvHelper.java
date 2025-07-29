package org.br.mineradora.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.br.mineradora.dto.OpportunityDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CsvHelper {

    public static ByteArrayInputStream OpportunitiesToCsv(List<OpportunityDTO> opportunities)  {

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader("ID Proposta", "Cliente", "Preço por Tonelada", "Melhor Cotação da Moeda").get();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            CSVPrinter cvsPrinter = new CSVPrinter(new PrintWriter(out), format);

            for (OpportunityDTO opps : opportunities) {
                List<String> data = Arrays.asList(
                        String.valueOf(opps.getProposalId()),
                        opps.getCustomer(),
                        String.valueOf(opps.getPriceTonne()),
                        String.valueOf(opps.getLastDollarQuotation())
                );
                cvsPrinter.printRecord(data);
            }
            cvsPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        }catch (IOException e){
            return null;
        }
    }

}
