package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M") //Db에 들어갈때 식별해주기 위함
@Getter
@Setter
public class Movie extends Item {
    private String director;
    private String actor;
}
