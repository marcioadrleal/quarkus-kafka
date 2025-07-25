package org.br.mineradora.repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.br.mineradora.entity.QuotationEntity;

@ApplicationScoped
public class QuotationRepository implements PanacheRepositoryBase<QuotationEntity,Long> {

}
