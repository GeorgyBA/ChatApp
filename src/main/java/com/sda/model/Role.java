package com.sda.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

/**
 * Class which imagine roles
 * @author GEORGY1986
 * @version 1.0
 */
@Entity
@Table(name = "roles")
@Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roleName;

    public Role() {
    }

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName.substring(5);
    }
}
