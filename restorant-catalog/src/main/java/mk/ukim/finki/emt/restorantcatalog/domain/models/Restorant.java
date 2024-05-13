package mk.ukim.finki.emt.restorantcatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.emt.restorantcatalog.domain.valueObjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "restorant")
public class Restorant extends AbstractEntity<RestorantId> {


    private String restorantName;
    private Money price;
    private Quantity quantity;
}
