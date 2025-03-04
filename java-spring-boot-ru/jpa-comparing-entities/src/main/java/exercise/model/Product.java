package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "price"})
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int price;
}
// END
