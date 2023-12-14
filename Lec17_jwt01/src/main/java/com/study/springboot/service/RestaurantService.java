package com.study.springboot.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.springboot.api.request.RestaurantView;
import com.study.springboot.api.response.RestaurantDetailView;
import com.study.springboot.entity.MenuEntity;
import com.study.springboot.entity.RestaurantEntity;
import com.study.springboot.repository.MenuRepository;
import com.study.springboot.repository.RestaurantRepository;
import com.study.springboot.service.api.request.CreateAndEditRestaurantRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RestaurantService {
	
	private final RestaurantRepository restaurantRepository;
	private final MenuRepository menuRepository;
	
	// 레스토랑 생성 및 메뉴생성
	public RestaurantEntity createRestaurant(CreateAndEditRestaurantRequest request) {
		RestaurantEntity restaurant = RestaurantEntity.builder()
				.name(request.getName())
				.address(request.getAddress())
				.createdAt(ZonedDateTime.now())
				.updatedAt(ZonedDateTime.now())
				.build();
		restaurantRepository.save(restaurant);
		request.getMenus().forEach((menu)->{
			MenuEntity menuEntity = MenuEntity.builder()
					.restaurantId(restaurant.getId())
					.name(menu.getName())
					.price(menu.getPrice())
					.createdAt(ZonedDateTime.now())
					.updatedAt(ZonedDateTime.now())
					.build();
			menuRepository.save(menuEntity);
		});
		return restaurant;
	}
	
	// 레스토랑 리스트 불러오기
	public List<RestaurantView> getAllRestaurants() {
		List<RestaurantEntity> restaurants = restaurantRepository.findAll();
		
		return restaurants.stream().map((restaurant)-> RestaurantView.builder()
					.id(restaurant.getId())
					.name(restaurant.getName())
					.address(restaurant.getAddress())
					.createdAt(restaurant.getCreatedAt())
					.updatedAt(restaurant.getUpdatedAt())
					.build())
				.toList();
	}
	
	// 레스토랑 삭제
	public void deleteRestaurant(Long restaurantId) {
		RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
		restaurantRepository.delete(restaurant);
		
		List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
		menuRepository.deleteAll(menus);
	}

	// 레스토랑 수정
	public void editRestaurant(Long restaurantId, CreateAndEditRestaurantRequest request) {
		 RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RuntimeException("없는 레스토랑입니다"));
	        restaurant.changeNameAndAddress(request.getName(), request.getAddress());
	        restaurantRepository.save(restaurant);

	        List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
	        menuRepository.deleteAll(menus);

	        request.getMenus().forEach((menu) -> {
	            MenuEntity menuEntity = MenuEntity.builder()
	                    .restaurantId(restaurantId)
	                    .name(menu.getName())
	                    .price(menu.getPrice())
	                    .createdAt(ZonedDateTime.now())
	                    .updatedAt(ZonedDateTime.now())
	                    .build();

	            menuRepository.save(menuEntity);
	        });
	}
	
	// 단일조회 메뉴포함
	public RestaurantDetailView getRestaurantDetail(Long restaurantId) {
		RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
		List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
		
		return RestaurantDetailView.builder()
				.id(restaurant.getId())
				.name(restaurant.getName())
				.address(restaurant.getAddress())
				.updatedAt(restaurant.getUpdatedAt())
				.createdAt(restaurant.getCreatedAt())
				.menus(menus.stream().map((menu)-> RestaurantDetailView.Menu.builder()
						.id(menu.getId())
						.name(menu.getName())
						.updatedAt(menu.getUpdatedAt())
						.createdAt(menu.getCreatedAt())
						.price(menu.getPrice())
						.build()).toList()
						).build();
	}
}