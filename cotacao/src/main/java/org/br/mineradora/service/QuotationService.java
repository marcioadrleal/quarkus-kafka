package org.br.mineradora.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.br.mineradora.client.CurrencyPriceClient;
import org.br.mineradora.dto.CurrencyPriceDTO;
import org.br.mineradora.dto.QuotationDTO;
import org.br.mineradora.dto.USDBRL;
import org.br.mineradora.entity.QuotationEntity;
import org.br.mineradora.message.KafkaEvents;
import org.br.mineradora.repository.QuotationRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@ApplicationScoped
public class QuotationService {

    @Inject
    @RestClient
    private CurrencyPriceClient currencyPriceClient;

    @Inject
    private QuotationRepository quotationRepository;

    @Inject
    private KafkaEvents kafkaEvents;

    public void getCurrencyPrice(){
        CurrencyPriceDTO currencyPriceInfo = currencyPriceClient.getPriceByPair("USD-BRL");
        System.out.println("Passei aqui");
        System.out.println(currencyPriceInfo.getUSDBRL());
        if (updateCurrentInfoPrice(currencyPriceInfo)){
          kafkaEvents.sendNewKafkaEvent(
                  new QuotationDTO( new Date() ,
                  new BigDecimal( currencyPriceInfo.getUSDBRL().getBid() )));
        }
    }



    private boolean updateCurrentInfoPrice(CurrencyPriceDTO currency){
        BigDecimal currencyPrice = new BigDecimal(currency.getUSDBRL().getBid());
        AtomicBoolean updatePrice = new AtomicBoolean(false);
        List<QuotationEntity> quotationList = quotationRepository.findAll().list();
        if ( quotationList.isEmpty() ){
           saveQuotation(currency);
           updatePrice.set(true);
        } else {
           QuotationEntity lastDollasrPrice = quotationList.get((quotationList.size()-1));
           if( currencyPrice.floatValue() > lastDollasrPrice.getCurrecyPrice().floatValue()) {
               saveQuotation(currency);
               updatePrice.set(true);
           }
        }
        return updatePrice.get();
    }

    private void saveQuotation(CurrencyPriceDTO currency) {
      QuotationEntity quotation = new QuotationEntity();
      quotation.setDate(new Date());
      quotation.setCurrecyPrice(new BigDecimal(currency.getUSDBRL().getBid()));
      quotation.setPctChange(currency.getUSDBRL().getBid());
      quotation.setPair("USD-BRL");
      quotationRepository.persist(quotation);
    }

}
