/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.sportsplanner5000.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 *
 * @author Andreas
 */
@Entity
// Define Querys
@NamedQueries({
@NamedQuery(name ="",query=""),
@NamedQuery(name ="",query=""),
@NamedQuery(name ="",query="")})
@Table(name = "t_event")
@SecondaryTable(name ="t_place") // Referenz to Table place
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable =false) // NOT NULL
    private String eventname;
    @Column(nullable =false) // NOT NULL
    private String typ;
    
    @OneToOne
    @JoinColumn(name= "address_fk")
    @Column(table ="t_place")
    private String place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.fhnw.sportsplanner5000.domain.Event[ id=" + id + " ]";
    }
    
}
