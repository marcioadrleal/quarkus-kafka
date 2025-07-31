package org.br.mineradora.service;

import org.br.mineradora.dto.OpportunityDTO;

import java.io.ByteArrayInputStream;
import java.util.List;

public class ReportServiceImpl implements  ReportService{

    @Override
    public ByteArrayInputStream generateCSVOpportunityReport() {
        return null;
    }

    @Override
    public List<OpportunityDTO> getOpportuniesData() {
        return List.of();
    }
}
