package by.htp.epam.bonjo.service.impl;

import java.util.List;

import by.htp.epam.bonjo.dao.AdDAO;
import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.service.AdService;

public class AdServiceImpl implements AdService {

	private AdDAO adDao = DAOFactory.getDaoInstance().getAdDao();

	@Override
	public void create(Ad ad) {
		adDao.create(ad);
	}

	@Override
	public Ad read(int id) {
		return adDao.read(id);
	}

	@Override
	public void update(Ad ad) {
		adDao.update(ad);
	}

	@Override
	public void delete(int adId) {
		adDao.delete(adId);
	}

	@Override
	public List<Ad> getAllAds() {
		return adDao.readAll();
	}
	
	@Override
	public List<Ad> getAllAdsWithPage(int start, int end) {
		return adDao.readAllWithPage(start, end);
	}

	@Override
	public List<Ad> getUserAds(int user_ID) {
		return adDao.readUserAds(user_ID);
	}
	
	@Override
	public List<Ad> getUserAdsWithPage(int user_ID, int start, int end) {
		return adDao.readUserAdsWithPage(user_ID, start, end);
	}
}
