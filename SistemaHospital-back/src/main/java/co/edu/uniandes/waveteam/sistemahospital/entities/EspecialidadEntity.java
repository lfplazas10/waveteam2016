/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.waveteam.sistemahospital.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author d.marino10
 */
@Entity
public class EspecialidadEntity extends BaseEntity implements Serializable {

    //@OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<> doctores = new ArrayList<>();
}
