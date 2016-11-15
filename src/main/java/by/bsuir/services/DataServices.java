package by.bsuir.services;

import by.bsuir.model.*;

import java.util.List;

public interface DataServices {

    public boolean addUser(UserEntity user) throws Exception;
    public boolean updateUser(UserEntity user) throws Exception;
    public boolean updateUserList(List<UserEntity> list) throws Exception;
    public UserEntity getUserEntity(int id) throws Exception;
    public List<UserEntity> getUserList() throws Exception;
    public boolean deleteUserEntity(int id) throws Exception;

    public boolean addDriver(DriverEntity driver) throws Exception;
    public boolean updateDriver(DriverEntity driver) throws Exception;
    public boolean updateDriverList(List<DriverEntity> list) throws Exception;
    public DriverEntity getDriverEntity(int id) throws Exception;
    public List<DriverEntity> getDriverList() throws Exception;
    public boolean deleteDriverEntity(int id) throws Exception;

    public boolean addCar(CarEntity car) throws Exception;
    public boolean updateCar(CarEntity car) throws Exception;
    public boolean updateCarList(List<CarEntity> list) throws Exception;
    public CarEntity getCarEntity(int id) throws Exception;
    public List<CarEntity> getCarList() throws Exception;
    public boolean deleteCarEntity(int id) throws Exception;

    public boolean addPark(ParkEntity park) throws Exception;
    public boolean updatePark(ParkEntity park) throws Exception;
    public boolean updateParkList(List<ParkEntity> list) throws Exception;
    public ParkEntity getParkEntity(int id) throws Exception;
    public List<ParkEntity> getParkList() throws Exception;
    public boolean deleteParkEntity(int id) throws Exception;
}
