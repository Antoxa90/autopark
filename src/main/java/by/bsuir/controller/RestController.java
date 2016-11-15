package by.bsuir.controller;


import by.bsuir.model.*;
import by.bsuir.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/rest")
public class RestController {

    @Autowired
    DataServices dataServices;

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addUserEntity(@RequestBody UserEntity user) {
        try {
            dataServices.addUser(user);
            return new Status(200, "User added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updUser(@RequestBody UserEntity user) {
        try {
            dataServices.updateUser(user);
            return new Status(200, "User update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }


    @RequestMapping(value = "/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updUsers(@RequestBody List<UserEntity> list) {
        try {
            dataServices.updateUserList(list);
            return new Status(200, "Users update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    UserEntity getUser(@PathVariable("id") int id) {
        UserEntity user = null;
        try {
            user = dataServices.getUserEntity(id);
            if (user == null)
                throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<UserEntity> getUsers() {
        List<UserEntity> employeeList = null;
        try {
            employeeList = dataServices.getUserList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delUser(@PathVariable("id") int id) {

        try {
            dataServices.deleteUserEntity(id);
            return new Status(200, "User deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }



    @RequestMapping(value = "/driver", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addDriverEntity(@RequestBody DriverEntity driver) {
        try {
            dataServices.addDriver(driver);
            return new Status(200, "User added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "/driver/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updDriver(@RequestBody DriverEntity driver) {
        try {
            dataServices.updateDriver(driver);
            return new Status(200, "User update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }


    @RequestMapping(value = "/drivers", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updDrivers(@RequestBody List<DriverEntity> list) {
        try {
            dataServices.updateDriverList(list);
            return new Status(200, "Users update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/driver/{id}", method = RequestMethod.GET)
    public @ResponseBody
    DriverEntity getDriver(@PathVariable("id") int id) {
        DriverEntity driver = null;
        try {
            driver = dataServices.getDriverEntity(id);
            if (driver == null)
                throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public @ResponseBody
    List<DriverEntity> getDrivers() {
        List<DriverEntity> driverList = null;
        try {
            driverList = dataServices.getDriverList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driverList;
    }

    @RequestMapping(value = "driver/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delDriver(@PathVariable("id") int id) {

        try {
            dataServices.deleteDriverEntity(id);
            return new Status(200, "User deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }



    @RequestMapping(value = "/car", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addCarEntity(@RequestBody CarEntity car) {
        try {
            dataServices.addCar(car);
            return new Status(200, "User added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updCar(@RequestBody CarEntity car) {
        try {
            dataServices.updateCar(car);
            return new Status(200, "User update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }


    @RequestMapping(value = "/cars", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updCars(@RequestBody List<CarEntity> list) {
        try {
            dataServices.updateCarList(list);
            return new Status(200, "Users update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public @ResponseBody
    CarEntity getCar(@PathVariable("id") int id) {
        CarEntity car = null;
        try {
            car = dataServices.getCarEntity(id);
            if (car == null)
                throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public @ResponseBody
    List<CarEntity> getCars() {
        List<CarEntity> carList = null;
        try {
            carList = dataServices.getCarList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carList;
    }

    @RequestMapping(value = "car/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delCar(@PathVariable("id") int id) {

        try {
            dataServices.deleteCarEntity(id);
            return new Status(200, "User deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }



    @RequestMapping(value = "/park", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addParkEntity(@RequestBody ParkEntity park) {
        try {
            dataServices.addPark(park);
            return new Status(200, "User added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "/park/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updPark(@RequestBody ParkEntity park) {
        try {
            dataServices.updatePark(park);
            return new Status(200, "User update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }


    @RequestMapping(value = "/parks", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updParks(@RequestBody List<ParkEntity> list) {
        try {
            dataServices.updateParkList(list);
            return new Status(200, "Users update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/park/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ParkEntity getPark(@PathVariable("id") int id) {
        ParkEntity park = null;
        try {
            park = dataServices.getParkEntity(id);
            if (park == null)
                throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return park;
    }

    @RequestMapping(value = "/parks", method = RequestMethod.GET)
    public @ResponseBody
    List<ParkEntity> getParks() {
        List<ParkEntity> parkList = null;
        try {
            parkList = dataServices.getParkList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkList;
    }

    @RequestMapping(value = "park/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delPark(@PathVariable("id") int id) {

        try {
            dataServices.deleteParkEntity(id);
            return new Status(200, "User deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}

