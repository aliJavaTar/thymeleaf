package ir.maktab.last.entity;

import ir.maktab.last.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity<Long> {
    @Column(unique = true)
    private String username;
    private String password;
}
