package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sample.mybatis.business.domain.Pet;
import sample.mybatis.business.service.PetDao;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    	//Springのコンテナを生成        
    	//JavaConfigでBean定義した場合
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(
//                DataSourceConfig.class, MyBatisConfig.class);

    	//Springのコンテナを生成        
    	//XMLでBean定義した場合
        ApplicationContext ctx = new ClassPathXmlApplicationContext("sample/config/spring-mybatis.xml");
        
        
        PetDao dao = ctx.getBean(PetDao.class);
        
        List<Pet> list = dao.findAll();
        
        System.out.println(list.get(0).getPetName());
                
        Pet p = dao.findById(12);
        System.out.println(p.getPetName());
        
    }

}
