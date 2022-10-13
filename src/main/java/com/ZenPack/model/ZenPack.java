package com.ZenPack.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zen_pack")
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZenPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zenPackId;
    @Column(name = "zen_pack_name")
    private String name;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate=new Date();
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_time")
    private Date updatedTime=new Date();

    @Column(name = "jsonData")
    private String jsonData;



}
