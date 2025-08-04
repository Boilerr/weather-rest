package com.weatherrest.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.weatherrest.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {

	@Modifying
	@Query("delete from WeatherData w where w.city=:city")
	Long deleteByCity(@Param("city") String city);
}
