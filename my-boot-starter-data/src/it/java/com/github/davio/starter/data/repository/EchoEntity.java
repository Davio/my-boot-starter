package com.github.davio.starter.data.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.github.davio.starter.data.model.EchoMessage;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "echo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EchoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_id"
    )
    @SequenceGenerator(
            name = "seq_id",
            sequenceName = "seq_id",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "message", columnDefinition = "jsonb")
    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonBinaryType")
    private EchoMessage echoMessage;

    @Version
    @Column(name = "version")
    private Long version;
}
