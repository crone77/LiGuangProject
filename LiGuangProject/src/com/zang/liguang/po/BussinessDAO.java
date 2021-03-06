package com.zang.liguang.po;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bussiness entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zang.liguang.po.Bussiness
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BussinessDAO {
	private static final Logger log = LoggerFactory.getLogger(BussinessDAO.class);
	// property constants
	public static final String BNAME = "bname";
	public static final String CLASSID = "classid";
	public static final String SHOPNAME = "shopname";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String AREA = "area";
	public static final String DETAILADDRESS = "detailaddress";
	public static final String MASTERNAME = "mastername";
	public static final String MASTERPHONE = "masterphone";
	public static final String MASTEREMAIL = "masteremail";
	public static final String SHOPPHONE = "shopphone";
	public static final String LICENCE = "licence";
	public static final String REMARKS = "remarks";
	public static final String IS_LEGAL = "isLegal";
	public static final String MASTERID = "masterid";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Bussiness transientInstance) {
		log.debug("saving Bussiness instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bussiness persistentInstance) {
		log.debug("deleting Bussiness instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bussiness findById(java.lang.String id) {
		log.debug("getting Bussiness instance with id: " + id);
		try {
			Bussiness instance = (Bussiness) getCurrentSession().get("com.zang.liguang.po.Bussiness", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Bussiness> findByExample(Bussiness instance) {
		log.debug("finding Bussiness instance by example");
		try {
			List<Bussiness> results = (List<Bussiness>) getCurrentSession().createCriteria("com.zang.liguang.po.Bussiness").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Bussiness instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Bussiness as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Bussiness> findByBname(Object bname) {
		return findByProperty(BNAME, bname);
	}

	public List<Bussiness> findByClassid(Object classid) {
		return findByProperty(CLASSID, classid);
	}

	public List<Bussiness> findByShopname(Object shopname) {
		return findByProperty(SHOPNAME, shopname);
	}

	public List<Bussiness> findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	public List<Bussiness> findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List<Bussiness> findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List<Bussiness> findByDetailaddress(Object detailaddress) {
		return findByProperty(DETAILADDRESS, detailaddress);
	}

	public List<Bussiness> findByMastername(Object mastername) {
		return findByProperty(MASTERNAME, mastername);
	}

	public List<Bussiness> findByMasterphone(Object masterphone) {
		return findByProperty(MASTERPHONE, masterphone);
	}

	public List<Bussiness> findByMasteremail(Object masteremail) {
		return findByProperty(MASTEREMAIL, masteremail);
	}

	public List<Bussiness> findByShopphone(Object shopphone) {
		return findByProperty(SHOPPHONE, shopphone);
	}

	public List<Bussiness> findByLicence(Object licence) {
		return findByProperty(LICENCE, licence);
	}

	public List<Bussiness> findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List<Bussiness> findByIsLegal(Object isLegal) {
		return findByProperty(IS_LEGAL, isLegal);
	}

	public List<Bussiness> findByMasterid(Object masterid) {
		return findByProperty(MASTERID, masterid);
	}

	public List findAll() {
		log.debug("finding all Bussiness instances");
		try {
			String queryString = "from Bussiness";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bussiness merge(Bussiness detachedInstance) {
		log.debug("merging Bussiness instance");
		try {
			Bussiness result = (Bussiness) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bussiness instance) {
		log.debug("attaching dirty Bussiness instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bussiness instance) {
		log.debug("attaching clean Bussiness instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BussinessDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BussinessDAO) ctx.getBean("BussinessDAO");
	}
}