package mk.ukim.finki.emt.sharedkernel.domain.base;


import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity<ID extends DomainObjectId> {
    @EmbeddedId
    private ID id;

    public AbstractEntity(Object randomId) {
    }
}
