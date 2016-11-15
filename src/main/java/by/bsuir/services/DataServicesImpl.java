package by.bsuir.services;

import by.bsuir.model.CarEntity;
import by.bsuir.model.DriverEntity;
import by.bsuir.model.ParkEntity;
import by.bsuir.model.UserEntity;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataServicesImpl implements DataServices {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addUser(UserEntity user) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateUser(UserEntity user) throws Exception {
        session = sessionFactory.openSession();
        UserEntity user1;
        user1 = (UserEntity) session.load(UserEntity.class, user.getIdUser());
        tx = session.getTransaction();
        user1 = user;
        tx = session.beginTransaction();
        session.saveOrUpdate(user1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateUserList(List<UserEntity> list) throws Exception {
        session = sessionFactory.openSession();
        for(UserEntity user:list) {
            UserEntity user1;
            user1 = (UserEntity) session.load(UserEntity.class, user.getIdUser());
            tx = session.getTransaction();
            user1 = user;
            tx = session.beginTransaction();
            session.saveOrUpdate(user1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public UserEntity getUserEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        UserEntity user = (UserEntity) session.load(UserEntity.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return user;
    }

    @Override
    public List<UserEntity> getUserList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<UserEntity> userList = session.createCriteria(UserEntity.class).list();
        tx.commit();
        session.close();
        return userList;
    }

    @Override
    public boolean deleteUserEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(UserEntity.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }


    @Override
    public boolean addDriver(DriverEntity driver) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(driver);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateDriver(DriverEntity driver) throws Exception {
        session = sessionFactory.openSession();
        DriverEntity driver1;
        driver1 = (DriverEntity) session.load(DriverEntity.class, driver.getIdDriver());
        tx = session.getTransaction();
        driver1 = driver;
        tx = session.beginTransaction();
        session.saveOrUpdate(driver1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateDriverList(List<DriverEntity> list) throws Exception {
        session = sessionFactory.openSession();
        for(DriverEntity driver:list) {
            DriverEntity driver1;
            driver1 = (DriverEntity) session.load(DriverEntity.class, driver.getIdDriver());
            tx = session.getTransaction();
            driver1 = driver;
            tx = session.beginTransaction();
            session.saveOrUpdate(driver1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public DriverEntity getDriverEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        DriverEntity driver = (DriverEntity) session.load(DriverEntity.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return driver;
    }

    @Override
    public List<DriverEntity> getDriverList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<DriverEntity> driverList = session.createCriteria(DriverEntity.class).list();
        tx.commit();
        session.close();
        return driverList;
    }

    @Override
    public boolean deleteDriverEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(DriverEntity.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }


    @Override
    public boolean addCar(CarEntity car) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(car);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateCar(CarEntity car) throws Exception {
        session = sessionFactory.openSession();
        CarEntity car1;
        car1 = (CarEntity) session.load(CarEntity.class, car.getIdCar());
        tx = session.getTransaction();
        car1 = car;
        tx = session.beginTransaction();
        session.saveOrUpdate(car1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateCarList(List<CarEntity> list) throws Exception {
        session = sessionFactory.openSession();
        for(CarEntity car:list) {
            CarEntity car1;
            car1 = (CarEntity) session.load(CarEntity.class, car.getIdCar());
            tx = session.getTransaction();
            car1 = car;
            tx = session.beginTransaction();
            session.saveOrUpdate(car1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public CarEntity getCarEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        CarEntity car = (CarEntity) session.load(CarEntity.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return car;
    }

    @Override
    public List<CarEntity> getCarList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<CarEntity> carList = session.createCriteria(CarEntity.class).list();
        tx.commit();
        session.close();
        return carList;
    }

    @Override
    public boolean deleteCarEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(CarEntity.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }


    @Override
    public boolean addPark(ParkEntity park) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(park);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updatePark(ParkEntity park) throws Exception {
        session = sessionFactory.openSession();
        ParkEntity park1;
        park1 = (ParkEntity) session.load(ParkEntity.class, park.getIdPark());
        tx = session.getTransaction();
        park1 = park;
        tx = session.beginTransaction();
        session.saveOrUpdate(park1);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateParkList(List<ParkEntity> list) throws Exception {
        session = sessionFactory.openSession();
        for(ParkEntity park:list) {
            ParkEntity park1;
            park1 = (ParkEntity) session.load(ParkEntity.class, park.getIdPark());
            tx = session.getTransaction();
            park1 = park;
            tx = session.beginTransaction();
            session.saveOrUpdate(park1);
            tx.commit();
        }
        session.close();
        return false;
    }

    @Override
    public ParkEntity getParkEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        ParkEntity park = (ParkEntity) session.load(ParkEntity.class, new Integer(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return park;
    }

    @Override
    public List<ParkEntity> getParkList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<ParkEntity> parkList = session.createCriteria(ParkEntity.class).list();
        tx.commit();
        session.close();
        return parkList;
    }

    @Override
    public boolean deleteParkEntity(int id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(ParkEntity.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }
}
