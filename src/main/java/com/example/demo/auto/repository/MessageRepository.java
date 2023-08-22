package com.example.demo.auto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.auto.entity.Message;




/**
 * @author igonix
 *
 * 26-Jul-2023
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, String> {

	/**
	 * @author igonix
	 *
	 * 26-Jul-2023
	 */
	List<Message> findAllByCode(String code);

	/**
	 * @author igonix
	 *
	 * 26-Jul-2023
	 */
	Message findByCodeAndEn(String key, String language);

	/**
	 * @author igonix
	 *
	 * 26-Jul-2023
	 */
	Message findByCode(String key);

}
