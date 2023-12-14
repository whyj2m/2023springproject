package com.study.springboot.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "menu")
@Getter
public class MenuEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
	@SequenceGenerator(name = "menu_seq", sequenceName = "menu_SEQ", allocationSize = 1)
	private Long id;
	
	private Long restaurantId;
	private String name;
	private Integer price;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}
