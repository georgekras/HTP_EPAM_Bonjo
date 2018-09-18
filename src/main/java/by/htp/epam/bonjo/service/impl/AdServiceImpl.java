package by.htp.epam.bonjo.service.impl;

import java.util.List;

import by.htp.epam.bonjo.dao.AdDAO;
import by.htp.epam.bonjo.dao.DAOFactory;
import by.htp.epam.bonjo.domain.Ad;
import by.htp.epam.bonjo.service.AdService;

/**
 * Class implementing AdService interface
 * 
 * @author George Krasutski
 *
 */
public class AdServiceImpl implements AdService {

	/**
	 * AdDao instance
	 */
	private AdDAO adDao = DAOFactory.getDaoInstance().getAdDao();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(Ad ad) {
		adDao.create(ad);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Ad read(int id) {
		return adDao.read(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Ad ad) {
		adDao.update(ad);
	}

	@Override
	public void delete(int adId) {
		adDao.delete(adId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ad> getAllAds() {
		return adDao.readAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ad> getAllAdsWithPage(int start, int end) {
		return adDao.readAllWithPage(start, end);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ad> getUserAds(int user_ID) {
		return adDao.readUserAds(user_ID);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Ad> getUserAdsWithPage(int user_ID, int start, int end) {
		return adDao.readUserAdsWithPage(user_ID, start, end);
	}
}
