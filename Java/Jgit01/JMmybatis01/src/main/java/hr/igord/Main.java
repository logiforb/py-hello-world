
package hr.igord;

import hr.igord.data.AnimalData;
import hr.igord.data.AnimalDataMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final transient Logger LOG = LoggerFactory.getLogger(Main.class);
    
    public Main() throws IOException {
        
        LOG.debug("main start");
        
//<editor-fold defaultstate="collapsed" desc="String resources fail">
//        String resource = "hr/igord/data/mybatis-config.xml";
//        String resource = "data/mybatis-config.xml";
//        String resource = "mybatis-config.xml";
//        String resource = "/data/mybatis-config.xml";
//        String resource = "org/mybatis/builder/mybatis-config.xml";
//        String resource = "/hr/igord/data/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
//        ClassLoader scl = ClassLoader.getSystemClassLoader();
//        LOG.info(scl.toString());
        
//        String resource = "mybatis-config.xml";
//        String resource = "main/java/hr/igord/data/mybatis-config.xml";
//        String resource = "/main/java/hr/igord/data/mybatis-config.xml";
//        String resource = "hr/igord/data/mybatis-config.xml";
//</editor-fold>
        
        String resource = "data/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
//        SqlSession session = sqlSessionFactory.openSession();
//        try {
//            CatDataMapper mapper = session.getMapper(CatDataMapper.class);
//            CatData selectCatData = mapper.selectCatData(3);
//            LOG.info(selectCatData.getName());
//            
//        } finally {
//            session.close();
//        }
        
        try (SqlSession session = sqlSessionFactory.openSession()) {

//            CatDataMapper mapper = session.getMapper(CatDataMapper.class);
//            CatData selectCatData = mapper.selectCatData(2);
//            LOG.info(selectCatData.getCatName());
            
//            AnimalDataMapper mapper = session.getMapper(AnimalDataMapper.class);
//            AnimalData animalData = mapper.selectAnimalData(2);
//            LOG.info("--------------------------");
//            LOG.info(animalData.toString());
////            LOG.info("--------------------------");
            
//            AnimalDataMapper mapper = session.getMapper(AnimalDataMapper.class);
//            AnimalData animalData = mapper.selectAnimalData(2);
////            LOG.info("--------------------------");
//            LOG.info(animalData.toString());
//            LOG.info("--------------------------");
            
            AnimalDataMapper mapper = session.getMapper(AnimalDataMapper.class);
            List<AnimalData> selectAllAnimalData = mapper.selectAllAnimalData();
            for (AnimalData animalData : selectAllAnimalData) {
                LOG.info(animalData.toString());
            }
        }
        
        LOG.debug("main end");
    }
    
    public static void main(String[] args) {
        try {
            new Main();
        } catch (IOException ex) {
            LOG.error("IOex: " + ex.getMessage());
        } catch (Exception ex) {
            LOG.error("Ex: " + ex.getMessage());
        }
    }

}
