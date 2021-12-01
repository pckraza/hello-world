package com.orchid.springdata.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name ="name",
                column = @Column(name="guardian_name")
        ),
        @AttributeOverride(
        name ="email",
        column = @Column(name="guardian_email")
),
        @AttributeOverride(
                name ="mobile",
                column = @Column(name="guardian_mobile"))
})


//Pas d'annotation @Entity car les propriétés de la classe ne seront pas
// stockées dans une table indépendante
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
