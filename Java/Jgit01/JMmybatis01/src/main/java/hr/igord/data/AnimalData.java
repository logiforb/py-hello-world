
package hr.igord.data;

import java.util.Date;
import org.joda.time.DateTime;

public class AnimalData {

    private String name;
    private int age;
    private DateTime lastUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
//    public void setAge(int age) {
//        if (age != 5) { // invalid age
//            this.age = -1;
//        } else {
//            this.age = age;
//        }
//    }
    
    public DateTime getLastUpdate() {
        return lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdateProxy) {
        this.lastUpdate = new DateTime(lastUpdateProxy);
    }

    public void setLastUpdate(DateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "AnimalData{" + "name=" + name + ", age=" + age + ", lastUpdate=" + lastUpdate + '}';
    }
    
}





//
//package hr.igord.data;
//
//import java.util.Date;
//import org.joda.time.DateTime;
//
//public class AnimalData {
//
//    private String name;
//    private int age;
//    private Date lastUpdateProxy;
//    private DateTime lastUpdate;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//    
//    public DateTime getLastUpdate() {
//        return lastUpdate;
//    }
//    
//    public void setLastUpdateProxy(Date lastUpdateProxy) {
//        this.lastUpdate = new DateTime(lastUpdateProxy);
//    }
//
//    public void setLastUpdate(DateTime lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
//
//    @Override
//    public String toString() {
//        return "AnimalData{" + "name=" + name + ", age=" + age + ", lastUpdate=" + lastUpdate + '}';
//    }
//    
//}





//
//package hr.igord.data;
//
//import java.util.Date;
//import org.joda.time.DateTime;
//
//public class AnimalData {
//
//    private String name;
//    private int age;
//    private Date lastUpdateProxy;
//    private DateTime lastUpdate;
////    private LocalTime lastUpdate;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
////    public Date getLastUpdate() {
////        return lastUpdate;
////    }
////
////    public void setLastUpdate(Date lastUpdate) {
////        this.lastUpdate = lastUpdate;
////    }
////
////    @Override
////    public String toString() {
////        return "AnimalData{" + "name=" + name + ", age=" + age + ", lastUpdate=" + lastUpdate.toGMTString() + '}';
////    }
//    
////    public LocalTime getLastUpdate() {
////        return lastUpdate;
////    }
////
////    public void setLastUpdate(LocalTime lastUpdate) {
////        this.lastUpdate = lastUpdate;
////    }
////
////    @Override
////    public String toString() {
////        return "AnimalData{" + "name=" + name + ", age=" + age + ", lastUpdate=" + lastUpdate + '}';
////    }
//    
//    public DateTime getLastUpdate() {
//        return lastUpdate;
//    }
//    
////    public Date getLastUpdateProxy() {
////        throw new UnsupportedOperationException("Proxy");
////    }
//    
//    public void setLastUpdateProxy(Date lastUpdateProxy) {
//        this.lastUpdate = new DateTime(lastUpdateProxy);
//    }
//
//    public void setLastUpdate(DateTime lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
//
//    @Override
//    public String toString() {
//        return "AnimalData{" + "name=" + name + ", age=" + age + ", lastUpdate=" + lastUpdate + '}';
//    }
//    
//}
