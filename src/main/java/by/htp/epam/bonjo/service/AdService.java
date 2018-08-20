package by.htp.epam.bonjo.service;

import java.util.List;

import by.htp.epam.bonjo.domain.Ad;

public interface AdService {
	
	void create(Ad ad);
	
	Ad read(int id);
	
	void update(Ad ad);
	
	void delete(Ad ad);
	
	List<Ad> getAllAds();
	
	List<Ad> getUserAds(int user_ID);

}
