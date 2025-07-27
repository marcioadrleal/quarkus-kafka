package org.br.mineradora.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class CurrencyPriceDTO  implements Serializable {

   private USDBRL USDBRL;

    public USDBRL getUSDBRL() {
        return USDBRL;
    }

    public void setUSDBRL(USDBRL USDBRL) {
        this.USDBRL = USDBRL;
    }
}
