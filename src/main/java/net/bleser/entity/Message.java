package net.bleser.entity;

import javax.persistence.*;

/**
 * Created by bleser on 15.10.16.
 */
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "data")
    private String data;

    @Column(name = "time")
    private String time;

    @ManyToOne(targetEntity = User.class)
    private User user;

}
