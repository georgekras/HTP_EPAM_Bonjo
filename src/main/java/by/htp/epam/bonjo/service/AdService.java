package by.htp.epam.bonjo.service;

import java.util.List;

import by.htp.epam.bonjo.domain.Ad;

public interface AdService {
	
	void create(Ad ad);
	
	Ad read(int id);
	
	void update(Ad ad);
	
	void delete(int adId);
	
	List<Ad> getAllAds();
	
	List<Ad> getAllAdsWithPage(int start, int end);
	
	List<Ad> getUserAds(int user_ID);

}
