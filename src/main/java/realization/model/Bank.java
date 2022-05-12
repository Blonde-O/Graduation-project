package realization.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String text;

    @NotEmpty
    @Column(name = "var_1")
    private String var1;

    @NotEmpty
    @Column(name = "var_2")
    private String var2;

    @NotEmpty
    @Column(name = "var_3")
    private String var3;

    @NotEmpty
    @Column(name = "var_4")
    private String var4;

    @NotNull
    private Integer control;

}
