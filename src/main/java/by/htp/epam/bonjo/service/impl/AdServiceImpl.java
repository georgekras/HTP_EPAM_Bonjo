package by.htp.epam.bonjo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.ad_project.dao.AdDao;
import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.service.AdService;

@Service
public class AdServiceImpl implements AdService {

	@Autowired
	private AdDao adDao;

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
	public void delete(Ad ad) {
		adDao.delete(ad);
	}

	@Override
	public List<Ad> getAllAds() {
		return adDao.readAll();
	}

	@Override
	public List<Ad> getUserAds(int user_ID) {
		return adDao.readUserAds(user_ID);
	}
}
