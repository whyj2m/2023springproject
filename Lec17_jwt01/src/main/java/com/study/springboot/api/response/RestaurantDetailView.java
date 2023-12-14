package com.study.springboot.api.response;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDetailView {
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	private List<Menu> menus;
	
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Menu{
		private Long id;
		private String name;
		private Integer price;
		private ZonedDateTime createdAt;
		private ZonedDateTime updatedAt;
	}
}
