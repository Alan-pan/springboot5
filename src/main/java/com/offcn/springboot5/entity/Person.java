package com.offcn.springboot5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //get 、set
@AllArgsConstructor //所有参数的有参数构造函数
@NoArgsConstructor  //无参数构造函数
@Entity
@Table(name="tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @Column(name = "age", nullable = true, length = 4)
    private Integer age;

}