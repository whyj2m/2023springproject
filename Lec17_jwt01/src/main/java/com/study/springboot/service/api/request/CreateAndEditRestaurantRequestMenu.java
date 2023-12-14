package com.study.springboot.service.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndEditRestaurantRequestMenu {
	private String name;
	private Integer price;
}
