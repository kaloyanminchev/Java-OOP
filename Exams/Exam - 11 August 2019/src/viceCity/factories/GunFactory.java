package viceCity.factories;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;

public class GunFactory {

    public static Gun createGun(String type, String name) {
        Gun gun = null;

        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
        }

        return gun;
    }
}

//REFLECTION
//    private static final String path = "viceCity.models.guns.";
//
//    private GunFactory() {
//    }
//
//    public static Gun createGun(String name, String type) {
//        try {
//            Class<?> aClass = Class.forName(path + type);
//            return (Gun) aClass.getDeclaredConstructor(String.class).newInstance(name);
//
//        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }




