package by.htp.epam.bonjo.dao;

import java.util.List;

import by.htp.epam.bonjo.domain.Ad;

public interface AdDAO {

	void create(Ad ad);

	Ad read(int id);

	List<Ad> readAll();

	void update(Ad ad);

	void delete(int id);
	
	List<Ad> readUserAds(int user_ID);
	
}
