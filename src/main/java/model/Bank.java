package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String text;

    @NotEmpty
    private String var_1;

    @NotEmpty
    private String var_2;

    @NotEmpty
    private String var_3;

    @NotEmpty
    private String var_4;

    @NotNull
    private Integer control;

}
