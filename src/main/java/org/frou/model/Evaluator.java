package org.frou.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Corentin on 13-novembre-14.
 */
@Entity
@Table(name = "EVALUATOR")
public class Evaluator implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "evaluator")
    private List<Evaluation> evaluations;

    @Column(name = "PASSWORD")
    private String password;

    /**
     * Default constructor for the Evaluator entity.
     */
    public Evaluator() {
        // do nothing, empty constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
