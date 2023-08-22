/**
 * 
 */
package com.example.demo.auto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;
/**
 * @author igonix
 *
 * 26-Jul-2023
 */

@Entity
@Table(name = "t_i18n")
@Getter
@Setter
public class Message  {

    @Id
    private String code;

    private String en;

    private String fr;

    private String pr;

    private String description;

}